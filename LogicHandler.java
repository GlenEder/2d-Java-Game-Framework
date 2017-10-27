

public class LogicHandler implements Runnable{

	private Thread thread; 


	private int updateLimit = 60;		//max updates per second
	private int UPS = 0;				//updates per second
	private boolean running = false;	//if game is running
	
	public LogicHandler() {
		init();
	}

	public void init() {
		ImageHandler.addImageToHashMap("ErrorBlock", ImageHandler.loadImageFromFile("ErrorBlock.png"));
		MapHandler.loadMap("testMap");
		MapHandler.printMap();
	}

	public void run() {
		long now = System.nanoTime();				//time now
		long lastTime = now;						//last update time
		long timer = 1000000000 / updateLimit;		//time interval for update limit
		long longTime = now;						//time of last second
		int ups = 0;								//update counter

		while(running) {
			now = System.nanoTime();

			if(now - lastTime >= timer) {
				update();
				ups++;
				lastTime = now;
			}

			if(now - longTime >= 1000000000) {
				UPS = ups;
				ups = 0;
				longTime = now;
			}
		}

		stop();
	}

	public void update() {
		
	}

	public synchronized void start() {
		if(thread == null) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	public synchronized void stop() {
		if(thread != null) {
			try {
				thread.join();
			}catch (Exception e) {
				System.out.println("Error joining logic handler thread.");
			}
		}
	}

}
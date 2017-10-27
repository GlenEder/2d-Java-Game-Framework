import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.*;

public class GraphicsHandler extends JPanel implements Runnable{
			
	private Thread thread;
	private boolean running = false;		//if game is running
	private int FPS = 0;					//frames per second 
	private int fpsLimit = 60;				//frame rate limit
	private int width, height = 0;		

	public GraphicsHandler() {
		init();
	}

	public void init() {
		Display.createDisplay();
		Display.getFrame().add(this);
	}

	public void run() {
		long now = System.nanoTime();				//time now
		long lastTime = now;						//last update time
		long timer = 1000000000 / fpsLimit;			//time interval for render limit
		long longTime = now;						//time of last second
		int frames = 0;								//update counter

		while(running) {
			now = System.nanoTime();

			if(now - lastTime >= timer) {
				render();
				frames++;
				lastTime = now;
			}

			if(now - longTime >= 1000000000) {
				FPS = frames;
				frames = 0;
				longTime = now;
			}
		}

		stop();
	}

	public void render() {
		BufferStrategy bs = Display.getCanvas().getBufferStrategy();
		if(bs == null) {
			Display.getCanvas().createBufferStrategy(3);
			return;
		}
		width = Display.getWidth();
		height = Display.getHeight();

		Graphics2D g = (Graphics2D)bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, width, height);

		MapHandler.drawMap(g);

		bs.show();
		g.dispose();

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
				System.out.println("Error joining graphics handler thread.");
			}
		}
	}


}
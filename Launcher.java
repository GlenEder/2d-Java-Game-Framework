

public class Launcher {

	private static LogicHandler logic;
	private static GraphicsHandler graphics;
	private static InputHandler input;

	public static void main(String[] args) {
		logic = new LogicHandler();
		logic.start();
		graphics = new GraphicsHandler();
		graphics.start();
		input = new InputHandler();
	}

	public static void exitGame() {
		System.out.println("Exiting Game...");
		graphics.stop();
		logic.stop();
		System.exit(0);
	}
}
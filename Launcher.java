

public class Launcher {
	public static void main(String[] args) {
		LogicHandler logic = new LogicHandler();
		logic.start();
		GraphicsHandler graphics = new GraphicsHandler();
		graphics.start();
	}
}
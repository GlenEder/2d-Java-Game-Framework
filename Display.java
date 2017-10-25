import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display {

	private static JFrame frame;
	private static Canvas canvas;
	private static int width = 1920;
	private static int height = 1080;
	private static String title = "to be set...";

	public static void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setVisible(true);
		frame.add(canvas);

		frame.setVisible(true);
	}

	public static int getWidth() {
		return width;
	}

	public static void setWidth(int i) {
		width = i;
		frame.setSize(width, height);
		canvas.setSize(width, height);
	}

	public static int getHeight() {
		return height;
	}

	public static void setHeight(int i) {
		height = i;
		frame.setSize(width, height);
		canvas.setSize(width, height);
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static Canvas getCanvas() {
		return canvas;
	}
}
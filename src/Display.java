import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display{

	private static JFrame frame;
	private static Canvas canvas;
	private static int width = 1920;
	private static int height = 1080;
	private static String title = "to be set...";

	public static void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		canvas = new Canvas();
		canvas.setSize(width, height);
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setVisible(true);
		frame.add(canvas);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?", "Confirm Quit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					Launcher.exitGame();
				}
			}
		});

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
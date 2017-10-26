import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class ImageHandler {
	

	public static BufferedImage loadImageFromFile(String file) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(file));
		}catch (Exception e) {
			System.out.println("Error loading " + file);
		}

		return img;
	}

}
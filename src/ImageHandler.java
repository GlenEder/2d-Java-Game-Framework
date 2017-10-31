import java.io.*;
import java.awt.image.*;
import javax.imageio.ImageIO;
import java.util.HashMap;

public class ImageHandler {
	
	private static HashMap images = new HashMap<String, BufferedImage>();

	public ImageHandler() {
		init();
	}

	private static init() {
		
	}


	public static BufferedImage loadImageFromFile(String file) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Assets/Sprites/" + file));
		}catch (Exception e) {
			System.out.println("Error loading " + file);
		}

		return img;
	}

	public static void addImageToHashMap(String key, BufferedImage img) {
		images.put(key, img);
	}

	public static BufferedImage getImageFromMap(String key) {
		return (BufferedImage)images.get(key);
	}

}
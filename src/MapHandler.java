import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class MapHandler {
	
	private static char[][] map;
	private static String currentLevel;
	private static int tileSize = 32;

	private static String spliter = " ";


	public static void loadMap(String level) {
		currentLevel = level;
		int width, height = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("Assets/Maps/" + level));
			String line;
			width = Integer.parseInt(br.readLine());
			height = Integer.parseInt(br.readLine());
			map = new char[height][width];
			int y = 0;
			while((line = br.readLine()) != null) {
				String[] parts = line.split(spliter);
				for(int i = 0; i < parts.length; i++) {
					map[y][i] = parts[i].charAt(0);
				}	
				y++;
			}

			br.close();
		}catch (Exception e) {
			System.out.println("Error loading " + level);
		}
		

	}

	public static void printMap() {
		if(currentLevel == null) {
			System.out.println("No map has been loaded");
			return;
		}
		System.out.printf("===%s===\n", currentLevel);
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void drawMap(Graphics2D g) {
		if(map == null) {
			return;
		}
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				g.drawImage(getTileImage(map[i][j]), j * tileSize, i * tileSize, null);
			}
		}
	}

	private static BufferedImage getTileImage(char c) {
		BufferedImage img;

		switch (c) {
			default:
				img = ImageHandler.getImageFromMap("ErrorBlock");
				break;
			}
		

		return img;
	}

}
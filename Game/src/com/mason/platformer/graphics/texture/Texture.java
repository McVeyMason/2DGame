package com.mason.platformer.graphics.texture;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author Mason
 *
 */
public class Texture {

	
	public static final Texture AIR = new Texture(new File("res\\textures/tiles/air.png"));
	public static final Texture BRICK = new Texture(new File("res\\textures/tiles/brick.png"));
	public static final Texture DIRT = new Texture(new File("res\\textures/tiles/dirt.png"));
	public static final Texture GOLD = new Texture(new File("res\\textures/tiles/gold.png"));
	public static final Texture GRASS = new Texture(new File("res\\textures/tiles/grass.png"));
	public static final Texture ICE = new Texture(new File("res\\textures/tiles/ice.png"));
	public static final Texture NULL = new Texture(new File("res\\textures/tiles/null.png"));
	public static final Texture SPECIAL = new Texture(new File("res\\textures/tiles/special.png"));
	public static final Texture WATER = new Texture(new File("res\\textures/tiles/water.png"));
	
	public static final Texture BACKGROUND_SKY = new Texture(new File("res\\textures/backgrounds/background_sky.png"));

	private final int[][] colors;
	private final Image texture;

	/**
	 * Defines a texture to be used in a Tile.
	 * 
	 * @param file texture file
	 */
	public Texture(File file) {
		this.texture = loadImage(file);
		this.colors = pixelFromImage(texture);
	}

	/**
	 * @return
	 */
	public int[][] getTexture() {
		return this.colors;
	}

	private static int[][] pixelFromImage(Image image) {
		int width = image.getWidth(null);
		int height = image.getHeight(null);
		int[] pix = new int[width * height];
		int[][] pixels = new int[width][height];
		PixelGrabber pg = new PixelGrabber(image, 0, 0, width, height, pix, 0, width);
		try {
			pg.grabPixels();
		} catch (InterruptedException e) {
			throw new IllegalStateException("Error: Interrupted Waiting for Pixels");
		}
		if ((pg.getStatus() & ImageObserver.ABORT) != 0) {
			throw new IllegalStateException("Error: Image Fetch Aborted");
		}
		int i = 0;
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x][y] = pix[i];
				i++;
			}
		}
		return pixels;
	}

	private static Image loadImage(File file) {
		Image image = null;
		try {
			image = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
}

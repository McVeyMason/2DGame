package com.mason.platformer.graphics;

/**
 * Renders pixels to main canvas pixel map.
 * 
 * @author Mason
 *
 */
public class Render {
	
	/**
	 * The width of the render in pixels.
	 */
	public final int width;
	/**
	 * The height of the render in pixels.
	 */
	public final int height;
	/**
	 * The array of RGB integers for the render. The size is {@link #width} * {@link #height}
	 */
	public final int[] pixels;

	/**
	 * Creates a render with a width and height.
	 * 
	 * @param width  The width of the render in pixels.
	 * @param height The height of the render in pixels.
	 */
	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	/**
	 * Draws a rendering to the pixel map {@link #pixels}.
	 * 
	 * @param render  The render to be drawn.
	 * @param xOffset The x coordinate of the top left corner of the render.
	 * @param yOffset The y coordinate of the top left corner of the render.
	 */
	public void draw(Render render, int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yPix = y + yOffset;
			if (yPix >= Display.HEIGHT || yPix < 0) {
				continue;
			}

			for (int x = 0; x < width; x++) {
				int xPix = x + xOffset;
				if (xPix >= Display.WIDTH || xPix < 0) {
					continue;
				}
				pixels[xPix + yPix * width] = render.pixels[x + y * width];
			}
		}
	}
/*
	/**
	 * Draws two renderings to the pixel map {@link #pixels}.
	 * 
	 * @param render0  The render to be drawn on the bottom.
	 * @param render1  The render to be drawn on the top.
	 * @param xOffset0 The x coordinate of the top left corner of the first render.
	 * @param yOffset0 The y coordinate of the top left corner of the first render.
	 * @param xOffset1 The x coordinate of the top left corner of the second render.
	 * @param yOffset1 The y coordinate of the top left corner of the second render.
	 *
	public void multiDraw(Render render0, Render render1, int xOffset0, int yOffset0, int xOffset1, int yOffset1) {
		for (int y = 0; y < render0.height; y++) {
			int yPix = y + yOffset0;
			if (yPix >= Display.HEIGHT || yPix < 0) {
				continue;
			}

			for (int x = 0; x < render0.width; x++) {
				int xPix = x + xOffset0;
				if (xPix >= Display.WIDTH || xPix < 0) {
					continue;
				}
				pixels[xPix + yPix * width] = render0.pixels[x + y * render0.width];
			}
		}
		for (int y = 0; y < render1.height; y++) {
			int yPix = y + yOffset1;
			if (yPix >= Display.HEIGHT || yPix < 0) {
				continue;
			}

			for (int x = 0; x < render1.width; x++) {
				int xPix = x + xOffset1;
				if (xPix >= Display.WIDTH || xPix < 0) {
					continue;
				}
				if (render1.pixels[x + y * render1.width] != 16777215) {
					pixels[xPix + yPix * width] = render1.pixels[x + y * render1.width];
				}
			}
		}
	}*/
}

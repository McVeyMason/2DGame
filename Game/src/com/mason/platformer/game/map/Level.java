package com.mason.platformer.game.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.mason.platformer.graphics.texture.Texture;

/**
 * 
 * @author Mason
 *
 */
public class Level {

	private Tile[][] tiles;
	private int width;
	private int height;
	private int tileWidth;
	private int tileHeight;
	private final Texture background;

	/**
	 * 
	 */
	public static Level level0 = new Level(new File("res\\maps\\level0.json"), 64, 64, Texture.BACKGROUND_SKY);

	/**
	 * A level is a grid of <code>Tiles</code> that the <code>Player</code>
	 * interacts with. When creating a level a scanner parses a .json file, using
	 * integer for each tile type.
	 * <p>
	 * 
	 * @param file       The location of the level.
	 * @param tileWidth  The width of each tile.
	 * @param tileHeight The height of each tile.
	 * @param background The background texture of the level.
	 * @see com.mason.platformer.game.map.Tile Tile
	 * @see com.mason.platformer.game.Player Player
	 */
	public Level(File file, int tileWidth, int tileHeight, Texture background) {
		try (Scanner scanner = new Scanner(file);) {
			int x = 0;
			int y = 0;
			int w = 0;
			while (scanner.hasNext()) {
				String token = scanner.next();
				if (token.toCharArray()[0] == ':') {
					y++;
					if (x > w)
						w = x;
					x = 0;
				} else
					x++;
				// System.out.println(token);
			}
			this.width = w;
			this.height = y + 1;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("width is:" + width + " Height is:" + height);
		tiles = new Tile[width][height];
		try (Scanner scanner = new Scanner(file);) {
			int x = 0;
			int y = 0;
			while (scanner.hasNext()) {
				String token = scanner.next();
				// System.out.println(token.toCharArray()[0]);
				if (token.toCharArray()[0] == ':') {
					y++;
					x = -1;
				} else
					tiles[x][y] = new Tile(x * tileWidth, y * tileHeight, tileWidth, tileHeight,
							TileType.TYPES[Integer.parseInt(token)]);
				x++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.background = background;
	}

	/**
	 * This gets the tile at the coordinate (x,y) in the level. This is good for
	 * getting the properties of the tile/<code>tileType</code>.
	 * 
	 * @param x The x coordinate of the tile.
	 * @param y The y coordinate of the tile.
	 * @return The tile at the coordinate (x,y).
	 * @see TileType
	 */
	public Tile getTile(int x, int y) {
		return this.tiles[x][y];
	}

	/**
	 * This gives the width of the level. This can be used for testing the width of
	 * level.
	 * 
	 * @return The width of the level in tiles.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * 
	 * @return the height of the level in tiles.
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * 
	 * @return The width of each tile in pixels.
	 */
	public int getTileWidth() {
		return this.tileWidth;
	}

	/**
	 * 
	 * @return The height of each tile in pixels.
	 */
	public int getTileHeight() {
		return this.tileHeight;
	}

	/**
	 * 
	 * @return The background texture.
	 */
	public Texture getBackground() {
		return background;
	}
}

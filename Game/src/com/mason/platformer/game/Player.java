package com.mason.platformer.game;

import com.mason.platformer.game.map.Level;
import com.mason.platformer.game.map.Tile;
import com.mason.platformer.game.map.TileType;

/**
 * 
 * @author Mason
 *
 */
public class Player {

	private static int xPos;
	private static int yPos;
	private static int width;
	private static int height;
	private static float xVelocity;
	private static int yVelocity;
	private static Level currentLevel;
	private static final int gravity = 1;

	private static int[][] color;

	/**
	 * Creates a player with position, size, and the current level.
	 * 
	 * @param xPosition    The x position of the player.
	 * @param yPosition    The y position of the player.
	 * @param playerWidth  The width of the player.
	 * @param playerHeight The height of the player.
	 * @param level        The current level of the player.
	 * @see Level
	 */
	public Player(int xPosition, int yPosition, int playerWidth, int playerHeight, Level level) {
		xPos = xPosition;
		yPos = yPosition;
		width = playerWidth;
		height = playerHeight;
		currentLevel = level;
		xVelocity = 0f;
		yVelocity = 0;
		color = new int[playerWidth][playerHeight];
		for (int x = 0; x < playerWidth; x++) {
			for (int y = 0; y < playerHeight; y++) {
				color[x][y] = 32321;
			}
		}
	}

	/**
	 * Gets the x-position of the player.
	 * 
	 * @return The current x-position of the player.
	 */
	public int getXPos() {
		return xPos;
	}

	/**
	 * Sets a new x position of the player.
	 * 
	 * @param x New x position for the player.
	 */
	public void setXPos(int x) {
		xPos = x;
	}

	/**
	 * Player getter.
	 * 
	 * @return The y position of the player.
	 */
	public int getYPos() {
		return yPos;
	}

	/**
	 * Sets a new y position of the player.
	 * 
	 * @param y New y position for the player.
	 */
	public void setYPos(int y) {
		yPos = y;
	}

	/**
	 * Player getter.
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Player getter.
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Player getter.
	 * 
	 * @return
	 */
	public static float getXVelocity() {
		return xVelocity;
	}

	/**
	 * 
	 * @param xVelocity
	 */
	public void setXVelocity(float xVelocity) {
		Player.xVelocity = xVelocity;
	}

	/**
	 * Player getter.
	 * 
	 * @return
	 */
	public static int getYVelocity() {
		return yVelocity;
	}

	/**
	 * 
	 * @param yVelocity
	 */
	public void setYVelocity(int yVelocity) {
		Player.yVelocity = yVelocity;
	}

	/**
	 * Player getter.
	 * 
	 * @return
	 */
	public Level getCurrentLevel() {
		return currentLevel;
	}

	/**
	 * 
	 * @param currentLevel
	 */
	public static void setCurrentLevel(Level currentLevel) {
		Player.currentLevel = currentLevel;
	}

	/**
	 * Player getter.
	 * 
	 * @return The color of the player.
	 */
	public int[][] getColors() {
		return color;
	}

	/**
	 * 
	 * @param yUp
	 * @return
	 */
	public boolean contactUp(int yUp) {
		int tileHeight = currentLevel.getTileHeight();
		int tileWidth = currentLevel.getTileWidth();
		int x = 0;
		int y = 0;
		for (int xOff = 0; xOff < width; xOff++) {
			x = (xPos + xOff) - ((xPos + xOff) % tileWidth);
			y = (yPos - yUp) - ((yPos - yUp) % tileHeight);
			if (x / tileWidth < currentLevel.getWidth() && x / tileWidth >= 0
					&& y / tileHeight < currentLevel.getHeight() && y / tileHeight >= 0) {
				if (currentLevel.getTile(x / tileWidth, y / tileHeight).getTileType().isSolid() == true) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param yDown The y amount in pixels down from the <code>Player</code>
	 * @return If the player is touching a tile.
	 */
	public boolean contactDown(int yDown) {
		int tileHeight = currentLevel.getTileHeight();
		int tileWidth = currentLevel.getTileWidth();
		int x = 0;
		int y = 0;
		for (int xOff = 0; xOff < width; xOff++) {
			x = (xPos + xOff) - ((xPos + xOff) % tileWidth);
			y = (yPos + height + yDown) - ((yPos + height + yDown) % tileHeight);
			if (x / tileWidth < currentLevel.getWidth() && x / tileWidth >= 0
					&& y / tileHeight < currentLevel.getHeight() && y / tileHeight >= 0) {
				if (currentLevel.getTile(x / tileWidth, y / tileHeight).getTileType().isSolid() == true) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param xRight
	 * @return
	 */
	public boolean contactRight(int xRight) {
		int tileHeight = currentLevel.getTileHeight();
		int tileWidth = currentLevel.getTileWidth();
		int x = 0;
		int y = 0;
		for (int yOff = 0; yOff < height; yOff++) {
			x = (xPos + width + xRight) - ((xPos + width + xRight) % tileWidth);
			y = (yPos + yOff) - ((yPos + yOff) % tileHeight);
			if (x / tileWidth < currentLevel.getWidth() && x / tileWidth >= 0
					&& y / tileHeight < currentLevel.getHeight() && y / tileHeight >= 0) {
				if (currentLevel.getTile(x / tileWidth, y / tileHeight).getTileType().isSolid() == true) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @param xLeft
	 * @return
	 */
	public boolean contactLeft(int xLeft) {
		int tileHeight = currentLevel.getTileHeight();
		int tileWidth = currentLevel.getTileWidth();
		int x = 0;
		int y = 0;
		for (int yOff = 0; yOff < height; yOff++) {
			x = (xPos - xLeft) - ((xPos + width - xLeft) % tileWidth);
			y = (yPos + yOff) - ((yPos + yOff) % tileHeight);
			if (x / tileWidth < currentLevel.getWidth() && x / tileWidth >= 0
					&& y / tileHeight < currentLevel.getHeight() && y / tileHeight >= 0) {
				if (currentLevel.getTile(x / tileWidth, y / tileHeight).getTileType().isSolid() == true) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public TileType tileDown() {
		int tileHeight = currentLevel.getTileHeight();
		int tileWidth = currentLevel.getTileWidth();
		int x = 0;
		int y = 0;
		int[] tileCount = new int[TileType.TYPES.length];
		for (int xOff = 0; xOff < width; xOff++) {
			x = (xPos + xOff) - ((xPos + xOff) % tileWidth);
			y = (yPos + height + 1) - ((yPos + height + 1) % tileHeight);
			if (x / tileWidth < currentLevel.getWidth() && x / tileWidth >= 0
					&& y / tileHeight < currentLevel.getHeight() && y / tileHeight >= 0) {
				tileCount[TileType.getTileNum(currentLevel.getTile(x / tileWidth, y / tileHeight).getTileType())]++;
			}
		}
		// excluding air as block
		int greatest = 1;
		for (int i = 1; i < TileType.TYPES.length; i++) {
			if (tileCount[i] > tileCount[greatest] && tileCount[i] != 0)
				greatest = i;
		}
		if (tileCount[greatest] > 0) {
			return TileType.TYPES[greatest];
		} else
			return TileType.TYPES[0];
	}

	/**
	 * Player getter.
	 * 
	 * @param xPix
	 * @param yPix
	 * @return
	 */
	public Tile getTile(int xPix, int yPix) {
		int tileHeight = currentLevel.getTileHeight();
		int tileWidth = currentLevel.getTileWidth();
		int x = (xPos + xPix) - ((xPos + xPix) % tileWidth);
		int y = (yPos + yPix) - ((yPos + yPix) % tileHeight);
		if (x / tileWidth < currentLevel.getWidth() && x / tileWidth >= 0 && y / tileHeight < currentLevel.getHeight()
				&& y / tileHeight >= 0) {
			return currentLevel.getTile(x / tileWidth, y / tileHeight);
		}
		return null;
	}

	/**
	 * 
	 */
	public void runPhysics() {
		// if (System.currentTimeMillis() % 1 == 0) {
		// up
		if (contactDown(Math.round(yVelocity)) == false && Math.round(yVelocity) > 0) {
			yPos += Math.round(yVelocity);
			yVelocity += gravity;
		} else if (contactDown(0) == false && Math.round(yVelocity) > 0) {
			for (int i = Math.round(yVelocity); i > 0; i--) {
				if (contactDown(0) == true)
					continue;
				if (contactDown(Math.abs(i)) == false) {
					yPos = yPos + i;
				}

			}
			yVelocity = 0;
		} else if (contactDown(0) == true && Math.round(yVelocity) > 0) {
			yVelocity = 0;
		} else if (contactUp(Math.abs(Math.round(yVelocity))) == false && Math.round(yVelocity) <= 0) {
			yPos += Math.round(yVelocity);
			yVelocity += gravity;
		} else if (contactUp(0) == false && Math.round(yVelocity) <= 0) {
			for (int i = Math.round(yVelocity); i < 0; i++) {
				if (contactUp(0) == true)
					continue;
				if (contactUp(Math.abs(i) - 1) == false) {
					yPos += i;
				}
			}
			yVelocity = 0;
		} else if (contactUp(0) == true && Math.round(yVelocity) <= 0) {
			yVelocity = 0;
			yVelocity += gravity;
			yPos += Math.round(yVelocity);
		}
//		System.out.println(contactRight(Math.round(xVelocity)));
//		System.out.println(Math.round(xVelocity));
		// right
		if (contactRight(Math.round(xVelocity-1)) == false && xVelocity > 0f
				&& xPos + width < currentLevel.getWidth() * currentLevel.getTileWidth()) {
			xPos += Math.round(xVelocity);
			if (xVelocity > .5f && !tileDown().isSilppery())
				xVelocity -= tileDown().getFriction();
			else if (!tileDown().isSilppery())
				xVelocity = 0f;
		} else if (contactRight(0) == true && xVelocity > 0f) {
			xVelocity = 0f;
		}
		// left
		if (contactLeft(Math.abs(Math.round(xVelocity+1))) == false && xVelocity < 0f && xPos > 0) {
			xPos += Math.round(xVelocity);
			if (xVelocity < -.5f && !tileDown().isSilppery())
				xVelocity += tileDown().getFriction();
			else if (!tileDown().isSilppery())
				xVelocity = 0f;
		} else if (contactLeft(0) == true && xVelocity < 0f) {
			xVelocity = 0f;
		}
		// }
	}

}

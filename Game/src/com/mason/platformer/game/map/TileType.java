package com.mason.platformer.game.map;

import com.mason.platformer.graphics.texture.Texture;

/**
 * <code>TileTypes</code> have a <code>Texture</code>, as well as attributes
 * such as: if it is solid, if it is translucent, if it is slippery, and the
 * friction of the <code>TileType</code>.
 * <p>
 * Each <code>Tile</code> in a <code>Level</code> has a <code>TileType</code>.
 * This uses the <code>TYPES</code> array, giving each <code>TileType</code> an
 * numeric value is the array.
 * 
 * 
 * @author Mason
 * @see Texture
 * @see Tile
 * @see Level
 * @see #TYPES
 * 
 */
@SuppressWarnings("javadoc")
public class TileType {

	public static final TileType AIR = new TileType(Texture.AIR, false, false, false, 0.1f);
	public static final TileType BRICK = new TileType(Texture.BRICK, true, false, false, 1f);
	public static final TileType DIRT = new TileType(Texture.DIRT, true, false, false, 1f);
	public static final TileType GOLD = new TileType(Texture.GOLD, true, false, false, 1f);
	public static final TileType GRASS = new TileType(Texture.GRASS, true, false, false, 1f);
	public static final TileType ICE = new TileType(Texture.ICE, true, false, true, 0.05f);
	public static final TileType SPECIAL = new TileType(Texture.SPECIAL, true, false, false, 1f);
	public static final TileType WATER = new TileType(Texture.WATER, false, true, false, 2f);

	/**
	 * The <code>TileTypes</code> in an array alphabetically.
	 */
	public static final TileType[] TYPES = { AIR, BRICK, DIRT, GOLD, GRASS, ICE, SPECIAL, WATER };

	private final Texture texture;
	private final boolean isSolid;
	private final boolean isTranslucent;
	private final boolean isSilppery;
	private final float friction;

	/**
	 * Defines a <code>TileType</code> with color and if it is solid.
	 * 
	 * @param texture      The <code>Texture</code> used by the
	 *                     <code>TileType</code>.
	 * @param isSolid      If the <code>TileType</code> is solid.
	 * @param isTansulcent If the <code>TileType</code> is translucent.
	 * @param isSilppery   If the <code>TileType</code> is slippery.
	 * @param friction     The amount of friction the <code>TileType</code> has.
	 * 
	 * @see TileType
	 * @see Texture Texture
	 *      <p>
	 * @see #getTexture()
	 * @see #isSolid()
	 * @see #isTranslucent()
	 * @see #isSilppery()
	 * @see #getFriction()
	 * @see #getTileNum(TileType)
	 * 
	 */
	public TileType(Texture texture, boolean isSolid, boolean isTansulcent, boolean isSilppery, float friction) {
		this.texture = texture;
		this.isSolid = isSolid;
		this.isTranslucent = isTansulcent;
		this.isSilppery = isSilppery;
		this.friction = friction;
	}

	/**
	 * Tile type getter.
	 * 
	 * @return The Texture of the <code>TileType</code>.
	 */
	public int[][] getTexture() {
		return this.texture.getTexture();
	}

	/**
	 * Tile type getter.
	 * 
	 * @return If the <code>TileType</code> is solid.
	 */
	public boolean isSolid() {
		return this.isSolid;
	}

	/**
	 * Tile type getter.
	 * 
	 * @return If the <code>TileType</code> is translucent.
	 */
	public boolean isTranslucent() {
		return isTranslucent;
	}

	/**
	 * Tile type getter.
	 * 
	 * @return If the <code>TileType</code> is slippery.
	 */
	public boolean isSilppery() {
		return isSilppery;
	}

	/**
	 * Gets the number associated with a TileType in the array <code>TYPES</code>.
	 * 
	 * @param tile The tile you want the number of.
	 * @return The number the tile is in the <code>TYPES</code> array.
	 * @see #TYPES
	 */
	public static int getTileNum(TileType tile) {
		for (int i = 0; i < TYPES.length; i++) {
			if (TYPES[i] == tile) {
				return i;
			}
		}
		return 0;
	}

	/**
	 * Gets the friction constant associated with a <code>TileType</code>.
	 * 
	 * @return the friction constant
	 */
	public float getFriction() {
		return friction;
	}
}

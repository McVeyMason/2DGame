package com.mason.platformer.game;

import com.mason.platformer.graphics.texture.Texture;

/**
 * TileTypes have
 * 
 * @author Mason
 *
 */
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
	 * The tile types in an array alphabetically.
	 */
	public static final TileType[] TYPES = { AIR, BRICK, DIRT, GOLD, GRASS, ICE, SPECIAL, WATER };

	private final Texture texture;
	private final boolean isSolid;
	private final boolean isTansulcent;
	private final boolean isSilppery;
	private final float friction;

	/**
	 * Defines a {@link TileType} with color and if it is solid.
	 * 
	 * @param texture      The texture file used by the {@link TileType}.
	 * @param isSolid      If the {@link TileType} is solid.
	 * @param isTansulcent If the {@link TileType} is translucent.
	 * @param isSilppery   If the {@link TileType} is slippery.
	 * @param friction     The amount of friction the {@link TileType} has.
	 * 
	 */
	public TileType(Texture texture, boolean isSolid, boolean isTansulcent, boolean isSilppery, float friction) {
		this.texture = texture;
		this.isSolid = isSolid;
		this.isTansulcent = isTansulcent;
		this.isSilppery = isSilppery;
		this.friction = friction;
	}

	/**
	 * Tile type getter.
	 * 
	 * @return The Texture of the tile type.
	 */
	public int[][] getTexture() {
		return this.texture.getTexture();
	}

	/**
	 * Tile type getter.
	 * 
	 * @return If the tile type is solid.
	 */
	public boolean isSolid() {
		return this.isSolid;
	}

	/**
	 * Tile type getter.
	 * 
	 * @return
	 */
	public boolean isTansulcent() {
		return isTansulcent;
	}

	/**
	 * Tile type getter.
	 * 
	 * @return
	 */
	public boolean isSilppery() {
		return isSilppery;
	}

	/**
	 * Gets the number associated with a TileType in the array {@link #TYPES}.
	 * 
	 * @param tile The tile you want the number of.
	 * @return The number the tile is in the {@link #TYPES} array.
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
	 * Gets the friction constant associated with a {@link TileType}.
	 * 
	 * @return the friction constant
	 */
	public float getFriction() {
		return friction;
	}
}

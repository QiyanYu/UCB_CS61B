package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class MapGenerationParameters {
    private static final int START_X = 30;
    private static final int START_Y = 6;
    private static final int MAX_W = 8;
    private static final int MAX_H = 8;
    private static final int MAX_OFFSET = 3;
    private static final Room.Side ENTRY_SIDE = Room.Side.BOTTOM;
    private static final TETile ENTRY_TILE = Tileset.LOCKED_DOOR;
    private static final TETile EXIT_TILE = Tileset.FLOOR;
    public int width;
    public int height;
    private long seed;

    public static MapGenerationParameters defaultParameters() {
        return new MapGenerationParameters(100, 200);
    }

    public MapGenerationParameters(int width, int height) {
        this.width = width;
        this.height = height;
        seed = System.currentTimeMillis();
    }
}

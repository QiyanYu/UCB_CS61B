package byog.Core;

import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class WorldState {
    private final int width;
    private final int height;
    private final TETile[][] world;

    public WorldState(int width, int height) {
        this.width = width;
        this.height = height;
        world = new TETile[height][width];
        initialWorld(world);
    }

    /**
     * Initialize the world 2D array
     *
     * @param world 2D array of TETile
     */
    private void initialWorld(TETile[][] world) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }

    public TETile[][] terrianGird() {
        return world;
    }


}

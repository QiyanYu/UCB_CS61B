package byog.Core;

import byog.TileEngine.TETile;

public class WorldState {
    private int width;
    private int height;
    private TETile[][] world;

    public WorldState(int width, int height) {
        this.width = width;
        this.height = height;
        this.world = new TETile[height][width];
    }

    public TETile[][] terrianGird() {
        return world;
    }


}

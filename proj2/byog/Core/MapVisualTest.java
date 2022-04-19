package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class MapVisualTest {
    private static final int START_X = 30;
    private static final int START_Y = 6;
    private static final int MAX_W = 8;
    private static final int MAX_H = 8;
    private static final int MAX_OFFSET = 3;
    private static final Room.Side ENTRY_SIDE = Room.Side.BOTTOM;
    private static final TETile ENTRY_TILE = Tileset.LOCKED_DOOR;
    private static final TETile EXIT_TILE = Tileset.FLOOR;

    public static void main(String[] args) {
        TERenderer teRenderer = new TERenderer();
        MapGenerationParameters mgp = MapGenerationParameters.defaultParameters();
        teRenderer.initialize(mgp.width, mgp.height);
        WorldState ws = MapGenerator.generate(mgp);
        teRenderer.renderFrame(ws.terrianGird());
    }
}

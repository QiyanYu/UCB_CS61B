package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

public class MapGenerator {
    public static WorldState generate(MapGenerationParameters mgp) {
        return new WorldState(mgp.width, mgp.height);
    }


    /**
     * For drawing rooms and hallways (when height or width equals to 3)
     *
     * @param world  given world
     * @param p      is the starting point at left bottom
     * @param width  of outer shape (includes the walls)
     * @param height of outer shape (includes the walls)
     */
    private static void addShapes(TETile[][] world, Position p, int width, int height) {
        int x = p.getX();
        int y = p.getY();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int xCoord = j + x;
                int yCoord = i + y;
                if (i == 0 || i == height - 1 || j == 0 || j == width - 1) {
                    world[xCoord][yCoord] = Tileset.WALL;
                } else {
                    world[xCoord][yCoord] = Tileset.FLOOR;
                }
            }
        }
    }

    /**
     * Initialize the world 2D array
     *
     * @param world 2D array of TETile
     */
    private static void initialWorld(TETile[][] world) {
        int width = world[0].length;
        int height = world.length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                world[i][j] = Tileset.NOTHING;
            }
        }
    }


}

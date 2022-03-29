import synthesizer.GuitarString;

public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        final int stringLen = 37;
        GuitarString[] strings = new GuitarString[stringLen];
        double frequency;

        for (int i = 0; i < stringLen; i++) {
            frequency = 440 * Math.pow(2, ((double) i - 24) / 12);
            strings[i] = new GuitarString(frequency);
        }

        GuitarString typedString;

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index < 0) {
                    System.out.println("Invalid input!");
                    continue;
                }
                typedString = strings[index];
                typedString.pluck();
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (GuitarString gs : strings) {
                sample += gs.sample();
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (GuitarString gs : strings) {
                gs.tic();
            }
        }
    }
}

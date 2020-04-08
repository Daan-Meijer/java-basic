package drawprogram;

import java.util.Arrays;

public class CoordinateFix {

    static int[] coordinateFixer(int x1, int y1, int x2, int y2) {
        int[] xList = {x1, x2};
        int[] yList = {y1, y2};

        Arrays.sort(xList);
        Arrays.sort(yList);

        return new int[]{xList[0], yList[0], xList[1], yList[1]};
    }
}


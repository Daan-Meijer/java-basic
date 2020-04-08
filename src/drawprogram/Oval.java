package drawprogram;

import java.awt.*;
import java.util.Arrays;

public class Oval extends Figure{

    @Override
    public void draw(Graphics g) {
        int[] xList = {x1, x2};
        int[] yList = {y1, y2};

        Arrays.sort(xList);
        Arrays.sort(yList);

        x1 = xList[0];
        x2 = xList[1];
        y1 = yList[0];
        y2 = yList[1];

        g.drawOval(x1, y1, x2-x1, y2-y1);
    }
}

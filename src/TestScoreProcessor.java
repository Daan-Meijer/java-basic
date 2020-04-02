import java.util.Arrays;
import java.util.Random;

public class TestScoreProcessor {
    public static void main(String[] args) {
        Random random = new Random();
        int[] scores = new int[20];
        int highScorers = 0;

        for(int i=0; i<20; i++){
            scores[i] = random.nextInt(100);
            if (scores[i] >= 85 && scores[i] <= 90){
                highScorers += 1;
            }
        }

        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Students with scores between 85 and 90: " + highScorers);
    }
}

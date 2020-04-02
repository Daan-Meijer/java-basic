import java.util.ArrayList;

// This program writes the first 10 numbers in the sequence 4n+1 with the first n = 1.

public class NumberSequence {
    public static void main(String[] args) {
        ArrayList<Integer> sequence = new ArrayList<>();

        for(int n=0; n<10; n++){
            sequence.add(4*(n+1) + 1);
        }

        System.out.println(sequence.toString());
    }
}

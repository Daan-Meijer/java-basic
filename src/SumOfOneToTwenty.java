// This program calculates the sum of all integers from one to 20.

public class SumOfOneToTwenty {
    public static void main(String[] args) {
        int[] myList = new int[20];

        int sum = 0;
        for(int i=0; i<20; i++){
            myList[i] = i+1;
            sum += myList[i];
        }
        System.out.println("The sum of all numbers from one to twenty is " + sum);
    }
}


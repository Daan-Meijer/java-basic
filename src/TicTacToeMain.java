import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class TicTacToeMain extends JFrame implements ActionListener {
    private static String player;
    private static String computer;
    JButton[][] buttons = new JButton[3][3];

    public TicTacToeMain(){
        player = getPlayer();
        computer = getComputer(player);
        this.setTitle("Tic Tac Toe");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        getContentPane().add(panel);

        for(int i=0; i<3; i++) {
            for (int j=0; j<3; j++){
                JButton button = new JButton("");
                buttons[i][j] = button;
                button.setFont(new Font("Arial", Font.PLAIN, 25));
                panel.add(button);
                button.addActionListener(this);
            }
        }

        String[][] myBoard = new String[3][3];
        for (int row = 0; row<3; row++) {
            for (int col = 0; col<3; col++){
                myBoard[row][col] = buttons[row][col].getText();
            }
        }

        String order = "first";
        if (computer.equals("X")){
            order = "second";
            int[] bestComputerMove = computerMove(myBoard);
            buttons[bestComputerMove[0]][bestComputerMove[1]].setText(computer);
        }

        this.setSize(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JOptionPane.showMessageDialog(this, "Your symbol is " + player + ". You will go " + order + ".");
    }

    public static void main(String[] args) {
        new TicTacToeMain();
    }

    boolean WinCheck(String[][] myBoard){
        boolean win = false;
        for(int i=0; i<3; i++){
            if (myBoard[0][i].equals(myBoard[1][i]) && myBoard[0][i].equals(myBoard[2][i]) && !myBoard[0][i].equals("")){
                win = true;
            } else if (myBoard[i][0].equals(myBoard[i][1]) && myBoard[i][0].equals(myBoard[i][2]) && !myBoard[i][0].equals("")){
                win = true;
            } else if (myBoard[0][0].equals(myBoard[1][1]) && myBoard[0][0].equals(myBoard[2][2]) && !myBoard[0][0].equals("")){
                win = true;
            } else if (myBoard[0][2].equals(myBoard[1][1]) && myBoard[2][0].equals(myBoard[1][1]) && !myBoard[1][1].equals("")){
                win = true;
            }
        }
        return win;
    }

    boolean tieCheck(String[][] myBoard){
        boolean tie = false;
        ArrayList<String> myList = new ArrayList<>();
        for (int i=0; i<3; i++){
            myList.addAll(Arrays.asList(myBoard[i]).subList(0, 3));
        }
        if (myList.contains("")){
            tie = true;
        }
        return tie;
    }

    int[] computerMove(String[][] myBoard){
        ArrayList<ArrayList<Integer>> emptyList = new ArrayList<>();
        int[] moveCoordinates = new int[2];

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if(myBoard[i][j].equals("")){
                    ArrayList<Integer> emptyPair = new ArrayList<>();
                    emptyPair.add(i);
                    emptyPair.add(j);
                    emptyList.add(emptyPair);
                }
            }
        }
        boolean placed = false;
        for (ArrayList<Integer> coordinates : emptyList) {
            int x = coordinates.get(0);
            int y = coordinates.get(1);
            if (!placed) {
                String[][] testBoard = testBoardMaker(myBoard);
                testBoard[x][y] = computer;
                if (WinCheck(testBoard)) {
                    moveCoordinates[0] = x;
                    moveCoordinates[1] = y;
                    placed = true;
                }
            }
        }
        for (ArrayList<Integer> coordinates : emptyList) {
            int x = coordinates.get(0);
            int y = coordinates.get(1);
            if (!placed){
                String[][]testBoard = testBoardMaker(myBoard);
                testBoard[x][y] = player;
                if (WinCheck(testBoard)){
                    moveCoordinates[0] = x;
                    moveCoordinates[1] = y;
                    placed = true;
                }
            }
        }
        if (!placed){
            int coordinateIndex = new Random().nextInt(emptyList.size());
            ArrayList<Integer> coordinates = emptyList.get(coordinateIndex);
            moveCoordinates[0] = coordinates.get(0);
            moveCoordinates[1] = coordinates.get(1);
        }
        return moveCoordinates;
    }

    public static String getPlayer() {
        String[] symbols = {"X", "O"};
        int playerIndex = new Random().nextInt(symbols.length);
        return symbols[playerIndex];
    }

    public static String getComputer(String player) {
        String computer = "X";
        if (TicTacToeMain.player.equals("X")){
            computer = "O";
        }
        return computer;
    }

    String[][] testBoardMaker (String[][] myBoard) {
        String[][] testBoard = new String[3][3];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(myBoard[i], 0, testBoard[i], 0, 3);
        }
        return testBoard;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton)source;
        String text = button.getText();
        if (!text.equals("")){
            JOptionPane.showMessageDialog(this, "Select an empty space!", "Illegal Move", JOptionPane.ERROR_MESSAGE);
        } else {
            button.setText(player);
            String[][] myBoard = new String[3][3];
            for (int row = 0; row<3; row++) {
                for (int col = 0; col<3; col++){
                    myBoard[row][col] = buttons[row][col].getText();
                }
            }

            if(WinCheck(myBoard)){
                int choice = JOptionPane.showConfirmDialog(this, "Congratulations, you win! Would you like to play again?", "Winner!", JOptionPane.YES_NO_OPTION);
                if (choice == 0){
                    this.dispose();
                    new TicTacToeMain();
                } else {
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
            } else if (tieCheck(myBoard)) {
                int choice = JOptionPane.showConfirmDialog(this, "You tied! Would you like to play again?", "Tie!", JOptionPane.YES_NO_OPTION);
                if (choice == 0){
                    this.dispose();
                    new TicTacToeMain();
                } else {
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
            } else {
                int[] bestComputerMove = computerMove(myBoard);
                myBoard[bestComputerMove[0]][bestComputerMove[1]] = computer;
                buttons[bestComputerMove[0]][bestComputerMove[1]].setText(computer);
                if(WinCheck(myBoard)){
                    int choice = JOptionPane.showConfirmDialog(this, "You lose! Try again?", "Game Over!", JOptionPane.YES_NO_OPTION);
                    if (choice == 0){
                        this.dispose();
                        new TicTacToeMain();
                    } else {
                        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                    }
                } else if (tieCheck(myBoard)) {
                    int choice = JOptionPane.showConfirmDialog(this, "You tied! Would you like to play again?", "Tie!", JOptionPane.YES_NO_OPTION);
                    if (choice == 0) {
                        this.dispose();
                        new TicTacToeMain();
                    } else {
                        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                    }
                }
            }
        }
    }
}

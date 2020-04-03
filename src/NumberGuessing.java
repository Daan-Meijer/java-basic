import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

/* This program is a number guessing game for numbers between 0 and 1000. The player can select the difficulty level
 in a dialog screen. The player can then enter a number, after which the game shows whether the number is correct,
 or if the correct number is lower or highter. If the player guesses correctly, a win dialog pops up. If the player
 loses all their lives, a game over dialog pops up.
 */

public class NumberGuessing extends JFrame implements ActionListener {

    private JLabel display;
    private JTextField textField;
    private int number;
    private int myLives;

    public NumberGuessing(){
        this.setTitle("Number Guessing");
        
        Random random = new Random();
        number = random.nextInt(1000);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        getContentPane().add(panel);

        display = new JLabel();
        display.setFont(new Font("Arial", Font.PLAIN, 25));
        display.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(display);

        JLabel lives = new JLabel("");
        lives.setFont(new Font("Arial", Font.PLAIN, 25));
        lives.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lives);

        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(textField);
        textField.addActionListener(this);

        JButton button = new JButton("Reset");
        button.setFont(new Font("Arial", Font.PLAIN, 25));
        panel.add(button);
        button.addActionListener(this);

        this.setSize(300, 300);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Allow the player to select a difficulty, which changes the number of lives available.

        Object[] options = {"Easy", "Moderate", "Hard"};
        int n = JOptionPane.showOptionDialog(this, "What difficulty would you like?", "Difficulty", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

        switch (n){
            case 0:
                myLives = 30;
            break;
            case 1:
                myLives = 20;
            break;
            case 2:
                myLives = 10;
            break;
            default:
                System.out.println("You should not be here");
        }
        lives.setText("Lives = " + myLives);
    }

    public static void main(String[] args) {
        new NumberGuessing();
    }

    public void actionPerformed(ActionEvent e) {

        // Check which command was given
        String currentCommand = e.getActionCommand();
        // If reset was pressed, restart program
        if (currentCommand.equals("Reset")){
            this.dispose();
            new NumberGuessing();

        // If a number was entered, check the number
        } else {
            // If the number is correct, open the winning dialog. Yes restarts, no closes the application.
            if (number == Integer.parseInt(textField.getText())){
                display.setText("Correct, you win!");
                int choice = JOptionPane.showConfirmDialog(this, "You win, would you like to play again?", "You Win!", JOptionPane.YES_NO_OPTION);
                if (choice == 0){
                    this.dispose();
                    new NumberGuessing();
                } else {
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
            // If the number was incorrect, show whether the number is higher or lower than the guessed number
            } else if (number > Integer.parseInt(textField.getText())) {
                display.setText("Higher");
            } else {
                display.setText("Lower");
            }
            textField.setText("");

            // Lower the amount of lives left. If 0 lives are left, open the game over dialog. Yes restarts, no closes the application.
            myLives--;
            if (myLives == 0){
                int choice = JOptionPane.showConfirmDialog(this, "Game over, would you like to restart?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (choice == 0){
                    this.dispose();
                    new NumberGuessing();
                } else {
                    this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
                }
            }
        }
    }
}

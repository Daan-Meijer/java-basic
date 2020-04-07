import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Random;

public class Hangman extends JFrame implements ActionListener {
    JTextField textField;
    JLabel display;
    JLabel lifeCounter;
    String answerWord;
    JLabel guessedLetters;
    int lives;

    public Hangman() throws IOException {

        answerWord = wordPicker();
        String guessWord = guessWordBuilder(answerWord);

        lives = 10;

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        getContentPane().add(panel);

        display = new JLabel(guessWord);
        panel.add(display);
        display.setFont(new Font("Arial", Font.PLAIN, 25));
        display.setHorizontalAlignment(SwingConstants.CENTER);

        lifeCounter = new JLabel("Lives: "+ lives);
        panel.add(lifeCounter);
        lifeCounter.setFont(new Font("Arial", Font.PLAIN, 25));
        lifeCounter.setHorizontalAlignment(SwingConstants.CENTER);

        textField = new JTextField();
        panel.add(textField);
        textField.setFont(new Font("Arial", Font.PLAIN, 25));
        textField.addActionListener(this);
        textField.setHorizontalAlignment(SwingConstants.CENTER);

        guessedLetters = new JLabel("");
        panel.add(guessedLetters);
        guessedLetters.setFont(new Font("Arial", Font.PLAIN, 10));
    }

    public static void main(String[] args) throws IOException {
        Hangman hangman = new Hangman();
        hangman.setTitle("Hangman");
        hangman.setSize(300, 300);
        hangman.setVisible(true);
        hangman.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public String wordPicker() throws IOException {
        FileReader fileReader = new FileReader("C:/Users/Daan Meijer/IdeaProjects/BasicJava/src/HangmanWords.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> lines = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            lines.add(line);
        }
        bufferedReader.close();
        return lines.get(new Random().nextInt(lines.size()));
    }

    public String letterPlacer(String letter, String currentWord, String answerWord){
        for (int i=0; i<answerWord.length(); i++){
            String answerLetter = String.valueOf(answerWord.charAt(i));
            currentWord = currentWord.replaceAll(" ", "");
            if (letter.equals(answerLetter)){
                if (i==0){
                    currentWord = letter + currentWord.substring(1);
                } else if (i == answerWord.length()-1) {
                    currentWord = currentWord.substring(0, i) + letter;
                } else{
                    currentWord = currentWord.substring(0, i) + letter + currentWord.substring(i+1);
                }
            }
        }
        return currentWord.replaceAll("", " ");
    }

    public String guessWordBuilder(String answerWord){
        return "_".repeat(answerWord.length()).replaceAll("", " ");
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        String myGuess = textField.getText().toLowerCase();
        if (guessedLetters.getText().equals("")){
            guessedLetters.setText(myGuess);
        } else {
            lives--;
            lifeCounter.setText("Lives: "+ lives);
            guessedLetters.setText(guessedLetters.getText() + ", " + myGuess);
        }

        if (answerWord.contains(myGuess)){
            String placedLetters = letterPlacer(myGuess, display.getText(), answerWord);
            display.setText(placedLetters);
        }
        textField.setText("");
    }
}

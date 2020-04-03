import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JLabel display = new JLabel();
    int firstNumber;
    int secondNumber;
    String operator;
    int result;

    public Calculator(){
        this.setTitle("Calculator");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        getContentPane().add(panel, BorderLayout.CENTER);
        String[] labels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "+",
                "C", "0", "=", "-"
        };

        for(int i=0; i<16; i++){
            JButton button = new JButton(labels[i]);
            button.setFont(new Font("Arial", Font.PLAIN, 25));
            panel.add(button);
            button.addActionListener(this);
        }
        getContentPane().add(display, BorderLayout.NORTH);
        display.setPreferredSize(new Dimension(400,30));
        display.setFont(new Font("Arial", Font.PLAIN, 25));
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setSize(400, 400);
        calculator.setVisible(true);
        calculator.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentButton = e.getActionCommand();

        switch (currentButton){
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                display.setText(display.getText() + currentButton);
            break;

            case "/": case "*": case "+": case "-":
                operator = currentButton;
                firstNumber = Integer.parseInt(display.getText());
                display.setText("");
            break;

            case "C":
                firstNumber = secondNumber = 0;
                display.setText("");
            break;

            case "=":
                secondNumber = Integer.parseInt(display.getText());
                switch (operator){
                    case "/":
                        if (secondNumber != 0){
                            result = firstNumber / secondNumber;
                        } else {
                            display.setText("cannot divide by 0");
                        }
                    break;
                    case "*":
                        result = firstNumber * secondNumber;
                    break;
                    case "-":
                        result = firstNumber - secondNumber;
                    break;
                    case "+":
                        result = firstNumber + secondNumber;
                    break;
                    default:
                        throw new IllegalArgumentException("What the hell did you do?!");
                }
                if (!display.getText().equals("cannot divide by 0")){
                    display.setText(String.valueOf(result));
                }
            break;
            default:
                throw new IllegalArgumentException("What the hell did you do?!");
        }

    }
}

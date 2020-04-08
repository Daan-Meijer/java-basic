package drawprogram;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Draw extends JFrame implements MouseListener, ActionListener {

    Figure figure = new Line();
    String drawType = "Line";
    int counter = 0;
    ArrayList<Figure> figures = new ArrayList<>();

    public Draw() throws HeadlessException {
        this.addMouseListener(this);

        JToolBar shapeBar = new JToolBar("Shapes");
        String[] shapeButtons = {"Oval", "Rectangle", "Line", "Triangle"};
        for(String shapeButtonText : shapeButtons){
            JButton button = new JButton();
            button.setText(shapeButtonText);
            button.addActionListener(this);
            shapeBar.add(button);
        }
        setPreferredSize(new Dimension(500, 100));
        add(shapeBar, BorderLayout.NORTH);

        JToolBar eraseBar = new JToolBar("Eraser");
        String[] eraseButtons = {"Clear Last", "Clear All"};
        for(String eraseButtonText : eraseButtons){
            JButton button = new JButton();
            button.setText(eraseButtonText);
            button.addActionListener(this);
            eraseBar.add(button);
        }
        setPreferredSize(new Dimension(500, 100));
        add(eraseBar, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        Draw draw = new Draw();
        draw.setSize(500, 500);
        draw.setVisible(true);
        draw.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Figure f : figures) {
            f.draw(g);
        }
    }

    @Override

    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (counter == 0){
            switch (drawType) {
                case "Oval":
                    figure = new Oval();
                    break;
                case "Rectangle":
                    figure = new Rectangle();
                    break;
                case "Line":
                    figure = new Line();
                    break;
                case "Triangle":
                    figure = new Triangle();
                    break;
            }
            figure.x1 = e.getX();
            figure.y1 = e.getY();
            counter++;
        } else if (counter == 1 && (drawType.equals("Oval") || drawType.equals("Rectangle") || drawType.equals("Line"))){
            figure.x2 = e.getX();
            figure.y2 = e.getY();
            figures.add(figure);
            repaint();
            counter = 0;
        } else if (counter ==1 && drawType.equals("Triangle")){
            figure.x2 = e.getX();
            figure.y2 = e.getY();
            counter++;
        } else {
            figure.x3 = e.getX();
            figure.y3 = e.getY();
            figures.add(figure);
            repaint();
            counter = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        JButton button = (JButton)source;
        if (button.getText().equals("Clear Last")) {
            figures.remove(figures.size() - 1);
            repaint();
        } else if (button.getText().equals("Clear All")) {
            figures.clear();
            repaint();
        } else {
            drawType = button.getText();
        }
    }
}

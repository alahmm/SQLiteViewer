package jscrollpane;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scroll Bars");
        JTextArea textArea = new JTextArea(5, 5);
        JScrollPane scrollPane = new JScrollPane(textArea);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }
}
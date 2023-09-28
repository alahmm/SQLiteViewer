package jscrollpane;

import javax.swing.*;

public class ScrollPaneWithScrollPolicy {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Scroll Bars");
        JTextArea textArea = new JTextArea(5, 5);

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        frame.getContentPane().add(scrollPane);
        frame.setVisible(true);
    }
}

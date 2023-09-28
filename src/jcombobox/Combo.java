package jcombobox;

import javax.swing.*;
import java.awt.*;

public class Combo extends JFrame {
    public static void main(String[] args) {
        new Combo();
    }
    public Combo() {
        setTitle("SQLite Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 900);
        setLayout(null);
        setResizable(false);
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void initComponents() {
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        add(panel, BorderLayout.NORTH);

/*        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("Corgi");
        comboBox.addItem("Dog");
        comboBox.addItem("Hound");
        comboBox.addItem("Lapdog");*/
        /**
         * using an array with constructor
         *
         * String[] dogsStr = { "Corgi", "Dog", "Hound", "Lapdog" };
         * JComboBox comboBox = new JComboBox(dogsStr);
         */
        /**
         * using DefaultComboBoxModel
         */

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
        String[] dogsStr = { "Corgi", "Dog", "Hound", "Lapdog" };
        for (String dog : dogsStr) {
            comboBoxModel.addElement(dog);
        }
        JComboBox comboBox = new JComboBox(comboBoxModel);

        panel.add(comboBox);

    }
}

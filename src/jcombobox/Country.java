package jcombobox;

import javax.swing.*;
import java.awt.*;

class Country {
    private final static String[] COUNTRIES = { "Ethiopia", "Turkey", "Greece", "Iraq", "Serbia", "Colombia" };

    public void start() {
        JFrame frame = createFrame();

        JComboBox<String> comboBox = createComboBox();
        frame.add(comboBox);

        frame.setVisible(true);
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame("Country");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }

    private JComboBox<String> createComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(COUNTRIES);
        JComboBox<String> comboBox = new JComboBox<>(model);
        comboBox.addActionListener(actionEvent -> System.out.println("Combobox value was changed"));
        comboBox.setSelectedIndex(0); // choose the default option

        return comboBox;
    }
}

class CountryDemo {
    public static void main(String[] args) {
        Country country = new Country();
        country.start();
    }
}
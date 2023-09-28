package jcombobox;

import javax.swing.*;
import java.awt.*;

class CountryCapital {
    private final static String[] COUNTRIES = { "Ethiopia", "Turkey", "Greece", "Iraq", "Serbia", "Colombia" };
    private final static String[] CAPITALS = { "Addis Ababa", "Ankara", "Athens", "Baghdad", "Belgrade", "Bogota" };

    public void start() {
        JFrame frame = createFrame();

        JComboBox<String> comboBox = createComboBox();
        frame.add(comboBox);

        JLabel label = createLabel(comboBox.getSelectedIndex());
        frame.add(label);

        comboBox.addActionListener(actionEvent -> label.setText(CAPITALS[comboBox.getSelectedIndex()]));

        frame.setVisible(true);
    }

    private JFrame createFrame() {
        JFrame frame = new JFrame("Country and Capital");
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }

    private JComboBox<String> createComboBox() {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(COUNTRIES);
        JComboBox<String> comboBox = new JComboBox<>(model);
        comboBox.setSelectedIndex(0); // choose the default option

        return comboBox;
    }

    private JLabel createLabel(int selectedIndex) {
        JLabel label = new JLabel();
        label.setText(CAPITALS[selectedIndex]);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        return label;
    }
}

class CountryCapitalDemo {
    public static void main(String[] args) {
        CountryCapital countryCapital = new CountryCapital();
        countryCapital.start();
    }
}
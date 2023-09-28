package viewer;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteViewer extends JFrame {

    public SQLiteViewer() throws SQLException {
        setTitle("SQLite Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 800);
        setLayout(null);
        setResizable(false);
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void initComponents() throws SQLException {
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel3 = new JPanel(new BorderLayout());
        List<JPanel> panels = List.of(panel, panel1, panel3);
        panels.forEach(panell -> panell.setPreferredSize(new Dimension(670, 30)));
        panel2.setPreferredSize(new Dimension(670, 90));
        add(panel);
        add(panel1);
        add(panel2);
        add(panel3);

        //setLayout(new GridLayout(4, 1, 5, 5));
        JLabel labelData = new JLabel("Database:");
        JLabel labelTable = new JLabel("Table:");
        JLabel labelQuery = new JLabel("Query:");

        List<JLabel> listOfLabels = List.of(labelData, labelTable, labelQuery);
        listOfLabels.forEach(label -> label.setPreferredSize(new Dimension(65, 10)));

        panel.add(labelData, BorderLayout.WEST);
        panel1.add(labelTable, BorderLayout.WEST);
        panel2.add(labelQuery, BorderLayout.WEST);

        JButton button = new JButton();
        button.setName("OpenFileButton");
        button.setText("Open");

        JTextField textField = new JTextField();

        textField.setName("FileNameTextField");

        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.EAST);

        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setName("TablesComboBox");
        panel1.add(comboBox, BorderLayout.CENTER);

        JTextArea textArea = new JTextArea();
        textArea.setName("QueryTextArea");

        panel2.add(textArea, BorderLayout.CENTER);

        JButton button1 = new JButton();
        button1.setName("ExecuteQueryButton");
        button1.setText("Execute");
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\alahmm\\Desktop\\icons\\execute.png");
        // Resize the icon to your desired width and height
        int width = 20; // Set the desired width
        int height = 20; // Set the desired height
        Image resizedImage = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        // Create a new ImageIcon with the resized image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        button1.setIcon(resizedIcon);
        button1.setPreferredSize(new Dimension(105, 10));

        panel3.add(button1, BorderLayout.EAST);
        List<String> listOfTables = new ArrayList<>();


        button.addActionListener(e -> {
            try {
                String text = textField.getText();
                String path = "C:\\sqlite\\" + text;

                comboBox.removeAllItems();
                listOfTables.clear();

                Connection connection = DriverManager.getConnection("jdbc:sqlite:" + path);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type ='table' AND name NOT LIKE 'sqlite_%'");

                while (resultSet.next()) {
                    String tableName = resultSet.getString("name");
                    listOfTables.add(tableName);
                }
                resultSet.close();
                statement.close();
                connection.close();
                // Process the ResultSet here
            } catch (SQLException ex) {
                // Handle any SQL exceptions here
            }
            listOfTables.forEach(comboBox::addItem);
            comboBox.setSelectedIndex(0);
        });
        comboBox.addActionListener(e -> {
            String nameToSelect = (String) comboBox.getSelectedItem();
            textArea.setText("SELECT * FROM " + nameToSelect + ";");
        });
    }
    }




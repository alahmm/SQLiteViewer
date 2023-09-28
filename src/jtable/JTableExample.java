package jtable;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class JTableExample extends JFrame {
    public static void main(String[] args) {
        JTableExample table = new JTableExample();
        table.setVisible(true);
    }

    public JTableExample() {
        super("JTable Example");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.white);
        /**
         * other way
         */
        Object[] columns = new Object[] { "Name", "Race" };
        Object[][] data = new Object[][] {
                {"Frodo", "Hobbit"},
                {"Legolas", "Elf"},
                {"Gimli", "Dwarf"}
        };

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        for (Object[] row : data) {
            model.addRow(row);
        }
        /**
         * until here
         */

        TableModel tableModel = new MyTableModel();

        JTable table = new JTable(tableModel);//or model instead of tableModel

        /**
         * to adjust the size of the column
         */
        TableColumn column = table.getColumnModel().getColumn(0);
        column.setPreferredWidth(200);

        /**
         * table listener
         */
        tableModel.addTableModelListener(new CustomListener()); //Adds the TableModelListener

        JScrollPane sp = new JScrollPane(table);
        this.add(sp);


        tableModel.setValueAt("James", 0, 0);

        /**
         * for sorting
         */
        //table.setAutoCreateRowSorter(true);
        /**
         * for sorting also
         */
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableModel);
        table.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("James"));
    }
}
class CustomListener implements TableModelListener {
    @Override
    public void tableChanged(TableModelEvent e) {
        System.out.println("Table Updated!");

    }
}
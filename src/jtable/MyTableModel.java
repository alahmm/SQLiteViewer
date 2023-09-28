package jtable;

import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
    String[] columns = {"Employee Name" , "Job Title" , "Salary"};
    Object[][] data = {{"Bob" , "Programmer" , 19000} , {"Alice" , "Programmer" , 19000}};

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columns[columnIndex];
    }
    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = value;
        fireTableCellUpdated(rowIndex,columnIndex);
    }

}
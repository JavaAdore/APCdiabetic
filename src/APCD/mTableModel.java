package APCD;


import java.awt.Dimension;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamed-ITI
 */
public class mTableModel extends AbstractTableModel {
    private String[] columnNames ;
    private Object[][] data; 
    
    mTableModel(){
    columnNames=new String[] {"","Saterday","Sunday","Monday","Tuesday","wednesday","Thursday","Friday"};
    data=new Object[][] {
            {"A_sleep", "", "", "", "","", "",""},
            {"Breackfast", "", "", "", "","", "",""},
            {"Lunch", "", "", "", "","", "",""},
            {"Diner", "", "", "", "","", "",""},
            {"B_Sleep", "", "", "", "","", "",""},
            {"Sudn_Drop", "", "", "", "","", "",""}
            
            
    };
}
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col >= 2;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        this.fireTableCellUpdated(row,col);

    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    
    public static void main(String[] args)
    {
        mTableModel model = new mTableModel();
        
        int count = model.getRowCount();
    
        for(int i=0; i<model.getRowCount();i++){
            model.setValueAt("Date "+ i+1 + " from main", i, 1);
        }
    
        model.setValueAt("Date from main", 3, 3);

        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 218, 884, 194);
        //now adding this to the frame where I want to show 
        JFrame frame = new JFrame();
        frame.add(scrollPane);
        frame.setBounds(5, 218, 884, 194);
        //frame.pack();
        frame.setVisible(true);
    }
}

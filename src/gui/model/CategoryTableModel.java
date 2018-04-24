package gui.model;
 
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Category;
import service.CategoryService;
 
public class CategoryTableModel extends AbstractTableModel {
 
    String[] columnNames = new String[] { "Category Name", "Number of Expense"};
 
    // use the List return from Service as the data of TableModel
 
    public List<Category> cs = new CategoryService().list();
 
     public int getRowCount() {
        
        return cs.size();
    }
 
    public int getColumnCount() {
        
        return columnNames.length;
    }
 
    public String getColumnName(int columnIndex) {
        
        return columnNames[columnIndex];
    }
 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    // Firstly, use cs.get(rowIndex) to get Category object in the specific row
    // And then, return relative attribute according to columnIndex
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category h = cs.get(rowIndex);
        if (0 == columnIndex)
            return h.name;
        if (1 == columnIndex)
            return h.recordNumber;

        return null;
    }
 
}

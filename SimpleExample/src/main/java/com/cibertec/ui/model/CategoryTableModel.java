package com.cibertec.ui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.cibertec.entity.Category;

public class CategoryTableModel extends AbstractTableModel {

	private String[] columnName = {"Codigo", "Descripcion", "Fec. Actualizacion"};
	private List<Category> categoryList = new ArrayList();
	
	@Override
	public int getRowCount() {
		
		return categoryList.size();
	}

	@Override
	public String getColumnName(int column) {
		
		return columnName[column];
	}

	@Override
	public int getColumnCount() {
		
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Category category = categoryList.get(rowIndex);
		
		Object value = null;
		
		if(columnIndex == 0) {
			
			value = category.getCategoryId();
		} else if(columnIndex == 1) {
			
			value = category.getName();
		} else {
			
			value = category.getLastUpdate().toString();
		}
		
		return value;
	}

	public void setCategoryList(List<Category> categoryList) {
		
		this.categoryList = categoryList;
		
		fireTableDataChanged();
	}		
	
}

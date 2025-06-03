package com.cibertec.ui.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.cibertec.entity.Actor;

public class ActorTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 3597581503525961691L;

	private String[] columnName = { "Código", "Nombre", "Apellido", "Fec. Actualización" };

	private List<Actor> actorList = new ArrayList<Actor>();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@Override
	public int getRowCount() {
		return actorList.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Actor actor = actorList.get(rowIndex);
		
		Object value = null;
		if (columnIndex == 0) {
			value = actor.getActorId();
		} else if (columnIndex == 1) {
			value = actor.getFirstName();
		} else if (columnIndex == 2) {
			value = actor.getLastName();
		} else if (columnIndex == 3) {
			value = sdf.format(actor.getLastUpdate());
		}
		
		return value;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnName[columnIndex];
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
		fireTableDataChanged();
	}

}

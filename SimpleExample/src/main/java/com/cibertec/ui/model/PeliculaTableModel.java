package com.cibertec.ui.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.cibertec.entity.Film;

public class PeliculaTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -7137847863085220319L;

	private String[] columnName = {"Código", "Tïtulo", "Año", "Idioma", "Caracteristas Especiales"};
	private List<Film> filmList = new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
	
	@Override
	public int getRowCount() {
		return filmList.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnName[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Film film = filmList.get(rowIndex);

		Object value = null;
		if (columnIndex == 0) {
			value = film.getFilmId();
		} else if (columnIndex == 1) {
			value = film.getTitle();
		} else if (columnIndex == 2) {
			value = sdf.format(film.getReleaseYear());
		} else if (columnIndex == 3) {
			value = film.getLanguage1().getName();
		} else if (columnIndex == 4) {
			value = film.getSpecialFeatures();
		}

		return value;
	}

	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
		fireTableDataChanged();
	}

}

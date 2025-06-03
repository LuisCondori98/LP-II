package com.cibertec.ui.renderer;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import com.cibertec.entity.Actor;

public class ActorCellRenderer extends JLabel implements ListCellRenderer<Actor> {

	private static final long serialVersionUID = -2454255695166734523L;

	public ActorCellRenderer() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(
            JList<? extends Actor> list,
            Actor value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        if (value != null) {
            setText(value.getFirstName() + " " + value.getLastName());
        } else {
            setText("");
        }

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        return this;
    }
    
}
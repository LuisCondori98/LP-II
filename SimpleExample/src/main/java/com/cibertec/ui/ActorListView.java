package com.cibertec.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cibertec.entity.Actor;
import com.cibertec.ui.model.ActorTableModel;
import com.cibertec.util.JPAUtil;
import com.cibertec.util.TypeOperation;

import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;

public class ActorListView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JToolBar toolBar;
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnVer;
	private JButton btnEliminar;
	private JPanel pnlContenido;
	private JPanel pnlTitulo;
	private JLabel lblTitulo;
	private JScrollPane scrollPane;
	
	private JTable table;
	
	private ActorTableModel tableModel = new ActorTableModel();

	/**
	 * Create the dialog.
	 */
	public ActorListView(JFrame parent) {
		super(parent);
		initComponents();
	}
	
	private void initComponents() {
		setModal(true);
		setTitle("Listado de Actores");
		setResizable(false);
		setBounds(100, 100, 611, 343);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(new BorderLayout(0, 0));
		
		this.toolBar = new JToolBar();
		this.toolBar.setFloatable(false);
		this.contentPanel.add(this.toolBar, BorderLayout.NORTH);
		
		this.btnNuevo = new JButton("Nuevo");
		this.btnNuevo.setIcon(new ImageIcon(MainView.class.getResource("/icons/add.png")));
		this.btnNuevo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createActor();
			}
		});
		this.toolBar.add(this.btnNuevo);
		
		this.toolBar.add(new JSeparator(JSeparator.VERTICAL));
		this.toolBar.add(new JSeparator(JSeparator.VERTICAL));
		
		this.btnEditar = new JButton("Editar");
		this.btnEditar.setIcon(new ImageIcon(MainView.class.getResource("/icons/pencil.png")));
		this.btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateActor();
			}
		});
		this.toolBar.add(this.btnEditar);
		
		this.btnEliminar = new JButton("Eliminar");
		this.btnEliminar.setIcon(new ImageIcon(MainView.class.getResource("/icons/delete.png")));
		this.btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeActor();
			}
		});
		this.toolBar.add(this.btnEliminar);
		
		this.toolBar.add(new JSeparator(JSeparator.VERTICAL));
		this.toolBar.add(new JSeparator(JSeparator.VERTICAL));
		
		this.btnVer = new JButton("Ver");
		this.btnVer.setIcon(new ImageIcon(MainView.class.getResource("/icons/zoom.png")));
		this.btnVer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewActor();
			}
		});
		this.toolBar.add(this.btnVer);
		
		this.pnlContenido = new JPanel();
		this.contentPanel.add(this.pnlContenido, BorderLayout.CENTER);
		this.pnlContenido.setLayout(new BorderLayout(0, 0));
		
		this.pnlTitulo = new JPanel();
		FlowLayout fl_pnlTitulo = (FlowLayout) this.pnlTitulo.getLayout();
		fl_pnlTitulo.setAlignment(FlowLayout.LEFT);
		this.pnlContenido.add(this.pnlTitulo, BorderLayout.NORTH);
		
		this.lblTitulo = new JLabel("Actores");
		this.lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.pnlTitulo.add(this.lblTitulo);
		
		this.scrollPane = new JScrollPane();
		this.pnlContenido.add(this.scrollPane, BorderLayout.CENTER);
		
		this.table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.scrollPane.setViewportView(this.table);
		
		loadActores();
	}
	
	private void loadActores() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		TypedQuery<Actor> query = entityManager.createNamedQuery("Actor.findAll", Actor.class);
		List<Actor> actorList = query.getResultList();
		tableModel.setActorList(actorList);
	}
	
	private void createActor() {
		ActorView view = new ActorView(this, TypeOperation.NEW);
		view.setVisible(true);
		
		if (view.isAccept()) {
			loadActores();
			int selectedRow = table.getRowCount() - 1;
			table.setRowSelectionInterval(selectedRow, selectedRow);
			Rectangle rect = table.getCellRect(selectedRow, 0, true);
            table.scrollRectToVisible(rect);
		}
	}
	
	private void updateActor() {
		int selectedRow = table.getSelectedRow();
		
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un Actor", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Actor actor = tableModel.getActorList().get(selectedRow);
		
		ActorView view = new ActorView(this, TypeOperation.UPDATE, actor);
		view.setVisible(true);
		
		if (view.isAccept()) {
			loadActores();
			table.setRowSelectionInterval(selectedRow, selectedRow);
			Rectangle rect = table.getCellRect(selectedRow, 0, true);
            table.scrollRectToVisible(rect);
		}
	}
	
	private void viewActor() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un Actor", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Actor actor = tableModel.getActorList().get(table.getSelectedRow());
		
		ActorView view = new ActorView(this, TypeOperation.VIEW, actor);
		view.setVisible(true);
	}
	
	private void removeActor() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un Actor", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();

		try {
			int codigo = tableModel.getActorList().get(table.getSelectedRow()).getActorId();
			Actor actor = entityManager.find(Actor.class, codigo);
			
			entityManager.remove(actor);
			entityManager.getTransaction().commit();
			loadActores();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Problemas al guardar la información", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}

}

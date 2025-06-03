package com.cibertec.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import com.cibertec.entity.Category;
import com.cibertec.ui.model.ActorTableModel;
import com.cibertec.ui.model.CategoryTableModel;
import com.cibertec.util.JPAUtil;

public class CategoryListView extends JDialog {

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
	
	private CategoryTableModel tableModel = new CategoryTableModel();

	/**
	 * Create the dialog.
	 */
	public CategoryListView(JFrame parent) {
		super(parent);
		initComponents();
	}
	
	private void initComponents() {
		setModal(true);
		setTitle("Listado de Categorias");
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
				
				//createActor();
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
				
				//updateActor();
			}
		});
		this.toolBar.add(this.btnEditar);
		
		this.btnEliminar = new JButton("Eliminar");
		this.btnEliminar.setIcon(new ImageIcon(MainView.class.getResource("/icons/delete.png")));
		this.btnEliminar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//removeActor();
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
				
				//viewActor();
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
		
		loadCategories();
	}

	private void loadCategories() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
		
		List<Category> categoryList = query.getResultList();
		
		tableModel.setCategoryList(categoryList);
	}
}

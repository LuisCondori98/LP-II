package com.cibertec.ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnMantenimiento;
	private JMenu mnOperaciones;
	private JMenu mnMantPeliculas;
	private JMenu mnuMantOtros;
	private JMenuItem mnuiMantActor;
	private JMenuItem mnuiMantIdioma;
	private JMenuItem mnuiMantCategoria;
	private JMenuItem mnuiPelicula;
	private JMenuItem mnuiMantCiudad;
	private JMenuItem mnuiMantPais;
	private JMenuItem mnuiMantDireccion;
	private JMenuItem mnuiCliente;
	private JMenuItem mnuiTienda;
	private JMenu mnReportes;
	private JMenuItem mnuiPeliculaPorActor;
	private JMenuItem mnuiTiendaPorPais;
	private JMenuItem mnuiPeliculaRentada;
	private JMenuItem mnuiStaff;
	private JMenuItem mnuiRenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace(); 
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		initComponents();
	}
	private void initComponents() {
		setTitle("Sakila Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 412, 201);
		setJMenuBar(this.menuBar);
		
		this.mnOperaciones = new JMenu("Operaciones");
		this.menuBar.add(this.mnOperaciones);
		
		this.mnuiRenta = new JMenuItem("Alquilar Película");
		this.mnOperaciones.add(this.mnuiRenta);
		
		this.mnMantenimiento = new JMenu("Mantenimiento");
		this.menuBar.add(this.mnMantenimiento);
		
		this.mnMantPeliculas = new JMenu("Peliculas");
		this.mnMantenimiento.add(this.mnMantPeliculas);
		
		this.mnuiMantActor = new JMenuItem("Actor");
		this.mnuiMantActor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showActorListView();
			}
		});
		this.mnMantPeliculas.add(this.mnuiMantActor);
		
		this.mnuiMantIdioma = new JMenuItem("Idioma");
		this.mnMantPeliculas.add(this.mnuiMantIdioma);
		
		this.mnuiMantCategoria = new JMenuItem("Categoría");
		this.mnuiMantCategoria.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				showCategoryListView();
			}
		});
		this.mnMantPeliculas.add(this.mnuiMantCategoria);
		
		this.mnuiPelicula = new JMenuItem("Película");
		this.mnMantPeliculas.add(this.mnuiPelicula);
		
		this.mnuMantOtros = new JMenu("Otros");
		this.mnMantenimiento.add(this.mnuMantOtros);
		
		this.mnuiMantCiudad = new JMenuItem("Ciudad");
		this.mnuMantOtros.add(this.mnuiMantCiudad);
		
		this.mnuiMantPais = new JMenuItem("País");
		this.mnuMantOtros.add(this.mnuiMantPais);
		
		this.mnuiMantDireccion = new JMenuItem("Dirección");
		this.mnuMantOtros.add(this.mnuiMantDireccion);
		
		this.mnuiCliente = new JMenuItem("Cliente");
		this.mnuMantOtros.add(this.mnuiCliente);
		
		this.mnuiTienda = new JMenuItem("Tienda");
		this.mnuMantOtros.add(this.mnuiTienda);
		
		this.mnuiStaff = new JMenuItem("Staff");
		this.mnuMantOtros.add(this.mnuiStaff);
		
		this.mnReportes = new JMenu("Reportes");
		this.menuBar.add(this.mnReportes);
		
		this.mnuiPeliculaPorActor = new JMenuItem("Peliculas por Actor");
		this.mnuiPeliculaPorActor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showPeliculasPorActorView();
			}
		});
		this.mnReportes.add(this.mnuiPeliculaPorActor);
		
		this.mnuiTiendaPorPais = new JMenuItem("Tiendas por País");
		this.mnReportes.add(this.mnuiTiendaPorPais);
		
		this.mnuiPeliculaRentada = new JMenuItem("Peliculas Rentadas");
		this.mnReportes.add(this.mnuiPeliculaRentada);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
	}

	protected void showCategoryListView() {
		
		CategoryListView view = new CategoryListView(this);
		view.setVisible(true);
	}

	private void showActorListView() {
		ActorListView view = new ActorListView(this);
		view.setVisible(true);
	}
	
	private void showPeliculasPorActorView() {
		PeliculasPorActorView view = new PeliculasPorActorView(this);
		view.setVisible(true);
	}

}

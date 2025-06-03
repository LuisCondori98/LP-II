package com.cibertec.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cibertec.entity.Actor;
import com.cibertec.entity.Film;
import com.cibertec.ui.model.PeliculaTableModel;
import com.cibertec.ui.renderer.ActorCellRenderer;
import com.cibertec.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PeliculasPorActorView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblActor;
	private JComboBox<Actor> cmbActor;
	private JButton btnBuscar;
	private JButton cancelButton;
	private JTable table;

	private PeliculaTableModel tableModel = new PeliculaTableModel();
	
	public PeliculasPorActorView(JFrame parent) {
		super(parent);
		initComponents();
	}

	private void initComponents() {
		setModal(true);
		setTitle("Consulta de Películas por Actor");
		setBounds(100, 100, 600, 450);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		this.contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		this.contentPanel.add(panel, BorderLayout.NORTH);

		lblActor = new JLabel("Actor");
		panel.add(lblActor);

		cmbActor = new JComboBox<Actor>();
		cmbActor.setRenderer(new ActorCellRenderer());
		panel.add(cmbActor);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(MainView.class.getResource("/icons/zoom.png")));
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buscarPelicula();
			}
		});
		panel.add(btnBuscar);

		JScrollPane scrollPane = new JScrollPane();
		this.contentPanel.add(scrollPane, BorderLayout.CENTER);

		this.table = new JTable(tableModel);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(this.table);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		cancelButton = new JButton("Salir");
		cancelButton.setIcon(new ImageIcon(MainView.class.getResource("/icons/door_in.png")));
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(cancelButton);

		loadActores();
	}

	private void loadActores() {
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Actor> query = em.createNamedQuery("Actor.findAll", Actor.class);
		
		List<Actor> actorList = query.getResultList();
		for (Actor actor: actorList) {
			cmbActor.addItem(actor);
		}
	}
	
	private void buscarPelicula() {
		Actor actor = (Actor) cmbActor.getSelectedItem();
		
		if (actor == null) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un Actor", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Film> query = em.createQuery("select f from Film f join FilmActor c where f.filmId = c.film.filmId and c.actor.actorId = " + actor.getActorId(), Film.class);
		//Query query = em.createNativeQuery("select f.* from Film f inner join Film_Actor c on f.film_Id = c.film_Id where c.actor_Id = " + actor.getActorId(), Film.class);
		//List<Object[]> filmList = query.getResultList();
		List<Film> filmList = query.getResultList();
		
		tableModel.setFilmList(filmList);
	}
	
}

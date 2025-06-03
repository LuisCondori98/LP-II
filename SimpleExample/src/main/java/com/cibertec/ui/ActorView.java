package com.cibertec.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.cibertec.entity.Actor;
import com.cibertec.util.JPAUtil;
import com.cibertec.util.TypeOperation;

import javax.persistence.EntityManager;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class ActorView extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtApellido;

	private TypeOperation type = TypeOperation.VIEW;
	private boolean accept;
	private Actor actor = null;

	public ActorView(JDialog parent, TypeOperation type) {
		this(parent, type, null);
	}

	public ActorView(JDialog parent, TypeOperation type, Actor actor) {
		super(parent);
		this.type = type;
		
		if (actor == null) {
			this.actor = new Actor();
		} else {			
			this.actor = actor;
		}
		initComponents();
	}

	private void initComponents() {
		setModal(true);
		setTitle("Información del Actor");
		setResizable(false);
		setBounds(100, 100, 301, 168);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 75, 63, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		this.contentPanel.setLayout(gbl_contentPanel);

		JLabel lblCodigo = new JLabel("Código: ");
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.fill = GridBagConstraints.VERTICAL;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 0;
		gbc_lblCodigo.gridy = 0;
		this.contentPanel.add(lblCodigo, gbc_lblCodigo);

		this.txtCodigo = new JTextField();
		this.txtCodigo.setEnabled(false);
		this.txtCodigo.setEditable(false);
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigo.gridx = 1;
		gbc_txtCodigo.gridy = 0;
		this.contentPanel.add(this.txtCodigo, gbc_txtCodigo);
		this.txtCodigo.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.fill = GridBagConstraints.VERTICAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		this.contentPanel.add(lblNombre, gbc_lblNombre);

		this.txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.gridwidth = 2;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.BOTH;
		gbc_txtNombre.gridx = 1;
		gbc_txtNombre.gridy = 1;
		this.contentPanel.add(this.txtNombre, gbc_txtNombre);
		this.txtNombre.setColumns(10);
		this.txtNombre.setEditable(type != TypeOperation.VIEW);

		JLabel lblApellido = new JLabel("Apellido: ");
		GridBagConstraints gbc_lblApellido = new GridBagConstraints();
		gbc_lblApellido.anchor = GridBagConstraints.EAST;
		gbc_lblApellido.fill = GridBagConstraints.VERTICAL;
		gbc_lblApellido.insets = new Insets(0, 0, 0, 5);
		gbc_lblApellido.gridx = 0;
		gbc_lblApellido.gridy = 2;
		this.contentPanel.add(lblApellido, gbc_lblApellido);

		this.txtApellido = new JTextField();
		GridBagConstraints gbc_txtApellido = new GridBagConstraints();
		gbc_txtApellido.gridwidth = 2;
		gbc_txtApellido.fill = GridBagConstraints.BOTH;
		gbc_txtApellido.gridx = 1;
		gbc_txtApellido.gridy = 2;
		this.contentPanel.add(this.txtApellido, gbc_txtApellido);
		this.txtApellido.setColumns(10);
		this.txtApellido.setEditable(type != TypeOperation.VIEW);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("Guardar");
		okButton.setIcon(new ImageIcon(MainView.class.getResource("/icons/disk.png")));
		okButton.setActionCommand("OK");
		okButton.setVisible(type != TypeOperation.VIEW);
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.setIcon(new ImageIcon(MainView.class.getResource("/icons/door_in.png")));
		cancelButton.setActionCommand("Cancel");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		buttonPane.add(cancelButton);

		showActorInfo();
	}

	private void guardar() {
		actor.setFirstName(txtNombre.getText());
		actor.setLastName(txtApellido.getText());
		actor.setLastUpdate(new Date());

		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();

		try {
			if (type == TypeOperation.NEW) {
				entityManager.persist(actor);
			} else if (type == TypeOperation.UPDATE) {
				entityManager.merge(actor);
			}
			entityManager.getTransaction().commit();

			accept = true;
			dispose();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Problemas al guardar la información", "Mensaje del Sistema", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cancelar() {
		accept = false;
		dispose();
	}

	public void showActorInfo() {
		if (actor == null) {
			return;
		}

		txtCodigo.setText(String.valueOf(actor.getActorId()));
		txtNombre.setText(actor.getFirstName());
		txtApellido.setText(actor.getLastName());
	}

	public boolean isAccept() {
		return accept;
	}

}

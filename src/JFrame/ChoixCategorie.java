package JFrame;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.*;
import POJO.Categorie;
import POJO.Client;
import POJO.Place;
import POJO.Representation;
import POJO.Spectacle;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ChoixCategorie extends JFrame {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Categorie> DAOCategorie = adf.getCatetogieDAO();
	DAO<Spectacle> DAOSpectacle = adf.getSpectacleDAO();
	DAO<Representation> DAORepresentation = adf.getRepresentationDAO();
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JSpinner SpinAReserver;
	SpinnerModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public ChoixCategorie(int idSpectacle, int IdRepresentation,Client cli) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 247, 243);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Type de la place", "Prix", "Places restantes", "NombrePlace","Id" }) {
			boolean[] columnEditables = new boolean[] { false, false, false};

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		List<Categorie> listes = ((CategorieDAO) DAOCategorie).getAll(idSpectacle);
		for (var j : listes) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[] { j.getType(), j.getPrix(), j.getNbrPlaceDispo(),j.getNbrPlaceMax(), j.getIdCategorie() };
			model.addRow(row);
		}
		table.removeColumn(table.getColumnModel().getColumn(3));
		table.removeColumn(table.getColumnModel().getColumn(3));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
		scrollPane.setViewportView(table);
		
		JLabel lblNombreDeReservation = new JLabel("Nombre place \u00E0 reserver");
		lblNombreDeReservation.setBounds(267, 17, 159, 13);
		contentPane.add(lblNombreDeReservation);

		Spectacle s = ((SpectacleDAO) DAOSpectacle).find(idSpectacle);
		if (s.getNbrPlaceParClient() != 0)
			model = new SpinnerNumberModel(1, 1, s.getNbrPlaceParClient(), 1);
		else
			model = new SpinnerNumberModel(1, 1, 8000, 2);
		SpinAReserver = new JSpinner(model);
		SpinAReserver.setBounds(320, 40, 51, 20);
		contentPane.add(SpinAReserver);

		btnNewButton = new JButton("Reserver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((int) table.getModel().getValueAt(table.getSelectedRow(), 2)-(int) SpinAReserver.getValue()>0)
				{
					var confirmer = JOptionPane.showConfirmDialog(null, "Voulez vous confirmer?");
					if (confirmer == 0) {
						table.repaint();
						Place p = new Place(0, 0, DAORepresentation.find(IdRepresentation));
						p.calculerPrix((double) table.getModel().getValueAt(table.getSelectedRow(), 1),
								(int) SpinAReserver.getValue());
						Categorie c = new Categorie((String) table.getModel().getValueAt(table.getSelectedRow(), 0),
								(double) table.getModel().getValueAt(table.getSelectedRow(), 1),
								(int) table.getModel().getValueAt(table.getSelectedRow(), 2)-(int) SpinAReserver.getValue(),
								(int) table.getModel().getValueAt(table.getSelectedRow(), 3),
								(int) table.getModel().getValueAt(table.getSelectedRow(), 4));
						p.ajouterPlace();
						c.diminuerNombreDePlace();
						
					} else {
						SpinAReserver.setValue(1);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Le nombre de place restante est insuffisant");
				}
			}
		});
		btnNewButton.setBounds(286, 127, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton TxtPayer = new JButton("Payer");
		TxtPayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreationCommande creationCommande = new CreationCommande(cli);
				creationCommande.setVisible(true);
			}
		});
		TxtPayer.setBounds(286, 187, 85, 21);
		contentPane.add(TxtPayer);
	}
}

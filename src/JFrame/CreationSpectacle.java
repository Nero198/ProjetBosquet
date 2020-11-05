package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AbstractDAOFactory;
import DAO.ArtisteDAO;
import DAO.DAO;
import POJO.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JList;

public class CreationSpectacle extends JFrame {

	private JPanel contentPane;
	private JTextField TxtTitre;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Artiste> artisteDAO = adf.getArtisteDAO();
	DAO<Client> clientDAO = adf.getClientDAO();
	DAO<Categorie> categorieDAO = adf.getCatetogieDAO();
	DAO<Commande> commandeDAO = adf.getCommandeDAO();
	DAO<Configuration> configurationDAO = adf.getConfigurationDAO();
	DAO<Gestionnaire> gestionnaireDAO = adf.getGestionnaireDAO();
	DAO<Organisateur> organisateurDAO = adf.getOrganisateurDAO();
	DAO<Place> placeDAO = adf.getPlaceDAO();
	DAO<PlanningSalle> planningSalleDAO = adf.getPlanningSalleDAO();
	DAO<Representation> representationDAO = adf.getRepresentationDAO();
	DAO<Reservation> reservationDAO = adf.getReservationDAO();
	DAO<Spectacle> spectacleDAO = adf.getSpectacleDAO();
	DAO<Personne> personneDAO = adf.getPersonneDAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//LoginFrame frame = new LoginFrame();
					CreationSpectacle frame = new CreationSpectacle(new Organisateur());
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
	public CreationSpectacle(Personne t) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Titre:");
		lblNewLabel.setBounds(10, 10, 45, 13);
		contentPane.add(lblNewLabel);
		
		TxtTitre = new JTextField();
		TxtTitre.setBounds(10, 33, 96, 19);
		contentPane.add(TxtTitre);
		TxtTitre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(10, 62, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		List<Artiste> listes = ((ArtisteDAO)artisteDAO).find();
		JList LstArtiste = new JList(listes.toArray());
		LstArtiste.setBounds(31, 129, 378, 101);
		contentPane.add(LstArtiste);
	}
}

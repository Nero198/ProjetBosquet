package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import POJO.Artiste;
import POJO.Categorie;
import POJO.Client;
import POJO.Commande;
import POJO.Configuration;
import POJO.Gestionnaire;
import POJO.Organisateur;
import POJO.Personne;
import POJO.Place;
import POJO.PlanningSalle;
import POJO.Representation;
import POJO.Reservation;
import POJO.Spectacle;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnregistrerFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup DiscriminatorGroup = new ButtonGroup();
	private JTextField TxtNom;
	private JTextField TxtPrenom;
	private JTextField TxtEmail;
	private JTextField TxtAdresse;
	private JPasswordField PswMotDePasse;
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
					EnregistrerFrame frame = new EnregistrerFrame();
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
	public EnregistrerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton RadioClient = new JRadioButton("Client");
		RadioClient.setSelected(true);
		DiscriminatorGroup.add(RadioClient);
		RadioClient.setBounds(114, 179, 103, 21);
		contentPane.add(RadioClient);
		
		JRadioButton RadioArtiste = new JRadioButton("Artiste");
		DiscriminatorGroup.add(RadioArtiste);
		RadioArtiste.setBounds(114, 202, 103, 21);
		contentPane.add(RadioArtiste);
		
		JRadioButton RadioOrganisateur = new JRadioButton("Organisateur");
		DiscriminatorGroup.add(RadioOrganisateur);
		RadioOrganisateur.setBounds(114, 225, 103, 21);
		contentPane.add(RadioOrganisateur);
		
		JButton BtnCreer = new JButton("Cr\u00E9er");
		BtnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(RadioClient.isSelected())
				{
					@SuppressWarnings("deprecation")
					Client p = new Client(TxtNom.getText(),TxtPrenom.getText(),TxtAdresse.getText(),TxtEmail.getText(),PswMotDePasse.getText());
					clientDAO.create(p);
					JOptionPane.showMessageDialog(null, "Client");
				}	
				else if(RadioArtiste.isSelected())
				{
					@SuppressWarnings("deprecation")
					Artiste p = new Artiste(TxtNom.getText(),TxtPrenom.getText(),TxtAdresse.getText(),TxtEmail.getText(),PswMotDePasse.getText());
					artisteDAO.create(p);
				}
				else if(RadioOrganisateur.isSelected()) 
				{
					@SuppressWarnings("deprecation")
					Organisateur p = new Organisateur(TxtNom.getText(),TxtPrenom.getText(),TxtAdresse.getText(),TxtEmail.getText(),PswMotDePasse.getText());
					organisateurDAO.create(p);
				}
			}
		});
		BtnCreer.setBounds(278, 133, 85, 21);
		contentPane.add(BtnCreer);
		
		TxtNom = new JTextField();
		TxtNom.setBounds(61, 28, 96, 19);
		contentPane.add(TxtNom);
		TxtNom.setColumns(10);
		
		TxtPrenom = new JTextField();
		TxtPrenom.setBounds(61, 72, 96, 19);
		contentPane.add(TxtPrenom);
		TxtPrenom.setColumns(10);
		
		TxtEmail = new JTextField();
		TxtEmail.setBounds(255, 28, 96, 19);
		contentPane.add(TxtEmail);
		TxtEmail.setColumns(10);
		
		TxtAdresse = new JTextField();
		TxtAdresse.setBounds(61, 111, 96, 19);
		contentPane.add(TxtAdresse);
		TxtAdresse.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setBounds(6, 31, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Prenom:");
		lblNewLabel_1.setBounds(6, 75, 56, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Adresse:");
		lblNewLabel_2.setBounds(6, 114, 56, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setBounds(158, 31, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("MotDePasse:");
		lblNewLabel_4.setBounds(158, 75, 87, 13);
		contentPane.add(lblNewLabel_4);
		
		PswMotDePasse = new JPasswordField();
		PswMotDePasse.setBounds(255, 72, 96, 21);
		contentPane.add(PswMotDePasse);
	}
}

package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.PersonneDAO;
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

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField TxtEmail;
	private JPasswordField PswMDP;
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TxtEmail = new JTextField();
		TxtEmail.setBounds(62, 81, 270, 19);
		contentPane.add(TxtEmail);
		TxtEmail.setColumns(10);
		
		JLabel LblEmail = new JLabel("Email:");
		LblEmail.setBounds(62, 58, 45, 13);
		contentPane.add(LblEmail);
		
		JLabel LblMDP = new JLabel("Mot de passe:");
		LblMDP.setBounds(62, 107, 96, 13);
		contentPane.add(LblMDP);
		
		PswMDP = new JPasswordField();
		PswMDP.setBounds(62, 130, 270, 19);
		contentPane.add(PswMDP);
		
		JButton BtnIdentifier = new JButton("S'identifier");
		BtnIdentifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = TxtEmail.getText();
				String motDePasse = PswMDP.getText();
				Personne p = ((PersonneDAO)personneDAO).find(email);
				if(p!=null)
				{
					if(p.verifierMotDePasse(motDePasse))
					{
						if(p instanceof Artiste)
						{
							JOptionPane.showMessageDialog(null, "Artiste");
						}
						else if(p instanceof Client)
						{
							JOptionPane.showMessageDialog(null, "Client");
						}
						else if(p instanceof Organisateur)
						{
							JOptionPane.showMessageDialog(null, "Organisateur");
							ReservationSalle creationSpectacle = new ReservationSalle((Organisateur) p);
							contentPane.setVisible(false);
							creationSpectacle.setVisible(true);
						}
						else
						{
							contentPane.setVisible(false);
							JOptionPane.showMessageDialog(null, "Gestionnaire");
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Mot de passe incorrect");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "L'adresse Email n'existe pas, veuillez créer un compte");
				}
			}
		});
		BtnIdentifier.setBounds(62, 183, 130, 21);
		contentPane.add(BtnIdentifier);
		
		JButton BtnEnregistrer = new JButton("S'enregistrer");
		BtnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnregistrerFrame frame = new EnregistrerFrame();
				frame.setVisible(true);
			}
		});
		BtnEnregistrer.setBounds(202, 183, 130, 21);
		contentPane.add(BtnEnregistrer);
		
	}
}

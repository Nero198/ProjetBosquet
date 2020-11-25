package JFrame;

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
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
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
	private JLabel LblEmail;
	private JLabel LblMDP;
	private JButton BtnIdentifier;
	private JButton BtnEnregistrer;
	private MenuClient menuClient;
	private MenuOrganisateur creationSpectacle;
	
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
		
		LblEmail = new JLabel("Email:");
		LblEmail.setBounds(62, 58, 45, 13);
		contentPane.add(LblEmail);
		
		LblMDP = new JLabel("Mot de passe:");
		LblMDP.setBounds(62, 107, 96, 13);
		contentPane.add(LblMDP);
		
		PswMDP = new JPasswordField();
		PswMDP.setBounds(62, 130, 270, 19);
		contentPane.add(PswMDP);
		
		BtnIdentifier = new JButton("S'identifier");
		BtnIdentifier.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
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
							menuClient = new MenuClient((Client) p);
							dispose();
							menuClient.setVisible(true);
						}
						else if(p instanceof Organisateur)
						{
							creationSpectacle = new MenuOrganisateur((Organisateur) p);
							dispose();
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
		
		BtnEnregistrer = new JButton("S'enregistrer");
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

package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
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
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JCheckBox;

public class CreationSpectacle extends JFrame {

	private JPanel contentPane;
	private JTextField TxtTitre;
	private JList<Artiste> LstArtiste;
	private List<Artiste> Artistes = new ArrayList<Artiste>();
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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField TxtBronze;
	private JTextField TxtArgent;
	private JTextField TxtOr;
	private JTextField TxtDiamant;
	private JTextField TxtLibre;
	private JTextField TxtPlaceMax;
	boolean visible = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// LoginFrame frame = new LoginFrame();
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
	public CreationSpectacle(Organisateur o, PlanningSalle ps) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Titre du spectacle:");
		lblNewLabel.setBounds(31, 10, 155, 13);
		contentPane.add(lblNewLabel);

		TxtTitre = new JTextField();
		TxtTitre.setBounds(31, 33, 155, 19);
		contentPane.add(TxtTitre);
		TxtTitre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tous les artistes:");
		lblNewLabel_1.setBounds(31, 114, 155, 13);
		contentPane.add(lblNewLabel_1);

		DefaultListModel<Artiste> model = new DefaultListModel<>();
		model.addAll(((ArtisteDAO) artisteDAO).find());
		LstArtiste = new JList<>(model);
		LstArtiste.setBounds(31, 129, 155, 101);
		contentPane.add(LstArtiste);

		DefaultListModel<Artiste> modelSelected = new DefaultListModel<>();
		JList<Artiste> LstArtisteSelected = new JList<>(modelSelected);
		LstArtisteSelected.setBounds(259, 129, 155, 101);
		contentPane.add(LstArtisteSelected);

		JButton BtnToLeft = new JButton("<<");
		BtnToLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Artistes.remove(LstArtisteSelected.getSelectedValue());
				modelSelected.removeElement(LstArtisteSelected.getSelectedValue());
			}
		});
		BtnToLeft.setBounds(195, 181, 54, 21);
		contentPane.add(BtnToLeft);

		JButton BtnToRight = new JButton(">>");
		BtnToRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!modelSelected.contains(LstArtiste.getSelectedValue())) {
					Artistes.add(LstArtiste.getSelectedValue());
					modelSelected.addElement(LstArtiste.getSelectedValue());
				}
			}
		});
		BtnToRight.setBounds(196, 147, 54, 21);
		contentPane.add(BtnToRight);

		JLabel lblNewLabel_1_1 = new JLabel("Artistes choisis:");
		lblNewLabel_1_1.setBounds(259, 114, 155, 13);
		contentPane.add(lblNewLabel_1_1);

		JRadioButton RadioDebout = new JRadioButton("Debout");
		RadioDebout.setSelected(true);
		buttonGroup.add(RadioDebout);
		RadioDebout.setBounds(256, 32, 103, 21);
		contentPane.add(RadioDebout);

		JRadioButton RadioConcert = new JRadioButton("Concert");
		buttonGroup.add(RadioConcert);
		RadioConcert.setBounds(256, 55, 103, 21);
		contentPane.add(RadioConcert);

		JRadioButton RadioCirque = new JRadioButton("Cirque");
		buttonGroup.add(RadioCirque);
		RadioCirque.setBounds(256, 78, 103, 21);
		contentPane.add(RadioCirque);

		JLabel lblNewLabel_2 = new JLabel("Configuration:");
		lblNewLabel_2.setBounds(256, 10, 116, 13);
		contentPane.add(lblNewLabel_2);

		TxtLibre = new JTextField();
		TxtLibre.setBounds(499, 33, 96, 19);
		contentPane.add(TxtLibre);
		TxtLibre.setColumns(10);

		JLabel LblLibre = new JLabel("Libre:");
		LblLibre.setBounds(444, 36, 45, 13);
		contentPane.add(LblLibre);

		TxtBronze = new JTextField();
		TxtBronze.setBounds(499, 33, 96, 19);
		contentPane.add(TxtBronze);
		TxtBronze.setColumns(10);
		TxtBronze.setVisible(false);

		JLabel LblBronze = new JLabel("Bronze:");
		LblBronze.setBounds(444, 36, 45, 13);
		contentPane.add(LblBronze);
		LblBronze.setVisible(false);

		TxtArgent = new JTextField();
		TxtArgent.setBounds(499, 56, 96, 19);
		contentPane.add(TxtArgent);
		TxtArgent.setColumns(10);
		TxtArgent.setVisible(false);

		JLabel LblArgent = new JLabel("Argent:");
		LblArgent.setBounds(444, 59, 45, 13);
		contentPane.add(LblArgent);
		LblArgent.setVisible(false);

		JLabel LblOr = new JLabel("Or:");
		LblOr.setBounds(444, 82, 45, 13);
		contentPane.add(LblOr);
		LblOr.setVisible(false);

		TxtOr = new JTextField();
		TxtOr.setBounds(499, 79, 96, 19);
		contentPane.add(TxtOr);
		TxtOr.setColumns(10);
		TxtOr.setVisible(false);

		JLabel LblDiamant = new JLabel("Diamant:");
		LblDiamant.setBounds(444, 105, 45, 13);
		contentPane.add(LblDiamant);
		LblDiamant.setVisible(false);

		TxtDiamant = new JTextField();
		TxtDiamant.setBounds(499, 102, 96, 19);
		contentPane.add(TxtDiamant);
		TxtDiamant.setColumns(10);
		TxtDiamant.setVisible(false);

		JLabel lblNewLabel_3 = new JLabel("Prix des places:");
		lblNewLabel_3.setBounds(444, 10, 151, 13);
		contentPane.add(lblNewLabel_3);

		JCheckBox CheckBoxPlaceMax = new JCheckBox("Place/Client:");
		CheckBoxPlaceMax.setBounds(31, 78, 116, 21);
		contentPane.add(CheckBoxPlaceMax);

		TxtPlaceMax = new JTextField();
		TxtPlaceMax.setBounds(153, 78, 33, 21);
		contentPane.add(TxtPlaceMax);
		TxtPlaceMax.setColumns(10);

		JButton BtnAjouter = new JButton("Ajouter");
		BtnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					if(TxtTitre.getText()!= null && Artistes !=null)
					{
						Spectacle s = new Spectacle();
						s.setTitre(TxtTitre.getText());
						s.setArtistes(Artistes);
						if (CheckBoxPlaceMax.isSelected()) {
							int a = Integer.valueOf(TxtPlaceMax.getText());
							s.setNbrPlaceParClient(a);
						}
						Configuration config=null;
						if (RadioDebout.isSelected()) {
							if(TxtLibre.getText()!=null)
							{
								Categorie categorie = new Categorie("Libre", Integer.valueOf(TxtLibre.getText()), 8000, 8000);
								List<Categorie> cat = new ArrayList<Categorie>();
								cat.add(categorie);
								config = new Configuration("Debout", "Toutes les personnes sont debout", cat);
							}
						} else if (RadioConcert.isSelected()) {
							if(TxtOr.getText()!=null && TxtArgent.getText()!=null && TxtBronze.getText()!=null)
							{
								Categorie categorie1 = new Categorie("Or", Integer.valueOf(TxtOr.getText()), 500, 500);
								Categorie categorie2 = new Categorie("Argent", Integer.valueOf(TxtArgent.getText()), 1500, 1500);
								Categorie categorie3 = new Categorie("Bronze", Integer.valueOf(TxtBronze.getText()), 3000, 3000);
								List<Categorie> cat = new ArrayList<Categorie>();
								cat.add(categorie1);
								cat.add(categorie2);
								cat.add(categorie3);
								config = new Configuration("Concert", "Parfait pour un concert", cat);
							}
						} else {
							if(TxtOr.getText()!=null && TxtArgent.getText()!=null && TxtBronze.getText()!=null && TxtDiamant.getText()!=null)
							{
								Categorie categorie1 = new Categorie("Diamant", Integer.valueOf(TxtBronze.getText()), 1000, 1000);
								Categorie categorie2 = new Categorie("Or", Integer.valueOf(TxtOr.getText()), 2000, 2000);
								Categorie categorie3 = new Categorie("Argent", Integer.valueOf(TxtArgent.getText()), 1500, 2000);
								Categorie categorie4 = new Categorie("Bronze", Integer.valueOf(TxtBronze.getText()), 1500, 2000);
								List<Categorie> cat = new ArrayList<Categorie>();
								cat.add(categorie1);
								cat.add(categorie2);
								cat.add(categorie3);
								cat.add(categorie4);
								config = new Configuration("Cirque", "Parfait pour un spectacle de cirque", cat);
							}
						}
						s.setConfiguration(config);
						s.ajouterSpectacle(ps);
					}
					else
						JOptionPane.showMessageDialog(null, "veuillez remplir tous les champs");
				}
				catch(NumberFormatException f)
				{
					JOptionPane.showMessageDialog(null, "veuillez entrer un nombre pour le prix des places");
				}
			}
		});
		BtnAjouter.setBounds(510, 209, 85, 21);
		contentPane.add(BtnAjouter);
		TxtPlaceMax.setVisible(visible);

		CheckBoxPlaceMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == CheckBoxPlaceMax) {
					if (visible == false) {
						visible = true;
						TxtPlaceMax.setVisible(visible);
					} else {
						visible = false;
						TxtPlaceMax.setVisible(visible);
					}
				}
			}
		});

		RadioDebout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == RadioDebout) {
					LblLibre.setVisible(true);
					TxtLibre.setVisible(true);
					LblBronze.setVisible(false);
					TxtBronze.setVisible(false);
					LblArgent.setVisible(false);
					TxtArgent.setVisible(false);
					LblOr.setVisible(false);
					TxtOr.setVisible(false);
					LblDiamant.setVisible(false);
					TxtDiamant.setVisible(false);
				}
			}
		});
		RadioCirque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == RadioCirque) {
					LblLibre.setVisible(false);
					TxtLibre.setVisible(false);
					LblBronze.setVisible(true);
					TxtBronze.setVisible(true);
					LblArgent.setVisible(true);
					TxtArgent.setVisible(true);
					LblOr.setVisible(true);
					TxtOr.setVisible(true);
					LblDiamant.setVisible(true);
					TxtDiamant.setVisible(true);
				}
			}
		});
		RadioConcert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == RadioConcert) {
					LblLibre.setVisible(false);
					TxtLibre.setVisible(false);
					LblBronze.setVisible(true);
					TxtBronze.setVisible(true);
					LblArgent.setVisible(true);
					TxtArgent.setVisible(true);
					LblOr.setVisible(true);
					TxtOr.setVisible(true);
					LblDiamant.setVisible(false);
					TxtDiamant.setVisible(false);
				}
			}
		});

	}
}

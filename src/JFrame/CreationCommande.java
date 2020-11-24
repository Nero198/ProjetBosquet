package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.AbstractDAOFactory;
import DAO.*;
import POJO.Client;
import POJO.Commande;
import POJO.Place;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreationCommande extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private double somme = 5;
	private Date date = null;
	JRadioButton RdbSepa;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Place> placeDAO = adf.getPlaceDAO();
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
	public CreationCommande(Client cli) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Montant total \u00E0 payer:");
		lblNewLabel.setBounds(10, 10, 160, 13);
		contentPane.add(lblNewLabel);
		
		List<Place> liste = ((PlaceDAO)placeDAO).getAll();
		for (var j : liste)
		{
			date=(Date) j.getRepresentation().getDate();
			somme+=j.getPrix();
		}
		JLabel TxtMontant = new JLabel(""+somme+"€");
		TxtMontant.setBounds(140, 10, 103, 13);
		contentPane.add(TxtMontant);
		System.out.println(date);
		JLabel lblNewLabel_1 = new JLabel("Mode de livraison:");
		lblNewLabel_1.setBounds(10, 39, 160, 13);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton RdbSurPlace = new JRadioButton("Sur place");
		buttonGroup.add(RdbSurPlace);
		RdbSurPlace.setSelected(true);
		RdbSurPlace.setBounds(6, 58, 103, 21);
		contentPane.add(RdbSurPlace);
		
		JRadioButton RdbTimbrePrior = new JRadioButton("Par timbre Prior");
		buttonGroup.add(RdbTimbrePrior);
		RdbTimbrePrior.setBounds(6, 81, 118, 21);
		contentPane.add(RdbTimbrePrior);
		
		JRadioButton RdbEnvoiSecurise = new JRadioButton("Par envoi s\u00E9curis\u00E9 +10\u20AC");
		buttonGroup.add(RdbEnvoiSecurise);
		RdbEnvoiSecurise.setBounds(6, 104, 179, 21);
		contentPane.add(RdbEnvoiSecurise);
		
		JLabel lblNewLabel_2 = new JLabel("Mode de payement:");
		lblNewLabel_2.setBounds(10, 144, 114, 13);
		contentPane.add(lblNewLabel_2);
		
		JRadioButton RdbVisa = new JRadioButton("Par Visa");
		buttonGroup_1.add(RdbVisa);
		RdbVisa.setSelected(true);
		RdbVisa.setBounds(6, 163, 103, 21);
		contentPane.add(RdbVisa);
		
		JRadioButton RdbPaypal = new JRadioButton("Par Paypal");
		buttonGroup_1.add(RdbPaypal);
		RdbPaypal.setBounds(6, 186, 103, 21);
		contentPane.add(RdbPaypal);
		
		
		Date dateAjd = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		if(((date.getTime()-dateAjd.getTime())/(1000*60*60*24)+1)>=20)
		{
			RdbSepa = new JRadioButton("Par Virement SEPA");
			buttonGroup_1.add(RdbSepa);
			RdbSepa.setBounds(6, 209, 140, 21);
			contentPane.add(RdbSepa);
		}
		
		JButton BtnValider = new JButton("Valider");
		BtnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Commande commande = new Commande(null,null,somme,liste);
				if(RdbSurPlace.isSelected())
				{
					commande.setModeLivraison("Sur place");
				}
				else if(RdbTimbrePrior.isSelected())
				{
					commande.setModeLivraison("Timbre Prior");
				}
				else if (RdbEnvoiSecurise.isSelected())
				{
					commande.setModeLivraison("Envoi sécurisé");
					somme+=10;
				}
				if(RdbVisa.isSelected())
				{
					commande.setModePayement("VISA");
				}
				else if(RdbPaypal.isSelected())
				{
					commande.setModePayement("Paypal");
				}
				else if(RdbSepa.isSelected())
				{
					commande.setModePayement("SEPA");
				}
				commande.creerCommande(cli);
			}
		});
		BtnValider.setBounds(293, 104, 85, 21);
		contentPane.add(BtnValider);
		
	}
}

package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.RepresentationDAO;
import POJO.Organisateur;
import POJO.PlanningSalle;
import POJO.Representation;
import POJO.Spectacle;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.sql.Date;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class CreationRepresentation extends JFrame {

	private JPanel contentPane;
	private JTextField TxtHeureOuverture;
	private JTextField TxtMinuteOuverture;
	private JTextField TxtHeureDebut;
	private JTextField TxtMinuteDebut;
	private JTextField TxtHeureFin;
	private JTextField TxtMinuteFin;
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Representation> representationDAO = adf.getRepresentationDAO();
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
	public CreationRepresentation(Organisateur o,Spectacle spectacle) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDateChooser DateRepresentation = new JDateChooser();
		DateRepresentation.setBounds(10, 44, 146, 19);
		PlanningSalle ps = ((RepresentationDAO)representationDAO).getDateReservation(spectacle);
		DateRepresentation.setSelectableDateRange(ps.getDateDebutReservation(), ps.getDateFinReservation());
		contentPane.add(DateRepresentation);

		JLabel lblNewLabel = new JLabel("Date de la repr\u00E9senation");
		lblNewLabel.setBounds(10, 31, 146, 13);
		contentPane.add(lblNewLabel);

		TxtHeureOuverture = new JTextField();
		TxtHeureOuverture.setBounds(10, 88, 26, 19);
		contentPane.add(TxtHeureOuverture);
		TxtHeureOuverture.setColumns(10);

		TxtMinuteOuverture = new JTextField();
		TxtMinuteOuverture.setColumns(10);
		TxtMinuteOuverture.setBounds(45, 88, 26, 19);
		contentPane.add(TxtMinuteOuverture);

		JLabel lblNewLabel_1 = new JLabel(":");
		lblNewLabel_1.setBounds(38, 91, 45, 13);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Heure d'ouverture des portes");
		lblNewLabel_2.setBounds(10, 73, 242, 13);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Heure du d\u00E9but de la repr\u00E9sentation");
		lblNewLabel_2_1.setBounds(10, 117, 264, 13);
		contentPane.add(lblNewLabel_2_1);

		TxtHeureDebut = new JTextField();
		TxtHeureDebut.setColumns(10);
		TxtHeureDebut.setBounds(10, 132, 26, 19);
		contentPane.add(TxtHeureDebut);

		TxtMinuteDebut = new JTextField();
		TxtMinuteDebut.setColumns(10);
		TxtMinuteDebut.setBounds(45, 132, 26, 19);
		contentPane.add(TxtMinuteDebut);

		JLabel lblNewLabel_1_1 = new JLabel(":");
		lblNewLabel_1_1.setBounds(38, 135, 45, 13);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_2 = new JLabel("Heure de fin de la repr\u00E9sentation");
		lblNewLabel_2_2.setBounds(10, 161, 242, 13);
		contentPane.add(lblNewLabel_2_2);

		TxtHeureFin = new JTextField();
		TxtHeureFin.setColumns(10);
		TxtHeureFin.setBounds(10, 176, 26, 19);
		contentPane.add(TxtHeureFin);

		TxtMinuteFin = new JTextField();
		TxtMinuteFin.setColumns(10);
		TxtMinuteFin.setBounds(45, 176, 26, 19);
		contentPane.add(TxtMinuteFin);

		JLabel lblNewLabel_1_2 = new JLabel(":");
		lblNewLabel_1_2.setBounds(38, 179, 45, 13);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_3 = new JLabel("Titre du Spectacle");
		lblNewLabel_3.setBounds(270, 50, 122, 13);
		contentPane.add(lblNewLabel_3);

		JLabel TxtTitre = new JLabel("");
		TxtTitre.setBounds(270, 73, 122, 13);
		TxtTitre.setText(spectacle.getTitre());
		contentPane.add(TxtTitre);
		
		JButton BtnMenu = new JButton("Menu");
		BtnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOrganisateur menuClient = new MenuOrganisateur(o);
				dispose();
				menuClient.setVisible(true);
			}
		});
		BtnMenu.setBounds(10, 10, 414, 243);
		
		JButton BtnValider = new JButton("Valider");
		BtnValider.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				Date d = new java.sql.Date(DateRepresentation.getDate().getTime());
				int heure1 = Integer.parseInt(TxtHeureDebut.getText());
				int minute1 = Integer.parseInt(TxtMinuteDebut.getText());
				Timestamp heureDebut = new Timestamp(new java.util.Date(d.getYear(),d.getMonth(),d.getDate(),heure1,minute1).getTime());
				

				int heure2 = Integer.parseInt(TxtHeureFin.getText());
				int minute2 = Integer.parseInt(TxtMinuteFin.getText());
				Timestamp heureFin = new Timestamp(new java.util.Date(d.getYear(),d.getMonth(),d.getDate(),heure2,minute2).getTime());
				

				int heure3 = Integer.parseInt(TxtHeureOuverture.getText());
				int minute3 = Integer.parseInt(TxtMinuteOuverture.getText());
				Timestamp heureOuverture = new Timestamp(new java.util.Date(d.getYear(),d.getMonth(),d.getDate(),heure3,minute3).getTime());
				if((0<=heure1&&heure1<=23)&&(0<=heure2&&heure2<=23)&&(0<=heure3&&heure3<=23)&&(0<=minute1&&minute1<=59)&&(0<=minute2&&minute2<=59)&&(0<=minute3&&minute3<=59))
				{
					Representation r = new Representation((java.sql.Date)d, spectacle, heureDebut, heureFin, heureOuverture);
					if(r.verifierHeure())
					{
						o.ajouterRepresentation(r);
						contentPane.add(BtnMenu);
						JOptionPane.showMessageDialog(null, "Ajout avec succès");
					}
					else
						JOptionPane.showMessageDialog(null, "Les heures choisies sont en dehors de la réservation de la salle");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Veuillez insérer une heure correcte");
					TxtHeureDebut.setText(null);
					TxtHeureFin.setText(null);
					TxtHeureOuverture.setText(null);
					TxtMinuteDebut.setText(null);
					TxtMinuteFin.setText(null);
					TxtMinuteOuverture.setText(null);
				}
			}
		});
		BtnValider.setBounds(262, 157, 85, 21);
		contentPane.add(BtnValider);
	}
}

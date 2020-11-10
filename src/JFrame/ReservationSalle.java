package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.PlanningSalleDAO;
import POJO.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class ReservationSalle extends JFrame {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<PlanningSalle> planningSalleDAO = adf.getPlanningSalleDAO();
	private JPanel contentPane;
	Date dateDebut = null;
	Date dateFin = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	JLabel LblConfirmer;
	JButton BtnOui;
	JButton BtnNon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationSalle frame = new ReservationSalle(new Organisateur());
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
	public ReservationSalle(Organisateur o) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 10, 206, 152);
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    List<PlanningSalle> planningSalle = ((PlanningSalleDAO)planningSalleDAO).find();
	    for(var ps : planningSalle) {
	    	RangeEvaluator evaluator = new RangeEvaluator();

	    	int a = ps.getDateDebutReservation().getDate()+1;
	    	int b = ps.getDateFinReservation().getDate()-1;
	    	Date dateDebut = new Date(ps.getDateDebutReservation().getYear(),ps.getDateDebutReservation().getMonth(),a);
	    	Date dateFin = new Date(ps.getDateFinReservation().getYear(),ps.getDateFinReservation().getMonth(),b);
			evaluator.setStartDate(dateDebut);
		    evaluator.setEndDate(dateFin);
		    calendar.getDayChooser().addDateEvaluator(evaluator);
		    SwingUtilities.updateComponentTreeUI(calendar);
		}
		contentPane.add(calendar);

		JLabel LblDateDebut = new JLabel("");
		LblDateDebut.setBounds(341, 32, 85, 13);
		contentPane.add(LblDateDebut);

		JLabel LblDateFin = new JLabel("");
		LblDateFin.setBounds(341, 55, 85, 13);
		contentPane.add(LblDateFin);

		LblConfirmer = new JLabel("Confirmez-vous ces deux dates?");
		LblConfirmer.setBounds(226, 82, 200, 13);
		contentPane.add(LblConfirmer);
		LblConfirmer.setVisible(false);

		BtnOui = new JButton("Oui");
		BtnOui.setBounds(236, 109, 85, 21);
		contentPane.add(BtnOui);
		BtnOui.setVisible(false);

		BtnNon = new JButton("Non");
		BtnNon.setBounds(331, 109, 85, 21);
		contentPane.add(BtnNon);
		BtnNon.setVisible(false);

		JButton BtnValider = new JButton("Valider la date de d\u00E9but");
		BtnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateDebut == null) {
					dateDebut = new java.sql.Date(calendar.getDate().getTime());
					java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
					if(dateDebut.before(now))
					{
						dateDebut = null;
					}
					else
					{
						LblDateDebut.setText(dateFormat.format(dateDebut));
					}
				}
				if (dateFin == null && dateDebut!=null) 
				{	
					BtnValider.setText("Valider la date de fin");
					dateFin = new java.sql.Date(calendar.getDate().getTime());
					if(dateDebut.after(dateFin) || dateFin.equals(dateDebut))
					{
						dateFin = null;
					}
					else
					{

						LblDateFin.setText(dateFormat.format(dateFin));
						BtnValider.setVisible(false);
						LblConfirmer.setVisible(true);
						BtnOui.setVisible(true);
						BtnNon.setVisible(true);
					}
				}
			}

		});
		BtnValider.setBounds(226, 78, 200, 21);
		contentPane.add(BtnValider);

		BtnNon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateDebut=null;
				dateFin=null;
				LblDateDebut.setText("");
				LblDateFin.setText("");
				BtnValider.setVisible(true);
				LblConfirmer.setVisible(false);
				BtnOui.setVisible(false);
				BtnNon.setVisible(false);
			}
		});

		BtnOui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlanningSalle PS = new PlanningSalle((java.sql.Date)dateDebut,(java.sql.Date)dateFin,null);
				AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
				DAO<PlanningSalle> planningSalleDAO = adf.getPlanningSalleDAO();
				if(PS.verifierDisponibilite())// false pas Libre - true Libre
				{
					Reservation r = new Reservation(5000,0,null,0,PS);
					r.calculerPrixSalle();
					CreationSpectacle frame = new CreationSpectacle(o);
					contentPane.setVisible(false);
					frame.setVisible(true);
					o.reserverSalle(r);
				}
				else
				{
					dateDebut=null;
					dateFin=null;
					LblDateDebut.setText("");
					LblDateFin.setText("");
					BtnValider.setVisible(true);
					LblConfirmer.setVisible(false);
					BtnOui.setVisible(false);
					BtnNon.setVisible(false);
					JOptionPane.showMessageDialog(null, "La salle est déjà reservée aces dates là");
				}
			}
		});

		JLabel LblDateDeDebut = new JLabel("Date de d\u00E9but:");
		LblDateDeDebut.setBounds(226, 32, 105, 13);
		contentPane.add(LblDateDeDebut);

		JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setBounds(226, 55, 79, 13);
		contentPane.add(lblDateDeFin);



	}
}
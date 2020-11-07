package JFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ReservationSalle extends JFrame {

	private JPanel contentPane;
	Date dateDebut = null;
	Date dateFin = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationSalle frame = new ReservationSalle();
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
	public ReservationSalle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 10, 206, 152);
		contentPane.add(calendar);

		JButton BtnValider = new JButton("Valider");
		BtnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateDebut == null) {
					dateDebut = calendar.getDate();
					if(dateDebut.after(new Date()))
					{
						System.out.print("B");
						dateDebut = calendar.getDate();
					}
					else
					{
						System.out.print("D");
						dateDebut = null;
					}
				}

				/*
				 * if (dateFin == null || dateFin.before(new Date())) { System.out.print("C");
				 * dateFin = null; } else { System.out.print("D"); dateFin=calendar.getDate();
				 * JOptionPane.showMessageDialog(null, "Voulez vous reserver la salle du " +
				 * dateFormat.format(dateDebut) + " jusqu'au " + dateFormat.format(dateFin)); }
				 */
			}

		});
		BtnValider.setBounds(157, 184, 85, 21);
		contentPane.add(BtnValider);
	}
}

package JFrame;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.PlanningSalleDAO;
import POJO.Gestionnaire;
import POJO.PlanningSalle;

@SuppressWarnings("serial")
public class MenuGestionnaire extends JFrame {

	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<PlanningSalle> DAO = adf.getPlanningSalleDAO();
	private JPanel contentPane;
	private JTable table;
	private JButton BtnLogin;
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
	public MenuGestionnaire(Gestionnaire g) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 211);
		contentPane.add(scrollPane);
		List<PlanningSalle> entry = ((PlanningSalleDAO) DAO).find();
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Heure début", "Heure fin"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		for (var i : entry) {
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy 12:00");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[] { s.format(i.getDateDebutReservation()),s.format(i.getDateFinReservation())};
			model.addRow(row);

		}
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		BtnLogin = new JButton("Quitter");
		BtnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame f = new LoginFrame();
				dispose();
				f.setVisible(true);
			}
		});
		BtnLogin.setBounds(174, 232, 85, 21);
		contentPane.add(BtnLogin);
	}

}

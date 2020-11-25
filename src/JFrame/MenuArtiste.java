package JFrame;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.RepresentationDAO;
import POJO.Artiste;
import POJO.Representation;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuArtiste extends JFrame {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Representation> DAO = adf.getRepresentationDAO();
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
	public MenuArtiste(Artiste a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 416, 211);
		contentPane.add(scrollPane);
		List<Representation> entry = ((RepresentationDAO) DAO).findAll(a.getId());
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titre", "Date", "Heure début", "Heure fin"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		for (var i : entry) {
			SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
			SimpleDateFormat s1 = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[] { i.getSpectacle().getTitre(), s1.format(i.getDate()), s.format(i.getHeureDebut()),s.format(i.getHeureFin())};
			model.addRow(row);

		}
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
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

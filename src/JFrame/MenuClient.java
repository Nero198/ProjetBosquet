package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.AbstractDAOFactory;
import DAO.CommandeDAO;
import DAO.DAO;
import POJO.Client;
import POJO.Commande;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuClient extends JFrame {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Commande> DAO = adf.getCommandeDAO();
	private JPanel contentPane;
	private JTable table;

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
	public MenuClient(Client c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setTitle("Menu Client");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 269, 226);
		contentPane.add(scrollPane);
		List<Commande> entry = ((CommandeDAO) DAO).getAll(c.getId());
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ModeLivraison", "ModePayement", "Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
			
		});
		table.setEnabled(false);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		for (var i : entry) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[] { i.getModeLivraison(), i.getModePayement(), i.getCout()};
			model.addRow(row);

		}
		scrollPane.setViewportView(table);
		
		JButton BtnReserver = new JButton("Reserver");
		BtnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoixSpectacle frame= new ChoixSpectacle(c);
				dispose();
				frame.setVisible(true);
			}
		});
		BtnReserver.setBounds(317, 112, 85, 21);
		contentPane.add(BtnReserver);
		
		JLabel lblNewLabel = new JLabel("Toutes mes commandes");
		lblNewLabel.setBounds(10, 4, 133, 13);
		contentPane.add(lblNewLabel);
		
		JButton BtnDeco = new JButton("Quitter");
		BtnDeco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame f = new LoginFrame();
				dispose();
				f.setVisible(true);
			}
		});
		BtnDeco.setBounds(317, 30, 85, 21);
		contentPane.add(BtnDeco);
	}
}

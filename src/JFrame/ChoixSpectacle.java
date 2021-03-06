package JFrame;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.SpectacleDAO;
import Other.Tuple;
import POJO.Client;
import POJO.Spectacle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ChoixSpectacle extends JFrame {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Spectacle> DAO = adf.getSpectacleDAO();
	private JPanel contentPane;
	private JTable table;
	private JButton BtnChoisir;

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
	public ChoixSpectacle(Client c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 10, 329, 243);
		contentPane.add(scrollPane);
		@SuppressWarnings({ "rawtypes" })
		List<Tuple> entry = ((SpectacleDAO) DAO).getAll();
		if (entry != null) {
			table = new JTable();
			table.setModel(new DefaultTableModel(new Object[][] {},
					new String[] { "Titre du spectacle", "D\u00E9but du spectacle", "Fin du spectacle", "Id" }) {
				boolean[] columnEditables = new boolean[] { false, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			table.removeColumn(table.getColumnModel().getColumn(3));
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			for (var i : entry) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Object[] row = new Object[] { i.item2, i.item3, i.item4, i.item1 };
				model.addRow(row);

			}
			scrollPane.setViewportView(table);
			
		}
		BtnChoisir = new JButton("Choisir");
		BtnChoisir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = (int) table.getModel().getValueAt(table.getSelectedRow(), 3);
				ChoixRepresentation RepresentationFrame = new ChoixRepresentation(j, c);
				dispose();
				RepresentationFrame.setVisible(true);
			}
		});
		BtnChoisir.setBounds(337, 112, 99, 21);
		contentPane.add(BtnChoisir);

	}
}
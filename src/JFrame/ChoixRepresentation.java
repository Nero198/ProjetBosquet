package JFrame;

import java.awt.BorderLayout;
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
import POJO.Client;
import POJO.Representation;
import POJO.Spectacle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoixRepresentation extends JFrame {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Representation> DAO = adf.getRepresentationDAO();
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
					ChoixSpectacle frame = new ChoixSpectacle(new Client("Versaevel","Florian","Courcelles","Versaevel.test@hotmail.com","Test2019",10));
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
	@SuppressWarnings("serial")
	public ChoixRepresentation(int i,Client c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 319, 243);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Date de la représentation", "Heure du début","IdRepresentation"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
		List<Representation> listes= ((RepresentationDAO)DAO).getAll(i);
		for(var j : listes)
		{
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			Object[] row = new Object[] {dateFormat.format(j.getDate()),dateFormat2.format(j.getHeureDebut()),j.getIdRepresentation()};
			model.addRow(row);
			
		}
		table.removeColumn(table.getColumnModel().getColumn(2));
		table.getColumnModel().getColumn(1).setResizable(false);
		scrollPane.setViewportView(table);
		
		BtnChoisir = new JButton("Choisir");
		BtnChoisir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoixCategorie ChoixCategorieFrame = new ChoixCategorie(i,(int) table.getModel().getValueAt(table.getSelectedRow(),2),c);
				ChoixCategorieFrame.setVisible(true);
			}
		});
		BtnChoisir.setBounds(341, 127, 85, 21);
		contentPane.add(BtnChoisir);
	}
}

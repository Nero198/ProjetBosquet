package JFrame;

import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POJO.Organisateur;
import POJO.PlanningSalle;
import POJO.Spectacle;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class MenuOrganisateur extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private JButton BtnCreerReservation;
	private JButton BtnCreerRepresentation;
	private JButton BtnPayer;

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
	public MenuOrganisateur(Organisateur o) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 266, 225);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Titre","Date de d\u00E9but", "Date de fin","Statut","Id","IdSalle"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false,false,false,false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		o.getReservation();
		for(var i : o.getReservations())
		{
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			for(var j : i.getPlanningSalle().getSpectacle())
			{
				Object[] row = new Object[] {j.getTitre(),dateFormat.format(i.getPlanningSalle().getDateDebutReservation()),dateFormat.format(i.getPlanningSalle().getDateFinReservation()),i.getStatut(),j.getIdSpectacle(),i.getPlanningSalle().getId()};
				model.addRow(row);
			}
			
		}
		table.removeColumn(table.getColumnModel().getColumn(4));
		table.removeColumn(table.getColumnModel().getColumn(4));
		table.getColumnModel().getColumn(0).setResizable(false);
		scrollPane.setViewportView(table);
		
		BtnCreerReservation = new JButton("Reserver");
		BtnCreerReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationSalle r = new ReservationSalle(o);
				dispose();
				r.setVisible(true);
			}
		});
		BtnCreerReservation.setBounds(304, 41, 102, 21);
		contentPane.add(BtnCreerReservation);
		
		BtnCreerRepresentation = new JButton("Ajouter une repr\u00E9sentation");
		BtnCreerRepresentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getModel().getValueAt(table.getSelectedRow(),0)!=null)
				{
					CreationRepresentation c = new CreationRepresentation(o,new Spectacle(table.getModel().getValueAt(table.getSelectedRow(),0).toString(),(int) table.getModel().getValueAt(table.getSelectedRow(),4)));
					dispose();
					c.setVisible(true);
				}
				else
				{
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					CreationSpectacle c;
					try {
						c = new CreationSpectacle(o,new PlanningSalle(dateFormat.parse(table.getModel().getValueAt(table.getSelectedRow(),1).toString()),dateFormat.parse(table.getModel().getValueAt(table.getSelectedRow(),1).toString()),null,(int)table.getModel().getValueAt(table.getSelectedRow(),5)));
						dispose();
						c.setVisible(true);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		BtnCreerRepresentation.setBounds(281, 122, 155, 21);
		contentPane.add(BtnCreerRepresentation);
		
		JButton BtnDeco = new JButton("Quitter");
		BtnDeco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame f = new LoginFrame();
				dispose();
				f.setVisible(true);
			}
		});
		BtnDeco.setBounds(341, 10, 85, 21);
		contentPane.add(BtnDeco);
		
		BtnPayer = new JButton("Payer");
		BtnPayer.setBounds(321, 215, 85, 21);
		contentPane.add(BtnPayer);
	}
}

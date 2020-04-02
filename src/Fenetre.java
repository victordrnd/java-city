import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Fenetre extends JFrame {

	private JPanel contentPane;
	private JTextField TXTCountry;
	private JButton btnSearch;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnDetails;
	private JScrollPane scrollPane;
	private JTable tableCity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fenetre frame = new Fenetre();
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
	public Fenetre() {
		setBackground(new Color(112, 128, 144));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 136, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(112, 128, 144));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBackground(new Color(255, 255, 255));
		lblCountry.setForeground(new Color(255, 255, 255));
		panel.add(lblCountry);
		
		TXTCountry = new JTextField();
		TXTCountry.setForeground(new Color(0, 0, 0));
		TXTCountry.setBackground(new Color(255, 255, 255));
		panel.add(TXTCountry);
		TXTCountry.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.setName("search");
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(100, 149, 237));
		btnSearch.setFont(new Font("Courier 10 Pitch", Font.BOLD, 12));
		panel.add(btnSearch);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setName("update");
		btnUpdate.setFont(new Font("Courier 10 Pitch", Font.BOLD, 12));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(100, 149, 237));
		panel_1.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setName("delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(100, 149, 237));
		btnDelete.setFont(new Font("Courier 10 Pitch", Font.BOLD, 12));
		panel_1.add(btnDelete);
		
		btnDetails = new JButton("Details");
		btnDetails.setName("details");
		btnDetails.setForeground(new Color(255, 255, 255));
		btnDetails.setBackground(new Color(100, 149, 237));
		btnDetails.setFont(new Font("Courier 10 Pitch", Font.BOLD, 12));
		panel_1.add(btnDetails);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tableCity = new JTable();
		tableCity.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tableCity);
	}

	public JTextField getTXTCountry() {
		return TXTCountry;
	}
	public JButton getBtnSearch() {
		return btnSearch;
	}
	public JButton getBtnUpdate() {
		return btnUpdate;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnDetails() {
		return btnDetails;
	}
	public JTable getTableCity() {
		return tableCity;
	}
}

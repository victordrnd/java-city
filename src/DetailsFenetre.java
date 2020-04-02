import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DetailsFenetre extends JFrame {

	private JPanel contentPane;
	private JTextField TXBCountry;
	private JTextField TXBRegion;
	private JTextField TXBPopulation;
	private JLabel lblPays;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetailsFenetre frame = new DetailsFenetre();
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
	public DetailsFenetre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 396);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel LBCIty = new JLabel("Nom de la ville :");
		LBCIty.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(LBCIty, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblPays = new JLabel("Pays :");
		lblPays.setBounds(131, -1, 41, 15);
		panel.add(lblPays);
		
		TXBCountry = new JTextField();
		TXBCountry.setBounds(219, 5, 124, 19);
		panel.add(TXBCountry);
		TXBCountry.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(348, 14, 0, 0);
		panel.add(label);
		
		JLabel lblRgion = new JLabel("Région :");
		lblRgion.setBounds(131, 51, 66, 15);
		panel.add(lblRgion);
		
		TXBRegion = new JTextField();
		TXBRegion.setBounds(219, 49, 124, 19);
		panel.add(TXBRegion);
		TXBRegion.setColumns(10);
		
		JLabel lblPopulation = new JLabel("Population :");
		lblPopulation.setBounds(131, 104, 88, 15);
		panel.add(lblPopulation);
		
		TXBPopulation = new JTextField();
		TXBPopulation.setBounds(219, 102, 124, 19);
		panel.add(TXBPopulation);
		TXBPopulation.setColumns(10);
	}
	public JLabel getLblPays() {
		return lblPays;
	}
	public JTextField getTXBCountry() {
		return TXBCountry;
	}
	public JTextField getTXBRegion() {
		return TXBRegion;
	}
	public JTextField getTXBPopulation() {
		return TXBPopulation;
	}
}

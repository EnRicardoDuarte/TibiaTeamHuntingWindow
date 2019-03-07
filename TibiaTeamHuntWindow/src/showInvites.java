import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showInvites extends JFrame {

	private JPanel contentPane;
	public JTable table;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showInvites frame = new showInvites();
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
	public showInvites() {
		setTitle("Players who want to join");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 399, 132);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Druid Abel", "Elder Druid", "300", "Yes", "Healer"}, 
					{"Wallasplank", "Royal Paladin", "45", "No", "DPS"}, 
					{"Tony Soprrano", "Elite Knight", "323", "Yes", "Tank"}, 
					{"Furiburing", "Elder Druid", "273", "Yes", "DPS"}, 
					
				},
				new String[] {
					"Name", "Vocation", "Level", "Share XP?", "Role"
				}
			));
		
		btnNewButton = new JButton("Accept selected player into party!");
		btnNewButton.setBounds(10, 191, 238, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(335, 191, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}

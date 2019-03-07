import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class HuntInfoWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HuntInfoWindow frame = new HuntInfoWindow();
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
	public JButton joinHunt;
	public boolean owner = false;
	public showInvites showInv = new showInvites();
	public JoinHuntWindow joinHuntW = new JoinHuntWindow();
	public HuntInfoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(475, 227, 89, 23);
		contentPane.add(btnNewButton);
		
		 joinHunt = new JButton();
		 joinHunt.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		if(owner)
		 		{
		 			if (showInv != null) {
		 				showInv.dispose();
					}
		 			
		 			showInv.table.setModel(new DefaultTableModel(
		 					new Object[][] {
		 						{"Druid Abel", "Elder Druid", "300", "Yes", "Healer"}, 
		 						{"Wallasplank", "Royal Paladin", "45", "No", "DPS"}, 
		 						{"Tony Soprrano", "Elite Knight", "323", "Yes", "Tank"}, 
		 						{"Furiburing", "Elder Druid", "273", "Yes", "DPS"}, 
		 						
		 					},
		 					new String[] {
		 						"Name", "Vocation", "Level", "Can share exp with me?", "Role"
		 					}
		 				));
		 			showInv.setVisible(true);
		 		}
		 		else
		 		{
		 			if (joinHuntW != null) {
		 				joinHuntW.dispose();
					}
		 			
		 			
		 			
		 		}
		 	}
		 });
		 joinHunt.setBounds(10, 227, 150, 23);
		contentPane.add(joinHunt);
		
		JLabel lblNewLabel = new JLabel("Tank(s):");
		lblNewLabel.setBounds(432, 11, 66, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DPS:");
		lblNewLabel_1.setBounds(432, 61, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Healer(s):");
		lblNewLabel_2.setBounds(432, 36, 66, 14);
		contentPane.add(lblNewLabel_2);
		
		  TankLabel = new JLabel("0");
		TankLabel.setBounds(508, 11, 18, 14);
		contentPane.add(TankLabel);
		
		  HealerLabel = new JLabel("0");
		HealerLabel.setBounds(508, 36, 18, 14);
		contentPane.add(HealerLabel);
		
		  DPSLabel = new JLabel("0");
		DPSLabel.setBounds(508, 61, 46, 14);
		contentPane.add(DPSLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Hunt created by:");
		lblNewLabel_3.setBounds(10, 11, 109, 14);
		contentPane.add(lblNewLabel_3);
		
		createdBy = new JLabel("New label");
		createdBy.setBounds(115, 11, 135, 14);
		contentPane.add(createdBy);
		
		JLabel lblNewLabel_5 = new JLabel("Hunt name:");
		lblNewLabel_5.setBounds(10, 36, 109, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Main Target:");
		lblNewLabel_6.setBounds(10, 61, 109, 14);
		contentPane.add(lblNewLabel_6);
		
		huntName = new JLabel("New label");
		huntName.setBounds(115, 36, 135, 14);
		contentPane.add(huntName);
		
		mainTarget = new JLabel("New label");
		mainTarget.setBounds(115, 61, 135, 14);
		contentPane.add(mainTarget);
		
		JLabel lblNewLabel_4 = new JLabel("Duration:");
		lblNewLabel_4.setBounds(10, 86, 109, 14);
		contentPane.add(lblNewLabel_4);
		
		duration = new JLabel("New label");
		duration.setBounds(115, 86, 77, 14);
		contentPane.add(duration);
		
		JLabel lblNewLabel_7 = new JLabel("Details:");
		lblNewLabel_7.setBounds(10, 135, 109, 14);
		contentPane.add(lblNewLabel_7);
		
		textArea = new JTextArea();
		textArea.setBounds(70, 140, 309, 76);
		contentPane.add(textArea);
		
		 modDetails = new JButton("Modify Details");
		modDetails.setBounds(405, 141, 159, 23);
		contentPane.add(modDetails);
		
		 editHunt = new JButton("Edit hunt details");
		editHunt.setBounds(170, 227, 146, 23);
		contentPane.add(editHunt);
		
		passLeader = new JButton("Pass Leadership");
		passLeader.setBounds(301, 7, 121, 23);
		contentPane.add(passLeader);
		
		sendMsg = new JButton("Send message");
		sendMsg.setBounds(260, 7, 31, 23);
		contentPane.add(sendMsg);
		
		JButton btnNewButton_6 = new JButton("Show players in this role");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (roleNames != null) {
					roleNames.dispose();
				}
				roleNames = new RoleNames();
				roleNames.txtrGoHere.setText("Tank names go here!");
				roleNames.setVisible(true);
			}
		});
		btnNewButton_6.setBounds(546, 7, 18, 23);
		contentPane.add(btnNewButton_6);
		
		JButton button = new JButton("Show players in this role");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (roleNames != null) {
					roleNames.dispose();
				}
				roleNames = new RoleNames();
				roleNames.txtrGoHere.setText("Healer names go here!");
				roleNames.setVisible(true);
			}
		});
		button.setBounds(546, 32, 18, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Show players in this role");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (roleNames != null) {
					roleNames.dispose();
				}
				roleNames = new RoleNames();
				roleNames.txtrGoHere.setText("DPS names go here!");
				roleNames.setVisible(true);
			}
		});
		button_1.setBounds(546, 57, 18, 23);
		contentPane.add(button_1);
		
		JButton btnNewButton_2 = new JButton("View All Players");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton_2.setBounds(432, 82, 132, 23);
		contentPane.add(btnNewButton_2);
	}
	public JButton modDetails;
	public JButton editHunt;
	public RoleNames roleNames = null;
	public JButton passLeader;
	public JButton sendMsg; 
	public JLabel TankLabel;
	public JLabel HealerLabel;
	public JLabel DPSLabel;
	
	public JLabel createdBy;
	public JLabel huntName;
	public JLabel duration;
	public JTextArea textArea;
	public JLabel mainTarget;
}

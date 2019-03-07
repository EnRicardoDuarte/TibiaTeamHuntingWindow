import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class WindowTest {

	private JFrame frmCurrentHunts;
	private JTable table;
	public HuntInfoWindow huntInfo = null;
	public CreateHuntWindow createHunt = null;
	public JButton infoButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowTest window = new WindowTest();
					window.frmCurrentHunts.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCurrentHunts = new JFrame();
		frmCurrentHunts.setTitle("Current hunts");
		frmCurrentHunts.setBounds(100, 100, 638, 402);
		frmCurrentHunts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCurrentHunts.getContentPane().setLayout(null);
		
		
		
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_1.setBounds(523, 329, 89, 23);
		frmCurrentHunts.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 57, 602, 97);
		frmCurrentHunts.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				infoButton.setEnabled(true);
				//System.out.println(table.getSelectedRow());
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Guido", "Oramond Hydras", "Hydras", "1 hour", "1/3", "None.", "1/0/0"},
				{"Elber Galarga", "Cyclop hunt", "Cyclops", "> 1 hour", "1/2", "Bring stealth ring.", "0/0/1"},
				{"Ferumbras", "PoI Service", "Varied", "> 2 hours", "36/30", "Meet in POH temple, bring required items.", "6/8/24"}
			},
			new String[] {
				"Creator", "Hunt Name", "Main Target", "Duration", "Hunt Size", "Details", "Tnk/Hlr/DPS"
			}
		));
		
		infoButton = new JButton("Show hunt information");
		infoButton.setEnabled(false);
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (huntInfo != null) {
					huntInfo.dispose();
				}
				huntInfo = new HuntInfoWindow();
				int row = table.getSelectedRow();
				int col = table.getSelectedColumn();
				huntInfo.createdBy.setText(table.getValueAt(row, 0).toString());
				huntInfo.huntName.setText(table.getValueAt(row, 1).toString());
				huntInfo.mainTarget.setText(table.getValueAt(row, 2).toString());
				huntInfo.duration.setText(table.getValueAt(row, 3).toString());
				huntInfo.textArea.setText(table.getValueAt(row, 5).toString());
				huntInfo.textArea.setEditable(false);
				
				int [] roles = getRoles(table.getValueAt(row, 6).toString());
				huntInfo.TankLabel.setText("" + roles[0]);
				huntInfo.HealerLabel.setText("" + roles[1]);
				huntInfo.DPSLabel.setText("" + roles[2]);
				roles = null;
				
				if(huntInfo.createdBy.getText().equals("Sanctus Ricardo")) {
					huntInfo.editHunt.setEnabled(true);
					huntInfo.modDetails.setEnabled(true);
					huntInfo.passLeader.setEnabled(true);
					huntInfo.sendMsg.setEnabled(false);
					huntInfo.joinHunt.setText("Manage invitations");
					huntInfo.owner = true;
				}
				
				else {
					huntInfo.editHunt.setEnabled(false);
					huntInfo.modDetails.setEnabled(false);
					huntInfo.passLeader.setEnabled(false);
					huntInfo.sendMsg.setEnabled(true);
					huntInfo.joinHunt.setText("Join this Hunt!");
					huntInfo.owner = false;
				}
				
				huntInfo.setVisible(true);
				
			}
			
		});
		
		JButton createButton = new JButton("Create Hunt");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (createHunt != null) {
					createHunt.dispose();
				}
				createHunt = new CreateHuntWindow();
				for(int i = 0; i < table.getRowCount(); i++)
				{
					if(table.getValueAt(i,0 ).toString().equals("Sanctus Ricardo"))
					{
						int n = JOptionPane.showConfirmDialog(null, 
								"Seems like you already have an ongoing hunt, would you like to create a new one in its place?", 
								"You already have a hunt in progress!",
								JOptionPane.YES_NO_OPTION);
						if(n == 1)		{				
							((DefaultTableModel)table.getModel()).removeRow(i);			
							createHunt.setVisible(true);
						}
					}
				} 
				
				createHunt.setVisible(true);  
			}
		});
		createButton.setBounds(10, 329, 127, 23);
		frmCurrentHunts.getContentPane().add(createButton);
		
		infoButton.setBounds(147, 329, 163, 23);
		frmCurrentHunts.getContentPane().add(infoButton);
		
		JButton btnNewButton = new JButton("Update list");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(createHunt != null && createHunt.isReady)
				{
					//System.out.println(createHunt.arg[0]);
					//System.out.println(createHunt.isReady);
					setNewTableModel(createHunt.arg);
				}
			}
		});
		btnNewButton.setBounds(479, 165, 133, 23);
		frmCurrentHunts.getContentPane().add(btnNewButton);
	}
	public void setNewTableModel(String[] args)
	{
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"Guido", "Oramond Hydras", "Hydras", "1 hour", "1/3", "None.", "1/0/0"},
					{"Elber Galarga", "Cyclop hunt", "Cyclops", "> 1 hour", "1/2", "Bring stealth ring.", "0/0/1"},
					{"Ferumbras", "PoI Service", "Varied", "> 2 hours", "36/30", "Meet in POH temple, bring required items.", "6/8/24"},
					{args[0], args[1], args[2], args[3], "1/" + args[4], args[5], args[6]}
				},
				new String[] {
					"Creator", "Hunt Name", "Main Target", "Duration", "Hunt Size", "Details", "Tnk/Hlr/DPS"
				}
			));
	}
	public int[] getRoles(String str)
	{
		int [] roles = new int[3];
		for(int i = 0; i < 3; i ++)
		{
			roles[i] = Integer.parseInt(str.split("/")[i]);
		}
		return roles;
	}
}

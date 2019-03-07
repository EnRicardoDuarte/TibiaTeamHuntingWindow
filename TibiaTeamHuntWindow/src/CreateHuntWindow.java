import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class CreateHuntWindow extends JFrame {

	private JPanel contentPane;
	public JTextField huntName;
	public JTextField mainTarget;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateHuntWindow frame = new CreateHuntWindow();
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
	public CreateHuntWindow() {
		setTitle("Create your own hunt!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		  choice = new Choice();
		choice.setBounds(76, 83, 58, 20);
		contentPane.add(choice);
		choice.addItem("<=");
		choice.addItem(">=");
		choice.addItem("<");
		choice.addItem(">");
		JLabel lblNewLabel = new JLabel("Hunt Name (*):");
		lblNewLabel.setBounds(10, 11, 95, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Main Target (*):");
		lblNewLabel_1.setBounds(10, 38, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		huntName = new JTextField();
		huntName.setBounds(94, 8, 177, 20);
		contentPane.add(huntName);
		huntName.setColumns(10);
		
		JLabel partyLabel = new JLabel("Min. Party Size:");
		partyLabel.setBounds(10, 63, 132, 14);
		contentPane.add(partyLabel);
		
		 partySize = new JSpinner();
		partySize.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(1)));
		partySize.setBounds(152, 60, 44, 20);
		contentPane.add(partySize);
		
		JLabel lblNewLabel_2 = new JLabel("Duration:");
		lblNewLabel_2.setBounds(10, 88, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Hunt Notes:");
		lblNewLabel_3.setBounds(10, 169, 132, 14);
		contentPane.add(lblNewLabel_3);
		
		 duration = new JSpinner();
		duration.setModel(new SpinnerNumberModel(1, 1, 23, 1));
		duration.setBounds(152, 83, 44, 20);
		contentPane.add(duration);
		
		JLabel lblNewLabel_4 = new JLabel("hour(s).");
		lblNewLabel_4.setBounds(206, 89, 89, 14);
		contentPane.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(102, 164, 322, 52);
		contentPane.add(scrollPane);
		
		huntNotes = new JTextArea();
		scrollPane.setViewportView(huntNotes);
		
		
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset fields");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				huntNotes.setText("");
				huntName.setText("");
				mainTarget.setText("");
			}
		});
		btnNewButton_2.setBounds(152, 227, 119, 23);
		contentPane.add(btnNewButton_2);
		
		mainTarget = new JTextField();
		mainTarget.setBounds(94, 35, 177, 20);
		contentPane.add(mainTarget);
		mainTarget.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Choose your role:");
		lblNewLabel_5.setBounds(10, 115, 124, 14);
		contentPane.add(lblNewLabel_5);
		
		role = new Choice();
		role.setBounds(138, 109, 58, 20);
		contentPane.add(role);
		role.add("Tank");
		role.add("Healer");
		role.add("DPS");
		
		
		JButton btnNewButton = new JButton("Create this hunt!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkEmpty())
					JOptionPane.showMessageDialog(null, "Empty fields! Make sure you complete the necessary (*) fields.");
				else
					setParameters();
			}
		});
		btnNewButton.setBounds(10, 227, 132, 23);
		contentPane.add(btnNewButton);
	}
	public JTextArea huntNotes; 
	public Choice choice;
	public Choice choice_1;
	public JSpinner partySize;
	public JSpinner duration; 
	public Choice role;
	public boolean isReady = false;
	
	public WindowTest wt1 = null;
	public JTable jt; 

	public String[] arg = new String[7];
	
	public void setParameters()
	{   
		arg[0] = "Sanctus Ricardo";
		arg[1] = huntName.getText();
		arg[2] = mainTarget.getText();
		arg[3] = choice.getSelectedItem().toString() + duration.getValue().toString();
		arg[4] = partySize.getValue().toString();
		arg[5] = huntNotes.getText();
		if(role.getSelectedItem().equals("Tank"))
			arg[6] = "1/0/0";
		else if(role.getSelectedItem().equals("Healer"))
			arg[6] = "0/1/0";
		else if(role.getSelectedItem().equals("DPS"))
			arg[6] = "0/0/1"; 
		isReady = true;
		setVisible(false);
	}

	public void setVals()
	{
		jt = new JTable();
		arg[0] = "Sanctus Ricardo";
		arg[1] = huntName.getText();
		arg[2] = mainTarget.getText();
		arg[3] = duration.getValue().toString();
		arg[4] = partySize.getValue().toString();
		arg[5] = huntNotes.getText();
		if(role.getSelectedItem().equals("Tank"))
			arg[6] = "1/0/0";
		else if(role.getSelectedItem().equals("Healer"))
			arg[6] = "0/1/0";
		else if(role.getSelectedItem().equals("DPS"))
			arg[6] = "0/0/1";
		jt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		jt.setModel(new DefaultTableModel(
				new Object[][] {
					{"Guido", "Oramond Hydras", "Hydras", "1 hour", "1/3", "None.", "1/0/0"},
					{"Elber Galarga", "Cyclop hunt", "Cyclops", "> 1 hour", "1/2", "Bring stealth ring.", "0/0/1"},
					{"Ferumbras", "PoI Service", "Varied", "> 2 hours", "36/30", "Meet in POH temple, bring required items.", "6/8/24"},
					{arg[0], arg[1], arg[2], arg[3], arg[4], arg[5], arg[6]}
				},
				new String[] {
					"Creator", "Hunt Name", "Main Target", "Duration", "Hunt Size", "Details", "Tnk/Hlr/DPS"
				}
			)); 
	}
	
	public boolean checkEmpty()
	{
		return huntName.getText().equals("") || 
				mainTarget.getText().equals("");
				
	}
}

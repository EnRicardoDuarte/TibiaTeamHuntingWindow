import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinHuntWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinHuntWindow frame = new JoinHuntWindow();
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
	public JoinHuntWindow() {
		setTitle("Join the hunt of ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 331, 213);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Tank");
		
		rdbtnNewRadioButton.setBounds(6, 48, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Healer");
		rdbtnNewRadioButton_1.setBounds(6, 74, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("DPS");
		rdbtnNewRadioButton_2.setBounds(6, 100, 109, 23);
		contentPane.add(rdbtnNewRadioButton_2);
		
		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rdbtnNewRadioButton_2);
        bgroup.add(rdbtnNewRadioButton_1);
        bgroup.add(rdbtnNewRadioButton);
        
       
        
		JButton btnNewButton = new JButton("Join!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(6, 138, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Select a role to play in the hunt!");
		lblNewLabel.setBounds(10, 26, 414, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(216, 138, 89, 23);
		contentPane.add(btnNewButton_1);
		
		 rdbtnNewRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton.setEnabled(true);
				}
			});
		 
		 rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton.setEnabled(true);
				}
			}); 
		 
		 rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnNewButton.setEnabled(true);
				}
			});
	}
}

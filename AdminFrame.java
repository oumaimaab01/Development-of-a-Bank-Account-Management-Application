package tp_bank;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import java.util.Random;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

public class AdminFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	DefaultListModel model = new DefaultListModel ();
	String  C;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame  frame = new AdminFrame ();
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
	public AdminFrame () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 432);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(481, 144, 96, 14);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(491, 105, 96, 14);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(24, 313, 225, 14);
		
		JLabel lblNewLabel_2 = new JLabel("BMCDE BANK");
		lblNewLabel_2.setBounds(157, 11, 370, 24);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		
		
		
		JLabel lblNewLabel_51 = new JLabel("");
		lblNewLabel_51.setBounds(491, 105, 96, 14);
		
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(271, 75, 481, 307);
		panel_1.setBorder(new TitledBorder(null, "Account Lists ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		contentPane.add(lblNewLabel_2);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(80, 36, 103, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(232, 36, 125, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setBounds(24, 36, 46, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setBounds(349, 36, 107, 14);
		panel_1.add(lblNewLabel_10);
		
		JList list = new JList();
		list.setBounds(10, 24, 461, 272);
		panel_1.add(list);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 75, 251, 307);
		panel.setBorder(new TitledBorder(null, "New Account", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(107, 63, 116, 20);
		panel.add(textField);
		textField.setColumns(10);//une zone texte pour taper le nom
		
		textField_2 = new JTextField();
		textField_2.setBounds(107, 94, 116, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New Name");
		lblNewLabel.setBounds(21, 66, 63, 14);
		panel.add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("New Balance ");
		lblNewLabel_4.setBounds(21, 100, 85, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("Account");
		lblNewLabel_1.setBounds(21, 128, 63, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Create New Account");
		btnNewButton.setBounds(37, 201, 162, 23);
		panel.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(107, 128, 116, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Current", "Saving"}));
		comboBox.setSelectedIndex(0);
		panel.add(comboBox);
		
		
		String selectedAccountType = (String) comboBox.getSelectedItem();
		
		if (selectedAccountType.equals("Current")) {
		 
		  C= "(rate=10%)";
		} else   {
		  C = "(1000.0 authzed)";
		}
		
		
		
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setBounds(21, 253, 202, 14);
		panel.add(lblNewLabel_11);
		
		
		
		
		 
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		String lettersAndDigits = "abcdefghijklmnopqrstuvwxyz0123456789";
		for (int i = 0; i < 4; i++) {
		    char c = lettersAndDigits.charAt(random.nextInt(lettersAndDigits.length()));
		    sb.append(c);
		}
		String randomChar = sb.toString();
						
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s =textField.getText();
				String R = sb.toString();
				//String B=textField_1.getText();
				String N=textField_2.getText();
				lblNewLabel_3.setText(s);
				lblNewLabel_7.setText("Balance = "+N);
				lblNewLabel_9.setText(R);
				lblNewLabel_10.setText(C);
				lblNewLabel_11.setText("\"This account has been registered");	
			}
		});
	}
}


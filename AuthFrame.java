package tp_bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class AuthFrame extends JFrame {
	private static final long serialVersionUID = 1L;


	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthFrame frame = new AuthFrame();
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
	public AuthFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setBounds(88, 97, 76, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Passeword");
		lblNewLabel_2.setBounds(88, 122, 76, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(169, 94, 167, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 119, 167, 20);
		contentPane.add(passwordField);
		
		JPanel panel = new JPanel();
		panel.setBounds(51, 42, 303, 173);
		panel.setBorder(new TitledBorder(null, "Authorization", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.setBounds(119, 112, 64, 23);
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(193, 112, 89, 23);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Status", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(51, 226, 303, 47);
		contentPane.add(panel_1);
		
		final JLabel statusLabel = new JLabel(" ");
		panel_1.add(statusLabel);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=textField.getText();
				String password = new String(passwordField.getPassword());
				
				if (Username.equals("Admin") && password.equals("123")) {
					statusLabel.setText("Admin Authentication successful. Access granted."); // Set the text of the label
					AdminFrame menu=new AdminFrame();
					menu.setVisible(true);
				} else {
					statusLabel.setText("Invalid login or password. Please try again."); // Set the text of the label
				}
			}
		});
	}
} 
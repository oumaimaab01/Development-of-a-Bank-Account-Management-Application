package tp_bank;

import java.awt.BorderLayout;
	import java.awt.BorderLayout;
	import java.awt.EventQueue;
	import java.awt.Font;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.text.DecimalFormat;
	import java.util.LinkedList;
	import java.util.List;
	import java.util.Map;
	import java.util.Set;
	import java.util.TreeMap;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JList;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	import javax.swing.JTextPane;
	import javax.swing.SwingConstants;
	import javax.swing.border.EmptyBorder;
	import java.awt.Color;
	import javax.swing.JRadioButton;
	import javax.swing.JSeparator;
	import javax.swing.JSlider;
	import javax.swing.JTextArea;

	public class CustomerFrame extends JFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
		private JTextField textField;

		
		Account compte;

		public CustomerFrame( List<Account> comptes ) {
			
			//on utilise une map pour simplifier l'acces
			Map<Integer,Account> map = new TreeMap<>();
			
			comptes.forEach( (compte) ->  {
				map.put(compte.getNumber(), compte);


			});
			
			// j'ai construire la fenetre � l'aide de window Builder
			Set<Integer> numberSet = map.keySet();
			JList<Integer> numberosJList  = new JList(numberSet.toArray());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			
			this.setBounds(100, 100, 621, 436);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.getContentPane().setLayout(null);
			contentPane.setLayout(null);
			
			var panel = new JPanel();
			panel.setEnabled(false);
			panel.setBounds(10, 120, 209, 269);
			this.getContentPane().add(panel);
			panel.setLayout(null);
			
			JButton btnDetails = new JButton("Details");
			btnDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
			btnDetails.setBounds(126, 10, 87, 19);
			panel.add(btnDetails);
			
			var IBANPane = new JTextPane();
			IBANPane.setBounds(42, 10, 62, 19);
			panel.add(IBANPane);
			
			var namePanel = new JLabel("Name");
			namePanel.setFont(new Font("Tahoma", Font.BOLD, 14));
			namePanel.setBounds(10, 39, 66, 19);
			panel.add(namePanel);
			
			JLabel balancePanel = new JLabel("Balance");
			balancePanel.setFont(new Font("Tahoma", Font.BOLD, 14));
			balancePanel.setBounds(10, 68, 76, 19);
			panel.add(balancePanel);
			
			JLabel IbanLabel = new JLabel("No");
			IbanLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
			IbanLabel.setBounds(10, 10, 66, 19);
			panel.add(IbanLabel);
			
			JLabel nameLabel = new JLabel("");
			nameLabel.setForeground(Color.BLUE);
			nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			nameLabel.setBounds(86, 39, 99, 18);
			panel.add(nameLabel);
			
			JLabel soldeLabel = new JLabel("");
			soldeLabel.setForeground(Color.BLUE);
			soldeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			soldeLabel.setBounds(86, 68, 99, 18);
			panel.add(soldeLabel);
			
			JTextField montant = new JTextField();
			montant.setBounds(8, 136, 96, 46);
			panel.add(montant);
			montant.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Amount");
			lblNewLabel_2.setForeground(Color.GRAY);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
			lblNewLabel_2.setBounds(10, 120, 62, 13);
			panel.add(lblNewLabel_2);
			
			JRadioButton rdbtnDeposit = new JRadioButton("Deposit");
			rdbtnDeposit.setBounds(110, 120, 103, 21);
			panel.add(rdbtnDeposit);
			
			JRadioButton rdbtnwithraw = new JRadioButton("Withdrow\r\n");
			rdbtnwithraw.setBounds(110, 149, 103, 21);
			panel.add(rdbtnwithraw);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(0, 97, 213, 13);
			panel.add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 205, 213, 2);
			panel.add(separator_1);
			
			var panel_1 = new JPanel();
			panel_1.setBounds(229, 120, 368, 269);
			this.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			var operationField = new JTextArea();
			operationField.setBounds(10, 0, 358, 269);
			panel_1.add(operationField);
			operationField.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Bank Transactions");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 10, 587, 84);
			this.getContentPane().add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Account");
			lblNewLabel_1.setBounds(20, 91, 66, 22);
			this.getContentPane().add(lblNewLabel_1);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
			
			JLabel lblNewLabel_3 = new JLabel("Statement");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_3.setBounds(241, 89, 98, 26);
			this.getContentPane().add(lblNewLabel_3);
			
			
			//j'ai programmer la bouton details pour afficher le details du compte
			btnDetails.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					montant.setText("");
					rdbtnwithraw.setSelected(false);
					rdbtnDeposit.setSelected(false);
					String Num = IBANPane.getText();
					int iban = Integer.valueOf(Num);
					//on affiche un message qu'on n'entre pas tous les infos
					if ( IBANPane.getText().equals("")) {
						JOptionPane.showMessageDialog(btnDetails, "Please Enter All Data !");
					}
					else {
						//sinon on affiche le relev�
						compte = map.get(iban);
						nameLabel.setText(compte.getName());
						String soldeString = new DecimalFormat("0.00").format(compte.getBalance());
						soldeLabel.setText(soldeString);
						operationField.setText(compte.bankStatement());
						
						
					}
					//j'ai programmer le radiobutton pour faire un depot
					rdbtnDeposit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							rdbtnwithraw.setSelected(false);
							String strMontant = montant.getText();
							double Montant = Double.valueOf(strMontant);
							compte.deposit(Montant);
						}	
					});
					// j'ai programmer aussi un autre radiobouton pour retirer de l'argent
					rdbtnwithraw.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							rdbtnDeposit.setSelected(false);
							String strMontant = montant.getText();
							double Montant = Double.valueOf(strMontant);
							try {
								compte.withdraw(Montant);
							} catch (InsufficientFundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}	
					});

				}	
			});
			
			
		}
	}
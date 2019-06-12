package com.revature.BankingApp.window;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.revature.BankingApp.BankDriver;
import com.revature.BankingApp.doa.AccountDoaImpl;
import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;
public class WelcomeWindow extends JFrame {
	
	

	private static final long serialVersionUID = 4852880853743889647L;
	
	public WelcomeWindow(){
		setTitle("Login");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50, 500,200);
		setLayout(new BorderLayout());
		buildWindow();
		setVisible(true);
	}
	Customer cust;
	
	private void buildWindow() {
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		JLabel loginl = new JLabel("Log into database");
		JLabel unl = new JLabel("Username");
		JLabel passl = new JLabel("Password");
		
		JTextField untf = new JTextField(12);
		JPasswordField passtf = new JPasswordField(12);
		
		JButton loginb = new JButton("Login");
		JButton close = new JButton("Close");
		JButton newCustomer = new JButton("New Customer");
		
		close.addActionListener(e -> 	{	System.exit(0);	});
		
		loginb.addActionListener(e -> {
			String username = "admin";
			String password = "password";
			String u = untf.getText();
			String p = passtf.getText();
			String url = "jdbc:oracle:thin:@[bankingapp.ccitm10gpxjr.us-east-2.rds.amazonaws.com]:1521:ORCL";
			BankDriver.connect(username, password, url);
			cust = BankDriver.User(u,p);
			List<Account>acc = BankDriver.getCustomerAccounts(cust);
			System.out.println(cust.getFirstName() + "\n" + acc.toString());
			
			if(cust != null) {
				PickAccount pa = new PickAccount(cust, acc);
				this.dispose();
			}
			else {
				loginl.setText("Error: Username or Password incorrect. Try again please.");
				System.out.println("ERROR");
			}
		});
		
		newCustomer.addActionListener(e -> {
			NewCustomerWindow ncw = new NewCustomerWindow();
			this.dispose();
			});
		
		
		panel.add(loginl);
		
		panel2.add(unl);
		panel2.add(untf);
		panel2.add(passl);
		panel2.add(passtf);
		
		panel3.add(loginb);
		panel3.add(newCustomer);
		panel3.add(close);
		
		add(panel, BorderLayout.NORTH);
		add(panel2, BorderLayout.CENTER);
		add(panel3, BorderLayout.SOUTH);
		
	}
	
	

}

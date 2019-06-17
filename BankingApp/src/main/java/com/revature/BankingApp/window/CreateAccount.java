package com.revature.BankingApp.window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.revature.BankingApp.BankDriver;
import com.revature.BankingApp.doa.AccountDoaImpl;
import com.revature.BankingApp.model.Customer;

public class CreateAccount extends JFrame {
	
	CreateAccount(){super();}
	
	CreateAccount(Customer c){
		setTitle("Create A New Account");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50, 500,200);
		buildWindow(c);
	}
	
	
	private void buildWindow(Customer c) {
		//ask for how much the balance will be then pass to bank driver
		JPanel panel = new JPanel();
		
		JLabel headingl = new JLabel("Creating an Account");
		JLabel balancel = new JLabel("Balance to insert");
		JLabel report = new JLabel();
		JLabel accountTypel = new JLabel("Account Type");
		
		JTextField accountTypetf = new JTextField(10);
		JTextField balancetf = new JTextField(10);

		
		JButton createAccount = new JButton("Create Account");
		JButton exit = new JButton("Logout");
		JButton back = new JButton("Back");
		
		createAccount.addActionListener(e -> {
			String accType = accountTypetf.getText();
			String balStr = balancetf.getText();
			
			
			if(BankDriver.isAccountType(accType) && BankDriver.isDouble(balStr) && Double.valueOf(balStr) > 0) {
				BankDriver.createNewAccount(c, Double.valueOf(balStr), accType);
				report.setText("Account created");
			}
			else
				report.setText("Information not in supported format");
		});
		
		exit.addActionListener(e -> {	System.exit(0);	});
		
		back.addActionListener(e -> {
			WelcomeWindow ww = new WelcomeWindow();
			this.dispose();
		});
		
		panel.add(headingl);
		panel.add(accountTypel);
		panel.add(accountTypetf);
		panel.add(balancel);
		panel.add(balancetf);
		panel.add(createAccount);
		panel.add(exit);
		panel.add(back);
		panel.add(report);
		add(panel);
		
	}
}

package com.revature.BankingApp.window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.revature.BankingApp.BankDriver;
import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;

public class DepositWindow extends JFrame{
	
	DepositWindow(){super(); System.out.println("Pass in customer");}
	DepositWindow(Customer c, Account a){
		setTitle("Deposit");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50, 500,200);
		buildWindow(c, a);
	}
	
	private void buildWindow(Customer c, Account a){
		JPanel panel = new JPanel();
		
		JLabel depositl = new JLabel("How much are you depositing");
		JLabel report = new JLabel();
		
		JTextField deposittf = new JTextField(10);
		
		JButton depositb = new JButton("Deposit");
		JButton back = new JButton("Back");
		JButton exit = new JButton("Logout");
		
		depositb.addActionListener(e -> {
			String depoNumStr = deposittf.getText();
			
			if(BankDriver.isDouble(depoNumStr) && Double.valueOf(depoNumStr) > 0) {
				BankDriver.deposit(a, Double.valueOf(deposittf.getText()));
				report.setText("Money has been added to the account");
			}
			else 
				report.setText("Your amount must be more than 1 and must be a number");
		});
		
		exit.addActionListener(e -> {	System.exit(0);	});
		
		back.addActionListener(e -> {
			SelectionWindow sw = new SelectionWindow(c, a);
			this.dispose();
		});
		
		panel.add(depositl);
		panel.add(deposittf);
		panel.add(depositb);
		panel.add(back);
		panel.add(exit);
		panel.add(report);
		add(panel);
		
	
	}
}

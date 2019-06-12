package com.revature.BankingApp.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.revature.BankingApp.BankDriver;
import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;

public class SelectionWindow extends JFrame {
	
	private static final long serialVersionUID = 6821715575379783122L;

	public SelectionWindow() {super();}
	public SelectionWindow(Customer c, Account a){
		setTitle("Welcome back " + c.getFirstName());
		setVisible(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50, 500,500);
		setLayout(new GridLayout(1,5));
		buildWindow(c, a);
		setVisible(true);
	}

	private void buildWindow(Customer c, Account a) {
		JLabel name = new JLabel("Welcome " + c.getFirstName());
		JLabel choice = new JLabel("What would you like to do?");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,1));
		
		JButton createAccount = new JButton("Create a new account");
		JButton deposit = new JButton("Deposit");
		JButton withdraw = new JButton("Withdraw");
		JButton viewBalance = new JButton("View Balance");
		JButton transfer = new JButton("Transfer Funds");
		JButton close = new JButton("Logout");
		
		createAccount.addActionListener(e -> {
			CreateAccount ca = new CreateAccount(c);
			this.dispose();
		});
		
		deposit.addActionListener(e -> {
			DepositWindow dw = new DepositWindow(c, a);
			this.dispose();
			
		});
		
		withdraw.addActionListener(e -> {
			WithdrawWindow ww = new WithdrawWindow(c, a);
			this.dispose();
			
		});
		
		viewBalance.addActionListener(e -> {
			ViewBalanceWindow vbw = new ViewBalanceWindow(c, a);
			this.dispose();
				
		});
		
		transfer.addActionListener(e -> {
			TransferWindow tw = new TransferWindow(c);
			this.dispose();
		});
		
		close.addActionListener(e -> {	System.exit(0);	});
		
		panel.add(name);
		panel.add(choice);
		panel.add(viewBalance);
		panel.add(createAccount);
		panel.add(deposit);
		panel.add(withdraw);
		panel.add(transfer);
		panel.add(close);
		
		
		add(panel);
	}
}

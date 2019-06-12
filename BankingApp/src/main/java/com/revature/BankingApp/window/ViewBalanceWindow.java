package com.revature.BankingApp.window;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.revature.BankingApp.BankDriver;
import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;

public class ViewBalanceWindow extends JFrame{
	
	public ViewBalanceWindow() { super();}
	
	public ViewBalanceWindow(Customer c, Account a) {
		setTitle("Balance");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50, 500,200);
		buildWindow(c, a);
	}
	
	private void buildWindow(Customer c, Account acc) {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,1));
		
		JLabel accHolder = new JLabel("Account Holder: " + c.getFirstName() + " " + c.getLastName() );
		JLabel balance = new JLabel("Current Balance: " + ((Double)acc.getBalance()).toString());
		panel.add(accHolder);
		panel.add(balance);
		
		JButton exit = new JButton("Logout");
		JButton back = new JButton("Back");
		
		exit.addActionListener(e -> System.exit(0));
		back.addActionListener(e -> {
			SelectionWindow sw = new SelectionWindow(c, acc);
			this.dispose();
		});

		panel.add(exit);
		panel.add(back);
		add(panel);
	}
	
}

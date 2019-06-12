package com.revature.BankingApp.window;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.revature.BankingApp.BankDriver;
import com.revature.BankingApp.doa.AccountDoaImpl;
import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;

public class WithdrawWindow extends JFrame{
	
	
	public WithdrawWindow() {super(); System.out.println("Pass in customer");}
	public WithdrawWindow(Customer c, Account a){
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50, 500,200);
		buildWindow(c, a);
	}
	
	private void buildWindow(Customer c, Account a) {
		JPanel panel = new JPanel();
		
		JLabel withdrawl = new JLabel("Withdraw Amount");
		JLabel info = new JLabel();
		
		JTextField withdrawtf = new JTextField(10);
		
		JButton withdrawb = new JButton("Withdraw");
		JButton exit = new JButton("Logout");
		JButton back = new JButton("Back");
		
		withdrawb.addActionListener(e -> {
			String w = withdrawtf.getText();
			
			if(BankDriver.isDouble(w)) {
				double money = Double.valueOf(w);
				if(a.getBalance() - money > 0) {
					BankDriver.withdraw(a, money);
					info.setText("Withdrawn");
				}
				else
					withdrawl.setText("You balance will be negative. Pick a smaller number");
			}
			else
				withdrawl.setText("Money was not entered correctly. Please try again");
		});
		
		
		exit.addActionListener(e -> System.exit(0));
		back.addActionListener(e -> {
			SelectionWindow sw = new SelectionWindow(c, a);
			this.dispose();
		});
		
		exit.addActionListener(e -> {	System.exit(0);	});
		
		back.addActionListener(e -> {
			SelectionWindow sw = new SelectionWindow(c, a);
			this.dispose();
		});
		
		panel.add(withdrawl);
		panel.add(withdrawtf);
		panel.add(withdrawb);
		panel.add(back);
		panel.add(exit);
		panel.add(info);
		add(panel);
		
		
	}
}

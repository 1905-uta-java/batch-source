package com.revature.BankingApp.window;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.revature.BankingApp.BankDriver;
import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;

public class TransferWindow extends JFrame {
	public TransferWindow(){
		super();
	}
	public TransferWindow(Customer c){
		setTitle("Login");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50, 500,200);
		setLayout(new BorderLayout());
		buildWindow(c);
		setVisible(true);
	}
	
	int i = 1;
	
	private void buildWindow(Customer c) {
		JPanel panel = new JPanel();
		
		JComboBox transferToChoices;
		JComboBox transferFromChoices;
		
		
		
		JLabel t2 = new JLabel("Transfer to");
		JLabel tf = new JLabel("Transfer From");
		JLabel tran = new JLabel("Amount to add");
		JLabel report = new JLabel();
		
		JTextField amount = new JTextField(10);
		
		JButton transfer = new JButton("Transfer");
		JButton exit = new JButton("Logout");
		JButton back = new JButton("Back");
		
		
		
		
		List<Account>accounts = BankDriver.getCustomerAccounts(c);
		String[] transferTo = new String[accounts.size()];
		String[] transferFrom = new String[accounts.size()];
		
		for(Account a : accounts) {
			transferTo[i-1] = "Account " + (i);
			transferFrom[i-1] = "Account " + (i);
			i++;
		}
		
		transferToChoices = new JComboBox(transferTo);
		transferFromChoices = new JComboBox(transferFrom);
		
		transfer.addActionListener(e -> {
			Account t2c = accounts.get(transferToChoices.getSelectedIndex());
			Account tfc = accounts.get(transferFromChoices.getSelectedIndex());
			
			if(t2c == tfc) {
				report.setText("Cannont transfer to and from the same file");
			}
			else {
				if(BankDriver.isDouble(amount.getText())) {
					double money = Double.valueOf(amount.getText());
					if(tfc.getBalance() - money < 0) {
						report.setText("You don't have enough money");
					}
					else {
						BankDriver.withdraw(tfc, money);
						BankDriver.deposit(t2c, money);
						report.setText("Transfered " + money);
					}
				}
				else {
					report.setText("Number is not formatted correctly");
				}
			}
		});
		exit.addActionListener(e -> System.exit(0));
		back.addActionListener(e -> {
			PickAccount pa = new PickAccount(c, BankDriver.getCustomerAccounts(c));
			this.dispose();
		});
		
	
		panel.add(transferFromChoices);
		panel.add(transferToChoices);
		panel.add(tran);
		panel.add(amount);
		panel.add(transfer);
		panel.add(back);
		panel.add(exit);
		panel.add(report);
		add(panel);
	}
	
	
}

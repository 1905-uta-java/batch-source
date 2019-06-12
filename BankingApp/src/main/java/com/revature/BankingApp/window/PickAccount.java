package com.revature.BankingApp.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.revature.BankingApp.model.Account;
import com.revature.BankingApp.model.Customer;

public class PickAccount extends JFrame {
	
	public PickAccount() {super();}
	public PickAccount(Customer c, List<Account> a){
		if(a.size() == 1) {	
			SelectionWindow sw = new SelectionWindow(c, a.get(0));
			this.dispose();
		}
		else if(a.size() == 0) {
			CreateAccount ca = new CreateAccount(c);
			this.dispose();
		}
		else {
		setTitle("Pick an account");
		setVisible(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,50, 500,500);
		setLayout(new GridLayout(1,5));
		buildWindow(c, a);
		setVisible(true);
		}
	}
	
	public void buildWindow(Customer c, List<Account> a){
		JPanel panel = new JPanel();
		List<Account>returning = new ArrayList();
		int iterator = 1;
		for(Account acc : a) {
			JButton temp = new JButton("Account " + iterator);
			iterator++;
			temp.addActionListener(e -> {
				returning.add(acc);
				SelectionWindow sw = new SelectionWindow(c, acc);
				this.dispose();
			});
			panel.add(temp);
		}
		
		JButton exit = new JButton("Logout");
		
		exit.addActionListener(e -> {	System.exit(0);	});	
		
	
		panel.add(exit);
		add(panel);
		
		
		
	}
}

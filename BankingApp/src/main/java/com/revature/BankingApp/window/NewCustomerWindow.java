package com.revature.BankingApp.window;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.revature.BankingApp.BankDriver;
import com.revature.BankingApp.model.Customer;

public class NewCustomerWindow extends JFrame{
	
	public NewCustomerWindow(){
		setTitle("Welcome to LaTorre bank. Happy to have you");
		setVisible(true);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,80,315 ,400);
		buildWindow();
	}
	
	private void buildWindow() {
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		//customerid, fn, ln, ssn, email, username, password, phone, address, city, county, dateadded, dateremoved
		JLabel fnl = new JLabel("First Name");
		JLabel lnl = new JLabel("Last Name");
		JLabel ssnl = new JLabel("SSN");
		JLabel emaill = new JLabel("Email");
		JLabel userl = new JLabel("Username");
		JLabel passl = new JLabel("Password");
		JLabel phonel = new JLabel("Phone Number");
		JLabel addrl = new JLabel("Address");
		JLabel cityl = new JLabel("City");
		JLabel countryl = new JLabel("Country");
		
		JLabel errorReport = new JLabel();
		
		
		JTextField fntf = new JTextField(20);
		JTextField lntf = new JTextField(20);
		JTextField ssntf = new JTextField(23);
		JTextField emailtf = new JTextField(20);
		JTextField usertf = new JTextField(20);
		JPasswordField passtf = new JPasswordField(15);
		JTextField phonetf = new JTextField(15);
		JTextField addrtf = new JTextField(20);
		JTextField citytf = new JTextField(20);
		JTextField countrytf = new JTextField(20);
		
		JButton add = new JButton("Add");
		JButton exit = new JButton("Logout");
		JButton back = new JButton("Back");
		
		
		add.addActionListener(e->{
			String ssnTest = ssntf.getText();
			String emailTest = emailtf.getText();
			String userTest = usertf.getText();
			boolean flag = true;
			
			if(!BankDriver.isSSN(ssnTest)) {
				errorReport.setText("SSN not Long enough or too long");
				flag = false;
			}
			
			if(BankDriver.emailExist(emailTest)) {
				flag = false;
				errorReport.setText("Email already exists");
			}
			
			if(BankDriver.userExist(userTest)) {
				flag = false;
				errorReport.setText("Username already eixists");
			}

			if(fntf.getText().equals("") || lntf.equals("") || passtf.getText().equals("") || phonetf.getText().equals("") || 
					addrtf.getText().equals(" ") || citytf.getText().equals("") || countrytf.getText().equals("")) {
				flag = false;
				errorReport.setText("Fill out all information");
			}
			
			
			if(flag == true) {
				Customer c = new Customer(0, fntf.getText(), lntf.getText(), ssnTest, emailTest, userTest, passtf.getText(),
						phonetf.getText(), addrtf.getText(), citytf.getText(), countrytf.getText(), null, null);
				BankDriver.addCustomer(c);
				errorReport.setText(c.getFirstName() + " has been added.");
			}
			
			
			
		});
		
		exit.addActionListener(e -> System.exit(0));
		back.addActionListener(e -> {
			WelcomeWindow sw = new WelcomeWindow();
			this.dispose();
		});
		
		
		panel.add(fnl);
		panel.add(fntf);
		panel.add(lnl);
		panel.add(lntf);
		panel.add(ssnl);
		panel.add(ssntf);
		panel.add(emaill);
		panel.add(emailtf);
		panel.add(userl);
		panel.add(usertf);
		panel.add(passl);
		panel.add(passtf);
		panel.add(phonel);
		panel.add(phonetf);
		panel.add(addrl);
		panel.add(addrtf);
		panel.add(cityl);
		panel.add(citytf);
		panel.add(countryl);
		panel.add(countrytf);
		
		panel3.add(add);
		panel3.add(back);
		panel3.add(exit);
		panel.add(errorReport);


		add(panel, BorderLayout.CENTER);
		//add(panel2);
		add(panel3, BorderLayout.SOUTH);
		
		
	}
	
	
}

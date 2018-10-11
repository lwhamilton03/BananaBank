import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeBank {
	Frame F; 
	
	public void createBankPage()
	{
		F = new Frame("BANANA BANK"); 
		F.setVisible(true);
		F.setSize(300,300);
	
		Panel titleHeader = new Panel(); 
		Label title = new Label("BANANA BANK"); 
		titleHeader.setBackground(Color.PINK);
		titleHeader.setFont(new Font("Head", Font.BOLD, 24));
		titleHeader.add(title);
		F.add(titleHeader, BorderLayout.NORTH);
		
		Panel homePage = new Panel(); 
		homePage.setVisible(true);
		GridLayout grid = new GridLayout(5,1);
		homePage.setLayout(grid);
		F.add(homePage, BorderLayout.CENTER); 
			
		
		Button createAccount = new Button ("Create Account");
		createAccount.setBackground(Color.lightGray);
		Button depositeMoney = new Button("Deposite Money");
		depositeMoney.setBackground(Color.lightGray);
		Button withdrawMoney = new Button("Withdraw"); 
		withdrawMoney.setBackground(Color.lightGray); 
		Button exit = new Button("EXIT"); 
		exit.setBackground(Color.GRAY);
		Button bankBalance = new Button("Bank Balance"); 
		bankBalance.setBackground(Color.lightGray);
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent eee)
			{
				//Stops the system from running
				System.exit(0);
			}
		});
		
		
		homePage.add(createAccount);
		homePage.add(depositeMoney);
		homePage.add(withdrawMoney);
		homePage.add(bankBalance);
		homePage.add(exit);
		
		
		
		CreateAccount create = new CreateAccount(F);
		createAccount.addActionListener(create);
		
		DepositPage deposit = new DepositPage(F); 
		depositeMoney.addActionListener(deposit); 
		
		WithdrawPage with = new WithdrawPage(F); 
		withdrawMoney.addActionListener(with);
		
		BankStatementPage bal = new BankStatementPage(F);
		bankBalance.addActionListener(bal);
		
	}
}

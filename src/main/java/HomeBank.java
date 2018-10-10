import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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
		F.setSize(600,600);
	
		Panel titleHeader = new Panel(); 
		Label title = new Label("BANANA BANK"); 
		titleHeader.setBackground(Color.PINK);
		titleHeader.add(title);
		F.add(titleHeader, BorderLayout.NORTH);
		
		Panel homePage = new Panel(); 
		homePage.setVisible(true);
		GridLayout grid = new GridLayout(4,1);
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
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent eee)
			{
				F.setVisible(false);
			}
		});
		
		
		homePage.add(createAccount);
		homePage.add(depositeMoney);
		homePage.add(withdrawMoney);
		homePage.add(exit);
		
		
		
		
		CreateAccount create = new CreateAccount(F);
		createAccount.addActionListener(create);
		
		DepositPage deposit = new DepositPage(F); 
		depositeMoney.addActionListener(deposit); 
		
		WithdrawPage with = new WithdrawPage(F); 
		withdrawMoney.addActionListener(with);
	}
}

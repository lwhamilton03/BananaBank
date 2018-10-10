import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

public class HomeBank {
	
	public void createBankPage()
	{
		Frame F = new Frame("home"); 
		F.setVisible(true);
		F.setSize(600,600);
		
		Panel homePage = new Panel(); 
		GridLayout grid = new GridLayout(3,1);
		homePage.setLayout(grid);
		F.add(homePage, BorderLayout.CENTER); 
		
		Button createAccount = new Button ("Create Account");
		createAccount.setBackground(Color.BLUE);
		Button depositeMoney = new Button("Deposite Money");
		depositeMoney.setBackground(Color.green);
		Button withdrawMoney = new Button("Withdraw"); 
		withdrawMoney.setBackground(Color.PINK); 
		
		homePage.add(createAccount);
		homePage.add(depositeMoney);
		homePage.add(withdrawMoney);
		
		CreateAccount create = new CreateAccount(F);
		createAccount.addActionListener(create);
		
		DepositPage deposit = new DepositPage(); 
		depositeMoney.addActionListener(deposit); 
		
	}
}

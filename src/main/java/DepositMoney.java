import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DepositMoney implements ActionListener{
	
	TextField submit;
	TextField accountNo;
	TextField balance;
	Connection conn = null; 
	Statement stmt = null; 
	
	
	public DepositMoney(TextField f, TextField account, TextField bal)
	{
		submit=f;
		accountNo = account; 
		balance = bal;
	}
	
	public boolean checkAccount(TextField accountNo)
	{
		boolean result = false;
		int check = Integer.parseInt(accountNo.getText());
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
			stmt = conn.createStatement();
			
			String getAccount = "SELECT * from account";
			ResultSet ra = stmt.executeQuery(getAccount); 
			
			while(ra.next())
			{
				int idd = ra.getInt(1);
				if(check == idd)
				{
					result = true;
				}
			}
			
			stmt.close();
			conn.close();
			
		}catch(Exception se) {}
				
		return result;
	}
	
	public void actionPerformed(ActionEvent ok)
	{
		System.out.println("clicked");
		String moneyDeposit = submit.getText();
			
		
		//NAME AND ADDRESS FROM THE ACCOUT NUM
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
			stmt = conn.createStatement();
			
			int money = Integer.parseInt(moneyDeposit);
			//create new deposit
			int acc = Integer.parseInt(accountNo.getText());
			System.out.println(accountNo.getText());
			System.out.println(money);
			String putDeposit = "insert into deposit values("+ acc + ", " + money +", CURDATE())"; 

			
			stmt.executeUpdate(putDeposit);
			System.out.println("trying to deposit");
			
			String getDeposit = "Select * from deposit where AcNo = " + acc;
			stmt = conn.createStatement();
			ResultSet rd = stmt.executeQuery(getDeposit); 
			int totalDeposits = 0;
			
			while(rd.next())
			{
				int amountss = rd.getInt("Amount");
				totalDeposits += amountss; 
				System.out.println("Amount Deposited Previously: " + amountss);
			}
			System.out.println("Total Deposits: " + totalDeposits);
			
			int totalWithdraws = 0; 
			String getWithdraw = "Select * from withdraws where AcNo = " + acc;
			stmt = conn.createStatement();
			ResultSet rw = stmt.executeQuery(getWithdraw); 
			
			while(rw.next())
			{
				System.out.println("in rw");
				int with = rw.getInt("Amount");
				totalWithdraws += with;
				System.out.println("Amount Deposited Previously: " + with);
			}
			
			int balan = totalDeposits - totalWithdraws;
			System.out.println("balance: " + balan);
			String bal = String.valueOf(balan);
			balance.setText(bal);
			stmt.close();
			conn.close();
			
			
		}catch(Exception se) {}
		
		submit.setText(null);
	}

}

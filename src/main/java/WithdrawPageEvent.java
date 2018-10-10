import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WithdrawPageEvent implements ActionListener{

	Connection conn = null; 
	Statement stmt = null; 
	Statement stat = null;
	Statement stt = null; 
		
	TextField accountNom; 
	TextField nom;
	TextField address;
	TextField balance; 
	TextField enterAmount; 
	Button enterAmountOk; 
	
	public WithdrawPageEvent(TextField account,TextField nom, TextField add,TextField bal, 
	TextField enter,Button ent)
	{
		accountNom = account;
		address = add; 
		this.nom = nom; 
		balance = bal;
		enterAmount = enter;
		enterAmountOk = ent;
	}
	
	public void actionPerformed(ActionEvent event)
	{
	
		//NAME AND ADDRESS FROM THE ACCOUT NUM
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
			stmt = conn.createStatement();
			
			//get name and address
			String getName = "SELECT * from account where AcNo = " + accountNom.getText(); 
//			String sqlUpdate = "insert into training values(8, 'Moo', 2)";
//			String sqlAlter = "update training set Name='Man' where Id = 3";
//			stmt.executeUpdate(getName);
//			stmt.executeUpdate(sqlAlter);
			
			ResultSet rs = stmt.executeQuery(getName);
			while(rs.next())
			{
				int id = rs.getInt(1);
				String name2 = rs.getString(2);
				String address2 = rs.getString(3);
				System.out.println("AcNo: " + id);
				System.out.println("Name: " + name2);
				
				//FINAL so need to change all the format 
				nom.setText(name2);
				address.setText(address2);
				System.out.println("Address: " + address2);
				System.out.println("");
			}
			
			
			String getDeposit = "Select * from deposit where AcNo = " + accountNom.getText();
			stat = conn.createStatement();
			ResultSet rd = stat.executeQuery(getDeposit); 
			int totalDeposits = 0;
			
			while(rd.next())
			{
				int amountss = rd.getInt("Amount");
				totalDeposits += amountss; 
				System.out.println("Amount Deposited Previously: " + amountss);
			}
			System.out.println("Total Deposits: " + totalDeposits);
			
			int totalWithdraws = 0; 
			String getWithdraw = "Select * from withdraws where AcNo = " + accountNom.getText();
			stt = conn.createStatement();
			ResultSet rw = stt.executeQuery(getWithdraw); 
			
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
			
			//When clicking the button it will deposit the money
			WithdrawMoney money = new WithdrawMoney(enterAmount, accountNom, balance);
			enterAmountOk.addActionListener(money);
						
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception se) {}
		

		
	}	
}

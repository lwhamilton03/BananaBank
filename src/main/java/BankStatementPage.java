import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BankStatementPage implements ActionListener{
	
Frame home; 
Frame balance; 
TextField input; 
Panel table;
String state = "Enter Account Number";
Connection conn = null; 

Statement stmt = null; 
Statement stt = null;
int row = 0; 


	public BankStatementPage(Frame f)
	{
		home = f;
	}
	
	public void actionPerformed(ActionEvent eve)
	{
		
		home.setVisible(false);
		balance = new Frame();
		balance.setVisible(true);
		balance.setSize(300, 300);
		
		Panel titleHeader = new Panel(); 
		Label title = new Label("BANK STATEMENT"); 
		GridLayout headgrid = new GridLayout(2,1);
		titleHeader.setLayout(headgrid);
		titleHeader.setBackground(Color.PINK);
		titleHeader.setFont(new Font("Head", Font.BOLD, 24));
		titleHeader.add(title);
		balance.add(titleHeader, BorderLayout.NORTH);
		
//		Label middle = new Label(state); 
//		balance.add(middle, BorderLayout.CENTER);
		
		Panel p = new Panel(); 
		FlowLayout flow = new FlowLayout(); 
		p.setBackground(Color.lightGray);
		p.setLayout(flow);
		titleHeader.add(p);
		
		Label accountN = new Label("Enter AcNo: "); 
		p.add(accountN);
		
		//NEEDS TO CHANGE BY IMPLEMENTING IT ELSE WHERE
		input = new TextField();
		p.add(input);
		input.setColumns(9);
		
		
		Button submit = new Button("Submit AcNo");
		p.add(submit);
		
		table = new Panel();
		
		GridLayout grid = new GridLayout(row,3);
		table.setLayout(grid);
		titleHeader.add(p);
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				balance.add(table, BorderLayout.CENTER);
				System.out.println("action performed");
				try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
				stmt = conn.createStatement();
				
				int acountNom = Integer.parseInt(input.getText());
				//get name and address
				String getDeposits = "SELECT * from deposit where AcNo = " + input.getText(); 
				ResultSet rs = stmt.executeQuery(getDeposits);
				state = "DEPOSITS";
				
				while(rs.next())
				{
					row ++;
					int amount = rs.getInt(2);
					String date = rs.getString(3);
					System.out.println(amount);
					
					balance.setVisible(true);
										
					Label rows = new Label("Deposit");
					table.add(rows);
					Label amou = new Label(String.valueOf(amount)); 
					table.add(amou);
					amou.setBackground(Color.green);
					Label dates = new Label(date); 
					table.add(dates); 
				
				}
				
				
				
				String getWithdraw = "SELECT * from withdraws where AcNo = " + input.getText(); 
				rs = stmt.executeQuery(getWithdraw);
				
				while(rs.next())
				{
					row ++;
					int am = rs.getInt(2);
					String datess = rs.getString(3);
					System.out.println(am);
					
					balance.setVisible(true);
										
					Label rows = new Label("Withdrawal");
					table.add(rows);
					Label amou = new Label(String.valueOf(am)); 
					table.add(amou);
					amou.setBackground(Color.red);
					Label dates = new Label(datess); 
					table.add(dates); 
				}
				rs.close();
				stmt.close();
				conn.close();
				} catch (SQLException eee) {
					eee.printStackTrace();
				}
			}
		});
		
		input.setText(null);

	}
	
}

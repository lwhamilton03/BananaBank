import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateAccountEvent implements ActionListener{
	TextField nom;
	TextField addresss;
	Label acNo; 
	Button sub; 
	Connection conn = null; 
	Statement stmt = null; 
	Frame error; 
	
	public CreateAccountEvent(TextField nom, TextField addresss, Label acNo, Button sub)
	{
		this.nom = nom; 
		this.addresss = addresss;
		this.acNo = acNo;
		this.sub = sub;
	}

	public void actionPerformed(ActionEvent act)
	{
		//sub.setEnabled(true);
		String name = nom.getText();
		String address = addresss.getText();
		String erMessage = "";
		error = new Frame("Needs More Info");
		error.setSize(200, 200);
		Button ok = new Button("OK"); 
		Label errorMessage = new Label(erMessage);
		error.add(ok, BorderLayout.SOUTH);
		error.add(errorMessage, BorderLayout.CENTER);
		
		if(name.equals("") && address.equals(""))
		{ 
			erMessage = "Please Fill In the Name and Address Field";
			errorMessage.setText(erMessage);
			error.setVisible(true);
			ok.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent tee)
				{
					error.setVisible(false);
				}
			});}
		
			else if(name.equals(""))
			{ 
				erMessage = "Please Fill In the Name Field";
				errorMessage.setText(erMessage);
				error.setVisible(true);
				ok.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent tee)
					{
						error.setVisible(false);
					}
				});}
		
			else if(address.equals(""))
				{ 
					erMessage = "Please Fill In the Address Field";
					errorMessage.setText(erMessage);
					error.setVisible(true);
					ok.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent tee)
						{
							error.setVisible(false);
						}
					});
					
				
			//sub.setEnabled(false);
		}
		else {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
			stmt = conn.createStatement();	
			
			String createA = "insert into account (Name, Address) values('"+ name + "', '" + address +"')"; 
			stmt.executeUpdate(createA);
			
			System.out.println("Creating Account");
			
			String getAcNo = "select MAX(AcNo) from account";
			
			ResultSet rd = stmt.executeQuery(getAcNo); 
			while(rd.next())
			{
				int num = rd.getInt(1);
				System.out.println("AccountNum: " + num);
				String accountNumber = String.valueOf(num);
				acNo.setText(accountNumber);
			}
			
			
			stmt.close();
			conn.close();
			
			
		}catch(Exception se) {}
	}}
}

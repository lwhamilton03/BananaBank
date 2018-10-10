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

public class CreateAccount implements ActionListener {

	Frame home; 
	
	public CreateAccount(Frame f)
	{
		home = f;
	}
	
	public void actionPerformed(ActionEvent event)
	{
		
		Frame A = new Frame("createAccount");
		A.setVisible(true);
		A.setSize(300, 300);
		home.setVisible(false);
		
		Panel titleHeader = new Panel(); 
		Label title = new Label("CREATE ACCOUNT"); 
		titleHeader.setBackground(Color.PINK);
		titleHeader.setFont(new Font("Head", Font.BOLD, 24));
		titleHeader.add(title);
		A.add(titleHeader, BorderLayout.NORTH);
		
		Panel acc = new Panel();
		GridLayout gri = new GridLayout(3,2);
		acc.setLayout(gri);
		A.add(acc, BorderLayout.CENTER);
		
		Label name = new Label("Name: "); 
		name.setBackground(Color.lightGray);
		acc.add(name);
		
		TextField nom = new TextField();
		nom.setBackground(Color.GRAY);
		acc.add(nom);
		
		Label address = new Label("Address: ");
		address.setBackground(Color.lightGray);
		acc.add(address); 
		
		TextField add = new TextField(); 
		add.setBackground(Color.GRAY);
		acc.add(add); 
		
		Label account = new Label("Account No: "); 
		account.setBackground(Color.lightGray);
		acc.add(account);
		
//		TextField retu = new TextField();
//		retu.setBackground(Color.lightGray);
//		acc.add(retu);
		
		Label retu = new Label();
		retu.setBackground(Color.lightGray);
		acc.add(retu);
		
		Button butt = new Button("SUBMIT");
		butt.setBackground(Color.lightGray);
			
		
		//ADD A PANEL THAT WILL ALLOW A FLOWLAYOUT 
		Panel back = new Panel();
		FlowLayout flow = new FlowLayout();
		back.setLayout(flow);
		A.add(back, BorderLayout.SOUTH);
		back.setBackground(Color.GRAY);
		
		Button backTo = new Button("Return To Home Page"); 
		backTo.setBackground(Color.lightGray);
		
		back.add(butt);
		back.add(backTo);
		
		ReturnButton returnTo = new ReturnButton(home, A);
		backTo.addActionListener(returnTo);
		
	//	A.add(back, BorderLayout.SOUTH);
		
		CreateAccountEvent cree = new CreateAccountEvent(nom, add, retu, butt); 
		butt.addActionListener(cree);
		
		
	}
}

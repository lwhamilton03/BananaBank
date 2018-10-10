import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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
		home.setVisible(false);
		Frame A = new Frame("createAccount");
		A.setVisible(true);
		A.setSize(600, 600);
		
		Panel acc = new Panel();
		GridLayout gri = new GridLayout(3,2);
		acc.setLayout(gri);
		A.add(acc, BorderLayout.CENTER);
		
		Label name = new Label("Name: "); 
		name.setBackground(Color.CYAN);
		acc.add(name);
		
		TextField nom = new TextField();
		nom.setBackground(Color.CYAN);
		acc.add(nom);
		
		Label address = new Label("Address: ");
		address.setBackground(Color.YELLOW);
		acc.add(address); 
		
		TextField add = new TextField(); 
		add.setBackground(Color.YELLOW);
		acc.add(add); 
		
		Label account = new Label("Account No: "); 
		account.setBackground(Color.RED);
		acc.add(account);
		
		TextField retu = new TextField();
		retu.setBackground(Color.RED);
		acc.add(retu);
		
		Button butt = new Button("SUBMIT");
		butt.setBackground(Color.ORANGE);
		A.add(butt, BorderLayout.SOUTH);
		
		CreateAccountEvent cree = new CreateAccountEvent(nom, add, retu, butt); 
		butt.addActionListener(cree);
		
		
	}
}

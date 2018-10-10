import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositPage implements ActionListener {

	Button sub; 
	Frame home; 
	
	public DepositPage(Frame f)
	{
		home = f;
	}
	public void actionPerformed(ActionEvent event)
	{
		Frame A = new Frame("depositAccount");
		A.setVisible(true);
		A.setSize(300, 300);
		home.setVisible(false);
		
		Panel p = new Panel(); 
		FlowLayout flow = new FlowLayout(); 
		p.setBackground(Color.MAGENTA);
		p.setLayout(flow);
		
		
		Label accountN = new Label("Enter AcNo: "); 
		p.add(accountN);
		
		//NEEDS TO CHANGE BY IMPLEMENTING IT ELSE WHERE
		final TextField input = new TextField();
		p.add(input);
		input.setColumns(9);
		
		Button submit = new Button("Submit AcNo");
		p.add(submit);
		
		A.add(p, BorderLayout.NORTH);
		
		Panel acc = new Panel();
		GridLayout gri = new GridLayout(5,2);
		acc.setLayout(gri);
		A.add(acc, BorderLayout.CENTER);
		
		Label name = new Label("Name: "); 
		name.setBackground(Color.CYAN);
		acc.add(name);
		
		final TextField nom = new TextField();
		nom.setBackground(Color.CYAN);
		acc.add(nom);
		
		Label address = new Label("Address: ");
		address.setBackground(Color.YELLOW);
		acc.add(address); 
		
		TextField add = new TextField(); 
		add.setBackground(Color.YELLOW);
		acc.add(add); 
		
		Label account = new Label("Balance: "); 
		account.setBackground(Color.blue);
		acc.add(account);
		
		TextField retu = new TextField();
		retu.setBackground(Color.blue);
		acc.add(retu);
		
		Label ac = new Label("Enter Deposit Amount: "); 
		ac.setBackground(Color.pink);
		acc.add(ac);
		
		TextField re = new TextField();
		re.setBackground(Color.pink);
		acc.add(re);
		
		Button butt = new Button("DEPOSIT");
		butt.setBackground(Color.ORANGE);
		A.add(butt, BorderLayout.SOUTH);
		
		Button backTo = new Button("Return To Home Page"); 
		backTo.setBackground(Color.GREEN);
		acc.add(backTo,  BorderLayout.CENTER);
		
		ReturnButton returnTo = new ReturnButton(home, A);
		backTo.addActionListener(returnTo);
		DepositPageEvent events = new DepositPageEvent(input, nom, add, retu, re, butt);
		submit.addActionListener(events);
	}
	
}

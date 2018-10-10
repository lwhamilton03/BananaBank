import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnButton implements ActionListener{
	
	Frame home;
	Frame second;
	
	public ReturnButton(Frame home, Frame second)
	{
		this.home = home; 
		this.second = second; 
	}
	
	public void actionPerformed(ActionEvent e)
	{
		home.setVisible(true);
		second.setVisible(false);
	}

}

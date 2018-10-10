import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DepositMoney implements ActionListener{
	
	TextField submit;
	
	public DepositMoney(TextField f)
	{
		submit=f;
	}
	
	public void actionPerformed(ActionEvent ok)
	{
		String moneyDeposit = submit.getText();
	}

}

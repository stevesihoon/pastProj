import java.io.Serializable;
public class CreditAccount extends Account implements Serializable{
	private int interRate,specialRate;

	public CreditAccount(String ID, String name, int money, int rate,int special) {
		super(ID, name, money, rate);
		// TODO Auto-generated constructor stub
		interRate=rate;
		specialRate=special;
	}
	public int Get_interRate() {
		return interRate;
	}
	public int Get_specialRate() {
		return specialRate;
	}
	public void Deposit(int money) {
		balance+=money+money*(interRate/100.0)+money*(specialRate/100.0);
	}
	public String[] showAccInfo() {
		String str[]=new String[5];
		str[0]=accID;
		str[1]=cusName;
		str[2]=Data.comma(balance);
		str[3]=Integer.toString(interRate)+"%";
		if(specialRate==7)
			str[4]="A등급";
		else if(specialRate==4)
			str[4]="B등급";
		else
			str[4]="C등급";
		return str;
	}
}

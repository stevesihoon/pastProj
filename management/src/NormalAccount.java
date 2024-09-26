import java.io.Serializable;
public class NormalAccount extends Account implements Serializable{
	private int interRate;

	public NormalAccount(String ID, String name, int money, int rate) {
		super(ID, name, money, rate);
		this.interRate=rate;
		// TODO Auto-generated constructor stub
	}
	public void Deposit(int money) {
		balance+=money+money*(interRate/100.0);
	}
	public String[] showAccInfo() {
		String str[]=new String[4];
		str[0]=accID;
		str[1]=cusName;
		str[2]=Data.comma(balance);
		str[3]=Integer.toString(interRate)+"%";
		return str;
	}
	public int Get_rate() {
		return interRate;
	}
	

}

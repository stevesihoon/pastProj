import java.io.Serializable;
public class Account implements Serializable{
	protected String accID;
	protected int balance;
	protected String cusName;
	protected int rate;
	protected int interRate,specialRate;
	
	public Account(String ID,String name,int money,int rate) {
		this.accID=ID;
		this.balance=money;
		this.cusName=name;
		this.rate=rate;
	}
	public String Get_id() {
		return accID;
	}
	public int Get_balance() {
		return balance;
	}
	public String Get_name() {
		return cusName;
	}
	public void Deposit(int money) {
		balance+=money;
	}
	public int Withdraw(int money) {
		if(balance<money)
			return 0;
		balance-=money;
		return 1;
	}
	public String[] showAccInfo() {
		String str[]=new String[4];
		return str;
	}
	public String[] ShowAccInfo2() {
		String str[]=new String[5];
		str[1]=accID;
		str[2]=cusName;
		str[3]=Data.comma(balance);
		str[4]=Integer.toString(rate)+"%";
		return str;
	}
	public int Get_interRate() {
		return interRate;
	}
	public int Get_specialRate() {
		return specialRate;
	}
	public int Get_rate() {
		return interRate;
	}
	

}

import java.io.Serializable;
public class Customer implements Serializable{
	private int gubun,amount,amountB,basic;
	private String phone,name;
	private double tax,total;
	
	public Customer(int gubun, String phone,String name,int amount) {
		this.gubun=gubun;
		this.phone=phone;
		this.name=name;
		this.amount=amount;
		
		if(gubun==1) basic=6000;
		else if(gubun==2) basic=4800;
		else if(gubun==3) basic=3000;
		amountB=amount*40;
		tax=(basic+amountB)*0.1;
		total=basic+amountB+tax;
	}
	public int getGubun() {
		return gubun;
	}
	public int getAmount() {
		return amount;
	}
	public int getAmountB() {
		return amountB;
	}
	public String getPhone() {
		return phone;
	}
	public String getName() {
		return name;
	}
	
	public int getBasic() {
		return basic;
	}
	public double getTax() {
		return tax;
	}
	public double getTotal() {
		return total;
	}
	public void setGubun(int gubun) {
		this.gubun=gubun;
	}
	public void setAmount(int amount) {
		this.amount=amount;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPhone(String phone) {
		this.phone=phone;
	}

	public String[] Print() {
		String str[]=new String[7];
		str[0]=Integer.toString(gubun);
		str[1]=phone;
		str[2]=name;
		str[3]=Integer.toString(amount);
		str[4]=Integer.toString(basic);
		str[5]=String.valueOf(tax);
		str[6]=String.valueOf(total);
		return str;
	}

}
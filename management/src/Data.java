import java.text.DecimalFormat;
import java.util.Vector;
public class Data {
	public static Vector<Account> vd=new Vector<Account>(10,5);
	public static String comma(int num) {
		DecimalFormat df=new DecimalFormat("#.##");
		return df.format(num);
	}

}

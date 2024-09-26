import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.*;
import javax.swing.JFileChooser;
import java.io.File;

public class Load {
	Scanner scan;
	void load() {
		JFileChooser fs=new JFileChooser(new File("c:\\"));
		fs.setDialogTitle("파일불러오기");
		int result=fs.showOpenDialog(null);
		InputStream in=null;
		BufferedInputStream bin=null;
		ObjectInputStream oin=null;
		if(result==JFileChooser.APPROVE_OPTION) {
			File fi=fs.getSelectedFile();
		try {
			in=new FileInputStream(fi.getPath());
			bin=new BufferedInputStream(in);
			oin=new ObjectInputStream(bin);
			@SuppressWarnings("unchecked")
			Vector<Account> readObject=(Vector<Account>) oin.readObject();
			Data.vd=readObject;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oin.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	}

}

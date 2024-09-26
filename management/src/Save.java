import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.File;
import javax.swing.JFileChooser;
public class Save {
	public void save() {
		JFileChooser fs=new JFileChooser(new File("c:\\"));
		fs.setDialogTitle("파일저장하기");
		int result=fs.showSaveDialog(null);
		OutputStream out=null;
		BufferedOutputStream bout=null;
		ObjectOutputStream oout=null;
		if(result==JFileChooser.APPROVE_OPTION) {
			File fi=fs.getSelectedFile();
		try {
			out=new FileOutputStream(fi.getPath()+".dat");
			bout=new BufferedOutputStream(out);
			oout=new ObjectOutputStream(bout);
			oout.writeObject(Data.vd);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oout.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		}
	}

}

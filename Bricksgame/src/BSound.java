import java.io.File;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
public class BSound {
	public void play(String bgm,boolean Loop) {
		Clip clip;
		AudioInputStream stream;
		File file=new File(bgm);
		AudioFormat format;
		DataLine.Info info;
		try {
			stream=AudioSystem.getAudioInputStream(file);
			format=stream.getFormat();
			info=new DataLine.Info(Clip.class, format);
			clip=(Clip)AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
			if(Loop) clip.loop(-1);
		}catch (Exception e) {}
	}

}

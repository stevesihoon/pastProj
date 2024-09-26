import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class QuizDataDAO extends ArrayList<QuestionDTO>{
	public boolean loadQuiz(String key) {
		String quizDataPath=key;
		try {
			Scanner scn=new Scanner(new FileInputStream(quizDataPath));
			while(scn.hasNext()) {
				QuestionDTO qDTO=new QuestionDTO(scn.nextLine(),scn.nextLine());
				this.add(qDTO);
			}
			Collections.shuffle(this);
			scn.close();
		}catch(FileNotFoundException e) {
			System.out.println("예외 : "+e);
			return false;
		}
		return true;
	}

}

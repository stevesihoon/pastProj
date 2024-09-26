import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ScrollPaneConstants;

public class Edit extends JDialog {
	private QuizDataDAO2 quizData;
	private JTextArea munje1,munje2,munje3;
	String answer[]=new String[5];
	
	public void Print() {
		String str="";
		
		for(int i=0;i<=quizData.size();i++) {
			QuestionDTO qDTO=quizData.get(i);
			String question=qDTO.getQuestion();
			answer[i]=qDTO.getAnswer();
			str+=(i+1)+")"+question+"\n";
		}
		munje1.setText(str);
	}
	public void Print2() {
		String str="";
		
		for(int i=0;i<=quizData.size();i++) {
			QuestionDTO qDTO=quizData.get(i);
			String question=qDTO.getQuestion();
			answer[i]=qDTO.getAnswer();
			str+=(i+1)+")"+question+"\n";
		}
		munje2.setText(str);
	}
	public void Print3() {
		String str="";
		
		for(int i=0;i<=quizData.size();i++) {
			QuestionDTO qDTO=quizData.get(i);
			String question=qDTO.getQuestion();
			answer[i]=qDTO.getAnswer();
			str+=(i+1)+")"+question+"\n";
		}
		munje3.setText(str);
	}
	

	
	public Edit() {
		setBounds(100, 100, 537, 338);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("일반상식문제", null, panel_1, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton btnNewButton = new JButton("문제저장");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		munje1 = new JTextArea();
		
		quizData=new QuizDataDAO2();
		if(quizData.loadQuiz2("quiz1.dat")) {
			Print();
		}
		else
			JOptionPane.showMessageDialog(null, "퀴즈데이터에 오류가 있습니다.");

		
		scrollPane.setViewportView(munje1);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_1_1 = new JPanel();
		tabbedPane.addTab("스포츠상식문제", null, panel_1_1, null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JButton btnNewButton_1 = new JButton("문제저장");
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap())
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnNewButton_1)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		munje2 = new JTextArea();
		quizData=new QuizDataDAO2();
		if(quizData.loadQuiz2("quiz2.dat")) {
			Print2();
		}
		else
			JOptionPane.showMessageDialog(null, "퀴즈데이터에 오류가 있습니다.");
		scrollPane_1.setViewportView(munje2);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JPanel panel_1_2 = new JPanel();
		tabbedPane.addTab("영화상식문제", null, panel_1_2, null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JButton btnNewButton_2 = new JButton("문제저장");
		GroupLayout gl_panel_1_2 = new GroupLayout(panel_1_2);
		gl_panel_1_2.setHorizontalGroup(
			gl_panel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnNewButton_2)
					.addContainerGap())
		);
		gl_panel_1_2.setVerticalGroup(
			gl_panel_1_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_2, Alignment.TRAILING)
						.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		munje3 = new JTextArea();
		
		quizData=new QuizDataDAO2();
		if(quizData.loadQuiz2("quiz3.dat")) {
			Print3();
		}
		else
			JOptionPane.showMessageDialog(null, "퀴즈데이터에 오류가 있습니다.");
		scrollPane_2.setViewportView(munje3);
		panel_1_2.setLayout(gl_panel_1_2);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("퀴즈문제는 문제를 먼저입력하고 다음줄에 답을 입력합니다");
		panel.add(lblNewLabel);

	}
}

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gmovie extends JDialog {
	private JTextField re1;
	private JTextField re2;
	private JTextField re3;
	private JTextField re4;
	private JTextField re5;
	private int result=0;
	private int qTotalOutput;
	private QuizDataDAO quizData;
	String answer[]=new String[5];
	JTextArea munje;

	
	public Gmovie(){
		setModal(true);
		setTitle("영화상식문제퀴즈");
		setBounds(100, 100, 462, 362);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		munje = new JTextArea();
		munje.setLineWrap(true);
		munje.setEditable(false);
		scrollPane.setViewportView(munje);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout=(FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("아래 문제를 보고 답을 적으세요");
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("답안전송");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(re1.getText().equals("")) JOptionPane.showMessageDialog(null, "1번문제 정답을 입력하세요");
				else if(re2.getText().equals("")) JOptionPane.showMessageDialog(null, "2번문제 정답을 입력하세요");
				else if(re3.getText().equals("")) JOptionPane.showMessageDialog(null, "3번문제 정답을 입력하세요");
				else if(re4.getText().equals("")) JOptionPane.showMessageDialog(null, "4번문제 정답을 입력하세요");
				else if(re5.getText().equals("")) JOptionPane.showMessageDialog(null, "5번문제 정답을 입력하세요");
				else
					ShowResult();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("1번문제 정답을 입력하세요 ---->");
		panel_1.add(lblNewLabel_1);
		
		re1 = new JTextField();
		panel_1.add(re1);
		re1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("2번문제 정답을 입력하세요 ---->");
		panel_1.add(lblNewLabel_2);
		
		re2 = new JTextField();
		panel_1.add(re2);
		re2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("3번문제 정답을 입력하세요 ---->");
		panel_1.add(lblNewLabel_3);
		
		re3 = new JTextField();
		panel_1.add(re3);
		re3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("4번문제 정답을 입력하세요 ---->");
		panel_1.add(lblNewLabel_4);
		
		re4 = new JTextField();
		panel_1.add(re4);
		re4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("5번문제 정답을 입력하세요 ---->");
		panel_1.add(lblNewLabel_5);
		
		re5 = new JTextField();
		panel_1.add(re5);
		re5.setColumns(10);
		
		quizData=new QuizDataDAO();
		qTotalOutput=5;
		if(quizData.loadQuiz("quiz3.dat")) {
			StartQuiz();
		}
		else
			JOptionPane.showMessageDialog(null, "퀴즈데이터에 오류가 있습니다.");

	}
	private void StartQuiz() {
		String str="";
		if(qTotalOutput>quizData.size()) qTotalOutput=quizData.size();
		for(int i=0;i<qTotalOutput;i++) {
			QuestionDTO qDTO=quizData.get(i);
			String question=qDTO.getQuestion();
			answer[i]=qDTO.getAnswer();
			str+=(i+1)+")"+question+"\n";
		}
		munje.setText(str);
	}
	private void ShowResult() {
		result=0;
		if(answer[0].equals(re1.getText())) result++;
		if(answer[1].equals(re2.getText())) result++;
		if(answer[2].equals(re3.getText())) result++;
		if(answer[3].equals(re4.getText())) result++;
		if(answer[4].equals(re5.getText())) result++;
		
		String str="";
		str+="==== Mini Quiz Result====\n";
		str+="문제수 : "+qTotalOutput+"\n";
		str+="정답수 : "+result+"\n";
		str+="점 수 : "+result*(100/qTotalOutput)+"\n";
		str+="================================\n";
		JOptionPane.showMessageDialog(null, str,"성적확인",JOptionPane.INFORMATION_MESSAGE);
	}

}
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class Main extends JFrame {

	private JPanel contentPane;
	Game mine;
	public JButton btnNewButton;
	public JLabel b1;
	public JLabel b2;
	public JLabel b3;
	private JLabel lblNewLabel_3;
	public JLabel t3;
	public JLabel t2;
	public JLabel t1;
	private JLabel lblNewLabel_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setResizable(false);
		setTitle("지뢰찾기게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 276, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		mine=new Game(this);
		mine.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		contentPane.add(mine,BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mine.game_ended) {
					mine.Init();
					btnNewButton.setIcon(new ImageIcon("sm1.png"));
				}
			}
		});
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Mine\\boom.png"));
		panel.add(lblNewLabel_3);
		
		b3 = new JLabel("");
		b3.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Mine\\d0.png"));
		panel.add(b3);
		
		b2 = new JLabel("");
		b2.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Mine\\d0.png"));
		panel.add(b2);
		
		b1 = new JLabel("");
		b1.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Mine\\d0.png"));
		panel.add(b1);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Mine\\sm1.png"));
		panel.add(btnNewButton);
		
		t3 = new JLabel("");
		t3.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Mine\\d0.png"));
		panel.add(t3);
		
		t2 = new JLabel("");
		t2.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Mine\\d0.png"));
		panel.add(t2);
		
		t1 = new JLabel("");
		t1.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Mine\\d0.png"));
		panel.add(t1);
		
		lblNewLabel_7 = new JLabel("  ");
		panel.add(lblNewLabel_7);
	}

}

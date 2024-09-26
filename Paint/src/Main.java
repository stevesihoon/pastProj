import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

public class Main extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

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
		setTitle("그림판");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Mypanel panel = new Mypanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		Box verticalBox = Box.createVerticalBox();
		toolBar.add(verticalBox);
		
		JLabel lblNewLabel = new JLabel("면색");
		verticalBox.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser choose=new JColorChooser();
				Color sclor=choose.showDialog(null, "면색선택", getForeground());
				btnNewButton.setBackground(sclor);
				panel.setFc(sclor);
			}
		});
		verticalBox.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		toolBar.add(lblNewLabel_1);
		
		Box verticalBox_1 = Box.createVerticalBox();
		toolBar.add(verticalBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("선색");
		verticalBox_1.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JColorChooser choose=new JColorChooser();
				Color sclor=choose.showDialog(null, "선색선택", getForeground());
				btnNewButton_1.setBackground(sclor);
				panel.setLc(sclor);
			}
		});
		verticalBox_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		toolBar.add(lblNewLabel_3);
		
		Box horizontalBox = Box.createHorizontalBox();
		toolBar.add(horizontalBox);
		
		JButton btnNewButton_2 = new JButton("~");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setDraw(1);
			}
		});
		horizontalBox.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("/");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setDraw(2);
			}
		});
		horizontalBox.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("□");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setDraw(3);
			}
		});
		horizontalBox.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("○");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setDraw(4);
			}
		});
		horizontalBox.add(btnNewButton_5);
		
		JLabel lblNewLabel_4 = new JLabel("        ");
		toolBar.add(lblNewLabel_4);
		
		JButton btnNewButton_6 = new JButton("전체지우기");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.Clear();
			}
		});
		toolBar.add(btnNewButton_6);
		
		JLabel lblNewLabel_5 = new JLabel("         ");
		toolBar.add(lblNewLabel_5);
		
		JCheckBox tcheck = new JCheckBox("투명");
		tcheck.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(tcheck.isSelected()) {
					panel.setTc(true);
				}
				else panel.setTc(false);
			}
		});
		toolBar.add(tcheck);
		
		JLabel lblNewLabel_6 = new JLabel("     선굵기");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		toolBar.add(lblNewLabel_6);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(5, 2, 25, 1));
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				panel.setStroke((float)spinner.getValue());
			}
		});
		toolBar.add(spinner);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		toolBar.add(horizontalBox_1);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("파일");
		menuBar.add(mnNewMenu);
		
		JMenuItem Load = new JMenuItem("불러오기");
		Load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.Load();
			}
		});
		mnNewMenu.add(Load);
		
		JMenuItem Save = new JMenuItem("저장하기");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.Save();
			}
		});
		mnNewMenu.add(Save);
		
	}

}

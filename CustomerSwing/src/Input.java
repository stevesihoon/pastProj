import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Input extends JDialog {
	private JTextField tnum;
	private JTextField tname;
	private JTextField tamount;
	private JSpinner sgubun;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Input dialog = new Input();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Input() {
		setTitle("입력화면");
		setBounds(100, 100, 649, 161);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 4, 0, 0));
		
		JLabel lblNewLabel = new JLabel("구분");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("전화번호");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("이름");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("통화량");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("");
		panel.add(label_1);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel.add(lblNewLabel_5);
		
		JSpinner sgubun = new JSpinner();
		sgubun.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		panel.add(sgubun);
		
		tnum = new JTextField();
		panel.add(tnum);
		tnum.setColumns(10);
		
		tname = new JTextField();
		panel.add(tname);
		tname.setColumns(10);
		
		tamount = new JTextField();
		panel.add(tamount);
		tamount.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gubun=Integer.parseInt(sgubun.getValue().toString());
				String num=tnum.getText().trim();
				String name=tname.getText().trim();
				int amount=Integer.parseInt(tamount.getText().trim());
				
				Data.vd.add(new Customer(gubun,num,name,amount));
				sgubun.setValue(1);
				tnum.setText("");
				tname.setText("");
				tamount.setText("");
				tnum.requestFocus();
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("초기화");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sgubun.setValue(1);
				tnum.setText("");
				tname.setText("");
				tamount.setText("");
				tnum.requestFocus();
			}
		});
		panel_1.add(btnNewButton_1);

	}

}

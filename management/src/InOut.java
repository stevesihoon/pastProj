import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InOut extends JDialog {
	private JTextField tid;
	private JTextField tmoney;
	private JTextField tid2;
	private JTextField tmoney2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InOut dialog = new InOut();
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
	public InOut() {
		setTitle("[[ 입금 / 출금 화면 ]]");
		setBounds(100, 100, 410, 143);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("입금", null, panel, null);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("계좌ID  :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel);
		
		tid = new JTextField();
		panel.add(tid);
		tid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("금   액  :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblNewLabel_1);
		
		tmoney = new JTextField();
		panel.add(tmoney);
		tmoney.setColumns(10);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JButton btnNewButton = new JButton("입금");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=tid.getText().trim();
				int money=Integer.parseInt(tmoney.getText().trim());
				int sw=0;
				for(Account c:Data.vd) {
					if(c.Get_id().equals(id)) {
						c.Deposit(money);
						sw=1;
						break;
					}
				}
				if(sw==0) {
					JOptionPane.showMessageDialog(null, "계좌ID를 확인하세요.");
					tid.setText("");
					tmoney.setText("");
					tid.requestFocus();
				}
				else {
					JOptionPane.showMessageDialog(null, "정상적으로 입력됐습니다.");
					tid.setText("");
					tmoney.setText("");
					tid.requestFocus();
				}
				}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("출금", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("계좌ID  :");
		panel_1.add(lblNewLabel_2);
		
		tid2 = new JTextField();
		panel_1.add(tid2);
		tid2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("금   액  :");
		panel_1.add(lblNewLabel_3);
		
		tmoney2 = new JTextField();
		panel_1.add(tmoney2);
		tmoney2.setColumns(10);
		
		JLabel label_3 = new JLabel("");
		panel_1.add(label_3);
		
		JButton btnNewButton_1 = new JButton("출금");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=tid.getText().trim();
				int money=Integer.parseInt(tmoney.getText().trim());
				int sw=0;
				for(Account c:Data.vd) {
					if(c.Get_id().equals(id)) {
						sw=1;
						if(c.Withdraw(money)==0) {
							JOptionPane.showMessageDialog(null, "잔액부족");
						}
						else JOptionPane.showMessageDialog(null, "출금완료");
						break;
					}
				}
				if(sw==0) {
					JOptionPane.showMessageDialog(null, "계좌ID를 확인하세요.");
					tid2.setText("");
					tmoney2.setText("");
					tid2.requestFocus();
				}
				else {
					
					tid2.setText("");
					tmoney2.setText("");
					tid2.requestFocus();
				}
			}
		});
		panel_1.add(btnNewButton_1);

	}

}

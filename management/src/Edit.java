import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Edit extends JDialog {
	private JTextField ttgubun;
	private JTextField ttid;
	private JTextField ttname;
	private JTextField ttmoney;
	int k=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Edit dialog = new Edit();
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
	public Edit() {
		setTitle("검색 / 수정");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(8, 5, 0, 0));
		
		JLabel lblNewLabel = new JLabel("계좌구분");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		ttgubun = new JTextField();
		panel.add(ttgubun);
		ttgubun.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("계좌 ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		ttid = new JTextField();
		panel.add(ttid);
		ttid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("이  름");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		ttname = new JTextField();
		panel.add(ttname);
		ttname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("금  액");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_5);
		
		ttmoney = new JTextField();
		panel.add(ttmoney);
		ttmoney.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("이  율");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		JSpinner ssrate = new JSpinner();
		ssrate.setModel(new SpinnerNumberModel(1, 0, 100, 1));
		ssrate.setEditor(new JSpinner.NumberEditor(ssrate,"#％"));
		panel.add(ssrate);
		
		JLabel lblNewLabel_4 = new JLabel("신용등급");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		JComboBox ccspecialrate = new JComboBox();
		ccspecialrate.setModel(new DefaultComboBoxModel(new String[] {"A 등급", "B 등급", "C 등급", "N/A"}));
		panel.add(ccspecialrate);
		
		JLabel lblNewLabel_6 = new JLabel("");
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<Data.vd.size();i++) {
					if(Data.vd.get(i).Get_id().equals(ttid.getText())) {
						ttname.setText(Data.vd.get(i).Get_name());
						ttmoney.setText(String.valueOf((Data.vd.get(i).Get_balance())));
						ssrate.setValue(Data.vd.get(i).Get_rate());
						
						for(Account c:Data.vd)
							if(c instanceof NormalAccount) {
								
								ttgubun.setText("보통계좌");
								k=3;
							}
							else if(c instanceof CreditAccount) {
								ttgubun.setText("신용계좌");
								if((Data.vd.get(i).Get_specialRate())==7) {
									k=0;
								}
								else if((Data.vd.get(i).Get_specialRate())==4) {
									k=1;
								}
								else
									k=2;
								
							}
							ccspecialrate.setSelectedIndex(k);
						//pos=i;
						return;
						
					}
				}
				JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
				
				ttid.requestFocus();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("수정");
		panel.add(btnNewButton_1);

	}

}

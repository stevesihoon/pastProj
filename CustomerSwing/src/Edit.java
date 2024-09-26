import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Edit extends JDialog {
	private JTextField tsearch;
	private JTextField ttnum;
	private JTextField ttname;
	private JTextField ttamount;
	int pos=0;

	public Edit() {
		setTitle("검색/수정/삭제");
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("구분");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		JSpinner ssgubun = new JSpinner();
		ssgubun.setModel(new SpinnerNumberModel(1, 1, 3, 1));
		panel.add(ssgubun);
		
		JLabel lblNewLabel_2 = new JLabel("전화번호");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_2);
		
		ttnum = new JTextField();
		panel.add(ttnum);
		ttnum.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("이름");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		ttname = new JTextField();
		panel.add(ttname);
		ttname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("통화량");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_4);
		
		ttamount = new JTextField();
		panel.add(ttamount);
		ttamount.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("검색하실 전화번호를 입력하세요");
		panel_1.add(lblNewLabel);
		
		tsearch = new JTextField();
		panel_1.add(tsearch);
		tsearch.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("검색");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0;i<Data.vd.size();i++) {
					if(Data.vd.get(i).getPhone().equals(tsearch.getText())) {
						ttnum.setText(Data.vd.get(i).getPhone());
						ttname.setText(Data.vd.get(i).getName());
						ttamount.setText(String.valueOf((Data.vd.get(i).getAmount())));
						ssgubun.setValue(Data.vd.get(i).getGubun());
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "데이터가 없습니다.");
				
				tsearch.requestFocus();
				tsearch.setText("");
			
			}
		});
		panel_1.add(btnNewButton_2);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("수정");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data.vd.get(pos).setName(ttname.getText().trim());
				Data.vd.get(pos).setPhone(ttnum.getText().trim());
				Data.vd.get(pos).setAmount(Integer.getInteger(ttamount.getText().trim()));
				Data.vd.get(pos).setGubun((int) ssgubun.getValue());
				JOptionPane.showMessageDialog(null, "수정되었습니다.");
				ttnum.setText("");
				ttname.requestFocus();
				ttname.setText("");
				ssgubun.setValue(1);
				ttamount.setText("");
			}
		});
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("삭제");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Data.vd.remove(pos);
				JOptionPane.showMessageDialog(null, "전화번호가 삭제되었습니다.");
				ttnum.setText("");
				ttname.requestFocus();
				ttname.setText("");
				ssgubun.setValue(1);
				ttamount.setText("");
			}
		});
		panel_2.add(btnNewButton_1);

	}

}

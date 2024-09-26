import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Input extends JDialog {
	private JTextField tid;
	private JTextField tname;
	private JTextField tmoney;
	private JTextField tid2;
	private JTextField tname2;
	private JTextField tmoney2;
	private JComboBox crate;

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
		setTitle("[[ 계좌개설 ]]");
		setBounds(100, 100, 450, 300);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("보통예금계좌개설", null, panel, null);
		panel.setLayout(new GridLayout(5, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("계좌ID");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		tid = new JTextField();
		panel.add(tid);
		tid.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1 = new JLabel("이  름");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		
		tname = new JTextField();
		panel.add(tname);
		tname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("금  액");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_3);
		
		tmoney = new JTextField();
		panel.add(tmoney);
		tmoney.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("");
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("이  율");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_6);
		
		JSpinner srate = new JSpinner();
		srate.setModel(new SpinnerNumberModel(1, 0, 100, 1));
		srate.setEditor(new JSpinner.NumberEditor(srate,"#％"));
		panel.add(srate);
		
		JLabel lblNewLabel_7 = new JLabel("");
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		panel.add(lblNewLabel_9);
		
		JButton btnNewButton = new JButton("계좌개설");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=tid.getText().trim();
				String name=tname.getText().trim();
				int money=Integer.parseInt(tmoney.getText().trim());
				int rate=Integer.parseInt(srate.getValue().toString());
				System.out.print(rate);
				Data.vd.add(new NormalAccount(id,name,money,rate));
				tid.setText("");
				tname.setText("");
				tmoney.setText("");
				srate.setValue(1);
				tid.requestFocus();
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("신용예금계좌개설", null, panel_1, null);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel10 = new JLabel("계좌ID");
		lblNewLabel10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel10);
		
		tid2 = new JTextField();
		panel_1.add(tid2);
		tid2.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		panel_1.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("이  름");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_12);
		
		tname2 = new JTextField();
		panel_1.add(tname2);
		tname2.setColumns(10);
		
		JLabel lblNewLabel_13 = new JLabel("");
		panel_1.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("금  액");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_14);
		
		tmoney2 = new JTextField();
		panel_1.add(tmoney2);
		tmoney2.setColumns(10);
		
		JLabel lblNewLabel_15 = new JLabel("");
		panel_1.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("이  율");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_16);
		
		JSpinner srate2 = new JSpinner();
		srate2.setModel(new SpinnerNumberModel(1, 0, 100, 1));
		srate2.setEditor(new JSpinner.NumberEditor(srate2,"#％"));
		panel_1.add(srate2);
		
		JLabel lblNewLabel_17 = new JLabel("");
		panel_1.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("신용등급");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_18);
		
		crate = new JComboBox();
		crate.setModel(new DefaultComboBoxModel(new String[] {"A등급", "B등급", "C등급"}));
		panel_1.add(crate);
		
		JButton btnNewButton_20 = new JButton("계좌개설");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=tid2.getText().trim();
				String name=tname2.getText().trim();
				int money=Integer.parseInt(tmoney2.getText().trim());
				int rate=Integer.parseInt(srate2.getValue().toString());
				int cr;
				if(crate.getSelectedItem().toString()=="A등급")
					cr=7;
				else if(crate.getSelectedItem().toString()=="B등급")
					cr=4;
				else
					cr=2;
				System.out.print(cr);
				Data.vd.add(new CreditAccount(id,name,money,rate,cr));
				tid2.setText("");
				tname2.setText("");
				tmoney2.setText("");
				srate2.setValue(1);
				crate.setSelectedIndex(0);
				tid2.requestFocus();
			}
		});
		panel_1.add(btnNewButton_20);
		
		

	}

}

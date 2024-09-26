import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Output extends JDialog {
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private DefaultTableModel model,model_1,model_2;

	public Output() {
		setModal(true);
		setTitle("[[ 계좌정보출력/수정/삭제 ]]");
		setBounds(100, 100, 450, 300);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("모든계좌출력", null, scrollPane, null);
		
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\uACC4\uC88C\uAD6C\uBD84", "\uACC4\uC88CID", "\uC774\uB984", "\uC794\uC561", "\uC774\uC728"
				}
			);
		
		table = new JTable(model);
		DefaultTableCellRenderer celAlignCenter=new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0;i<5;i++)
			table.getColumnModel().getColumn(i).setCellRenderer(celAlignCenter);
		String str[]=new String[5];
		for(Account c:Data.vd) {
			if(c instanceof NormalAccount) {
				str=c.ShowAccInfo2();
				str[0]="보통계좌";
				model.addRow(str);
			}
			if(c instanceof CreditAccount) {
				str=c.ShowAccInfo2();
				str[0]="신용계좌";
				model.addRow(str);
			
			}
		}
		
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("보통계좌출력", null, scrollPane_1, null);
		
		model_1=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uACC4\uC88CID", "\uC774\uB984", "\uAE08\uC561", "\uC774\uC728"
			}
		);
		table_1 = new JTable(model_1);
		for(int i=0;i<4;i++)
			table_1.getColumnModel().getColumn(i).setCellRenderer(celAlignCenter);
		for(Account c:Data.vd) {
			if(c instanceof NormalAccount) {
				model_1.addRow(c.showAccInfo());
			}
		}
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		tabbedPane.addTab("신용계좌출력", null, scrollPane_2, null);
		
		
		model_2=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uACC4\uC88CID", "\uC774\uB984", "\uAE08\uC561", "\uC774\uC728", "\uC2E0\uC6A9\uB4F1\uAE09"
			}
		);
		table_2 = new JTable(model_2);
		for(int i=0;i<5;i++)
			table_2.getColumnModel().getColumn(i).setCellRenderer(celAlignCenter);
		
		for(Account c:Data.vd) {
			if(c instanceof CreditAccount) {
				model_2.addRow(c.showAccInfo());
			}
		}
		scrollPane_2.setViewportView(table_2);

	}

}

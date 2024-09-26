import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Output extends JDialog {
	private JTable table;
	private DefaultTableModel model;

	
	public Output() {
		setTitle("전화요금명세서");
		setBounds(100, 100, 605, 305);
		
		model=new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"\uAD6C\uBD84", "\uC804\uD654\uBC88\uD638", "\uC774\uB984", "\uAE30\uBCF8\uC694\uAE08", "\uD1B5\uD654\uB8CC", "\uC138\uAE08", "\uD569\uACC4"
				}
			);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(model);
		DefaultTableCellRenderer celAlignCenter=new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0;i<5;i++)
			table.getColumnModel().getColumn(i).setCellRenderer(celAlignCenter);
		String str[]=new String[5];
		for(Customer c:Data.vd) {
				str=c.Print();
				model.addRow(str);
			
			
		}
		
		scrollPane.setViewportView(table);

	}

}

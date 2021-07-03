
import java.lang.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.sql.*;

class ViewDeletedProduct extends JFrame implements ActionListener {

     JTable table;
	private JFrame activity;
	JButton buttonLogout,buttonBack;
	Employee employee;
	private JPanel panel;
	private JScrollPane frame;
	private JLabel title, header, keywordLabel;
	private String[] columnNames = {"productId", "productName", "price", "quantity"};

public ViewDeletedProduct(ViewProductActivity prev, Employee employee){
	super("Purchase History");
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.activity = prev;
		this.employee=employee;
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);

		title = new JLabel("Deleted Products");
		title.setBounds(30, 40, 400,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);

		buttonBack = new JButton("Back");
		buttonBack.setBounds(Theme.GUI_WIDTH-140, 80, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonBack.setFont(Theme.FONT_BUTTON);
		buttonBack.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonBack.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonBack.addActionListener(this);
		panel.add(buttonBack);

		table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		System.out.println(model);
		table.setModel(model);
		model=employee.viewDeletedProduct();
		frame = new JScrollPane(table);
		frame.setBounds(40,185,600,300);
		table.setModel(model);
		panel.add(frame);
		


		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		this.add(panel);
	
}
	public void actionPerformed(ActionEvent ae) {
	if (ae.getSource().equals(buttonBack)) {
			this.setVisible(false);
			activity.setVisible(true);
		}

}
}
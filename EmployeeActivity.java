
import java.lang.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;


public class EmployeeActivity extends JFrame implements ActionListener {
	private JPanel panel;
	private Employee employee;
	private JButton buttonLogout,buttonViewCustomer, buttonProfile, buttonViewProduct;
	private JButton buttonAddProduct, buttonViewEmployee;
	private JLabel title, header;
	public EmployeeActivity(String userId) {
		super("Dashboard - Employee");
		
		this.setSize(Theme.GUI_WIDTH, Theme.GUI_HEIGHT);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		employee = new Employee(userId);
		employee.fetch();
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Theme.BACKGROUND_PANEL);
		
		title = new JLabel("Welcome, "+userId);
		title.setBounds(30, 40, userId.length()*30+220,75);
		title.setOpaque(true);
		title.setBorder(new EmptyBorder(0,20,0,0));
		title.setFont(Theme.FONT_TITLE);
		title.setForeground(Theme.COLOR_TITLE);
		panel.add(title);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(Theme.GUI_WIDTH-140, 505, Theme.BUTTON_PRIMARY_WIDTH,30);
		buttonLogout.setFont(Theme.FONT_BUTTON);
		buttonLogout.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonLogout.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonLogout.addActionListener(this);
		panel.add(buttonLogout);
		
		buttonProfile = new JButton("My Profile");
		buttonProfile.setBounds(Theme.GUI_WIDTH-150, 80, 120,30);
		buttonProfile.setFont(Theme.FONT_BUTTON);
		buttonProfile.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonProfile.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonProfile.addActionListener(this);
		panel.add(buttonProfile);
		
		buttonViewProduct = new JButton("View Product");
		buttonViewProduct.setBounds(200, 160, 200, 30);
		buttonViewProduct.setFont(Theme.FONT_BUTTON);
		buttonViewProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewProduct.addActionListener(this);
		panel.add(buttonViewProduct);
		
		buttonAddProduct = new JButton("Add Product");
		buttonAddProduct.setBounds(200, 210, 200, 30);
		buttonAddProduct.setFont(Theme.FONT_BUTTON);
		buttonAddProduct.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonAddProduct.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonAddProduct.addActionListener(this);
		panel.add(buttonAddProduct);

		buttonViewCustomer = new JButton("Purchase History");
		buttonViewCustomer.setBounds(200, 260, 200, 30);
		buttonViewCustomer.setFont(Theme.FONT_BUTTON);
		buttonViewCustomer.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
		buttonViewCustomer.setForeground(Theme.COLOR_BUTTON_PRIMARY);
		buttonViewCustomer.addActionListener(this);
		panel.add(buttonViewCustomer);
		
		if (employee.getRole().equals("Manager")) {
			buttonViewEmployee = new JButton("View Employee");
			buttonViewEmployee.setBounds(200, 310, 200, 30);
			buttonViewEmployee.setFont(Theme.FONT_BUTTON);
			buttonViewEmployee.setBackground(Theme.BACKGROUND_BUTTON_PRIMARY);
			buttonViewEmployee.setForeground(Theme.COLOR_BUTTON_PRIMARY);
			buttonViewEmployee.addActionListener(this);
			panel.add(buttonViewEmployee);
		}
		
		header = new JLabel();
		header.setBackground(Theme.BACKGROUND_HEADER);
		header.setOpaque(true);
		header.setBounds(0, 0, Theme.GUI_WIDTH, 75);
		panel.add(header);
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource().equals(buttonProfile)) {
			this.setVisible(false);
			new MyProfileActivity(this, employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonLogout)) {
			this.setVisible(false);
			new LoginActivity().setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewProduct)) {
			this.setVisible(false);
			new ViewProductActivity(this, employee).setVisible(true);
		}
		
		else if (ae.getSource().equals(buttonAddProduct)) {
			this.setVisible(false);
			new AddProductActivity(new ViewProductActivity(this, employee), employee).setVisible(true);
		}
		else if (ae.getSource().equals(buttonViewCustomer)) {
			this.setVisible(false);
			new ViewPurchasehistory(this, employee).setVisible(true);
		}
		
		else if (ae.getSource().equals(buttonViewEmployee)) {
			this.setVisible(false);
			new ViewEmployeeActivity(this, employee).setVisible(true);
		}
		else {}
	}
}




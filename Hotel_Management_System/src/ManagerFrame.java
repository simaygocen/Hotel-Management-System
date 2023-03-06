import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.AbstractListModel;
import javax.swing.JSlider;
import javax.swing.JComboBox;

public class ManagerFrame extends JFrame {

	private JPanel contentPane;	
	private JTextField id_e;
	private JTextField name_e;
	private JTextField surname_e;
	private JTextField salary_e;
	private JTable employee_table;
	private DefaultTableModel model_Employee;	
	private List<Employee> employees;
	private Boolean flag;
	
    

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerFrame frame = new ManagerFrame();
					//txt
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ManagerFrame() throws FileNotFoundException {
		flag = false;
		Employee.addEmployeeToList();
		employees = Employee.getEmployees();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 70, 1180, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 20, 1151, 662);
		contentPane.add(tabbedPane);		
		JPanel panel = new JPanel();
		tabbedPane.addTab("EMPLOYEE", null, panel, null);
		panel.setLayout(null);		
		JLabel EmployeeName = new JLabel("NAME");
		EmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmployeeName.setBounds(10, 139, 137, 43);
		panel.add(EmployeeName);		
		JLabel EmployeeId = new JLabel("ID");
		EmployeeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmployeeId.setBounds(10, 88, 137, 32);
		panel.add(EmployeeId);		
		JLabel EmployeeSurname = new JLabel("SURNAME");
		EmployeeSurname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmployeeSurname.setBounds(10, 208, 137, 24);
		panel.add(EmployeeSurname);		
		JLabel EmployeeSalary = new JLabel("SALARY");
		EmployeeSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmployeeSalary.setBounds(10, 314, 75, 24);
		panel.add(EmployeeSalary);		
		String[] STATU = {"Receptionist","Chef","HouseKeeper","Waiter"};
		final JComboBox statu_e = new JComboBox(STATU);		
		statu_e.setBounds(132, 262, 156, 28);
		panel.add(statu_e);		
		JLabel EmployeeStatu = new JLabel("STATU");
		EmployeeStatu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		EmployeeStatu.setBounds(10, 258, 75, 32);
		panel.add(EmployeeStatu);
		
		id_e = new JTextField();
		id_e.setBounds(132, 91, 156, 32);
		panel.add(id_e);
		id_e.setColumns(10);
		
		name_e = new JTextField();
		name_e.setColumns(10);
		name_e.setBounds(132, 147, 156, 32);
		panel.add(name_e);
		
		surname_e = new JTextField();
		surname_e.setColumns(10);
		surname_e.setBounds(132, 207, 156, 32);
		panel.add(surname_e);
		
		salary_e = new JTextField();
		salary_e.setColumns(10);
		salary_e.setBounds(132, 313, 156, 32);
		panel.add(salary_e);
		
		JScrollPane scrollPane_e = new JScrollPane();
		scrollPane_e.setBounds(546, 35, 567, 545);
		panel.add(scrollPane_e);
		
		employee_table = new JTable();
		model_Employee = new DefaultTableModel();
		Object[] column = {"ID","Name","Surname","Statu","Salary"};
		final Object[] row = new Object[50];
		model_Employee.setColumnIdentifiers(column);
		employee_table.setModel(model_Employee);
		scrollPane_e.setViewportView(employee_table);
		
		int count = 0;
		while(count != employees.size()) {
			row[0] = employees.get(count).getId();
			row[1] = employees.get(count).getName();
			row[2] = employees.get(count).getSurname();
			row[3] = employees.get(count).getStatu();
			row[4] = employees.get(count).getSalary();
			model_Employee.addRow(row);
			count++;
		}				
    	JButton add_Button_e = new JButton("ADD");
		add_Button_e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//name_e.getText(),surname_e.getText(), id_e.getText(),Integer.valueOf(salary_e.getText()),statu_e.getSelectedItem().toString()
				if(!(name_e.getText().equals("") && surname_e.getText().equals("") && id_e.getText().equals("") && salary_e.getText().equals("") ))	{			
					row[0] = id_e.getText();
					row[1] = name_e.getText();
					row[2] = surname_e.getText();
					row[3] = statu_e.getSelectedItem();
					row[4] = salary_e.getText();
					model_Employee.addRow(row);
					Employee emp;
					try {
						emp = new Employee(name_e.getText(),surname_e.getText(), id_e.getText(),Integer.valueOf(salary_e.getText()),statu_e.getSelectedItem().toString());
						employees.add(emp);					
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					id_e.setText("");
					name_e.setText("");
					surname_e.setText("");
					salary_e.setText("");
					try {
						Employee.writeTxt(employees);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					  JOptionPane.showMessageDialog(null, "All fields are required!");
				}

			}
			
		});
		add_Button_e.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add_Button_e.setBounds(29, 420, 93, 32);
		panel.add(add_Button_e);
		
		JButton modify_e = new JButton("MODIFY");
		employee_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		modify_e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(employee_table.getSelectedRow() != -1) {	
					int selectedRow=employee_table.getSelectedRow();
					   employees.get(selectedRow).setSalary(Integer.valueOf(salary_e.getText()));
		              
				}
				
				for(int i=employee_table.getRowCount()-1; i>=0; i--) {
					model_Employee.removeRow(i);}
				
				try {
					Employee.writeTxt(employees);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int count2 = 0;
				while(count2 != employees.size()) {
					row[0] = employees.get(count2).getId();
					row[1] = employees.get(count2).getName();
					row[2] = employees.get(count2).getSurname();
					row[3] = employees.get(count2).getStatu();
					row[4] = employees.get(count2).getSalary();
					model_Employee.addRow(row);
					count2++;
				}
				
			}
		});
		modify_e.setFont(new Font("Tahoma", Font.PLAIN, 15));
		modify_e.setBounds(141, 420, 93, 32);
		panel.add(modify_e);

		
		JButton delete_e = new JButton("DELETE");
		employee_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		delete_e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   if(employee_table.getSelectedRow() != -1) {	
					   int selectedRow=employee_table.getSelectedRow();
					   model_Employee.removeRow(selectedRow);
		               employees.remove(selectedRow);
		               JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		             
		               try {
		       			Employee.writeTxt(employees);
		       		} catch (IOException e1) {
		       			// TODO Auto-generated catch block
		       			e1.printStackTrace();
		       		}
		       }
				 
			}
			
		});

		
		
		
		delete_e.setFont(new Font("Tahoma", Font.PLAIN, 15));
		delete_e.setBounds(256, 420, 93, 32);
		panel.add(delete_e);
		
		JButton search_e = new JButton("SEARCH");
		
		search_e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < employees.size(); i++) {
					if(id_e.getText().equals(employees.get(i).getId())) {
						for(int j=model_Employee.getRowCount()-1; j>=0; j--) {
							model_Employee.removeRow(j);
						}
						row[0] = employees.get(i).getId();
						row[1] = employees.get(i).getName();
						row[2] = employees.get(i).getSurname();
						row[3] = employees.get(i).getStatu();
						row[4] = employees.get(i).getSalary();
						model_Employee.addRow(row);
						flag = true;
						break;
					}
					
				}
				if(!flag) {
					 JOptionPane.showMessageDialog(null, "There is no employee with this id number!");
				}
			}
		});
		search_e.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search_e.setBounds(381, 420, 93, 32);
		panel.add(search_e);
		
		JLabel employeeManagement = new JLabel("Employee Management");
		employeeManagement.setFont(new Font("Tahoma", Font.PLAIN, 20));
		employeeManagement.setBounds(10, 35, 309, 24);
		panel.add(employeeManagement);
		
		JButton btnNewButton = new JButton("CleanList");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count2 = 0;
				for(int i=model_Employee.getRowCount()-1; i>=0; i--) {
					model_Employee.removeRow(i);}
				
				while(count2 != employees.size()) {
					row[0] = employees.get(count2).getId();
					row[1] = employees.get(count2).getName();
					row[2] = employees.get(count2).getSurname();
					row[3] = employees.get(count2).getStatu();
					row[4] = employees.get(count2).getSalary();
					model_Employee.addRow(row);
					count2++;
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(545, 590, 85, 21);
		panel.add(btnNewButton);
		
	

		
		
		
	}
	
}

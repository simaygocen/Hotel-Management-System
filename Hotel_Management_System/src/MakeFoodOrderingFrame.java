

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Font;
import java.awt.*;  
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;  

public class MakeFoodOrderingFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private ArrayList<Food> FoodList = new ArrayList<Food>();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MakeFoodOrderingFrame frame = new MakeFoodOrderingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public MakeFoodOrderingFrame() {
		setBounds(350, 250, 726, 401);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("RoomNumber");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(50, 84, 88, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(50, 122, 88, 13);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 10, 156, 320);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Hamburger"},
				{"Finger Chicken"},
				{"Finger Grilled"},
				{"Rice Bowl"},
				{"Pizza"},
				{"French Fries"},
				{"BBQ Beef"},
				{"Beef Grilled"},
				{"Beef Meat Steak"},
				{"Antipasto Salad"},
				{"Caesar Salad"},
				{"Crispy Salad"},
				{"Orange Juice"},
				{"Lemonade"},
				{"Pineapple Juice"},
				{"Oatmeal"},
				{"Eggs"},
				{"Cottage Cheese"},
				{"Eggless Truffle Cake"},
				{"San Sebastian Cheese Cake"},
			},
			new String[] {
				"MENU"
			}
		));
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_1.setBounds(196, 81, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		textField_2.setBounds(196, 119, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnNewButton = new JButton("ORDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag = false;
				Food food=new Food(Integer.valueOf(textField_1.getText()),textField_2.getText());
				try {
					Scanner sc= new Scanner(new File("Booking.txt"));
					while(sc.hasNext()) {
						String line=sc.nextLine();
						String[] words= line.split(",");
						if(words[11].equals(textField_1.getText())) {
							try {
								food.addFoodOrdering(food);
								flag = true;
								JOptionPane.showMessageDialog(null,"Confirmed!");
								break;
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					if(flag==false) {
				    	JOptionPane.showMessageDialog(null,"There Is No Customer With This Room Number!");
				    }
					
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(143, 193, 85, 21);
		contentPane.add(btnNewButton);
		
		final ListSelectionModel model= table.getSelectionModel();
		
		model.addListSelectionListener(new ListSelectionListener() {

			
			int total = 0;
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				if(!model.isSelectionEmpty()) {
					int selectedRow=model.getMinSelectionIndex();
					try {
						Scanner scan = new Scanner(new File("Menu.txt"));
						while(scan.hasNext()){
							String name_price =  scan.nextLine();
							String[] split =name_price.split(",");
							Food food = new Food(split[0],split[1]);
							FoodList.add(food);
							
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}		

					switch(selectedRow) {
						case 0:
							textField_2.setText(String.valueOf(FoodList.get(0).getPrice()));
							break;
						case 1:
							textField_2.setText(String.valueOf(FoodList.get(1).getPrice()));
							break;
						case 2:
							textField_2.setText(String.valueOf(FoodList.get(2).getPrice()));
							break;
						case 3:
							textField_2.setText(String.valueOf(FoodList.get(3).getPrice()));
							break;
						case 4:
							textField_2.setText(String.valueOf(FoodList.get(4).getPrice()));
							break;
						case 5:
							textField_2.setText(String.valueOf(FoodList.get(5).getPrice()));
							break;
						case 6:
							textField_2.setText(String.valueOf(FoodList.get(6).getPrice()));
							break;
						case 7:
							textField_2.setText(String.valueOf(FoodList.get(7).getPrice()));
							break;
						case 8:
							textField_2.setText(String.valueOf(FoodList.get(8).getPrice()));
							break;
						case 9:
							textField_2.setText(String.valueOf(FoodList.get(9).getPrice()));
							break;
						case 10:
							textField_2.setText(String.valueOf(FoodList.get(10).getPrice()));
							break;
						case 11:
							textField_2.setText(String.valueOf(FoodList.get(11).getPrice()));
					     	break;
						case 12:
							textField_2.setText(String.valueOf(FoodList.get(12).getPrice()));
							break;
						case 13:
							textField_2.setText(String.valueOf(FoodList.get(13).getPrice()));
							break;
						case 14:
							textField_2.setText(String.valueOf(FoodList.get(14).getPrice()));
							break;
						case 15:
							textField_2.setText(String.valueOf(FoodList.get(15).getPrice()));
							break;
						case 16:
							textField_2.setText(String.valueOf(FoodList.get(16).getPrice()));
							break;
						case 17:
							textField_2.setText(String.valueOf(FoodList.get(17).getPrice()));
							break;
						case 18:
							textField_2.setText(String.valueOf(FoodList.get(18).getPrice()));
							break;
						case 19:
							textField_2.setText(String.valueOf(FoodList.get(19).getPrice()));
							break;
						case 20:
						    textField_2.setText(String.valueOf(FoodList.get(20).getPrice()));
							break;
						default:
						
					}
					
					
					
					
				}

				
			}
			
		});
	 
		
		
	}
}

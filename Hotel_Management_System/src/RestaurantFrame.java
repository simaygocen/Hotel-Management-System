import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RestaurantFrame extends JFrame {

	private JPanel contentPane;
	private JTextField roomNum;
	private JTextField date;
	private JTextField price;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestaurantFrame frame = new RestaurantFrame();					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RestaurantFrame() {
		
		setBounds(350, 250, 726, 401);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel RoomNumber = new JLabel("Room Number");
		RoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RoomNumber.setBounds(10, 42, 103, 29);
		contentPane.add(RoomNumber);
		
		JLabel lblDate = new JLabel("DATE");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(10, 96, 76, 29);
		contentPane.add(lblDate);
		
		JLabel lblRestaurantType = new JLabel("Alacarte");
		lblRestaurantType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRestaurantType.setBounds(10, 148, 134, 29);
		contentPane.add(lblRestaurantType);
		
		String[] restaurantType = {"Fish","Italian","China"};
		final JComboBox alacarte = new JComboBox(restaurantType);
		final JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(RestaurantFrame.class.getResource("/images/3p.jpg")));					
		
		alacarte.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String[] split = date.getText().split("/");
				if(split.length == 3) {
					Date date = new Date(split[0],split[1],split[2]);
					
					if(alacarte.getSelectedItem().equals("Fish")) {				
						lblNewLabel_1.setIcon(new ImageIcon(RestaurantFrame.class.getResource("/images/3p.jpg")));	
						if(split[0] != null && split[1]!= null && split[2] != null) {
							price.setText("200");
						}
						else 
							JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
					}
					else if(alacarte.getSelectedItem().equals("Italian")) {
						lblNewLabel_1.setIcon(new ImageIcon(RestaurantFrame.class.getResource("/images/1p.jpg")));	
						if(split[0] != null && split[1]!= null && split[2] != null) {
							price.setText("150");
						}
						else 
							JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
					}
					else {
						lblNewLabel_1.setIcon(new ImageIcon(RestaurantFrame.class.getResource("/images/2p.jpg")));	
						if(split[0] != null && split[1]!= null && split[2] != null) {
							price.setText("175");
						}
						else 
							JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
					}
					
				}
				
			}
			
		});
		lblNewLabel_1.setBounds(300, 0, 412, 364);
		contentPane.add(lblNewLabel_1);
		alacarte.setBounds(121, 150, 115, 29);
		contentPane.add(alacarte);
		
		roomNum = new JTextField();
		roomNum.setBounds(121, 48, 115, 22);
		contentPane.add(roomNum);
		roomNum.setColumns(10);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(121, 102, 115, 22);
		contentPane.add(date);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(121, 208, 115, 22);
		contentPane.add(price);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrice.setBounds(10, 202, 103, 29);
		contentPane.add(lblPrice);
		

		JButton Confirm = new JButton("Confirm");
		
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Boolean flag = false;
				RestaurantBooking restaurantBooking=new RestaurantBooking(roomNum.getText(),date.getText(),alacarte.getSelectedItem().toString(),price.getText());
				Scanner sc;
				
				try {
					sc = new Scanner(new File("C:\\Users\\MONSTER\\Desktop\\Booking.txt"));
					while(sc.hasNext()) {
					    String line=sc.nextLine();
					    String[] words=line.split(",");
					    if(words[11].equals(roomNum.getText())) {
					    	try {
								restaurantBooking.addBooking(restaurantBooking);
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
		Confirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Confirm.setBounds(121, 273, 109, 21);
		contentPane.add(Confirm);
		
		
		
	
	}

}

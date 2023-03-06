

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;

public class BookingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField surname;
	private JTextField email;
	private JTextField id;
	private JTextField RoomNum;
	private JTextField price;
	private JTextField checkin;
	private JTextField checkout;
	private JTextField phone;
	private FileWriter BookingTxt; 
	private static List<Booking> bookings;
	private static List<Room> rooms;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingFrame frame = new BookingFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public BookingFrame() throws FileNotFoundException {
		Booking.addToList();
		bookings = Booking.getBookings();
		Room.addRoomToList();
		rooms=Room.getRooms();
		setBounds(350, 250, 789, 488);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(29, 21, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Surname");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(29, 55, 77, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(29, 90, 70, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID Proof");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(29, 124, 83, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Check Out Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(29, 235, 120, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Check In Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(26, 192, 107, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile Phone");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(376, 21, 120, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel RoomNumber = new JLabel("Room Number");
		RoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RoomNumber.setBounds(376, 55, 146, 13);
		contentPane.add(RoomNumber);
		
		JLabel lblNewLabel_9 = new JLabel("Room Type");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(376, 121, 120, 19);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Price");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(375, 90, 77, 13);
		contentPane.add(lblNewLabel_10);
		
		Name = new JTextField();
		Name.setBounds(193, 20, 96, 19);
		contentPane.add(Name);
		Name.setColumns(10);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(193, 54, 96, 19);
		contentPane.add(surname);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(193, 89, 96, 19);
		contentPane.add(email);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(193, 123, 96, 19);
		contentPane.add(id);
		
		RoomNum = new JTextField();
		RoomNum.setEditable(false);
		RoomNum.setColumns(10);
		RoomNum.setBounds(536, 54, 96, 19);
		contentPane.add(RoomNum);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(536, 89, 96, 19);
		contentPane.add(price);
		
		checkin = new JTextField();
		checkin.setColumns(10);
		checkin.setBounds(193, 197, 96, 19);
		contentPane.add(checkin);
		
		checkout = new JTextField();
		checkout.setColumns(10);
		checkout.setBounds(193, 234, 96, 19);
		contentPane.add(checkout);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(536, 20, 96, 19);
		contentPane.add(phone);
		
		final JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon(BookingFrame.class.getResource("/images/singleroom.jpg")));
		lblNewLabel_11.setBounds(371, 217, 394, 234);
		contentPane.add(lblNewLabel_11);
		
		String[] roomType={"Single","Double","Suite","Deluxe"};
		final JComboBox comboBox = new JComboBox(roomType);
		comboBox.setBounds(536, 122, 96, 21);
		contentPane.add(comboBox);
		
		
		JButton Confirm = new JButton("Confirm");
		Confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Name.getText().equals("") || surname.getText().equals("") || email.getText().equals("") || id.getText().equals("") || phone.getText().equals("") || checkin.getText().equals("") 
						||checkout.getText().equals("") || RoomNum.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Every Field is Required");
				}
				else {	
					Customer c = new Customer(Name.getText(),surname.getText(),RoomNum.getText(),email.getText(),id.getText(),phone.getText());
					String[] dateSplit = checkin.getText().split("/");
					String[] dateSplit2 = checkout.getText().split("/");
					Date checkIn = new Date(dateSplit[0],dateSplit[1],dateSplit[2]);
					Date checkOut = new Date(dateSplit2[0],dateSplit2[1],dateSplit2[2]);	
					Booking booking = new Booking(checkIn,checkOut,c,RoomNum.getText(),price.getText(),comboBox.getSelectedItem().toString());
					bookings.add(booking);
					
					rooms.get(Integer.valueOf(booking.getRoomNumber())-1).setAvailability("non-available");
					try {
						Booking.writeTxt(bookings);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					try {
						Room.writeTxt(rooms);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Confirmed!");
				}

				Name.setText("");
				surname.setText("");
				RoomNum.setText("");
				email.setText("");
				id.setText("");
				phone.setText("");
				checkin.setText("");
				checkout.setText("");
				price.setText("");
			}
		});
		Confirm.setFont(new Font("Tahoma", Font.BOLD, 12));
		Confirm.setBounds(21, 395, 85, 21);
		contentPane.add(Confirm);
		
		JLabel lblNewLabel_12 = new JLabel("Please Enter Date 10/01/2022 format!");
		lblNewLabel_12.setForeground(Color.RED);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_12.setBounds(29, 169, 260, 13);
		contentPane.add(lblNewLabel_12);
						
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if(!(checkin.getText().equals("") && checkout.getText().equals(""))) {
					Scanner sc = null;
					String[] dateSplit = checkin.getText().split("/");
					String[] dateSplit2 = checkout.getText().split("/");
					try {
						
						sc = new Scanner(new File("Room.txt"));
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					if(dateSplit.length == 3 && dateSplit2.length == 3) {
						Date checkIn = new Date(dateSplit[0],dateSplit[1],dateSplit[2]);
						Date checkOut = new Date(dateSplit2[0],dateSplit2[1],dateSplit2[2]);
						Room room=new Room(RoomNum.getText(),"Single","available");
						if(comboBox.getSelectedItem().equals("Single")) {
							while(sc.hasNext()) {
								String line =  sc.nextLine();
								String[] word =line.split(",");
								if(word[1].equals("single") && word[2].equals("available")) {									
									RoomNum.setText(word[0]);
									room.setRoomNumber(RoomNum.getText());
									room.setAvailability("non-available");
									break;
						}
							}
							
							lblNewLabel_11.setIcon(new ImageIcon(RestaurantFrame.class.getResource("/images/singleroom.jpg")));	
							if(dateSplit[0] != null && dateSplit[1]!= null && dateSplit[2] != null && dateSplit2[0] != null && dateSplit2[1]!= null && dateSplit2[2] != null) {
								int price2 = (Integer.valueOf(checkOut.getDay()) - Integer.valueOf(checkIn.getDay())) * 1000;
								price.setText(String.valueOf(price2));
							}
							else 
								JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
					
						}
						else if(comboBox.getSelectedItem().equals("Double")) {
							lblNewLabel_11.setIcon(new ImageIcon(RestaurantFrame.class.getResource("/images/room3double.jpg")));
							if(dateSplit.length == 3 && dateSplit2.length == 3) {
								int price2 = (Integer.valueOf(checkOut.getDay()) - Integer.valueOf(checkIn.getDay())) * 2300;
								price.setText(String.valueOf(price2));
								
								while(sc.hasNext()) {
									String line =  sc.nextLine();
									String[] word =line.split(",");
									if(word[1].equals("double") && word[2].equals("available")) {
										RoomNum.setText(word[0]);
										break;
									}
								}
							}
							else 
								JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
								
						}
						else if(comboBox.getSelectedItem().equals("Suite")) {
							lblNewLabel_11.setIcon(new ImageIcon(RestaurantFrame.class.getResource("/images/suitelex.jpg")));	
							if(dateSplit[0] != " " && dateSplit[1]!= " " && dateSplit[2] != " " && dateSplit2[0] != " " && dateSplit2[1]!= " " && dateSplit2[2] != " ") {
								
								while(sc.hasNext()) {
									String line =  sc.nextLine();
									String[] word =line.split(",");
									if(word[1].equals("suite") && word[2].equals("available")) {
										RoomNum.setText(word[0]);
										break;
									}
								}
								int price2 = (Integer.valueOf(checkOut.getDay()) - Integer.valueOf(checkIn.getDay())) * 4000;
								price.setText(String.valueOf(price2));
							}
							else 
								JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
							}
						else {
							lblNewLabel_11.setIcon(new ImageIcon(RestaurantFrame.class.getResource("/images/room2.jpg")));
							if(dateSplit[0] != " " && dateSplit[1]!= " " && dateSplit[2] != " " && dateSplit2[0] != " " && dateSplit2[1]!= " " && dateSplit2[2] != " ") {
								
								while(sc.hasNext()) {
									String line =  sc.nextLine();
									String[] word =line.split(",");
									if(word[1].equals("deluxe") && word[2].equals("available")) {
										RoomNum.setText(word[0]);
										break;
									}
								}
								int price2 = (Integer.valueOf(checkOut.getDay()) - Integer.valueOf(checkIn.getDay())) * 5800;
								price.setText(String.valueOf(price2));
							}
							else 
								JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
								
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
					}
			}
				else {
					JOptionPane.showMessageDialog(null,"Plase Enter Date Valid Format!");
				}
			}
			
			
		});
		
		
	}
}

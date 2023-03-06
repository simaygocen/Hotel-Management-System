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

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ReceptionistBookingFrame extends JFrame{

	private JPanel contentPane;
	private JTextField Name;
	private JTextField surname;
	private JTextField email;
	private JTextField id;
	private JTextField guestNum;
	private JTextField price;
	private JTextField checkin;
	private JTextField checkout;
	private JTextField phone;
	private JTable bookingtable;
	private DefaultTableModel booking_model;
	private static List<Booking> bookings;
	private static List<Room> rooms;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistBookingFrame frame = new ReceptionistBookingFrame();
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
	public ReceptionistBookingFrame() throws FileNotFoundException {
		Booking.addToList();
		bookings = Booking.getBookings();
		Room.addRoomToList();
		rooms=Room.getRooms();
		setBounds(200, 150, 1086, 594);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel B_NAME = new JLabel("Name");
		B_NAME.setFont(new Font("Tahoma", Font.PLAIN, 15));
		B_NAME.setBounds(29, 21, 45, 13);
		contentPane.add(B_NAME);
		
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
		lblNewLabel_4.setBounds(29, 193, 120, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Check In Date");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(29, 153, 107, 25);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Mobile Phone");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(29, 231, 120, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel roomNumber = new JLabel("Room Number");
		roomNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		roomNumber.setBounds(29, 266, 146, 13);
		contentPane.add(roomNumber);
		
		JLabel lblNewLabel_9 = new JLabel("Room Type");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(29, 336, 120, 19);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Price");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(29, 300, 77, 13);
		contentPane.add(lblNewLabel_10);
		
		Name = new JTextField();
		Name.setBounds(147, 20, 96, 19);
		contentPane.add(Name);
		Name.setColumns(10);
		
		surname = new JTextField();
		surname.setColumns(10);
		surname.setBounds(147, 54, 96, 19);
		contentPane.add(surname);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(147, 89, 96, 19);
		contentPane.add(email);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(147, 123, 96, 19);
		contentPane.add(id);
		
		guestNum = new JTextField();
		guestNum.setEditable(false);
		guestNum.setColumns(10);
		guestNum.setBounds(147, 265, 96, 19);
		contentPane.add(guestNum);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(147, 299, 96, 19);
		contentPane.add(price);
		
		checkin = new JTextField();
		checkin.setColumns(10);
		checkin.setBounds(146, 158, 96, 19);
		contentPane.add(checkin);
		
		checkout = new JTextField();
		checkout.setColumns(10);
		checkout.setBounds(146, 192, 96, 19);
		contentPane.add(checkout);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(147, 230, 96, 19);
		contentPane.add(phone);
		
		String[] roomType={"Single","Double","Suite","Deluxe"};
		final JComboBox comboBox = new JComboBox(roomType);
		comboBox.setBounds(147, 337, 96, 21);
		contentPane.add(comboBox);
		
		JScrollPane scrollPanebooking = new JScrollPane();
		scrollPanebooking.setBounds(295, 10, 767, 526);
		contentPane.add(scrollPanebooking);
		
		bookingtable = new JTable();
		booking_model = new DefaultTableModel();
		Object[] column = {"IDProof","Name","Surname","Email","CheckIn","CheckOut","Phone","Room Number","Price","Room Type"};
		final Object[] row = new Object[11];
		booking_model.setColumnIdentifiers(column);
		bookingtable.setModel(booking_model);
		scrollPanebooking.setViewportView(bookingtable);
		int count = 0;
		while(count != bookings.size()) {
			row[0] = bookings.get(count).getCustomer().getIdProof();
			row[1] = bookings.get(count).getCustomer().getName();
			row[2] = bookings.get(count).getCustomer().getSurname();
			row[3] = bookings.get(count).getCustomer().getEmail();
			row[4] = bookings.get(count).getCheckInDate().getDay() + "/" + bookings.get(count).getCheckInDate().getMonth() + "/ "+ bookings.get(count).getCheckInDate().getYear();
			row[5] = bookings.get(count).getCheckOutDate().getDay() + "/" + bookings.get(count).getCheckOutDate().getMonth() + "/ "+ bookings.get(count).getCheckOutDate().getYear();
			row[6] = bookings.get(count).getCustomer().getPhone();
			row[7] = bookings.get(count).getCustomer().getRoomNumber();
			row[8] = bookings.get(count).getPrice();
			row[9] = bookings.get(count).getRoomType();
			booking_model.addRow(row);
			count++;
			
		}	
		

		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Scanner sc = null;
				try {
					sc = new Scanner(new File("./Room.txt"));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String[] dateSplit = checkin.getText().split("/");
				String[] dateSplit2 = checkout.getText().split("/");
				Date checkIn = new Date(dateSplit[0],dateSplit[1],dateSplit[2]);
				Date checkOut = new Date(dateSplit2[0],dateSplit2[1],dateSplit2[2]);
				Room room=new Room(guestNum.getText(),"Single","available");
				if(comboBox.getSelectedItem().equals("Single")) {
					while(sc.hasNext()) {
						String line =  sc.nextLine();
						String[] word =line.split(",");
						if(word[1].equals("single") && word[2].equals("available")) {									
							guestNum.setText(word[0]);
							
							room.setRoomNumber(guestNum.getText());
							room.setAvailability("non-available");
							break;

						}
					}
					int price2 = (Integer.valueOf(checkOut.getDay()) - Integer.valueOf(checkIn.getDay())) * 1000;
					price.setText(String.valueOf(price2));
				}
				else if(comboBox.getSelectedItem().equals("Double")) {
					while(sc.hasNext()) {
						String line =  sc.nextLine();
						String[] word =line.split(",");
						if(word[1].equals("double") && word[2].equals("available")) {									
							guestNum.setText(word[0]);
							room.setRoomNumber(guestNum.getText());
							room.setAvailability("non-available");
							break;

						}
					}

					int price2 = (Integer.valueOf(checkOut.getDay()) - Integer.valueOf(checkIn.getDay())) * 2300;
					price.setText(String.valueOf(price2));
				}
				else if("Suite".equals("Suite")) {
					while(sc.hasNext()) {
						String line =  sc.nextLine();
						String[] word =line.split(",");
						if(word[1].equals("suite") && word[2].equals("available")) {
							guestNum.setText(word[0]);
							room.setRoomNumber(guestNum.getText());
							room.setAvailability("non-available");
							break;
						}
					}
					int price2 = (Integer.valueOf(checkOut.getDay()) - Integer.valueOf(checkIn.getDay())) * 4000;
					price.setText(String.valueOf(price2));
				}
				else {
					while(sc.hasNext()) {
						String line =  sc.nextLine();
						String[] word =line.split(",");
						if(word[1].equals("deluxe") && word[2].equals("available")) {
							guestNum.setText(word[0]);
							room.setRoomNumber(guestNum.getText());
							room.setAvailability("non-available");
							break;
						}
						
					}
				
					int price2 = (Integer.valueOf(checkOut.getDay()) - Integer.valueOf(checkIn.getDay())) * 5800;
					price.setText(String.valueOf(price2));
				}
					
				
			}
			
			
		});
		
		
		
		JButton Add = new JButton("Add");
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag=false;
				if(Name.getText().equals("") || surname.getText().equals("") || email.getText().equals("") || id.getText().equals("") || phone.getText().equals("") || checkin.getText().equals("") 
						||checkout.getText().equals("") ||  guestNum.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Every Field is Required");
				}
				else {
					
					for(int i=0; i<rooms.size(); i++) {
						if(comboBox.getSelectedItem().toString().toLowerCase().equals(rooms.get(i).getType()) && rooms.get(i).getAvailability().equals("available")) {
							row[0]=id.getText();
							row[1]=Name.getText();
							row[2]=surname.getText();
							row[3]=email.getText();
							row[4]=checkin.getText();
							row[5]=checkout.getText();
							row[6]=phone.getText();
							row[7]=rooms.get(i).getRoomNumber();
							row[8]=price.getText();
							row[9]=comboBox.getSelectedItem().toString();
							booking_model.addRow(row);
							

							Customer c = new Customer(Name.getText(),surname.getText(),guestNum.getText(),email.getText(),id.getText(),phone.getText());
							String[] dateSplit = checkin.getText().split("/");
							String[] dateSplit2 = checkout.getText().split("/");
							Date checkIn = new Date(dateSplit[0],dateSplit[1],dateSplit[2]);
							Date checkOut = new Date(dateSplit2[0],dateSplit2[1],dateSplit2[2]);
							Booking booking = new Booking(checkIn,checkOut,c,guestNum.getText(),price.getText(),comboBox.getSelectedItem().toString());
							rooms.get(Integer.valueOf(booking.getRoomNumber())-1).setAvailability("non-available");
							
							
							bookings.add(booking);
				            flag=true;
							try {
								Booking.writeTxt(bookings);
								Room.writeTxt(rooms);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							break;
							
						}
		
					}
					if(flag==false)
						JOptionPane.showMessageDialog(null,"There is  available room");

					id.setText("");
					Name.setText("");
					surname.setText("");
					email.setText("");
					checkin.setText("");
					checkout.setText("");
					phone.setText("");
					guestNum.setText("");
					price.setText("");
				}

				
			}

		});
		Add.setFont(new Font("Tahoma", Font.BOLD, 12));
		Add.setBounds(46, 411, 85, 31);
		contentPane.add(Add);
		
		
		JButton Delete = new JButton("Delete");
		Delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		Delete.setBounds(141, 411, 85, 31);	
		bookingtable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(bookingtable.getSelectedRow() != -1) {
					 int selectedRow=bookingtable.getSelectedRow();
					 booking_model.removeRow(selectedRow);
		             bookings.remove(selectedRow);
		             JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		             try {
			       			Booking.writeTxt(bookings);
			       		} catch (IOException e1) {
			       			// TODO Auto-generated catch block
			       			e1.printStackTrace();
			       		}
				}
		  }
		});
		contentPane.add(Delete);
        try {
   			Booking.writeTxt(bookings);
   		} catch (IOException e1) {
   			// TODO Auto-generated catch block
   			e1.printStackTrace();
   		}
		JButton backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ReceptionistFrame().setVisible(true);
			}
		});
		backButton.setIcon(new ImageIcon(ReceptionistBookingFrame.class.getResource("/images/back.png")));
		backButton.setBounds(10, 532, 85, 25);
		contentPane.add(backButton);
		

		
	
		

		
		
	}
}

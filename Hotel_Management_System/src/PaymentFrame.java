import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class PaymentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField RoomNum;
	private JTextField Accommodotion;
	private JTextField Restaurant;
	private JTextField RoomService;
	private JTextField TotalPrice;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentFrame frame = new PaymentFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PaymentFrame() {
		setBounds(400, 300, 683, 368);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel RoomNumber = new JLabel("Room Number");
		RoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RoomNumber.setBounds(27, 28, 110, 24);
		contentPane.add(RoomNumber);
		
		RoomNum = new JTextField();
		RoomNum.setBounds(166, 33, 96, 19);
		contentPane.add(RoomNum);
		RoomNum.setColumns(10);
		
		Accommodotion = new JTextField();
		Accommodotion.setEditable(false);
		Accommodotion.setColumns(10);
		Accommodotion.setBounds(166, 89, 96, 19);
		contentPane.add(Accommodotion);
		
		Restaurant = new JTextField();
		Restaurant.setEditable(false);
		Restaurant.setColumns(10);
		Restaurant.setBounds(474, 33, 96, 19);
		contentPane.add(Restaurant);
		
		RoomService = new JTextField();
		RoomService.setEditable(false);
		RoomService.setColumns(10);
		RoomService.setBounds(474, 89, 96, 19);
		contentPane.add(RoomService);
		
		TotalPrice = new JTextField();
		TotalPrice.setEditable(false);
		TotalPrice.setColumns(10);
		TotalPrice.setBounds(474, 150, 96, 19);
		contentPane.add(TotalPrice);
		
		JLabel lblAccommodation = new JLabel("Accommodation");
		lblAccommodation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAccommodation.setBounds(27, 84, 110, 24);
		contentPane.add(lblAccommodation);
		
		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRestaurant.setBounds(335, 28, 110, 24);
		contentPane.add(lblRestaurant);
		
		JLabel lblRoomService = new JLabel("Room Service");
		lblRoomService.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRoomService.setBounds(335, 84, 110, 24);
		contentPane.add(lblRoomService);
		
		JLabel lblTotalPrice = new JLabel("Total Price");
		lblTotalPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTotalPrice.setBounds(335, 145, 110, 24);
		contentPane.add(lblTotalPrice);
		
		JButton Confirm = new JButton("Confirm");
		Confirm.setBounds(485, 212, 102, 21);
		contentPane.add(Confirm);
		
		JButton GetPrice = new JButton("Get Price");
		GetPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flag=false;
				Scanner sc = null;
				try {
					sc = new Scanner(new File("./Booking.txt"));
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int total = 0;
				while(sc.hasNext()) {
					String line = sc.nextLine();
					String[] split = line.split(",");
					if((split[11].equals(RoomNum.getText()))) {
						flag=true;
						break;
						
					}
						
				}
				
				if(flag==true) {
					try {
						sc = new Scanner(new File("./Booking.txt"));
						total = 0;
						while(sc.hasNext()) {
							String line = sc.nextLine();
							String[] split = line.split(",");
							if(split[11].equals(RoomNum.getText())) {
								Accommodotion.setText(split[12]);
								total+=Integer.valueOf(split[12]);
								System.out.println(total);
								
							}
						}
						sc = new Scanner(new File("./RestaurantBookingReservation.txt"));
						while(sc.hasNext()) {
							String line = sc.nextLine();
							String[] split = line.split(",");
							if(split[0].equals(RoomNum.getText())) {
								Restaurant.setText(split[3]);
								total+=Integer.valueOf(split[3]);
								System.out.println(total);
							}
						}
						sc = new Scanner(new File("./FoodOrdering.txt"));
						while(sc.hasNext()) {
							String line = sc.nextLine();
							String[] split = line.split(",");
							if(split[0].equals(RoomNum.getText())) {
								RoomService.setText(split[1]);
								total+=Integer.valueOf(split[1]);
								System.out.println(total);
							}
						}
						TotalPrice.setText(String.valueOf(total));
						System.out.println(total);
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null,"There is no Customer with this Room Number!");
				
				
			}
		});
		GetPrice.setBounds(360, 212, 102, 21);
		contentPane.add(GetPrice);
	}
}

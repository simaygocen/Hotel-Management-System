import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Color;

public class ReceptionistFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceptionistFrame frame = new ReceptionistFrame();
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
	public ReceptionistFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 150, 1024, 622);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu BOOKING = new JMenu("BOOKING");
		menuBar.add(BOOKING);
		
		JMenuItem BookingRoom = new JMenuItem("Booking Room");
		BOOKING.add(BookingRoom);
		BookingRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ReceptionistBookingFrame().setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JMenuItem RoomAvailability = new JMenuItem("Room Availability");
		BOOKING.add(RoomAvailability);
		RoomAvailability.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ReceptionistCheckingFrame().setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

		
		JButton PaymentButton = new JButton("PAYMENT");
		PaymentButton.setBackground(Color.WHITE);
		PaymentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PaymentFrame().setVisible(true);
			}
		});
		menuBar.add(PaymentButton);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel reception = new JLabel("New label");
		reception.setIcon(new ImageIcon(ReceptionistFrame.class.getResource("/images/recep2.jpg")));
		reception.setBounds(0, 0, 1010, 561);
		contentPane.add(reception);
	}
}

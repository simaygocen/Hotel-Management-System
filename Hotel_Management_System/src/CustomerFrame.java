import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JMenuItem;
import javax.swing.JButton;

public class CustomerFrame extends JFrame{

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerFrame frame = new CustomerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CustomerFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1177, 651);
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JButton btnNewButton = new JButton("Booking Room");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new BookingFrame().setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 15));
		menuBar.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Restaurant Reservation");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RestaurantFrame().setVisible(true);
			}
			
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 15));
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Make Food Ordering");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new MakeFoodOrderingFrame().setVisible(true);
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 15));
		menuBar.add(btnNewButton_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("HOTEL ROYAL WELCOMES YOU");
		lblNewLabel_1.setFont(new Font("Baskerville Old Face", Font.ITALIC, 30));
		lblNewLabel_1.setBounds(301, 20, 511, 48);
		contentPane.add(lblNewLabel_1);
		

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(CustomerFrame.class.getResource("/images/one.jpg")));
		lblNewLabel.setBounds(0, 0, 1163, 647);
		contentPane.add(lblNewLabel);
		
		
	}
}

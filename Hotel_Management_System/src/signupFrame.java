import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class signupFrame extends JFrame {
	private JPanel contentPane;
	private JTextField username;
	private JTextField name;
	private JPasswordField passwordField;
	private JTextField surname;
	private JTextField email;
	private JPasswordField password;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signupFrame frame = new signupFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public signupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 50, 1264, 735);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Welcome To HOTEL ROYAL");
		lblNewLabel_6.setFont(new Font("Baskerville Old Face", Font.ITALIC, 34));
		lblNewLabel_6.setBounds(379, 34, 556, 33);
		contentPane.add(lblNewLabel_6);
		
		password = new JPasswordField();
		password.setFont(new Font("Dialog", Font.PLAIN, 12));
		password.setBounds(559, 398, 205, 20);
		contentPane.add(password);
		
		JLabel lblNewLabel_8 = new JLabel("Password");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setBounds(465, 400, 58, 13);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_7 = new JLabel("Email");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(465, 371, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("SignUp");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(581, 220, 93, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(465, 268, 68, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(478, 305, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Surname");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(461, 333, 72, 13);
		contentPane.add(lblNewLabel_3);
		
		username = new JTextField();
		username.setFont(new Font("Dialog", Font.PLAIN, 12));
		username.setBounds(559, 265, 205, 19);
		contentPane.add(username);
		username.setColumns(10);
		
		name = new JTextField();
		name.setFont(new Font("Dialog", Font.PLAIN, 12));
		name.setBounds(559, 302, 205, 19);
		contentPane.add(name);
		name.setColumns(10);
		
		JButton btnNewButton = new JButton("SignUp");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
			if(username.getText().equals("") || name.getText().equals("")||
					surname.getText().equals("")||email.getText().equals("")||password.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Every Field is Required");
			}
			else {Customer customer=new Customer(username.getText(),name.getText(),surname.getText(),email.getText(),password.getText());
			try {
				customer.addCustomer(customer);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Signed Up!");
			setVisible(false);
			try {
				new Login().setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}
			
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(679, 439, 85, 21);
		contentPane.add(btnNewButton);
		
		surname = new JTextField();
		surname.setFont(new Font("Dialog", Font.PLAIN, 12));
		surname.setBounds(559, 331, 205, 19);
		contentPane.add(surname);
		surname.setColumns(10);
		
		email = new JTextField();
		email.setFont(new Font("Dialog", Font.PLAIN, 12));
		email.setBounds(559, 369, 205, 19);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(signupFrame.class.getResource("/images/123123.png")));
		lblNewLabel_5.setBounds(-25, -91, 1281, 877);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome To HOTEL ROYAL");
		lblNewLabel_4.setFont(new Font("Baskerville Old Face", Font.ITALIC, 34));
		lblNewLabel_4.setBounds(379, 48, 556, 33);
		contentPane.add(lblNewLabel_4);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tUser;
	private JPasswordField passwordField;
	public SingletonManager singleton = SingletonManager.getSingletonManager();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Login() throws IOException {
	    writeManager();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(80, 50, 1280, 735);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNotAMember = new JLabel("Not a member? Become a member");
		labelNotAMember.setForeground(Color.BLACK);
		labelNotAMember.setBounds(384, 419, 290, 13);
		labelNotAMember.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(labelNotAMember);
		
		JButton signUp = new JButton("SignUp");
		signUp.setForeground(Color.WHITE);
		signUp.setBackground(Color.DARK_GRAY);
		signUp.setBounds(684, 416, 85, 21);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				new signupFrame().setVisible(true);
			}
		});
		signUp.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(signUp);
		

		
		JLabel lblNewLabel = new JLabel("Welcome To HOTEL ROYAL");
		lblNewLabel.setBounds(396, 30, 556, 33);
		lblNewLabel.setFont(new Font("Baskerville Old Face", Font.ITALIC, 34));
		contentPane.add(lblNewLabel);
		
		tUser = new JTextField();
		tUser.setBounds(528, 272, 176, 33);
		contentPane.add(tUser);
		tUser.setColumns(10);
		
		JLabel usernamelabel = new JLabel("USERNAME");
		usernamelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		usernamelabel.setBounds(384, 270, 98, 33);
		contentPane.add(usernamelabel);
		
		JLabel passwordlabel = new JLabel("PASSWORD");
		passwordlabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		passwordlabel.setBounds(384, 337, 98, 33);
		contentPane.add(passwordlabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(528, 339, 176, 33);
		contentPane.add(passwordField);
		
		JButton signIn = new JButton("Sign In");
		signIn.setForeground(Color.WHITE);
		signIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		signIn.setBackground(Color.DARK_GRAY);
		signIn.setBounds(742, 344, 85, 21);
		contentPane.add(signIn);
		
		String[] LoginType = {"Manager","Customer","Receptionist"};
		final JComboBox statu = new JComboBox(LoginType);
		statu.setForeground(Color.BLACK);
		statu.setBackground(Color.WHITE);
		statu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		statu.setBounds(742, 272, 114, 33);
		contentPane.add(statu);
		
		JLabel lblNewLabel_2 = new JLabel("a");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(Color.DARK_GRAY);
		lblNewLabel_2.setBounds(-18, -19, 1398, 735);
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/123123.png")));
		contentPane.add(lblNewLabel_2);
		
		
		signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean flagCustomer = false;
				Boolean flagReceptionist = false;
				String userName = tUser.getText();
				String passWord = passwordField.getText();
			
				Scanner scan;
				String loginType = (String) statu.getSelectedItem();
				if(loginType.equals("Manager")) {
					try {
						 scan = new Scanner(new File("./manager.txt"));
						while(scan.hasNext()){					
							String line = scan.nextLine().toString();
							String[] split = line.split(",");
							String username = split[0];
							String password = split[4];
							
							if(passWord.equals(password) && userName.equals(username)) {
								setVisible(false);
								new ManagerFrame().setVisible(true);						
							}
							else if(userName.equals("") || passWord.equals("")) {
								JOptionPane.showMessageDialog(null,"Every Field is Required");
							}
							else 
								JOptionPane.showMessageDialog(null,"Invalid username or password!");
							
							
					  }
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(loginType.equals("Customer")) {
					try {
						 scan = new Scanner(new File("./Customers.txt"));					
						while(scan.hasNext()){					
							String line = scan.nextLine().toString();
							String[] split = line.split(",");
							String username = split[0];
							String password = split[4];
							
							if(passWord.equals(password) && userName.equals(username)) {
								setVisible(false);
								flagCustomer = true;
								new CustomerFrame().setVisible(true);	
								break;
							}
							else if(userName.equals("") || passWord.equals("")) {
								JOptionPane.showMessageDialog(null,"Every Field is Required");
								break;
							}							
							
								
								
						
								
							
							
					     }
						if(!flagCustomer) {
							JOptionPane.showMessageDialog(null,"Invalid Username or Password");									
							
						}
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					try {
						scan = new Scanner(new File("./Receptionist.txt"));
						while(scan.hasNext()){					
							String line = scan.nextLine().toString();
							String[] split = line.split(",");
							String username = split[0];
							String password = split[4];
							
							if(passWord.equals(password) && userName.equals(username)) {
								setVisible(false);
								flagReceptionist = true;
								new ReceptionistFrame().setVisible(true);	
								break;
							}
							else if(userName.equals("") || passWord.equals("")) {
								JOptionPane.showMessageDialog(null,"Every Field is Required");
								break;
							}	
							
					}
						if(!flagReceptionist) {
							JOptionPane.showMessageDialog(null,"Invalid Username or Password");									
							
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}				
			}
		});
	
	}
	public void writeManager() throws IOException {
		FileWriter writer = new FileWriter("./manager.txt");
		String emp = singleton.getUsername()+","+singleton.getName()+","+singleton.getSurname()+","+singleton.getEmail()
+","+singleton.getPassword();		
        writer.write(emp + System.lineSeparator());
		
		writer.close();
		
	}
}

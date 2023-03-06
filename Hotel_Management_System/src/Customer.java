import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JOptionPane;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;


public class Customer extends Person{
	private String email;
	private String idProof;
	private String phone;
	private String RoomNumber;
	private static final String NEW_LINE = System.lineSeparator();
	

	public Customer(String name, String surname, String RoomNumber, String email, String idProof, String phone) {
		super(name, surname, idProof);
		this.email = email;
		this.idProof = idProof;
		this.phone = phone;
		this.RoomNumber=RoomNumber;
	}
	public Customer(String username,String name,String surname, String email, String password) {
	    super(username,name,surname,password);
        this.email=email;
	
	}	
	public boolean searchCustomer(String name,String email,String password) throws FileNotFoundException {
		boolean flag=false;
		Scanner scan = new Scanner(new File("./Customers.txt"));
		while(scan.hasNext()){
            String line = scan.nextLine().toLowerCase().toString();
            String search=name.toLowerCase()+","+email.toLowerCase()+","+password.toLowerCase();
            if(line.contains(search)){
            	flag=true;
            	break;
            }
            else {
            	flag=false;
            }
           
        }
		return flag;
	}	
	public void addCustomer(Customer customer) throws IOException {
		String append=customer.getUsername()+","+customer.getName()+","+customer.getSurname()+","+customer.getEmail()
		+","+customer.getPassword();
				
		Path path = Paths.get("Customers.txt");
		appendToFile(path, append + NEW_LINE);

	}
	private static void appendToFile(Path path, String content) throws IOException {

			Files.write(path, content.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);

		}	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdProof() {
		return idProof;
	}

	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}

	

}

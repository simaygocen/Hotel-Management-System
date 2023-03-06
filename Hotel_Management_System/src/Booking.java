import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Booking {
	private Date checkInDate;
	private Date checkOutDate;
	private Customer customer;
	private String RoomNumber;
	private String Bed;
	private String Price;
	private String RoomType;
	private static final String NEW_LINE = System.lineSeparator();
	private static List<Booking> bookings = new ArrayList<Booking>();
	

	public Booking(Date checkInDate, Date checkOutDate, Customer customer, String RoomNumber, String price,
			String roomType) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.customer = customer;
		this.RoomNumber = RoomNumber;
		Price = price;
		RoomType = roomType;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getRoomNumber() {
		return RoomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}
	public String getBed() {
		return Bed;
	}
	public void setBed(String bed) {
		Bed = bed;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getRoomType() {
		return RoomType;
	}
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	public static List<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(List<Booking> bookings) {
		Booking.bookings = bookings;
	}
	public static void addToList() throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File("./Booking.txt"));	
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] split = line.split(",");		
			Date checkIn = new Date(split[4],split[5],split[6]) ;
			Date checkOut = new Date(split[7],split[8],split[9]) ;
			Customer c1 = new Customer(split[1],split[2],split[11],split[3],split[0],split[10]);
			Booking booking1 = new Booking(checkIn,checkOut,c1,split[11],split[12],split[13]);
			bookings.add(booking1);					  
		}
	}
	public static void writeTxt(List<Booking> bookings) throws IOException {		
		FileWriter writer = new FileWriter("Booking.txt"); 
		for(Booking booking: bookings) {
			String book = booking.getCustomer().getIdProof() +","+ booking.getCustomer().getName()+"," +booking.getCustomer().getSurname()  +","+ booking.getCustomer().getEmail() +","+ booking.getCheckInDate().getDay() +","+booking.getCheckInDate().getMonth() 
					+","	+booking.getCheckInDate().getYear() + ","+ booking.getCheckOutDate().getDay() +","+booking.getCheckOutDate().getMonth() +","+ booking.getCheckOutDate().getYear() + "," + booking.getCustomer().getPhone() + "," +
					booking.getCustomer().getRoomNumber() + ","+ booking.getPrice() + "," + booking.getRoomType();
		    writer.write(book + System.lineSeparator());
		}
		writer.close();
		
		
	}
}

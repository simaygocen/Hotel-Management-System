import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RestaurantBooking{
    private static final String NEW_LINE = System.lineSeparator();
	private String RoomNumber;
    private String date;
    private String RestaurantType;
    private String price;
    
    public RestaurantBooking(String roomNumber, String date, String restaurantType, String price) {
		super();
		RoomNumber = roomNumber;
		this.date = date;
		RestaurantType = restaurantType;
		this.price = price;
	}
    
    
    
	public String getRoomNumber() {
		return RoomNumber;
	}
	
	
	public void setRoomNumber(String roomNumber) {
		RoomNumber = roomNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getRestaurantType() {
		return RestaurantType;
	}
	public void setRestaurantType(String restaurantType) {
		RestaurantType = restaurantType;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void addBooking(RestaurantBooking restaurantbooking) throws IOException{
		String append=restaurantbooking.getRoomNumber()+","+restaurantbooking.getDate()+","+restaurantbooking.getRestaurantType()
	+","+restaurantbooking.getPrice();
		
		
		Path path=Paths.get("./RestaurantBookingReservation.txt");
		appendToFile(path, append + NEW_LINE);
	}
	private static void appendToFile(Path path ,String content) throws IOException {
		Files.write(path, content.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
	}
    
	
	
	
	
	
	
	

}

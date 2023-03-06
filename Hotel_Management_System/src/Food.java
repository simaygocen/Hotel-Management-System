import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Food {

	private static final String NEW_LINE = System.lineSeparator();
	private int roomNumber;
	private String name;
	private String price;
	


	
	public Food(String name, String price) {
		super();
		this.name = name;
		this.price = price;
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Food(int roomNumber, String price) {
		super();
		this.roomNumber = roomNumber;
		this.price = price;
	}
	

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	public void addFoodOrdering(Food food) throws IOException{
		String append=food.getRoomNumber()+","+food.getPrice();
		Path path=Paths.get("./FoodOrdering.txt");
		appendToFile(path, append + NEW_LINE);
		
	}
	private static void appendToFile(Path path ,String content) throws IOException {
		Files.write(path, content.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
	}
	
	
	
	
	
}

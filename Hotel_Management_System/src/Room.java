import java.io.BufferedWriter;
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

public class Room {
	private static final String NEW_LINE = null;
	private String roomNumber;
	private String type;
	private String availability;
	private static List <Room> rooms=new ArrayList<Room>();
	
	public Room(String roomNumber, String type,String availability) {	
		this.roomNumber = roomNumber;
		this.type = type;
		this.availability=availability;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static void addRoomToList() throws FileNotFoundException {
		int c = 0;
		Scanner sc = new Scanner(new File("./Room.txt"));		
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] split = line.split(",");		
			Room room = new Room(split[0],split[1],split[2]);
		    rooms.add(room);
		}
	}
	
	
	
	public static List<Room> getRooms() {
		return rooms;
	}

	public static void setRooms(List<Room> rooms) {
		Room.rooms = rooms;
	}

	public void modifyRoom(Room room) throws IOException{
		Scanner sc  = new Scanner(new File("./Room.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter("./Room.txt"));			
		while(sc.hasNext()) {
			String line =  sc.nextLine();
			String[] word =line.split(",");
			if(word[0].equals(room.getRoomNumber())) {
			   
				room.setAvailability("non-available");
				break;
			}
		}		
	}
	public static void writeTxt(List<Room> rooms) throws IOException {		
		FileWriter writer = new FileWriter("./Room.txt"); 
		for(Room r: rooms) {
			String room = r.getRoomNumber() + "," + r.getType() + "," + r.getAvailability();
		    writer.write(room + System.lineSeparator());
		}
		writer.close();
		
		
	}

	private void appendToFile(Path path, String content) throws IOException {

		
		// TODO Auto-generated method stub
		Files.write(path, content.getBytes(StandardCharsets.UTF_8),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
	}
	
	
	

}


public class Person {
	
	private String username;
	private String password;
	private String name;
	private String surname;
	private String id;

	
	public Person(String name, String surname, String id) {		
		this.name = name;
		this.surname = surname;
		this.id = id;
		
	}
	public Person(String username, String  name, String surname,String password) {
		this.username=username;
		this.name=name;
		this.surname=surname;
		this.password=password;
	}
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	
	
	
	

}

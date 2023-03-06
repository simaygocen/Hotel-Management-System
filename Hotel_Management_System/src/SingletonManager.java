

public class SingletonManager extends Person{
	private String email;
	private static SingletonManager singletonManager = new SingletonManager("fatihDilmac", "Fatih", "Dilmac", "fatih@gmail.com", "1234");
	private SingletonManager(String username, String  name, String surname,String email,String password){
		super(username,name,surname,password);
		this.email=email;
	}
    public static SingletonManager getSingletonManager() {
	    return singletonManager;
    }
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

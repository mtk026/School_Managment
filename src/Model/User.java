package Model;
import Helper.*;
public class User {
	private int id;
	private String name,lastName,tc,phoneNumber,passWord;
	static DbHelper conn =new DbHelper();
	
	
	public User(int id, String name, String lastName, String tc, String phoneNumber, String passWord) {
		
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.tc = tc;
		
		this.passWord = passWord;
		
	}
	public User() {}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTc() {
		return tc;
	}
	public void setTc(String tc) {
		this.tc = tc;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
	
	

}

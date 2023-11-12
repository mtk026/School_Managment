package Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Teacher extends User  {
	
	
	private String lecture;
	static Statement st = null;
	static ResultSet rs = null;
	static Connection con = null;
	static PreparedStatement preparedStatement = null;
	 String query=null;


	public Teacher(int id, String name, String lastName, String tc, String phoneNumber, String passWord, String lecture) {
		super(id, name, lastName, tc, phoneNumber, passWord);
		this.lecture=lecture;
	}
	public Teacher() {}
	
	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	public ArrayList<User>getTeacherList() throws SQLException{
		ArrayList<User> list=new ArrayList<>();
		User obj ;
		 con =conn.DBConnection();
		
		
		try {
			
			st = con.createStatement();
		   rs =st.executeQuery("SELECT * FROM school.teacher");
			while(rs.next()) {
				
				obj= new User(rs.getInt("teacherıd"),rs.getString("teacherName"),rs.getString("teacherLastName"),rs.getString("tc"),rs.getString("teacherPhoneNumber"),rs.getString("teacherPassword"));
				list.add(obj);
			}
			 
			}catch(Exception e) {
				e.printStackTrace();
			}finally{
				st.close();
				rs.close();
				con.close();
			}
		return list;
	}
	public static  boolean addTeacher(String name, String lastName,String phoneNumber, String passWord, String tc,String lecture) throws SQLException {
		
		String query =("INSERT INTO teacher(teacherName, teacherLastName,teacherPhoneNumber,teacherPassword,tc,teacherLecture) values(?,?,?,?,?,?);");
		con =conn.DBConnection();
	boolean key =false;
		try {
			
			System.out.println("merhaba");
			
			st = con.createStatement();
			System.out.println("bağlandı");
			
			preparedStatement = con.prepareStatement(query);
			System.out.println("sogu hazırlanıyor");
			
			preparedStatement.setObject(1, name);
			preparedStatement.setObject(2, lastName);
			preparedStatement.setObject(3, phoneNumber);
			preparedStatement.setObject(4, passWord );
			preparedStatement.setObject(5, tc);
			preparedStatement.setObject(6, lecture);		
			preparedStatement.executeUpdate();
			System.out.println("gönderdi");
			key =true;
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			st.close();
		    preparedStatement.close();
			con.close();
		}
		if(key)
			return true;
		else
		
		return false;
	}
public static  boolean deleteTeacher(int tc) throws SQLException {
		
		String query =("delete from teacher where tc =?");
		con =conn.DBConnection();
	boolean key =false;
		try {
			
			System.out.println("merhaba");
			
			st = con.createStatement();
			System.out.println("bağlandı");
			
			preparedStatement = con.prepareStatement(query);
			System.out.println("sogu hazırlanıyor");
			
		
			preparedStatement.setObject(1, tc);
					
			preparedStatement.executeUpdate();
			System.out.println("gönderdi");
			key =true;
			
		}catch(Exception e) {e.printStackTrace();}
		finally {
			st.close();
		    preparedStatement.close();
			con.close();
		}
		if(key)
			return true;
		else
		
		return false;
	}
public static  boolean upDAteTeacher(String name, String lastName) throws SQLException {
	
	String query =("UPDATE school.teacher SET teacherName=?,teacherLastName=?");
	con =conn.DBConnection();
boolean key =false;
	try {
		
		
		st = con.createStatement();
			
		preparedStatement = con.prepareStatement(query);
				
		preparedStatement.setObject(1, name);
		preparedStatement.setObject(2, lastName);
		
		preparedStatement.executeUpdate();
		
		key =true;
		
	}catch(Exception e) {e.printStackTrace();}
	finally {
		st.close();
	    preparedStatement.close();
		con.close();
	}
	if(key)
		return true;
	else
	
	return false;}
}

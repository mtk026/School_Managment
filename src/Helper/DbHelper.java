package Helper;
import java.sql.*;

public class DbHelper {
private String userName="root";
private String password ="1234";
private String url ="jdbc:mysql://127.0.0.1:3306/school";
Connection c = null;
public Connection DBConnection()throws SQLException {
	try{
	this.c =DriverManager.getConnection(url,userName,password);
	return c;
}catch(Exception e) {
	e.printStackTrace();
}
return c;
}
}



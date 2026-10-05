package comp.demo;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FBDao {
	public static int saveFeedback(String name, String email, String phone, String message, int rating) {
		int status=0;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/Feedbackserver", "root", "YourPassword");
			
			PreparedStatement ps= con.prepareStatement("insert into Feedback(name, email, phone, message, rating) values(?,?,?,?,?)");
			
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, message);
			ps.setInt(5, rating);
			
			status = ps.executeUpdate();
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
}

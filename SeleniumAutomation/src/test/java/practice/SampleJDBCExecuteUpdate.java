package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class SampleJDBCExecuteUpdate {

	public static void main(String[] args) throws SQLException {

		Driver driverRef = new Driver();

		DriverManager.registerDriver(driverRef);

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbGeetha", "root", "root");

		Statement state = con.createStatement();
		int result = state.executeUpdate("insert into dbGeethainfo values('SuperMan','11','Delhi');");
		if (result == 1) {
			System.out.println("Data is added");
		}
		ResultSet result1 = state.executeQuery("select * from dbGeethainfo");

		while (result1.next()) {
			System.out.println(result1.getString(1) + " " + result1.getInt(2) + " " + result1.getString(3));
		}
		con.close();
	}

}

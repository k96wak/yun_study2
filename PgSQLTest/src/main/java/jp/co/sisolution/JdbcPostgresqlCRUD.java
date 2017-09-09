package jp.co.sisolution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcPostgresqlCRUD {

	public static void main(String[] args) {
		JdbcPostgresqlCRUD app = new JdbcPostgresqlCRUD();
		app.create();
		app.insert();
		app.select();
		app.update();
		app.delete();
	}
	
/**
create table users 
(
  user_id serial
 ,username varchar(45) not null
 ,password varchar(45) not null
 ,fullname varchar(45) null
 ,age int null
 ,email varchar(45) null
 ,primary key (user_id)
);
**/

	public Connection getConnection() {
		String dbURL = "jdbc:postgresql:yun?user=postgres&password=1234";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(dbURL);
			if (conn != null) {
				System.out.println("Connected to database");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	
	public void create() {
		String sql = "CREATE TABLE IF NOT EXISTS Users " +
				"(\r\n" + 
				"  user_id serial\r\n" + 
				" ,username varchar(45) not null\r\n" + 
				" ,password varchar(45) not null\r\n" + 
				" ,fullname varchar(45) null\r\n" + 
				" ,age int null\r\n" + 
				" ,email varchar(45) null\r\n" + 
				" ,primary key (user_id)\r\n" + 
				")";

		try (Connection conn = getConnection()) {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insert() {
		try (Connection conn = getConnection()) {

			String sql = "INSERT INTO Users (username, password, fullname, age, email) VALUES (?, ?, ?, ?, ?)";

			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setString(1, "bill");
			statement.setString(2, "secretpass");
			statement.setString(3, "Bill Gates");
			statement.setInt(4, 50);
			statement.setString(5, "bill.gates@microsoft.com");

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void select() {
		try (Connection conn = getConnection()) {
			String sql = "SELECT * FROM Users";

			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);

			int count = 0;

			while (result.next()) {
				String name = result.getString(2);
				String pass = result.getString(3);
				String fullname = result.getString("fullname");
				Integer age = result.getInt("age");
				String email = result.getString("email");

				String output = "User #%d: %s - %s - %s - %d - %s";
				System.out.println(String.format(output, ++count, name, pass, fullname, age, email));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		try (Connection conn = getConnection()) {

			String sql = "UPDATE Users set password=? where username=?";

			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setString(1, "newpass");
			statement.setString(2, "bill");

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Update new password was successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete() {
		try (Connection conn = getConnection()) {

			String sql = "DELETE FROM Users where username=?";

			PreparedStatement statement;
			statement = conn.prepareStatement(sql);
			statement.setString(1, "bill");

			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Delete user was successfully!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

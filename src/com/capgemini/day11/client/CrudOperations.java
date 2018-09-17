package com.capgemini.day11.client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.capgemini.day11.util.DbUtil;

public class CrudOperations {
	public static void main(String[] args) {
		String query = "INSERT INTO customer1 VALUES(?,?,?,?,?)";
		String query1 = "INSERT INTO bankaccount VALUES(?,?,?,?)";
		//String query = "UPDATE cutsomers SET customer_name= ? WHERE customer_id = ?";
		//String query = "DELETE FROM customers WHERE customer_id = ?";
		//String query = "SELECT * FROM customers";
		
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				PreparedStatement statement1 = connection.prepareStatement(query1);
				/*ResultSet result = statement.executeQuery(*/) {
			
			/*while(result.next()) {
				System.out.println(result.getInt(1) + "\t" + result.getString(2) + "\t" + result.getDate(3).toLocalDate());
			}		*/
			
			statement.setInt(1, 10);
			statement.setString(2, "Jane Doe");
			statement.setString(3, "krishnachythu@gmail.com ");
			statement.setString(4, "krishna villa");
			statement.setDate(5, Date.valueOf(LocalDate.now()));
			
			statement1.setInt(1, 1111);
			statement1.setInt(2, 100);
			statement1.setString(3, "savings");
			statement1.setInt(4, 10000);
			
			
			if(statement.executeUpdate() != 0 && statement1.executeUpdate() !=0)
				System.out.println("Record inserted successfully");
			
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}	
	
	/*public Customer authenticateCustomer(Customer customer) {
		
		String query = "SELECT * FROM customers WHERE customer_id = ? AND customer_password = ?";
		
		try (Connection connection = DbUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			
			if(result.next()) {
				customer.setEmail(result.getString(3))
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}*/
}


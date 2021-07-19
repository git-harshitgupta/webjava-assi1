package tester;

import static Utilis.Dbconnetor.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import customerror.CustomerExceptionHandler;

public class Testesr {
	public static void main(String[] args) {
		try(Connection cn=fetchConnection();
				Scanner sc = new Scanner(System.in)){
			System.out.println("1.User Login,2.New user registeration\n Enter the choose");
			switch(sc.nextInt()) {
			case 1:
				System.out.println("Enter the email and password");
				String sql=("select email,password from customers where email=? && password=?");
				PreparedStatement ps = cn.prepareStatement(sql);
				String email = sc.next();
				String password = sc.next();
				ps.setString(1, email);
				ps.setString(2, password);
				try(ResultSet rs = ps.executeQuery()){
					rs.next();
					if(rs.getString(1).equals(email)&&rs.getString(2).equals(password)) {
						
					}
					else 
						throw new CustomerExceptionHandler("Invaild email and password");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

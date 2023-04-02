package com.palletech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ManagerJdbcOperations 
{
	static String url="jdbc:mysql://localhost:3306/palle";
	static String user="root";
	static String password="Ganga@123";
	static String createstatement=" create table manager(id int auto_increment primary key,name varchar(20) not null,"
			+ "dept varchar(20) not null,exp int)";
	static String insert="insert into manager(name,dept,exp) values(?,?,?)";
	static String delete="delete from manager where id=?";
	static String update="update manager set name=?,dept=?,exp=? where id=?";
	static Connection con=null;
	static Statement s=null;
	static ResultSet rs=null;
	static PreparedStatement ps=null;
	public static void create()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			s=con.createStatement();
			s.executeUpdate(createstatement);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void insert(String name,String dept,int exp)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			ps=con.prepareStatement(insert);
			ps.setString(1, name);
			ps.setString(2, dept);
			ps.setInt(3, exp);
			ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void delete(int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			ps=con.prepareStatement(delete);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void update(String name,String dept,int exp, int id)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			ps=con.prepareStatement(update);
			ps.setString(1, name);
			ps.setString(2, dept);
			ps.setInt(3, exp);
			ps.setInt(4, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static ArrayList<Manager> display()
	{
		ArrayList<Manager> al=new ArrayList<Manager>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			s=con.createStatement();
			rs=s.executeQuery("select * from manager");
			while(rs.next())
			{
				int i=rs.getInt("id");
				String n=rs.getString("name");
				String d=rs.getString("dept");
				int e=rs.getInt("exp");
				Manager m=new Manager(i,n,d,e);
				al.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				rs.close();
				s.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
		
	}
}

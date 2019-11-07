package com.lti;
import java.sql.*;
public class UserDAO {

	DatabaseConnector db = new DatabaseConnector();
	
	public User authentication(User u)
	{
		User user=null;
		
		String email = u.getEmail();
		String emailD = "";
		String password=u.getPassword();
		String passwordD="";
		
		
		try
		{
			String query = "Select email,password from zuser where email='"+email+"'";
			ResultSet rs=db.getResultSet(query);
			
			if(rs.next())
			{
				emailD=rs.getString("email");
				passwordD=rs.getString("password");
			}
			if(email.equals(emailD) && password.equals(passwordD))
			{
				user=getUserByEmail(email);
			}
			else
			{
				user=null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeConnection();
		}
	return user;
	}
	
	public String addUser(User u)
	{
		String result="";
		try
		{
			String query="insert into zuser values(?,?,?,?)";
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setInt(1,u.getId());
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPassword());
			int i = pstmt.executeUpdate();
			
			if(i==1)
			{
				result=Results.SUCCESS;
			}
			else
			{
				result=Results.FAILURE;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=Results.PROBLEM;
		}
		finally
		{
			db.closeConnection();
		}
		return result;
	}
	
	 
	
	public User getUserByEmail(String email)
	{
		User user=null;
		try
		{
			String query="select * from zuser where email='"+email+"'";
			ResultSet rs = db.getResultSet(query);
			if(rs.next())
			{
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeConnection();
		}
		return user;
	}
	public User getUserById(int id)
	{
		User user=null;
		try
		{
			String query="select * from zuser where id="+id+"";
			ResultSet rs = db.getResultSet(query);
			if(rs.next())
			{
				user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeConnection();
		}
		return user;
	}
	public String updateUser(User u)
	{
		String result="";
		
		try
		{
			String query="update zuser set name=?,email=?,password=? where id=?";;
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setInt(4,u.getId());
			pstmt.setString(1, u.getName());
			pstmt.setString(2,u.getEmail());
			pstmt.setString(3, u.getPassword());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
			{
				result=Results.SUCCESS;
			}
			else
			{
				result=Results.FAILURE;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=Results.PROBLEM;
		}
		finally
		{
			db.closeConnection();
		}
		
		return result;
	}
	public String deleteUser(User u)
	{
		String result="";
		
		try
		{
			String query="delete from zuser where id=?";;
			PreparedStatement pstmt=db.getPreparedStatement(query);
			pstmt.setInt(1,u.getId());
			
			int i=pstmt.executeUpdate();
			
			if(i==1)
			{
				result=Results.SUCCESS;
			}
			else
			{
				result=Results.FAILURE;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			result=Results.PROBLEM;
		}
		finally
		{
			db.closeConnection();
		}
		
		return result;
	}
}

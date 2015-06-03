package com.amdocs.avishkar.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class SaveVoteToDBWithMySQL implements SaveVoteToDB{
	
	private String hostname;
	private String dbPort;
	private String username; 
	private String password;
	
	private final static String DUPLICATE_ENTRY_STRING = "Duplicate entry";
	
	public boolean doesUserExistsInDB(Connection conn, String ntnetUsername){
		PreparedStatement pstmt = null;
		try {
			
			pstmt = conn.prepareStatement("select ntnet_username from table_vote "+
						" where ntnet_username = ?;");
			
			pstmt.setString(1, ntnetUsername);
			
			ResultSet resultSet = pstmt.executeQuery();
			
			boolean userExists = resultSet.next();
			
			System.out.println("User exists: "+userExists);
			
			return userExists;
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();			
		}
		finally{
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public int saveVote(Connection conn, VoteDt voteDt){
		
		PreparedStatement pstmt = null;
		try {
			
			pstmt = conn.prepareStatement("insert INTO table_vote(`timestamp`, `ntnet_username`, `rank1_idea_no`, `rank2_idea_no`, `rank3_idea_no`) " +
					" VALUES "+ 
					" (?,?,?,?,?);");
			
			Timestamp timestamp = new Timestamp(new GregorianCalendar().getTimeInMillis());
			pstmt.setTimestamp(1, timestamp);
			pstmt.setString(2, voteDt.getNtnetUser());
			pstmt.setLong(3, voteDt.getRank1IdeaNo());
			pstmt.setLong(4, voteDt.getRank2IdeaNo());
			pstmt.setLong(5, voteDt.getRank3IdeaNo());
			
			int rowCount = pstmt.executeUpdate();
			
			conn.commit();
			
			System.out.println(rowCount);
			
			return SaveDBConstants.SUCCESS;
			
		}catch(SQLException e){
			String errMessage = e.getMessage(); 
			System.out.println(errMessage);
			if(errMessage.startsWith(DUPLICATE_ENTRY_STRING)){
				return SaveDBConstants.DUPLICATE_ENTRY;
			}
			e.printStackTrace();
			return SaveDBConstants.ERROR_DB;
		}
		finally{
			try {
				if(pstmt != null){
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Connection getConnection(){
		
		if(hostname == null){
			throw new RuntimeException("The parameters hostname,dbPort,username,password should be set before calling getConnection");			
		}

		
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//conn = DriverManager.getConnection("jdbc:mysql://"+hostname+":"+dbPort+"/avishkar_voting?" + "user="+username+"&password="+password);
			conn = DriverManager.getConnection("jdbc:mysql://"+hostname+":"+dbPort+"/avishkar_voting?" + "user="+username+"&password="+password);
			conn.setAutoCommit(false);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeConnection(Connection conn){
		try {
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}

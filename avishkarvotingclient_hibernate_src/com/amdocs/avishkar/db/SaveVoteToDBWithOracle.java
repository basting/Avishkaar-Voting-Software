package com.amdocs.avishkar.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class SaveVoteToDBWithOracle implements SaveVoteToDB{
	private String hostname;
	private String port;
	private String dbSID;
	private String dbUsername;
	private String dbPassword;
	
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
			System.out.println(e.getMessage());
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
			throw new RuntimeException("The parameters hostname,port,dbSID,dbUsername,dbPassword should be set before calling getConnection");			
		}
		
		Connection conn = null;
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			//return null;
		}
		  
		String url = "jdbc:oracle:thin:@(DESCRIPTION=" +
				"(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)" +
				"(HOST="+hostname+")(PORT="+port+")))(CONNECT_DATA=(SID="+dbSID+")( SERVER=DEDICATED)))";
		
		  //String url = new StringBuilder().append("jdbc:oracle:thin:@").append(hostname).
		  //append(":").append(port).append(":").append(dbSID).toString();
		           
		try {
			conn = DriverManager.getConnection(url,dbUsername, dbPassword);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			//return null;
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

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public void setDbSID(String dbSID) {
		this.dbSID = dbSID;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public void setPort(String port) {
		this.port = port;
	}
}

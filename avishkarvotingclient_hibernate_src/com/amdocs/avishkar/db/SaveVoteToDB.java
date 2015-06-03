package com.amdocs.avishkar.db;

import java.sql.Connection;

public interface SaveVoteToDB {
	public int saveVote(Connection conn, VoteDt voteDt);
	public Connection getConnection();
	public boolean doesUserExistsInDB(Connection conn, String ntnetUsername);
	public void closeConnection(Connection conn);
}

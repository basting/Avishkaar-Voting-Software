package com.amdocs.avishkar.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.avishkar.voting.db.Vote;

import persistence.HibernateUtil;

public class SaveToDBMySqlWithHibernate {
	public int saveVote(Session session, VoteDt voteDt){
		Transaction tx = session.beginTransaction();
		Vote vote = new Vote(voteDt.getNtnetUser(),voteDt.getRank1IdeaNo(),voteDt.getRank2IdeaNo(),voteDt.getRank3IdeaNo());
		vote.setHostAddr(voteDt.getHostAddr());
		String ntnetUser = (String) session.save(vote);
		System.out.println(ntnetUser);
		tx.commit();
		return 1;
	}
	public Session getSession(){
		return HibernateUtil.getSessionFactory().openSession();
	}
	public boolean doesUserExistsInDB(Session session, String ntnetUsername){
		Transaction newTransaction = session.beginTransaction();
		List vote = session.createQuery("SELECT v FROM Vote v WHERE v.ntnetUsername = '"+ntnetUsername+"'").list();
		int size = vote.size();
		System.out.println( size + " vote(s) found for user " + ntnetUsername );
		if(size != 0){
			return true;
		}
		newTransaction.commit();
		return false;
	}
	
	public boolean isValidNtnetId(Session session, String ntnetUsername){
		Transaction newTransaction = session.beginTransaction();
		List user = session.createQuery("SELECT u FROM User u WHERE u.username = '"+ntnetUsername+"'").list();
		int size = user.size();
		System.out.println( size + " user(s) with username: " + ntnetUsername );
		if(size != 0){
			return true;
		}
		newTransaction.commit();
		return false;
	}
	
	public void closeSession(Session session){
		session.close();		
	}
}

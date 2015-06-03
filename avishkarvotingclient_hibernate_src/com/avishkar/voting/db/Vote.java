package com.avishkar.voting.db;

import java.util.Date;
import java.util.GregorianCalendar;

public class Vote {
	private String ntnetUsername;
	private Date updateTime;
	private long rank1IdeaNo;
	private long rank2IdeaNo;
	private long rank3IdeaNo;
	private String hostAddr;
	
	public Vote(){
		
	}
	
	public Vote(String ntnetUsername, long rank1IdeaNo, long rank2IdeaNo, long rank3IdeaNo){
		this.ntnetUsername = ntnetUsername;
		this.updateTime = new GregorianCalendar().getTime();
		this.rank1IdeaNo = rank1IdeaNo;
		this.rank2IdeaNo = rank2IdeaNo;
		this.rank3IdeaNo = rank3IdeaNo;
	}
	
	public String getNtnetUsername() {
		return ntnetUsername;
	}
	public void setNtnetUsername(String ntnetUsername) {
		this.ntnetUsername = ntnetUsername;
	}
	public long getRank1IdeaNo() {
		return rank1IdeaNo;
	}
	public void setRank1IdeaNo(long rank1IdeaNo) {
		this.rank1IdeaNo = rank1IdeaNo;
	}
	public long getRank2IdeaNo() {
		return rank2IdeaNo;
	}
	public void setRank2IdeaNo(long rank2IdeaNo) {
		this.rank2IdeaNo = rank2IdeaNo;
	}
	public long getRank3IdeaNo() {
		return rank3IdeaNo;
	}
	public void setRank3IdeaNo(long rank3IdeaNo) {
		this.rank3IdeaNo = rank3IdeaNo;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getHostAddr() {
		return hostAddr;
	}

	public void setHostAddr(String hostAddr) {
		this.hostAddr = hostAddr;
	}
	
	
}

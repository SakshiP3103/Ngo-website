package com.yash.entities;

public class Campaigns {
   private int id;
   private String cname;
   private String des;
   private double gamt;
private int cid;
   
public Campaigns() {
	super();
	// TODO Auto-generated constructor stub
}

public Campaigns(int id, String cname, String des, double gamt) {
	super();
	this.cid = id;
	this.cname = cname;
	this.des = des;
	this.gamt = gamt;
}

public Campaigns(String cname, String des, double gamt) {
	super();
	this.cname = cname;
	this.des = des;
	this.gamt = gamt;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public String getDes() {
	return des;
}

public void setDes(String des) {
	this.des = des;
}

public double getGamt() {
	return gamt;
}

public void setGamt(double gamt) {
	this.gamt = gamt;
}


}

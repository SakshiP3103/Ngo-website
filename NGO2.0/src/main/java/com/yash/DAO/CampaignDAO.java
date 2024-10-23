package com.yash.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yash.DB.DBConnect;
import com.yash.entities.Campaigns;

public class CampaignDAO {
	private static Connection conn;
    public CampaignDAO(Connection conn) {
    	super();
    	this.conn=conn;
}
    
    
    public static void insertCampaign(Campaigns camp) {
    	try {
    		String qu="insert into campaigns(cname,des,gamt) values(?,?,?)";
    		PreparedStatement ps=conn.prepareStatement(qu);
    		ps.setString(1,camp.getCname());
    		ps.setString(2,camp.getDes());
    		ps.setDouble(3,camp.getGamt());
    		
    		ps.executeUpdate();
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    public Campaigns selectCampaigns(int id) {
		Campaigns camps = null;
		
			try{
				String qu="select from campaigns where id = ?";
				PreparedStatement ps=conn.prepareStatement(qu);
				System.out.println(ps);
				ps.setInt(1, id);
				ResultSet rs =ps.executeQuery();
				
				while(rs.next()) {
	    			String name=rs.getString("cname");
	    			String des=rs.getString("des");
	    			double gamt=rs.getDouble("gamt");
	    			camps= new Campaigns(name,des,gamt);
				}
			}catch(Exception e) {
	    		e.printStackTrace();
	    	}
		
	
		return camps;
	}

    
    public List<Campaigns> selectAllCampaigns(){
    	List<Campaigns> camps=new ArrayList<>();
    	try {
    		Connection conn=DBConnect.getConnection();
    		String qu="select * from campaigns";
    		PreparedStatement ps=conn.prepareStatement(qu);
    		ResultSet rs=ps.executeQuery();
    		
    		while(rs.next()) {
    			int id=rs.getInt("cid");
    			String name=rs.getString("cname");
    			String des=rs.getString("des");
    			double gamt=rs.getDouble("gamt");
    			camps.add(new Campaigns(id,name,des,gamt));
    		}
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return camps;
    	
    	
    }
    
	public boolean deleteCampaign(int id) throws SQLException {
		boolean rowDeleted = false;
		try{
			String qu="delete from campaigns where id = ?";
			PreparedStatement ps=conn.prepareStatement(qu);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		}catch(Exception e) {
    		e.printStackTrace();
    	}
		return rowDeleted;
	}

	public boolean updateCampaign(Campaigns camp) throws SQLException {
		boolean rowUpdated = false;
		try{
			String qu="update campaigns set cname = ?,des= ?,gamt =? where cid = ?";
			PreparedStatement ps=conn.prepareStatement(qu);

			ps.setString(1,camp.getCname());
			ps.setString(2,camp.getDes());
			ps.setDouble(3,camp.getGamt());
			ps.setInt(4, camp.getCid());
			rowUpdated = ps.executeUpdate() > 0;
		}catch(Exception e) {
    		e.printStackTrace();
    	}
		return rowUpdated;
	}

}

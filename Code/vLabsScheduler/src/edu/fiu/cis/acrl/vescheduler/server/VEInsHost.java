package edu.fiu.cis.acrl.vescheduler.server;

public class VEInsHost {

	private String veInsId;
	private int hostId;
	
	public VEInsHost( 
			String veInsId,
			int hostId) {
		
		this.veInsId = veInsId;
		this.hostId = hostId;
		
	}
	
	public void setVeInsId(String veInsId) {
		this.veInsId = veInsId;
	}
	public String getVeInsId() {
		return veInsId;
	}
	
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	public int getHostId() {
		return hostId;
	}
}

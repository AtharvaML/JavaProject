package in.soft.entity;

public class User {
	
	private int sid;
	private String sname;
	private String sadd;
	private float smarks;
	private String ssec;
	private int sstd;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSadd() {
		return sadd;
	}
	public void setSadd(String sadd) {
		this.sadd = sadd;
	}
	public float getSmarks() {
		return smarks;
	}
	public void setSmarks(float smarks) {
		this.smarks = smarks;
	}
	public String getSsec() {
		return ssec;
	}
	public void setSsec(String ssec) {
		this.ssec = ssec;
	}
	public int getSstd() {
		return sstd;
	}
	public void setSstd(int sstd) {
		this.sstd = sstd;
	}
	@Override
	public String toString() {
		return "User [sid=" + sid + ", sname=" + sname + ", sadd=" + sadd + ", smarks=" + smarks + ", ssec=" + ssec
				+ ", sstd=" + sstd + "]";
	}
	
	
}

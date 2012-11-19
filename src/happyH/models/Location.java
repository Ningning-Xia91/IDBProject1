package happyH.models;

public class Location {
	
	private String l_id;
	private String r_id;
	private String street;
	private String zipcode;
	private String area;
	
	public String getL_id() {
		return l_id;
	}
	public void setL_id(String l_id) {
		this.l_id = l_id;
	}
	public String getR_id() {
		return r_id;
	}
	public void setR_id(String r_id) {
		this.r_id = r_id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Street: " + street + "\n ");
		sb.append("Zipcode:  "+ zipcode +"\n");
		return sb.toString();
	}
	

}

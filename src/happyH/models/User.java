package happyH.models;

public class User {
	
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String ACCOUNT = "account";
	public static final String PREFERENCE_TYPE = "preference_type";
	
	private String u_id;
	private String u_account;
	private String u_password;
	private String u_name;
	private String u_email;
	private String pref_type;
	
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_account() {
		return u_account;
	}
	public void setU_account(String u_account) {
		this.u_account = u_account;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getPref_type() {
		return pref_type;
	}
	public void setPref_type(String pref_type) {
		this.pref_type = pref_type;
	}
	
	public String toJSON(){
		StringBuilder sb = new StringBuilder();
		sb.append(" " + ID + ": " + u_id + ", ");
		sb.append(" " + NAME + ": " + u_name + ", ");
		sb.append(" " + EMAIL + ": " + u_email + ",");
		sb.append(" " + PREFERENCE_TYPE + ": " + pref_type);
		return sb.toString();
	}
	
}

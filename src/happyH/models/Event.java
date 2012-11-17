package happyH.models;

public class Event {
	
	private int evt_id;
	private int r_id;
	private String evt_title;
	private String start_time;
	private String end_time;
	
	public int getEvt_id() {
		return evt_id;
	}
	public void setEvt_id(int evt_id) {
		this.evt_id = evt_id;
	}
	
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getEvt_title() {
		return evt_title;
	}
	public void setEvt_title(String evt_title) {
		this.evt_title = evt_title;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	
	

}

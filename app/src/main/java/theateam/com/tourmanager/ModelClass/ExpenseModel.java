package theateam.com.tourmanager.ModelClass;

public class ExpenseModel {
	private int ex_id;
	private int ex_profile_id;
	private int ex_event_id;
	private String ex_title;
	private double ex_amount;
	
	public ExpenseModel(int ex_id, int ex_profile_id, int ex_event_id,
			String ex_title, double ex_amount) {
		super();
		this.ex_id = ex_id;
		this.ex_profile_id = ex_profile_id;
		this.ex_event_id = ex_event_id;
		this.ex_title = ex_title;
		this.ex_amount = ex_amount;
	}
	
	public ExpenseModel(int ex_profile_id, int ex_event_id,
			String ex_title, double ex_amount) {
		super();
		this.ex_profile_id = ex_profile_id;
		this.ex_event_id = ex_event_id;
		this.ex_title = ex_title;
		this.ex_amount = ex_amount;
	}
	
	public ExpenseModel() {
		super();
	}

	public int getEx_id() {
		return ex_id;
	}

	public int getEx_profile_id() {
		return ex_profile_id;
	}

	public int getEx_event_id() {
		return ex_event_id;
	}

	public String getEx_title() {
		return ex_title;
	}

	public double getEx_amount() {
		return ex_amount;
	}

	@Override
	public String toString() {
		return "p=" + ex_profile_id + " e="+ex_event_id+ ", Amount="
				+ ex_amount ;
	}
	
	
	
	
	
	
	
}

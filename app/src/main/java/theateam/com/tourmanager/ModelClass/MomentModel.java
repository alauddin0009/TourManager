package theateam.com.tourmanager.ModelClass;

public class MomentModel {
	private int m_id;
	private int m_profile_id;
	private int m_event_id;
	private String m_name;
	private String m_description;
	private String m_time;
	private String m_image;
	
	public MomentModel(int m_id, int m_profile_id,int m_event_id, String m_name,
			String m_description, String m_time, String m_image) {
		super();
		this.m_id = m_id;
		this.m_profile_id = m_profile_id;
		this.m_event_id=m_event_id;
		this.m_name = m_name;
		this.m_description = m_description;
		this.m_time = m_time;
		this.m_image = m_image;
	}
	
	public MomentModel(int m_profile_id,int m_event_id, String m_name,
			String m_description, String m_time, String m_i) {
		super();
		this.m_profile_id = m_profile_id;
		this.m_event_id=m_event_id;
		this.m_name = m_name;
		this.m_description = m_description;
		this.m_time = m_time;
		this.m_image = m_i;
	}
	
	public MomentModel() {
		super();
	}

	public int getM_id() {
		return m_id;
	}

	public int getM_profile_id() {
		return m_profile_id;
	}

	public String getM_name() {
		return m_name;
	}

	public String getM_description() {
		return m_description;
	}

	public String getM_time() {
		return m_time;
	}

	public String getM_image() {
		return m_image;
	}
	public int getM_event_id(){
		return m_event_id;
	}

	@Override
	public String toString() {
		return "date="+ m_time+" path :"+m_image;
	}
	
	
	
	
	
	
	
}

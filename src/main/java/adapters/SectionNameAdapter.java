package adapters;


public class SectionNameAdapter{
	String section_name;
	String sid;
	public SectionNameAdapter(String sid, String section_name) {
		this.sid = sid;
		this.section_name= section_name;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SectionNameAdapter other = (SectionNameAdapter) obj;
		if (section_name == null) {
			if (other.section_name != null)
				return false;
		} else if (!section_name.equals(other.section_name))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SectionNameAdapter [section_name=" + section_name + ", sid=" + sid + "]";
	}
	public static SectionNameAdapter[] defaultSectionsSetup() {
		SectionNameAdapter[] sna = new SectionNameAdapter[6];			
		sna[0] = new SectionNameAdapter("123", "Front right");
		sna[1] = new SectionNameAdapter("124", "Front center");
		sna[2] = new SectionNameAdapter("125", "Front left");
		sna[3] = new SectionNameAdapter("126", "Main right");
		sna[4] = new SectionNameAdapter("127", "Main center");
		sna[5] = new SectionNameAdapter("128", "Main left");
		return sna;
	}
	
	
}

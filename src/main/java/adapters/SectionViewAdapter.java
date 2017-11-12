package adapters;

import seating.Section;

public class SectionViewAdapter {

	protected String sid;
	protected String section_name;
	protected RowAdapter[] seating;

	public SectionViewAdapter(Section section) {
		this.sid = section.getSid();
		this.section_name = section.getSection_name();
		this.seating = new RowAdapter[section.getRows().length];
		for (int i = 0; i < this.seating.length; i++){
			this.seating[i] = new RowAdapter(section.getRows()[i]);
		}
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
		SectionViewAdapter other = (SectionViewAdapter) obj;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SectionAdapter [sid=" + sid + "]";
	}

}
package adapters;

import java.util.Arrays;

import seating.Section;

public class SectionNumberAdapter {

	protected String sid;
	protected String section_name;
	protected RowNumberAdapter[] seating;

	public SectionNumberAdapter(Section section) {
		this.sid = section.getSid();
		this.section_name = section.getSection_name();
		this.seating = new RowNumberAdapter[section.getRows().length];
		for (int i = 0; i < this.seating.length; i++){
			this.seating[i] = new RowNumberAdapter(section.getRows()[i]);
		}
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSection_name() {
		return section_name;
	}

	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	public RowNumberAdapter[] getSeating() {
		return seating;
	}

	public void setSeating(RowNumberAdapter[] seating) {
		this.seating = seating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(seating);
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
		SectionNumberAdapter other = (SectionNumberAdapter) obj;
		if (!Arrays.equals(seating, other.seating))
			return false;
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
		return "SectionNumberAdapter [sid=" + sid + ", section_name=" + section_name + ", seating="
				+ Arrays.toString(seating) + "]";
	}

	

}
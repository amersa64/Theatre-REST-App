package adapters;

import seating.Section;

public class SectionNameAdapter extends SectionAdapter{
	String section_name;
	public SectionNameAdapter(Section section) {
		super(section);
		this.section_name= section.getSection_name();
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((section_name == null) ? 0 : section_name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SectionNameAdapter other = (SectionNameAdapter) obj;
		if (section_name == null) {
			if (other.section_name != null)
				return false;
		} else if (!section_name.equals(other.section_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SectionNameAdapter [section_name=" + section_name + "]";
	}
	

}

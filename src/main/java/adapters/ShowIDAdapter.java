package adapters;

import thalia.Show;

public class ShowIDAdapter {

	protected String wid;

	public ShowIDAdapter(Show show) {
		this.wid = show.getWid();
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wid == null) ? 0 : wid.hashCode());
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
		ShowIDAdapter other = (ShowIDAdapter) obj;
		if (wid == null) {
			if (other.wid != null)
				return false;
		} else if (!wid.equals(other.wid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShowIDAdapter [wid=" + wid + "]";
	}

	
}
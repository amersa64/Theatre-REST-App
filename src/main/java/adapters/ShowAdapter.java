package adapters;

import thalia.Show;
import thalia.ShowData;

public class ShowAdapter {

	protected String wid;
	protected ShowData show_info;

	public ShowAdapter(Show show) {
		this.wid = show.getWid();
		this.show_info= show.getShow_info();
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public ShowData getShow_info() {
		return show_info;
	}

	public void setShow_info(ShowData show_info) {
		this.show_info = show_info;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((show_info == null) ? 0 : show_info.hashCode());
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
		ShowAdapter other = (ShowAdapter) obj;
		if (show_info == null) {
			if (other.show_info != null)
				return false;
		} else if (!show_info.equals(other.show_info))
			return false;
		if (wid == null) {
			if (other.wid != null)
				return false;
		} else if (!wid.equals(other.wid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShowAdapter [wid=" + wid + ", show_info=" + show_info + "]";
	}

}
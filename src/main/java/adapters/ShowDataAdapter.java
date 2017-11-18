package adapters;

import thalia.ShowData;

public class ShowDataAdapter {
	private String name;
	private String web;
	private String date;
	private String time;
	

	public ShowDataAdapter(ShowData sd){
		int iyear = sd.getDate().getYear();
		int imonth = sd.getDate().getMonthValue();
		int iday = sd.getDate().getDayOfMonth();
		int ihour = sd.getTime().getHour();
		int iminute = sd.getTime().getMinute();
//		String year = String.valueOf(iyear);
//		String month = String.valueOf(imonth);
//		String day = String.valueOf(iday);
//		String hour = String.valueOf(ihour);
//		String minute = String.valueOf(iminute);
		String year = String.format("%04d", iyear);
		String month = String.format("%02d", imonth);
		String day = String.format("%02d", iday);
		String hour = String.format("%02d", ihour);
		String minute = String.format("%02d", iminute);
		
		
		
		this.time = (hour + ":" + minute);
		this.date = (year + "-" + month + "-" + day);
		this.name= sd.getName();
		this.web= sd.getWeb();
		
	}
	public ShowDataAdapter(String name, String web, String time, String date) {
		this.name = name;
		this.web = web;
		this.time = time;
		this.date = date;
	}
	
	
	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((web == null) ? 0 : web.hashCode());
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
		ShowDataAdapter other = (ShowDataAdapter) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (web == null) {
			if (other.web != null)
				return false;
		} else if (!web.equals(other.web))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ShowData [name=" + name + ", web=" + web + ", time=" + time + ", date=" + date + "]";
	}
	
}

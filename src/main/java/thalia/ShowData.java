package thalia;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowData {
	private String name;
	private String web;
	private LocalTime time;
	private LocalDate date;

	public ShowData(){
		this.time = LocalTime.now();
		this.date = LocalDate.now();
		this.name= "";
		this.web= "";
		
	}
	public ShowData(String name, String web, LocalTime time, LocalDate date) {
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

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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
		ShowData other = (ShowData) obj;
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
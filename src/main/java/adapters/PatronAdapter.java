package adapters;



import thalia.Patron;


public class PatronAdapter {
	String name;
	String email;
	String phone;
	String billing_address;
	String cc_number;
	String cc_expiration_date;
	
	public PatronAdapter(Patron patron) {
		this.name = patron.getName();
		this.email = patron.getEmail();
		this.phone = patron.getPhone();
		this.billing_address = patron.getBilling_address();
		this.cc_number = coverCC_number(patron.getCc_number());
		this.cc_expiration_date = patron.getCc_expiration_date();
	}
	private String coverCC_number(String cc_number){
		String oldChar = cc_number.substring(0, cc_number.length()-4);
		String res = cc_number.replace(oldChar, "xxxxxxxxxxxx");
		return res;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBilling_address() {
		return billing_address;
	}
	public void setBilling_address(String billing_address) {
		this.billing_address = billing_address;
	}
	public String getCc_number() {
		return cc_number;
	}
	public void setCc_number(String cc_number) {
		this.cc_number = cc_number;
	}
	public String getCc_expiration_date() {
		return cc_expiration_date;
	}
	public void setCc_expiration_date(String cc_expiration_date) {
		this.cc_expiration_date = cc_expiration_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getPhoneNum() {
//		return phone;
//	}
//	public void setPhoneNum(String phoneNum) {
//		this.phone = phoneNum;
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((billing_address == null) ? 0 : billing_address.hashCode());
		result = prime * result + ((cc_expiration_date == null) ? 0 : cc_expiration_date.hashCode());
		result = prime * result + ((cc_number == null) ? 0 : cc_number.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		PatronAdapter other = (PatronAdapter) obj;
		if (billing_address == null) {
			if (other.billing_address != null)
				return false;
		} else if (!billing_address.equals(other.billing_address))
			return false;
		if (cc_expiration_date == null) {
			if (other.cc_expiration_date != null)
				return false;
		} else if (!cc_expiration_date.equals(other.cc_expiration_date))
			return false;
		if (cc_number == null) {
			if (other.cc_number != null)
				return false;
		} else if (!cc_number.equals(other.cc_number))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Patron [name=" + name + ", email=" + email + ", phone=" + phone + ", billing_address=" + billing_address
				+ ", cc_number=" + cc_number + ", cc_expiration_date=" + cc_expiration_date + "]";
	}



}

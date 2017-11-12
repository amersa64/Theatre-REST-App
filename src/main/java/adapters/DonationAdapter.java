//Used to print out the donation ID
package adapters;

import thalia.Donation;

public class DonationAdapter {

	protected String did;

	public DonationAdapter(Donation donation) {
		this.did = donation.getDid();
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((did == null) ? 0 : did.hashCode());
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
		DonationAdapter other = (DonationAdapter) obj;
		if (did == null) {
			if (other.did != null)
				return false;
		} else if (!did.equals(other.did))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DonationAdapter [did=" + did + "]";
	}
	
	

}
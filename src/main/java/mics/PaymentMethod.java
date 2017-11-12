package mics;

import java.time.LocalDate;

public class PaymentMethod {
	long creditCardNum;
	LocalDate Date;
	String nameOnCard;
	
	public PaymentMethod(long creditCardNum, LocalDate date, String nameOnCard) {
		super();
		this.creditCardNum = creditCardNum;
		Date = date;
		this.nameOnCard = nameOnCard;
	}
	public long getCreditCardNum() {
		return creditCardNum;
	}
	public void setCreditCardNum(long creditCardNum) {
		this.creditCardNum = creditCardNum;
	}
	public LocalDate getDate() {
		return Date;
	}
	public void setDate(LocalDate date) {
		Date = date;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Date == null) ? 0 : Date.hashCode());
		result = prime * result + (int) (creditCardNum ^ (creditCardNum >>> 32));
		result = prime * result + ((nameOnCard == null) ? 0 : nameOnCard.hashCode());
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
		PaymentMethod other = (PaymentMethod) obj;
		if (Date == null) {
			if (other.Date != null)
				return false;
		} else if (!Date.equals(other.Date))
			return false;
		if (creditCardNum != other.creditCardNum)
			return false;
		if (nameOnCard == null) {
			if (other.nameOnCard != null)
				return false;
		} else if (!nameOnCard.equals(other.nameOnCard))
			return false;
		return true;
	}
	

}

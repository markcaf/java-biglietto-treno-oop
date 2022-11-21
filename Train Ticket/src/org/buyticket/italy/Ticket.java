package org.buyticket.italy;

import java.math.BigDecimal;

public class Ticket {
	
	private int userKm;
	private int userAge;
	
	private static final BigDecimal PRICE_FOR_KM = new BigDecimal(0.21);
    private static final BigDecimal OVER_65_DISCOUNT = new BigDecimal(0.6);
    private static final BigDecimal UNDERAGE_DISCOUNT = new BigDecimal(0.8);
	
	public Ticket (int userKm, int userAge) throws Exception {
		isValidKm(userKm);
		isValidAge(userAge);
	}

	public int getUserKm() {
		return userKm;
	}

	public void setUserKm(int userKm) {
		this.userKm = userKm;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public void isValidKm(int km) throws Exception{
		if (km < 0) {
			throw new Exception("Il numero di Km deve essere positivo");
		} else {
			this.userKm = km;
		}
	}
	
	public void isValidAge(int age) throws Exception{
		if (age <= 0) {
			throw new Exception("L'età deve essere superiore a 0");
		}
	}

}

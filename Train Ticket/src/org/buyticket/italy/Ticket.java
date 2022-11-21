package org.buyticket.italy;

import java.math.BigDecimal;
import java.text.Format;

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
			throw new Exception("The number of km must be positive");
		} else {
			this.userKm = km;
		}
	}
	
	public void isValidAge(int age) throws Exception{
		if (age <= 0) {
			throw new Exception("Age must be greater than 0");
		} else {
			this.userAge = age;
		}
	}

	public static BigDecimal getPriceForKm() {
		return PRICE_FOR_KM;
	}

	public static BigDecimal getOver65Discount() {
		return OVER_65_DISCOUNT;
	}

	public static BigDecimal getUnderageDiscount() {
		return UNDERAGE_DISCOUNT;
	}
	
	private BigDecimal calculateDiscount() {
        if(userAge < 18) {
            return UNDERAGE_DISCOUNT.multiply(PRICE_FOR_KM);
        } else if(userAge > 65) {
            return OVER_65_DISCOUNT.multiply(PRICE_FOR_KM);
        } else {
            return PRICE_FOR_KM;
        }
    }
	
	public BigDecimal getTicketPrice() {
        return calculateDiscount().multiply(BigDecimal.valueOf(userKm));
    }
	
	public String getTicketPriceFormatted() {
    	double priceToDouble = getTicketPrice().doubleValue();
        return String.format("%.2f", priceToDouble);
    }

	@Override
	public String toString() {
		return "Km: " + getUserKm()
		+ "\nAge: " + getUserAge()
        + "\nPrice: €" + getTicketPriceFormatted();
	}
	

}

package org.buyticket.italy;

import java.util.Scanner;

public class Biglietteria {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of km to travel: ");
		int userKm = sc.nextInt();
		
		System.out.print("Enter the age of the passenger: ");
		int userAge = sc.nextInt();
		
		sc.close();
		System.out.println("--------------");
		
		Ticket userTicket = null;
		try {
			userTicket = new Ticket(userKm, userAge);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} finally {
			System.out.println(userTicket);
		}

	}

}

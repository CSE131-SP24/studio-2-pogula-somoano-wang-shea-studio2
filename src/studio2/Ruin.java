package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.print("What is your start amount? ");
		double startAmount = in.nextDouble();
		
		System.out.print("What is your win chance? ");
		double winChance = in.nextDouble();
		
		System.out.print("What is your win limit? ");
		double winLimit = in.nextDouble();
		
		System.out.print("What is your total simulations? ");
		int totSims = in.nextInt();
		
		double random;
		int ruins = 0;
	

		for(int x = 0; x < totSims; x++) {
			int count = 0;
			int wins = 0;
			
			System.out.println("Day " + (x+1));
			
			while(startAmount > 0 && wins < winLimit) {
				random = Math.random();
				
				if(random < winChance) {
					startAmount++;
					count++;
					wins++;
				}
				else {
					startAmount--;
					count++;
				}
			}
			
			System.out.println("total plays: " + count);
			
			if(startAmount == 0) {
				System.out.println("ruin");
				ruins++;
			}
			else {
				System.out.println("success");
			}
		

		

	}
		double estRuins = ruins/totSims;
		
		double expRuins;
		double alpha = (1-winChance)/winChance;
		if(winChance == 0.5) {
			expRuins  = 1- (startAmount/winLimit);
		}
		
		else {
			expRuins = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit))/(1-Math.pow(alpha,  winLimit));
		}
		
		System.out.println("Estimated Ruins: " + estRuins);
		System.out.println("Expected Ruins: " + expRuins);
		
	}
	}


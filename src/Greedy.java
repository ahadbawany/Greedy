
import java.util.*;
/* Name of the class has to be "Main" only if the class is public. */

import Exceptions.ChangeException;
import Exceptions.NegativeCostException;
import Exceptions.PayupException;

class Greedy
{
	
	
	public static void main (String[] args) throws PayupException, ChangeException, NegativeCostException {
	double change; //The value of the change
	
//**********************************COIN VALUES!***********************************************************************************
	final double Q = 25; //Value of Quarter
	final double D = 10; //^	  ^  Dime
	final double N = 05; //^	  ^  Nickel
	final double P = 01; //^	  ^  Penny
//**********************************COIN COUNTERS!**********************************************************************************
	int q=0; //Counter of Quarter
	int d=0; //^	   ^  Dime
	int n=0; //^	   ^  Nickel
	int p=0; //^	   ^  Penny
//*********************************SCANNER!*****************************************************************************************
	Scanner s = new Scanner(System.in);
	
	
		System.out.println("Enter Cost in Dollars. ");

		double cost = s.nextDouble();
		if (cost < 0){
			s.close();
			throw new NegativeCostException("Your product needs to cost a positive value!");
		}

		System.out.println("Enter Amount paid in Dollars. ");

		double amount =s.nextDouble();
		if (amount >= cost){
			System.out.println("The Cost is $"+ cost );
		}
		
		else if (amount < cost){
			s.close();
			throw new PayupException("That isn't enough money, Payup!"); //Throw an Exception if your cost is greater than payment
		}

		System.out.println("The Amount Paid is $"+ amount );
		if (amount - cost < 0.01 && (amount - cost) != 0 ){
			s.close();
			throw new ChangeException("The value of your change needs to exceed $0.01!"); //Throw an Exception if your Change < Penny
		} 
		
		change = (int)((amount*100) - (cost*100)); //Convert to cents in order to make calculations possible. 
												   // This is used to avoid floating point errors.

		System.out.println("The value of the change is "+ change + " Cents");

		while(change > 0 ){

		    if(change >= Q){

		        change-=Q;
		        q++;

		    } else if (change >= D && change < Q){

		        change-=D;
		        d++;

		    } else if (change >=N && change < D){

		        change-=N;
		        n++;

		    } else if (change >=P && change < N){

		        change-=P;
		        p++;

		    }

		} if (change == 0){
			s.close();
			System.out.println("Your Change is " + q +" Quarters, "+d+" Dimes, "+n+" Nickles, and "+p+" Pennies.");

		}
		} 
	

}

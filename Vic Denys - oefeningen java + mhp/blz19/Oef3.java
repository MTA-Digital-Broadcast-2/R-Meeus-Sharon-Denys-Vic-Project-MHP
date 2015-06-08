import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class Oef3 {

	/**
	* Dit is een main-functie. hier start het programma
	* @param args Dit is een array van string waarmee parameters kunnen meegegeven worden.
	*/

	public static void main(String args[])
	{
		drukPIAf();
	}
	
	/**
	* print PI uit
	*/

	private static void drukPIAf()
	{
		int teller;
		int noemer = 1; 
		double som = 0;
		for(teller=0; teller<5000; teller++){
			som+=(1.0/noemer);
			noemer+=4;
		}
		noemer = 3;
		for(teller=0; teller<5000; teller++){
			som-=(1.0/noemer);
			noemer+=4;
		}
		som*=4;
		System.out.println("PI = " + som);
	}
}	
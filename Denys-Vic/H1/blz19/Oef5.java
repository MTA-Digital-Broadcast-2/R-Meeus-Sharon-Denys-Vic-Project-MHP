import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class Oef5 {

	/**
	* Dit is een main-functie. hier start het programma
	* @param args Dit is een array van string waarmee parameters kunnen meegegeven worden.
	*/

	public static void main(String args[])
	{
		drukAf();
	}
	
	/**
	* Vind Priemgetallen
	*/

	private static void drukAf()
	{
		int getal;
		float getal2;
		for(getal = 3; getal<100; getal++){
			if(isPrime(getal)){
				System.out.println(getal);
			}
		}
	}
	
	private static boolean isPrime(int n){
		for(int i=2;i<n;i++) {
        	if(n%i==0)
            	return false;
			}
		return true;
	}
}	
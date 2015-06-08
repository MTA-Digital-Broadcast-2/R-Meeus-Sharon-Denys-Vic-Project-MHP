import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class Oef1 {

	/**
	* Dit is een main-functie. hier start het programma
	* @param args Dit is een array van string waarmee parameters kunnen meegegeven worden.
	*/

	public static void main(String args[])
	{
		drukTafelsAf();
	}
	
	/**
	* print maaltafels uit.
	*/

	private static void drukTafelsAf()
	{
		int i; 
		int uitkomst;
		for(i=1; i<10; i++){
			int k; 
			for(k=1; k<10; k++){
				uitkomst = i * k;
				System.out.println(i + " x " + k + " = " + uitkomst);
			}
		}
	}
}	
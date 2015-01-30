import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class Oef6 {

	/**
	* Dit is een main-functie. hier start het programma
	* @param args Dit is een array van string waarmee parameters kunnen meegegeven worden.
	*/

	public static void main(String args[])
	{
		zoekGrootste();
	}
	
	/**
	* Vind Priemgetallen
	*/

	private static void zoekGrootste()
	{
		int a[] = {12,34,56,78,123,234,99,88};
		int huidigGetal = 0;
		int grootsteGetal = 0;
		for(int x = 0; x < 8; x++){
			huidigGetal = a[x];
			if (huidigGetal > grootsteGetal){
				grootsteGetal = huidigGetal;
			}
		}
		
		System.out.println(grootsteGetal);
	}
	
}	
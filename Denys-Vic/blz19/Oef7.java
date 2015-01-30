import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class Oef7 {

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
		int b[] = new int[8];
		int huidigGetal = 0;
		int grootsteGetal = 0;
		int indexGrootste = 0;
		for(int y = 0; y < a.length; y++){
			for(int x = 0; x < a.length; x++){
				huidigGetal = a[x];
				if (huidigGetal > grootsteGetal){
					grootsteGetal = huidigGetal;
					indexGrootste = x;
				}
			}
			b[y] = grootsteGetal;
			a[indexGrootste] = 0;
			
			indexGrootste = 0;
			grootsteGetal = 0;
		}
		
		
		
		
		for( int p = 0; p < b.length; p++){
			System.out.println(b[p]);
		}
	}
	
}	
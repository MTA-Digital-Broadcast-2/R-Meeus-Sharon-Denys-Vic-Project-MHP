import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class EersteProg {

	/**
	* Dit is een main-functie. hier start het programma
	* @param args Dit is een array van string waarmee parameters kunnen meegegeven worden.
	*/

	public static void main(String args[])
	{
		drukAf(100);
	}
	
	/**
	* Dit is de drukAf-functie.
	* Drukt de intigers af vanaf 0 tot de meegegeven intiger
	*/

	private static void drukAf(int m)
	{
		int a;
		for (a = 0; a<m; a++)
			{
				System.out.println(a);
			}
	}
}	

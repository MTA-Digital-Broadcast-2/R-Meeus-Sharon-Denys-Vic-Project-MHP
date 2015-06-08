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
		drukAf();
	}
	
	/**
	* Dit is de drukAf-functie.
	* is een vervanging voor:
	*	for (i=55;i>34;i--)
	*		{
	*			System.out.println(i);
	*		}
	*/

	private static void drukAf()
	{
		int i = 55;
		while (i>34){
			System.out.println(i);
			i--;
		}
	}
}	
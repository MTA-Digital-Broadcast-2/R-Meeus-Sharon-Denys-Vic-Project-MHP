import java.lang.*;
/** 
* De klasse EersteProg is een Java applicatie
*
* @author Sharon Meeus
* @version 1.5 
*/


public class EersteProg
{
	/**
	* Dit is een main-functie, hier start het programme
	* @param args Dit is een array van strings waarmee parameters
	kunnen meegegeven worden vanaf de commandline.
	*/
	public static void main(String args[])
	{
		drukaf(100);
	}
	
	/** 
	* Dit is een public methode die getallen afdrukt
	*/
	public static void drukaf(int m)
	{
		int a;
		for (a=0; a<m; a++)
		{
			System.out.println(a);
		}
	}
}
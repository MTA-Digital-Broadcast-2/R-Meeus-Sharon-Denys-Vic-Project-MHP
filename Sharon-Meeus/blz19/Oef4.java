import java.lang.*;
/** 
* De klasse EersteProg is een Java applicatie
*
* @author Sharon Meeus
* @version 1.5 
*/


public class Oef4
{
	/**
	* Dit is een main-functie, hier start het programme
	* @param args Dit is een array van strings waarmee parameters
	kunnen meegegeven worden vanaf de commandline.
	*/
	public static void main(String args[])
	{
		drukaf();
	}
	
	private static void drukaf()
	{
		int a = 4302;
		int b = ~a + 1;

		System.out.println(b);
		
	}
}
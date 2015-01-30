import java.lang.*;
/** 
* De klasse EersteProg is een Java applicatie
*
* @author Sharon Meeus
* @version 1.5 
*/


public class Oef2
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
	/** 
	* Deze methode toont de negen tafels van vermenigvuldiging
	*/
	private static void drukaf()
	{
		int weekdag = 1;
		for(int dag=1; dag<29; dag++)
		{
			if (weekdag == 1)
			{
				System.out.print("zondag");
			}
			if (weekdag == 2)
			{
				System.out.print("maandag");
			}	
			if (weekdag == 3)
			{
				System.out.print("dinsdag");
			}
			if (weekdag == 4)
			{
				System.out.print("woensdag");
			}
			if (weekdag == 5)
			{
				System.out.print("donderdag");
			}
			if (weekdag == 6)
			{
				System.out.print("vrijdag");
			}
			if (weekdag == 7)
			{
				System.out.print("zaterdag");
			}

			weekdag++;
			if(weekdag > 7)
			{
				weekdag = 1;
			}

			System.out.print(" " + dag + "februari 2009\n");
		}
	}
}
import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @autthor Vic Denys
*
* @version 1.5
*/

public class Oef2 {

	/**
	* Dit is een main-functie. hier start het programma
	* @param args Dit is een array van string waarmee parameters kunnen meegegeven worden.
	*/

	public static void main(String args[])
	{
		printDag();
	}
	
	/**
	* Deze functie print de dagen van februari 2009 uit.
	* 
	*/

	private static void printDag()
	{
		int weekdag=1;
		int dag;
		for(dag = 1; dag<29;dag++){
			if (weekdag==1){
				System.out.print("zondag");
			}
			if (weekdag==2){
				System.out.print("maandag");
			}
			if (weekdag==3){
				System.out.print("dinsdag");
			}
			if (weekdag==4){
				System.out.print("woensdag");
			}
			if (weekdag==5){
				System.out.print("donderdag");
			}
			if (weekdag==6){
				System.out.print("vrijdag");
			}
			if (weekdag==7){
				System.out.print("zaterdag");
			}
			
			weekdag++;
			if (weekdag>7){
				weekdag = 1;
			}
			
			System.out.print(" " + dag + "februari 2009\n");
		}
	}
}
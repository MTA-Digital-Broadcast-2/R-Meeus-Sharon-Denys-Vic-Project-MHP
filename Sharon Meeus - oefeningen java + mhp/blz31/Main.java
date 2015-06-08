import java.lang.*;
/** 
* De klasse EersteProg is een Java applicatie
*
* @author Sharon Meeus
* @version 1.5 
*/

Public class main
{
	public static void main(String args[])
	{
		// OEF1
		Werknemer Herman = new Werknemer(Herman, Michielsen, 1, 1500.0F);
		Werknemer Jan = new Werknemer(Jan, Sterkx, 2, 2000.0F);
		Werknemer Johan = new Werknemer(Johan, Geboes, 3, 2000.0F);
		Werknemer Steven = new Werknemer(Steven, Cassiers, 4, 1500.0F);
		
		// OEF2
		Herman.salarisVerhogen(10);

		System.Out.println(Herman.getSalaris());
		System.Out.println(Jan.getSalaris());
		System.Out.println(Johan.getSalaris());
		System.Out.println(Steven.getSalaris());

		// OEF3
		PartTimeWerknemer Tim = new PartTimeWerknemer(Tim, Verachtert, 10, 800.0F, 40);
		PartTimeWerknemer Jonas = new PartTimeWerknemer(Jonas, De Mey, 11, 800.0F, 40);
		
		// OEF4
		Tim.salarisVerhogen(10);

		System.Out.println(Tim.getSalaris());
		System.Out.println(Jan.getSalaris());

		// OEF5 (zie werknemer klasse)
		
		// OEF6
		System.Out.println(Herman.setRSZ(0.25F));
		System.Out.println(Herman.getRSZ());
		System.Out.println(Tim.setRSZ(0.35F));
		System.Out.println(Tim.getRSZ());
		
		//OEF7
		StudentWerknemer Andy = new StudentWerknemer(Andy, Sels, 20, 500.0F, 40);
		System.Out.println(Andy.getRSZ());
		
	
		
		 
		

	}
}

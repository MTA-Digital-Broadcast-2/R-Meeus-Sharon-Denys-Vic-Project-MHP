public class StudentWerknemer extends PartTimeWerknemer{
	
	public StudentWerknemer ( String voornaam, String achternaam, int nr, float sal, int urengw){
		super(voornaam, achternaam, nr, sal, urengw) ;
		RSZpercentage = 0.5F;
	}
	
}
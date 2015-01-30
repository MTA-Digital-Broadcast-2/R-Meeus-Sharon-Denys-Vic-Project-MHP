public class werknemer 
{
	public string voornaam;
	public string achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage;
	

	public werknemer (string voornaam, string achternaam, int wNummer, float salaris)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		werknemerNummer = wNummer;
		this.salaris = salaris;
		RSZpercentage = 0.33F;
	}

	public void salarisVerhogen(int percentage)
	{
		float verhogingsfactor = (float)percentage/100;
		salaris += salaris*verhogingsfactor
	}

	public float getSalaris()
	{
		return salaris;
	}

	public void setRSZ(float RSZ)
	{
		RSZpercentage = RSZ;
	}

	public float getRSZ()
	{
		return RSZpercentage;
	}


}
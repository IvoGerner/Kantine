package nl.hanze.kantine;

public class Datum {

	private int dag;
	private int maand;
	private int jaar;

	  /**
	   * Constructor
	   */
  	public Datum(int dag, int maand, int jaar){
  		this();
		if (bestaatDatum(dag, maand, jaar)){
			this.dag = dag;
			this.maand = maand;
			this.jaar = jaar;
		}
	}

	public Datum(){
  		dag = 0;
  		maand = 0;
  		jaar = 0;
	}
	
	public boolean bestaatDatum(int dag, int maand, int jaar){
		if (dag >= 1 && dag <= 31 && maand >= 1 && maand <= 12 && jaar >= 1900 && jaar <= 2100) {
			if ((maand == 2 && dag <= getDagenFebruari(jaar)) || (maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12 && dag <= 31) || (maand == 4 || maand == 6 || maand == 9 || maand == 11 && dag <= 30)){
//				System.out.println(dag+"/"+maand+"/"+jaar+" bestaat");
				return true;
			}
		}
//		System.out.println(dag+"/"+maand+"/"+jaar+" bestaat niet");
		return false;
	}

	public int getDagenFebruari(int jaar) {
		if (jaar % 4 == 0 && !(jaar % 100 == 0) || jaar % 400 == 0){
//			System.out.println(jaar+": true");
			return 29;
		}
//		System.out.println(jaar+": false");
		return 28;
	}
	/**
	 * Getter voor Sting weergave van datum
	 * @return Geboortedatum
	 */
	public String getDatumAsString() {
		return getDag()+"/"+getMaand()+"/"+getJaar();
	}

	public int getDag() {
		return dag;
	}

	public void setDag(int dag) {
		this.dag = dag;
	}

	public int getMaand() {
		return maand;
	}

	public void setMaand(int maand) {
		this.maand = maand;
	}

	public int getJaar() {
		return jaar;
	}

	public void setJaar(int jaar) {
		this.jaar = jaar;
	}
}

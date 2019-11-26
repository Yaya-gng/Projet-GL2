package Model;

import java.sql.Date;

public class Formation {
	
	protected int numF,id;
	protected String nomF;
	protected Date dateC;
	
	public Formation(int numF, String nomF, Date dateC, int id) {
		
		this.numF = numF;
		this.nomF = nomF;
		this.dateC = dateC;
		this.id = id;
	}
	
	
	
	

}

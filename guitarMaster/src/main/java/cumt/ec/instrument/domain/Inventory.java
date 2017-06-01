package cumt.ec.instrument.domain;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Guitar> guitars;
	

	  public List<Guitar> getGuitars() {
		return guitars;
	}

	public void setGuitars(List<Guitar> guitars) {
		this.guitars = guitars;
	}

	public Inventory() {
	    guitars = new LinkedList<Guitar>();
	  }

	  public void addGuitar(String serialNumber,
	                        GuitarSpec spec) {
	    Guitar guitar = new Guitar(serialNumber, spec);
	    guitars.add(guitar);
	  }

	  public List<Guitar> search(GuitarSpec searchSpec) {
		    List<Guitar> matchingGuitars = new LinkedList<Guitar>();
		    for (Iterator<Guitar> i = guitars.iterator(); i.hasNext(); ) {
		      Guitar guitar = (Guitar)i.next();
		      if (guitar.getSpec().matches(searchSpec))
		        matchingGuitars.add(guitar);
		    }
		    return matchingGuitars;
		  }
}






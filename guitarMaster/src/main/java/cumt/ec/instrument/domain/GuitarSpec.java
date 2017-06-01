package cumt.ec.instrument.domain;

public class GuitarSpec {
	 
	  private String builder; 
	  private String model;
	  private String numStrings;
	  private String backWood;
	  private String topWood;

	  public GuitarSpec(String builder, String model,
			  String numStrings, String backWood, String topWood) {
	    this.builder = builder;
	    this.model = model;
	    this.numStrings = numStrings;
	    this.backWood = backWood;
	    this.topWood = topWood;
	  }

	 
	  public String getBuilder() {
		return builder;
	}


	public void setBuilder(String builder) {
		this.builder = builder;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public String getNumStrings() {
		return numStrings;
	}


	public void setNumStrings(String numStrings) {
		this.numStrings = numStrings;
	}


	public String getBackWood() {
		return backWood;
	}


	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}


	public String getTopWood() {
		return topWood;
	}


	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}


	public boolean matches(GuitarSpec otherSpec) {
		if(!builder.equalsIgnoreCase(otherSpec.getBuilder()) && otherSpec.getBuilder().length() > 0){
			return false;
		}else if(!model.equalsIgnoreCase(otherSpec.getModel()) && otherSpec.getModel().length() > 0){
			return false;
		}else if(!numStrings.equalsIgnoreCase(otherSpec.getNumStrings()) && otherSpec.getNumStrings().length() > 0){
			return false;
		}else if(!backWood.equalsIgnoreCase(otherSpec.getBackWood()) && otherSpec.getBackWood().length() > 0){
			return false;
		}else if(!topWood.equalsIgnoreCase(otherSpec.getTopWood()) && otherSpec.getTopWood().length() > 0){
			return false;
		}
		return true;
		
	}
	}


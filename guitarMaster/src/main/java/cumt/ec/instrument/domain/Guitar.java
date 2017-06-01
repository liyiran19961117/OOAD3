package cumt.ec.instrument.domain;


public class Guitar implements java.io.Serializable{
	
	 private String serialNumber;
	  GuitarSpec spec;

	  public Guitar(String serialNumber, GuitarSpec spec) {
	    this.serialNumber = serialNumber;
	    this.spec = spec;
	  }
	  
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public GuitarSpec getSpec() {
		return spec;
	}

	public void setSpec(GuitarSpec spec) {
		this.spec = spec;
	}

//	public boolean matches(Guitar otherSpec) {
//		if(!builder.equalsIgnoreCase(otherSpec.getBuilder()) && otherSpec.getBuilder().length() > 0){
//			return false;
//		}else if(!model.equalsIgnoreCase(otherSpec.getModel()) && otherSpec.getModel().length() > 0){
//			return false;
//		}else if(!numStrings.equalsIgnoreCase(otherSpec.getNumStrings()) && otherSpec.getNumStrings().length() > 0){
//			return false;
//		}else if(!backWood.equalsIgnoreCase(otherSpec.getBackWood()) && otherSpec.getBackWood().length() > 0){
//			return false;
//		}else if(!topWood.equalsIgnoreCase(otherSpec.getTopWood()) && otherSpec.getTopWood().length() > 0){
//			return false;
//		}
//		return true;
//
//	  }
	 
	}

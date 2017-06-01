package cumt.ec.instrument.service;
import cumt.ec.instrument.domain.GuitarSpec;
import net.sf.json.JSONArray;

public interface GuitarService {
	public JSONArray searchGuitar(GuitarSpec spec);
	public void addGuitar(String serialNumber,GuitarSpec spec);
	public void deleteGuitar(String serialNumber);
	public JSONArray getAllGuitar();
}

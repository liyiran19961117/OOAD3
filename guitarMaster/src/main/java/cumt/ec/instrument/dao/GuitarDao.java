package cumt.ec.instrument.dao;

import java.util.List;

import cumt.ec.instrument.domain.Guitar;
import cumt.ec.instrument.domain.GuitarSpec;


public interface GuitarDao {
	public List<Guitar> getAllGuitar();
	public void addGuitar(String serialNumber,GuitarSpec spec);
	public void deleteGuitar(String serialNumber);

}

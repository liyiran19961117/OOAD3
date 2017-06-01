package cumt.ec.instrument.serviceImpl;

import cumt.ec.instrument.service.GuitarService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import cumt.ec.instrument.dao.*;
import cumt.ec.instrument.domain.Guitar;
import cumt.ec.instrument.domain.GuitarSpec;
import cumt.ec.instrument.domain.Inventory;

public class GuitarServiceImpl implements GuitarService {
		private GuitarDao guitarDao=DataAccess.createGuitarDao();
	@Override
	public JSONArray searchGuitar(GuitarSpec spec) { 
		 List<Guitar> guitars=(List<Guitar>)guitarDao.getAllGuitar();
		 Inventory inv=new Inventory();
		 inv.setGuitars(guitars);
		 List<Guitar> matchingGuitars = inv.search(spec);
		  JSONArray array=new JSONArray();
		  for(Guitar guitar:matchingGuitars){
			  JSONObject jo=new JSONObject();
			  jo.put("serialNumber", guitar.getSerialNumber());
			  jo.put("topWood", guitar.getSpec().getTopWood());
			  jo.put("backWood", guitar.getSpec().getBackWood());
			  jo.put("numStrings", guitar.getSpec().getNumStrings());
			  jo.put("model", guitar.getSpec().getModel());
			  jo.put("builder", guitar.getSpec().getBuilder());
			  array.add(jo);
		  }
		 return array; 
	}
	@Override
	public void addGuitar(String serialNumber, GuitarSpec spec) {
		guitarDao.addGuitar(serialNumber, spec);
		
	}
	@Override
	public void deleteGuitar(String serialNumber) {
		guitarDao.deleteGuitar(serialNumber);
		
	}
	@Override
	public JSONArray getAllGuitar() {
		 List<Guitar> guitars=(List<Guitar>)guitarDao.getAllGuitar();
		 JSONArray array=new JSONArray();
		 for(Guitar guitar:guitars){
			  JSONObject jo=new JSONObject();
			  jo.put("serialNumber", guitar.getSerialNumber());
			  jo.put("topWood", guitar.getSpec().getTopWood());
			  jo.put("backWood", guitar.getSpec().getBackWood());
			  jo.put("numStrings", guitar.getSpec().getNumStrings());
			  jo.put("model", guitar.getSpec().getModel());
			  jo.put("builder", guitar.getSpec().getBuilder());
			  array.add(jo);
		  }
		 return array; 
	}
	}


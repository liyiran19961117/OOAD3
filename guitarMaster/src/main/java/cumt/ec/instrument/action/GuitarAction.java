package cumt.ec.instrument.action;

import com.opensymphony.xwork2.ActionSupport;
import cumt.ec.instrument.domain.GuitarSpec;
import cumt.ec.instrument.service.*;
import cumt.ec.instrument.serviceImpl.GuitarServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GuitarAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String serialNumber;
	private String numStrings;
	private String builder;
	private String model;
	private String type;
	private String backWood;
	private String topWood;
	private JSONArray jsonArray;
	private JSONObject jsonObject=new JSONObject();
	private GuitarService guitarService=new GuitarServiceImpl();
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	public String getNumStrings() {
		return numStrings;
	}
	public void setNumStrings(String numStrings) {
		this.numStrings = numStrings;
	}
	public JSONArray getJsonArray() {
		return jsonArray;
	}
	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}
	public String getAllGuitar(){
		jsonArray=guitarService.getAllGuitar();
		return "jsonArray";
	}
	
	public JSONObject getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	public String searchGuitar(){
		GuitarSpec spec=new GuitarSpec(builder, model, numStrings, topWood, backWood);
		jsonArray=guitarService.searchGuitar(spec);
			return "jsonArray";
	}
	public String addGuitar(){
		jsonObject.put("status", "ok");
		GuitarSpec spec=new GuitarSpec(builder,model,numStrings,topWood,backWood);
		try{
			guitarService.addGuitar(serialNumber,spec);
		}catch(Exception e){
			jsonObject.put("status", "nook");
			e.printStackTrace();
		}
		return "jsonObject";
	}
	public String deleteGuitar(){
		jsonObject.put("status","ok");
		try{
			guitarService.deleteGuitar(serialNumber);
		}catch(Exception e){
			jsonObject.put("status","nook");
		}
		return "jsonObject";
	}
}

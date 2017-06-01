package cumt.ec.instrument.sqliteDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import cumt.ec.util.*;
import cumt.ec.instrument.dao.GuitarDao;
import net.sf.json.JSONArray;
import cumt.ec.instrument.domain.Guitar;
import cumt.ec.instrument.domain.GuitarSpec;
import net.sf.json.JSONObject;

public class GuitarDaoImpl implements GuitarDao {
	private Connection connection = null; // �������ӵĶ���
	private PreparedStatement ps = null; // ����Ԥ׼���Ķ���
	private JDBConnection jdbc = null;  // �������ݿ����Ӷ���
	public  GuitarDaoImpl(){
		jdbc = new JDBConnection();
		connection = jdbc.connection; // ���ù��췽��ȡ�����ݿ�����
	}
	@SuppressWarnings({ })
	public List<Guitar> getAllGuitar( ){
		    List<Guitar> guitars=new ArrayList<Guitar>();
			String sql = "select * from inventory ";
			try {
				ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Guitar guitar=new Guitar(null, null);
					guitar.setSerialNumber(rs.getString(1));
					GuitarSpec spec=new GuitarSpec(null, null, null, null, null);
					spec.setBuilder(rs.getString(2));
					spec.setModel(rs.getString(3));
					spec.setNumStrings(rs.getString(4));
					spec.setBackWood(rs.getString(5));
					spec.setTopWood(rs.getString(6));
					guitar.setSpec(spec);
					guitars.add(guitar);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		return  guitars;
	} 
	@Override
	public void addGuitar(String serialNumber, GuitarSpec spec) {
		String sql="insert into inventory values('"+serialNumber+"','"+spec.getBuilder()+"','"+spec.getModel()+"','"+spec.getNumStrings()+"','"+spec.getBackWood()+"','"+spec.getTopWood()+"');";
		try{
			ps = connection.prepareStatement(sql);
			ps.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		
		
	}
	@Override
	public void deleteGuitar(String serialNumber) {
		String sql="delete from inventory  where serialNumber='"+serialNumber+"'";
		try{
			ps = connection.prepareStatement(sql);
			ps.executeUpdate();
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
	
}

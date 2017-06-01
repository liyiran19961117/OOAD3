package cumt.ec.instrument.dao;

import cumt.ec.instrument.sqliteDao.GuitarDaoImpl;

public class DataAccess {
	private static String daoName="sqliteDao";
	public static GuitarDao createGuitarDao(){
		GuitarDao result=null;
		try{
			Object o=Class.forName("cumt.ec.instrument."+daoName+"."+"GuitarDaoImpl").newInstance();
			result=(GuitarDaoImpl)o;
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

}

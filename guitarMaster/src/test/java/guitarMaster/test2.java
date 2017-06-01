package guitarMaster;

import java.util.List;

import cumt.ec.instrument.dao.DataAccess;
import cumt.ec.instrument.dao.GuitarDao;
import cumt.ec.instrument.domain.Guitar;

public class test2 {
	public static void main(String[] args) {
		GuitarDao guitarDao=DataAccess.createGuitarDao();
		List<Guitar> guitars=(List<Guitar>)guitarDao.getAllGuitar();
		for(Guitar guitar:guitars){
			System.out.println(guitar.getSerialNumber());
		}
	}

}

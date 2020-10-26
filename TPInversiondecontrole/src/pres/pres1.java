package pres;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dao.DaoImpl;
import dao.IDao;
import metier.IMetier;
import metier.Metier;

public class pres1 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, FileNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		/* 1
		 * on utilise l'injection de dependences et l'instantiation statique(utilise new )
		 */
	/*DaoImpl dao = new DaoImpl();
    Metier m=new Metier();
    m.setDao(dao);
    System.out.println(m.calcule());
    */
		
		// 1 equvalente a 2 
		//2 
		// voila l'nstanciation dynamique 
			Scanner scanner= new Scanner(new File("config.txt"));
			String daoClassName=scanner.nextLine();
			
			Class cDao=Class.forName(daoClassName);
			IDao o =(IDao) cDao.newInstance(); 
			
			String metierClassName=scanner.nextLine();
			Class cMetier=Class.forName(metierClassName);
			IMetier metier=(IMetier) cMetier.newInstance();
			
			Method m=cMetier.getMethod("setDao", IDao.class);
		    m.invoke(metier, o);
		    System.out.println(metier.calcule());
	}
		

}

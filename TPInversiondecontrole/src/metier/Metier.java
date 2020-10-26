package metier;

import dao.IDao;

public class Metier implements IMetier {
	 /*
     * coublage faible 
     */
	private IDao dao;
	
	@Override
	public double calcule() {
		double d=dao.getData();
		double res=d*23;
		return res;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

}

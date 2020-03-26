package belajar.spring.ioc;

public class DemoIoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* constructor injection */
		KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
		koneksiDatabase.setUrl("jdbc:postgresql://localhost/bank");
		koneksiDatabase.setUsername("postgres");
		koneksiDatabase.setPassword("postgres"); 
		NasabahDaoIoc nd = new NasabahDaoIoc(koneksiDatabase);

		/* setter injection
		KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
		koneksiDatabase.setUrl("jdbc:postgresql://localhost/bank");
		koneksiDatabase.setUsername("postgres");
		koneksiDatabase.setPassword("postgres"); */
		
		// setter injection
		// nd.setKoneksiDatabase(koneksiDatabase);
		nd.simpan();
	}

}

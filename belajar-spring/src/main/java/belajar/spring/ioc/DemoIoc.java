package belajar.spring.ioc;

public class DemoIoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NasabahDaoIoc nd = new NasabahDaoIoc();

		KoneksiDatabase koneksiDatabase = new KoneksiDatabase();
		koneksiDatabase.setUrl("jdbc:postgresql://localhost/bank");
		koneksiDatabase.setUsername("postgres");
		koneksiDatabase.setPassword("postgres");
		
		nd.setKoneksiDatabase(koneksiDatabase);
		nd.simpan();
	}

}

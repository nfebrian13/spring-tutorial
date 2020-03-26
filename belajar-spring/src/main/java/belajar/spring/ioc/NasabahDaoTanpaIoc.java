package belajar.spring.ioc;

public class NasabahDaoTanpaIoc {

	private KoneksiDatabase koneksiDatabase;

	public NasabahDaoTanpaIoc() {
		koneksiDatabase = new KoneksiDatabase();
		koneksiDatabase.setUrl("jdbc:postgresql://localhost/bank");
		koneksiDatabase.setUsername("postgres");
		koneksiDatabase.setPassword("postgres");
	}

	private void connect() {
		koneksiDatabase.connect();
	}

	private void disconnect() {

	}

	public void simpan() {
		connect();
		System.out.println("Menyimpan data");
		disconnect();
	}

	public void cariData() {

	}
}

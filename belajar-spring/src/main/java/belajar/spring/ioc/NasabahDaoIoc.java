package belajar.spring.ioc;

public class NasabahDaoIoc {

	private KoneksiDatabase koneksiDatabase;

	public NasabahDaoIoc() {
	}

	// constructor injection
	public NasabahDaoIoc(KoneksiDatabase koneksiDatabase) {
		super();
		this.koneksiDatabase = koneksiDatabase;
	}

	// setter injection
	public void setKoneksiDatabase(KoneksiDatabase koneksiDatabase) {
		this.koneksiDatabase = koneksiDatabase;
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

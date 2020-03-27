package belajar.spring.ioc;

import org.springframework.stereotype.Component;

@Component
public class RekeningDao {

	private KoneksiDatabase koneksiDatabase;

	public RekeningDao(KoneksiDatabase koneksiDatabase) {
		super();
		this.koneksiDatabase = koneksiDatabase;
	}

	private void connect() {
		koneksiDatabase.connect();
	}

	public void simpan() {
		connect();
		System.out.println("Menyimpan data");
		disconnect();
	}

	private void disconnect() {
		koneksiDatabase.connect();
	}
}

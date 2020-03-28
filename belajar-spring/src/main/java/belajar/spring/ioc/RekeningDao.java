package belajar.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RekeningDao {

	/* @Qualifier ("koneksiDatabase")
	 * Untuk menentukan koneksi database
	 * jika konfigurasi database lebih dari 1
	 *  */
	
	@Autowired 
	private KoneksiDatabase koneksiDatabase;

	/* 
	public RekeningDao(KoneksiDatabase koneksiDatabase) {
		super();
		this.koneksiDatabase = koneksiDatabase;
	} */

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

package belajar.java.fundamental.hari1;

import training.internet.banking.Nasabah;
import training.internet.banking.dao.NasabahDao;

public class DemoInsertNasabah {

	public static void main(String[] args) {

		// variabel koneksi database
		String dbDriver = "org.postgresql.Driver";
		String dbUrl = "jdbc:postgresql://localhost/bank";
		String dbUser = "postgres";
		String dbPassword = "postgres";

		// Data Access Object untuk Nasabah
		NasabahDao dbNasabah = new NasabahDao(dbDriver, dbUrl, dbUser, dbPassword);

		// Data yang mau diinsert
		Nasabah n = new Nasabah();
		n.setNomor("125");
		n.setNama("Sandi Oktavian");
		n.setEmail("sandi@gmail.com");

		// insert menggunakan DAO
		dbNasabah.connect();
		dbNasabah.simpan(n);
		dbNasabah.disconnect();
	}

}

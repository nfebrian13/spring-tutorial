package com.management.trx;

import com.management.trx.dao.NasabahDao;
import com.management.trx.models.Nasabah;

public class TrxMain {
	public static void main(String[] args) {

		// variabel koneksi database
		String dbDriver = "org.postgresql.Driver";
		String dbUrl = "jdbc:postgresql://localhost/management-transaksi";
		String dbUser = "postgres";
		String dbPassword = "postgres";

		// Data Access Object untuk Nasabah
		NasabahDao dbNasabah = new NasabahDao(dbDriver, dbUrl, dbUser, dbPassword);

		// Data yang mau diinsert
		Nasabah n = new Nasabah();
		n.setNomor("126");
		n.setNama("Nana Febriana");
		n.setEmail("nana@gmail.com");

		// insert menggunakan DAO
		dbNasabah.connect();
		dbNasabah.simpan(n);
		dbNasabah.disconnect();
	}
}

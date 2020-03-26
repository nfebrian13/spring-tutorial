package belajar.java.fundamental.hari1;

import java.io.IOException;
import java.util.List;

import training.internet.banking.Nasabah;
import training.internet.banking.helper.NasabahFileImporter;

public class DemoBacaFile {

	public static void main(String[] args) throws Exception {
		NasabahFileImporter ni = new NasabahFileImporter("src/main/resources/daftar-nasabah.txt");

		try {
			List<Nasabah> nList = ni.proses();
			for (Nasabah nasabah : nList) {
				System.out.println("Nomor " + nasabah.getNomor());
				System.out.println("Nama " + nasabah.getNama());
				System.out.println("Email " + nasabah.getEmail());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

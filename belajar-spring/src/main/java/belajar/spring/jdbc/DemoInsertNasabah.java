package belajar.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoInsertNasabah {

	public static void main(String[] args) {

		ApplicationContext springContainer = new ClassPathXmlApplicationContext("belajar-jdbc.xml");

		// Data yang mau diinsert
		Nasabah n = new Nasabah();
		n.setNomor("123");
		n.setNama("Ridwan Oktavian");
		n.setEmail("ridwan@gmail.com");

		// insert menggunakan DAO
		NasabahDao nd = springContainer.getBean(NasabahDao.class);
//		nd.insert(n);
		
		/* cek rollback transaksi untuk declarative transaction */
		nd.insertTransaksi();
	}

}

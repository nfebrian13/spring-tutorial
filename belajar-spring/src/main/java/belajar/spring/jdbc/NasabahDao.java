package belajar.spring.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class NasabahDao {

	private static final String SQL_INSERT = "insert into nasabah (nomor,nama,email) values (?,?,?)";
	private static final String SQL_CARI_SEMUA = "select * from nasabah";
	
	private static final String SQL_INSERT_REK = "insert into rekening (nomor, nomor_nasabah, saldo) values ('111','123', 100000.00)";
	private static final String SQL_INSERT_MUT= "insert into mutasi (nomor, nomor_rekening, waktu_transaksi, keterangan, debet, kredit)" + 
			"values ('001','111', now(), 'Setoran Awal', 100000.00,0)";
	
	@Autowired
	private DataSource dataSource;

	public void insert(Nasabah n) {
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
			ps.setString(1, n.getNomor());
			ps.setString(2, n.getNama());
			ps.setString(3, n.getEmail());
			ps.executeUpdate();
			
			conn.createStatement().executeUpdate(SQL_INSERT_REK);
			conn.createStatement().executeUpdate(SQL_INSERT_MUT);	

			conn.close();
			
		} catch (SQLException err) {
			err.printStackTrace();
		}
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void insertTransaksi() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.execute("insert into rekening (nomor, nomor_nasabah, saldo) " + "values ('111','123', 100000.00)");

		jt.execute("insert into mutasi (nomor, nomor_rekening, waktu_transaksi, keterangan, debet, kredit) "
				+ "values ('001','222', now(), 'Setoran Awal', 100000.00,0)");
		
		/* untuk cek rollback sukses atau tidak.
		if (3 < 5) {
			throw new IllegalStateException("Pura puranya error");
		} */
		
	}

	@Transactional
	public List<Nasabah> cariSemuaNasabah() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		return jt.query(SQL_CARI_SEMUA, new BeanPropertyRowMapper(Nasabah.class));
	}
}

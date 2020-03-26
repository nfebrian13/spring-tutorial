package training.internet.banking;

public class Nasabah {
	
	public static Integer jumlahNasabah = 0;
	private String nomor;
	private String nama;
	private String email;
	
	public Nasabah() {
		jumlahNasabah = jumlahNasabah + 1;
	}
	public Nasabah(String nama) {
		super();
		this.nama = nama;
	} 
	public Nasabah(String nomor, String nama, String email) {
		super();
		this.nomor = nomor;
		this.nama = nama;
		this.email = email;
	}
	public String getNomor() {
		return nomor;
	}
	public void setNomor(String nomor) {
		this.nomor = nomor;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}

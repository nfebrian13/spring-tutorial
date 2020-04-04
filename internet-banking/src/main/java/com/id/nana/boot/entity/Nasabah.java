package com.id.nana.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

/* 
 * Natural Key :
 * Primary key yang diambil dari kolom yang ada data meaningnya
 * ex : kolom email, ktp etc
 * Natural key kurang baik karena nomornya kemungkinan berubah.
 * 
 * surrogate key :
 * primary key yang tidak mempunyai business meaning
 * ada 2 pilihan number atau string.
 * solusi yang baik menggunakan primary key string uuid
 * */


@Entity
public class Nasabah {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 10)
	@Column(unique = true)
	private String nomor;
	
	@NotNull
	@NotEmpty
	@Size(min = 3, max = 255)
	private String nama;
	
	@NotNull
	@NotEmpty
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

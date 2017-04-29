package recep.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	
	private String ad;
	
	private String soyad;
	
	private String telefon;
	
	private String email;
	
	@Column(name = "hangi_kurs")
	private String hangiKurs;
	
	@Column(name = "gorusme_tipi")
	private int gorusmeTipi;
	
	private String mesaj;
	
	@Column(name = "gorusme_zamani")
	private Date gorusmeZamani;

	public Person() {}
	
	public Person(String ad,String soyad, String telefon, String email, String hangiKurs, int gorusmeTipi, String mesaj,
			Date gorusmeZamani) {
		this.ad = ad;
		this.soyad = soyad;
		this.telefon = telefon;
		this.email = email;
		this.hangiKurs = hangiKurs;
		this.gorusmeTipi = gorusmeTipi;
		this.mesaj = mesaj;
		this.gorusmeZamani = gorusmeZamani;
	}



	public int getId() {
		return id;
	}

	public String getAd() {
		return ad;
	}
	
	public String getSoyad() {
		return soyad;
	}

	public String getTelefon() {
		return telefon;
	}

	public String getEmail() {
		return email;
	}

	public String getHangiKurs() {
		return hangiKurs;
	}

	public int getGorusmeTipi() {
		return gorusmeTipi;
	}

	public String getMesaj() {
		return mesaj;
	}

	public Date getGorusmeZamani() {
		return gorusmeZamani;
	}
	
	

	
}

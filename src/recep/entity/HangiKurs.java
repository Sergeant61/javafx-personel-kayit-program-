package recep.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HangiKurs {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	int id;

	@Column(name = "kurs_adi")
	String kursAdi;
	
	public HangiKurs() {
	}
	
	public HangiKurs(String kursAdi) {
		this.kursAdi = kursAdi;
	}
	
	public void setId(int id) {
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public String getKursAdi() {
		return kursAdi;
	}
	
	

}

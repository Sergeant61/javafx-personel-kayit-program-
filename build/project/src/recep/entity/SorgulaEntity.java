package recep.entity;

import java.util.Date;

public class SorgulaEntity {
	
	private String ad;
	private String soyad;
	private Date basTarihi;
	private Date sonTarihi;
	private String hangiKurs;
	private int type;
	
	
	public SorgulaEntity(String ad, String soyad, Date basTarihi, Date sonTarihi, String hangiKurs, int type) {
		this.ad = ad;
		this.soyad = soyad;
		this.basTarihi = basTarihi;
		this.sonTarihi = sonTarihi;
		this.hangiKurs = hangiKurs;
		this.type = type;
	}


	public String getAd() {
		return ad;
	}


	public void setAd(String ad) {
		this.ad = ad;
	}


	public String getSoyad() {
		return soyad;
	}


	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}


	public Date getBasTarihi() {
		return basTarihi;
	}


	public void setBasTarihi(Date basTarihi) {
		this.basTarihi = basTarihi;
	}


	public Date getSonTarihi() {
		return sonTarihi;
	}


	public void setSonTarihi(Date sonTarihi) {
		this.sonTarihi = sonTarihi;
	}


	public String getHangiKurs() {
		return hangiKurs;
	}


	public void setHangiKurs(String hangiKurs) {
		this.hangiKurs = hangiKurs;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
	
	
	

}

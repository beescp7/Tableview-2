package application;

public class Personel {
 private String ad;
 private String sehir;
 private String cinsiyet;
 private String durum;
 private Double maas;
 public Personel()
 {
	 ad=null;
	 sehir=null;
	 cinsiyet=null;
	 durum=null;
	 maas=0.0;
	 
 }
 public Personel(String ad, String sehir, String cinsiyet, String durum, Double maas) {
	super();
	this.ad = ad;
	this.sehir = sehir;
	this.cinsiyet = cinsiyet;
	this.durum = durum;
	this.maas = maas;
}
 

public String getAd() {
	return ad;
}
public void setAd(String ad) {
	this.ad = ad;
}
public String getSehir() {
	return sehir;
}
public void setSehir(String sehir) {
	this.sehir = sehir;
}
public String getCinsiyet() {
	return cinsiyet;
}
public void setCinsiyet(String cinsiyet) {
	this.cinsiyet = cinsiyet;
}
public String getDurum() {
	return durum;
}
public void setDurum(String durum) {
	this.durum = durum;
}
public Double getMaas() {
	return maas;
}
public void setMaas(Double maas) {
	this.maas = maas;
}
}

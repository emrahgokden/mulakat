package mulakat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Musteri")
public class Musteri {
	
	@Id
	@Column(name="musteri_id")
	public int musteriId;
	@Column(name="musteri_ad")
	public String musteriAd;
	@Column(name="musteri_soyad")
	public String musteriSoyad;
	@Column(name="sehir")
	public String sehir;
	public int getMusteriId() {
		return musteriId;
	}
	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}
	public String getMusteriAd() {
		return musteriAd;
	}
	public void setMusteriAd(String musteriAd) {
		this.musteriAd = musteriAd;
	}
	public String getMusteriSoyad() {
		return musteriSoyad;
	}
	public void setMusteriSoyad(String musteriSoyad) {
		this.musteriSoyad = musteriSoyad;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	@Override
	public String toString() {
		return "Musteri [musteriId=" + musteriId + ", musteriAd=" + musteriAd + ", musteriSoyad=" + musteriSoyad
				+ ", sehir=" + sehir + ", getMusteriId()=" + getMusteriId() + ", getMusteriAd()=" + getMusteriAd()
				+ ", getMusteriSoyad()=" + getMusteriSoyad() + ", getSehir()=" + getSehir() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}

package mulakat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sepeturun")
public class SepetUrun {
	@Id
	@Column(name="sepet_urun_id")
	public int sepetUrunId;
	@Column(name="sepet_id")
	public int sepetId;
	@Column(name="tutar")
	public float tutar;
	@Column(name="aciklama")
	public String aciklama;
	public int getSepetUrunId() {
		return sepetUrunId;
	}
	public void setSepetUrunId(int sepetUrunId) {
		this.sepetUrunId = sepetUrunId;
	}
	public int getSepetId() {
		return sepetId;
	}
	public void setSepetId(int sepetId) {
		this.sepetId = sepetId;
	}
	public float getTutar() {
		return tutar;
	}
	public void setTutar(float tutar) {
		this.tutar = tutar;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	
	

}

package mulakat.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sepet")
public class Sepet {
	@Id
	@Column(name="sepet_id")
	public int sepetId;
	@Column(name="musteri_id")
	public int musteriId;
	public int getSepetId() {
		return sepetId;
	}
	public void setSepetId(int sepetId) {
		this.sepetId = sepetId;
	}
	public int getMusteriId() {
		return musteriId;
	}
	public void setMusteriId(int musteriId) {
		this.musteriId = musteriId;
	}
	
	

}

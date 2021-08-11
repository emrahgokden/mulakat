package mulakat.Model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
public class DtoSehirAnaliz
{
    public String sehirAdi;
    public int sepetAdet;
    public float toplamTutar;
    
	public DtoSehirAnaliz(String sehirAdi, int sepetAdet, float toplamTutar) {
		this.sehirAdi = sehirAdi;
		this.sepetAdet= sepetAdet;
		this.toplamTutar = toplamTutar;
	}
	public String getSehirAdi() {
		return sehirAdi;
	}
	public void setSehirAdi(String sehirAdi) {
		this.sehirAdi = sehirAdi;
	}
	public int getSepetAdet() {
		return sepetAdet;
	}
	public void setSepetAdet(int sepetAdet) {
		this.sepetAdet = sepetAdet;
	}
	public float getToplamTutar() {
		return toplamTutar;
	}
	public void setToplamTutar(int toplamTutar) {
		this.toplamTutar = toplamTutar;
	}
}
package mulakat.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mulakat.Model.Musteri;
import mulakat.Repository.MusteriRepository;

@Service
public class MusteriService {
	
	@Autowired
	private MusteriRepository musteriRepository;
	
	public List<Musteri> getAllMusteriList() {
		
		return musteriRepository.getAllMusteriList();
	}
	
	@Transactional
	public int save(Musteri musteri) {
		
		
		Musteri yeniMusteri = new Musteri();
		yeniMusteri.setMusteriId(musteriRepository.findMaxMusteriId()+1);
		yeniMusteri.setMusteriAd(musteri.getMusteriAd());
		yeniMusteri.setMusteriSoyad(musteri.getMusteriSoyad());
		yeniMusteri.setSehir(musteri.getSehir());
		musteri = musteriRepository.save(yeniMusteri);
		
		
		return musteri.getMusteriId();
	}
	

}
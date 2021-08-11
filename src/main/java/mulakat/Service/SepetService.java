package mulakat.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mulakat.Model.Sepet;
import mulakat.Repository.SepetRepository;

@Service
public class SepetService {
	
	@Autowired
	private SepetRepository sepetRepository;
	
	public List<Sepet> getAllSepetList() {
		
		return sepetRepository.getAllSepetList();
	}
	
	@Transactional
	public int save(Sepet sepet) {
		
		Sepet yeniSepet = new Sepet();
		yeniSepet.setSepetId(sepetRepository.findMaxSepetId()+1);
		yeniSepet.setMusteriId(sepet.getMusteriId());
		sepet = sepetRepository.save(yeniSepet);		
		
		return sepet.getSepetId();
	}
	

}
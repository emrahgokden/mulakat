package mulakat.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mulakat.Model.SepetUrun;
import mulakat.Repository.SepetUrunRepository;

@Service
public class SepetUrunService {
	
	@Autowired
	private SepetUrunRepository sepetUrunRepository;
	
	public List<SepetUrun> getAllMusteriList() {
		
		return sepetUrunRepository.getAllSepetUrunList();
	}
	
	@Transactional
	public int save(SepetUrun sepetUrun) {
			
		SepetUrun yeniSepetUrun = new SepetUrun();
		yeniSepetUrun.setSepetUrunId(sepetUrunRepository.findMaxSepetUrunId()+1);
		yeniSepetUrun.setSepetId(sepetUrun.getSepetId());
		yeniSepetUrun.setTutar(sepetUrun.getTutar());
		yeniSepetUrun.setAciklama(sepetUrun.getAciklama());
		sepetUrun = sepetUrunRepository.save(yeniSepetUrun);
		
		return sepetUrun.getSepetUrunId();
	}
	

}
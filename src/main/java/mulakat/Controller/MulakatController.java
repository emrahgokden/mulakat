package mulakat.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mulakat.Model.DtoSehirAnaliz;
import mulakat.Model.Musteri;
import mulakat.Model.Sepet;
import mulakat.Model.SepetUrun;
import mulakat.Service.MusteriService;
import mulakat.Service.SepetService;
import mulakat.Service.SepetUrunService;

@RestController
public class MulakatController {
	Random random = new Random();
	
	@Autowired
	public MusteriService musteriService;
	@Autowired
	public SepetService sepetService;
	@Autowired
	public SepetUrunService sepetUrunService;
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/testVerisiOlustur",method=RequestMethod.POST)
	public String testVerisiOlustur(@RequestParam int musteriAdet,@RequestParam int sepetAdet) {
		
		String [] sehirler = {"Ankara","İstanbul","İzmir","Bursa","Edirne","Konya","Antalya","Diyerbakır","Van","Rize"};
		List<Integer> musteriIdList = new ArrayList<Integer>();
		
		for(int i=0; i<musteriAdet; i++) {
			
	        String setOfCharacters = "abcdefghxyz";
	        String ad ="";
	        String soyad = "";
	        int randomInt;
	        char randomChar;
	        for(int k=0; k<5; k++) {
	        	
	        	randomInt = random.nextInt(setOfCharacters.length());
	        	randomChar = setOfCharacters.charAt(randomInt);
	        	ad += randomChar;
	        	randomInt = random.nextInt(setOfCharacters.length());
	        	randomChar = setOfCharacters.charAt(randomInt);
	        	soyad +=randomChar;//
	        }
			Musteri musteri = new Musteri();
			musteri.musteriAd=ad;
			musteri.musteriSoyad=soyad;
			int rand = (int)(Math.random()*9)+1;
			musteri.sehir=sehirler[rand];
			int musteriId = musteriService.save(musteri);
			musteriIdList.add(musteriId);
		}
		 	for(int i=0; i<sepetAdet;i++) {
		 		
		 		Sepet sepet =new Sepet();
		 		sepet.musteriId = musteriIdList.get((int)(Math.random()*musteriIdList.size()));
		 		int sepetId = sepetService.save(sepet);
		 		int olusturulacakUrunSayisi = (int)(Math.random()*5)+1;
		 		for(int j=0; j<olusturulacakUrunSayisi;j++) {
		 			
		 			SepetUrun sepetUrun = new SepetUrun();
		 			float tutar = (float)(Math.random())*(1000-100)+100;
		 			sepetUrun.sepetId= sepetId;
		 			sepetUrun.tutar=tutar;
		 			sepetUrun.aciklama="dsfgjklş";
		 			sepetUrunService.save(sepetUrun);

		 		}
		 	}
		
		
		return "eklendi";
		
	}
	@RequestMapping(value="/sehirBazliAnalizYap",method=RequestMethod.POST)
	public List<DtoSehirAnaliz> sehirBazliAnalizYap()  {
		
		List<DtoSehirAnaliz> dtoSehirAnalizList = jdbcTemplate.query(
                "select sehir,COUNT(sehir), sum(tutar) from Sepet "
                + "inner join Musteri on Sepet.musteri_id = Musteri. musteri_id "
                + "inner join Sepeturun on Sepet.sepet_id = Sepeturun.sepet_id "
                + "group by Musteri.sehir order by COUNT(sehir) desc",
                (rs, rowNum) ->
                        new DtoSehirAnaliz(
                                rs.getString(1),
                                rs.getInt(2),
                                rs.getFloat(3)
                        ) );
		
		return dtoSehirAnalizList;
		
	}
	

}

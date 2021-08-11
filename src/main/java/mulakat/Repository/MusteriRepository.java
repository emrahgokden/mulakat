package mulakat.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mulakat.Model.Musteri;

@Repository
public interface MusteriRepository extends CrudRepository<Musteri,Integer> {
	
	@Query(value="select m from Musteri m")
	public List<Musteri> getAllMusteriList();
	
	@Query(value="select max(m.musteriId) from Musteri m")
	public int findMaxMusteriId();
	
}

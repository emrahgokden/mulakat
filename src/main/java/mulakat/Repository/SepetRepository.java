package mulakat.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mulakat.Model.Sepet;

@Repository
public interface SepetRepository extends CrudRepository<Sepet,Integer> {

	@Query(value="select s from Sepet s")
	public List<Sepet> getAllSepetList();
	
	@Query(value="select max(s.sepetId) from Sepet s")
	public int findMaxSepetId();
}

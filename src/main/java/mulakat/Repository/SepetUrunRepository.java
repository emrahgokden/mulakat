package mulakat.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import mulakat.Model.SepetUrun;

@Repository
public interface SepetUrunRepository extends CrudRepository<SepetUrun,Integer> {
	
	@Query(value="select u from SepetUrun u")
	public List<SepetUrun> getAllSepetUrunList();
	
	@Query(value="select max(u.sepetUrunId) from SepetUrun u")
	public int findMaxSepetUrunId();
}

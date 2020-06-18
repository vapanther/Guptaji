package com.tvu.Metadata_BE.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tvu.Metadata_BE.Model.Session;

public interface SessionRepository extends JpaRepository<Session, String> {

	List<Session> findByProducedBy(String producedBy,Pageable pageable);
	
	Optional<Session> findById(String id);

	//List<Session> findByProducedBy(String producedBy, PageRequest of);
	
	
	/*@Query(value="SELECT s FROM Session s WHERE s.producedBy LIKE ?1 ORDER BY s.id limit ?2,?3", nativeQuery = true)
    public List<Session> findByProducedByAndMore(String producedBy, int offset, int limit);
	
	@Query("SELECT s from Session s where s.producedByp.ip like (:ip) or p.host like (:host) or p.canonicalHost like (:canonicalHost) or p.localHost like (:localhost) group by p.machines")
	public List<Session> findByIpOrHostOrCanonicalHostOrLocalHost(@Param("ip") String ip, @Param("host") String host, @Param("canonicalHost") String canonicalHost,  @Param("localhost") String localhost);

	*/
	/*@Query("SELECT s from Session s where s.producedBy = (:producedBy) limit (:offset) ,(:limitval)")
	public List<Session> getSessionByProducedBy(@Param("producedBy") String producedBy, @Param("offset") int offset, @Param("limitval") int limitval);
*/

}

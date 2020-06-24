package com.tvu.Metadata_BE.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tvu.Metadata_BE.Model.Session;

public interface SessionRepository extends JpaRepository<Session, String> {

	List<Session> findByProducedBy(String producedBy);
	
	Optional<Session> findById(String id);
	
	//@Query("SELECT s from Session s order by 'starttime' limit (:offset) ,(:limitval)")
	@Query(value="SELECT s.* from session s ORDER BY s.starttime limit :offset,:limitval", nativeQuery = true)
	public List<Session> getSessionByProducedBy( @Param("offset") int offset, @Param("limitval") int limitval);


}

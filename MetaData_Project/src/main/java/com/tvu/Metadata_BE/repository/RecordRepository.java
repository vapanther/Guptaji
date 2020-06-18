package com.tvu.Metadata_BE.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvu.Metadata_BE.Model.Records;
import com.tvu.Metadata_BE.Model.Session;

public interface RecordRepository extends JpaRepository<Records, String> {
	
	public List<Records> findAllBySession(Optional<Session> optional);

}

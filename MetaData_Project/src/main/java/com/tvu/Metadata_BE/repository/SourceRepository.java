package com.tvu.Metadata_BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvu.Metadata_BE.Model.Sources;

public interface SourceRepository extends JpaRepository<Sources, String> {
}

package com.tvu.Metadata_BE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tvu.Metadata_BE.Model.Records;
import com.tvu.Metadata_BE.Model.ShortStories;

public interface ShortStoriesRepository extends JpaRepository<ShortStories, String> {

}

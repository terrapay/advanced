package com.example.jpa.repository;

import com.example.jpa.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Pariwesh gupta on 22/11/17.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}

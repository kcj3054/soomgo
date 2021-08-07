package com.example.soomgo.repository;

import com.example.soomgo.domain.Expert;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertRepository extends JpaRepository<Expert, Long> {

  Optional<Expert> findByUserId(Long userId);

}

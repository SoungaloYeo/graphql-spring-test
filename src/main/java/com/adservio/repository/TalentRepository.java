package com.adservio.repository;

import com.adservio.domain.Talent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TalentRepository extends JpaRepository<Talent, Long> {

}

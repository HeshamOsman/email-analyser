package com.gamary.emailanalyzer.repository;

import com.gamary.emailanalyzer.domain.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email,Long> {
}

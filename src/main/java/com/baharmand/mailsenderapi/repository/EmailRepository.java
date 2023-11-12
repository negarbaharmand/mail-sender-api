package com.baharmand.mailsenderapi.repository;

import com.baharmand.mailsenderapi.domain.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<Email, String> {
}

package com.supadosworks.jhipster.oc.repository;

import com.supadosworks.jhipster.oc.domain.PersistentToken;
import com.supadosworks.jhipster.oc.domain.User;
import org.joda.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Spring Data JPA repository for the PersistentToken entity.
 */
public interface PersistentTokenRepository extends JpaRepository<PersistentToken, String> {

    List<PersistentToken> findByUser(User user);

    List<PersistentToken> findByTokenDateBefore(LocalDate localDate);

}

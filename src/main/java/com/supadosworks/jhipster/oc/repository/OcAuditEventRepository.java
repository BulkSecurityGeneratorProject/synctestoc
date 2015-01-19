package com.supadosworks.jhipster.oc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supadosworks.jhipster.oc.domain.OcAuditEvent;

public interface OcAuditEventRepository extends JpaRepository<OcAuditEvent,Long>{

}

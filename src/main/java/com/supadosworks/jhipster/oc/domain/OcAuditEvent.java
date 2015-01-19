package com.supadosworks.jhipster.oc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audit_event")
public class OcAuditEvent implements Serializable {

    @Id
    @Column(name = "audit_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long auditId;
    
    @Column(name = "audit_table")
    private String auditTable;
    
    @Column(name = "reason_for_change")
    private String reasonForChange;

    @Column(name = "action_message")
    private String actionMessage;
    
    @Column(name = "user_id")
    private int userId;
    
    @Column(name = "entity_id")
    private int entityId;

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public String getAuditTable() {
		return auditTable;
	}

	public void setAuditTable(String auditTable) {
		this.auditTable = auditTable;
	}

	public String getReasonForChange() {
		return reasonForChange;
	}

	public void setReasonForChange(String reasonForChange) {
		this.reasonForChange = reasonForChange;
	}

	public String getActionMessage() {
		return actionMessage;
	}

	public void setActionMessage(String actionMessage) {
		this.actionMessage = actionMessage;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEntityId() {
		return entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
}

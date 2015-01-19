package com.supadosworks.jhipster.oc.web.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.supadosworks.jhipster.oc.domain.OcArchivedDatasetFile;
import com.supadosworks.jhipster.oc.domain.OcAuditEvent;
import com.supadosworks.jhipster.oc.domain.OcConfiguration;
import com.supadosworks.jhipster.oc.domain.OcUser;
import com.supadosworks.jhipster.oc.repository.OcArchivedDatasetFileRepository;
import com.supadosworks.jhipster.oc.repository.OcAuditEventRepository;
import com.supadosworks.jhipster.oc.repository.OcConfigurationRepository;
import com.supadosworks.jhipster.oc.repository.OcUserRepository;

@RestController
@RequestMapping("/api")
public class OCRest {

	@Inject
	private OcUserRepository ocUserRepository;

	@RequestMapping(value = "/oc/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OcUser>> getUsers() {
		return new ResponseEntity<>(ocUserRepository.findAll(), HttpStatus.OK);
	}
	
	@Inject
	private OcArchivedDatasetFileRepository adfRepository;
	
	@RequestMapping(value = "/oc/archivedDataFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OcArchivedDatasetFile>> getADF() {
		return new ResponseEntity<>(adfRepository.findAll(), HttpStatus.OK);
	}
	
	@Inject
	private OcConfigurationRepository ocConfRepository;
	
	@RequestMapping(value = "/oc/configuration", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OcConfiguration>> getConf() {
		return new ResponseEntity<>(ocConfRepository.findAll(), HttpStatus.OK);
	}
	
	@Inject
	private OcAuditEventRepository ocAuditEventRepository;
	
	@RequestMapping(value = "/oc/auditEventRepository", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OcAuditEvent>> getAER() {
		return new ResponseEntity<>(ocAuditEventRepository.findAll(), HttpStatus.OK);
	}
}

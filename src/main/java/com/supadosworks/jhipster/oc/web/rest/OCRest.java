package com.supadosworks.jhipster.oc.web.rest;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.supadosworks.jhipster.oc.domain.OcUser;
import com.supadosworks.jhipster.oc.repository.OcUserRepository;

@RestController
@RequestMapping("/api")
public class OCRest {

	@Inject
	private OcUserRepository ocUserRepository;

	@RequestMapping(value = "/oc/user", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	public ResponseEntity<List<OcUser>> getCurrentSessions() {
		return new ResponseEntity<>(ocUserRepository.findAll(), HttpStatus.OK);
	}
}

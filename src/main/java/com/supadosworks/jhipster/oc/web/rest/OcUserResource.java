package com.supadosworks.jhipster.oc.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.supadosworks.jhipster.oc.domain.OcUser;
import com.supadosworks.jhipster.oc.repository.OcUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * REST controller for managing OcUser.
 */
@RestController
@RequestMapping("/api")
public class OcUserResource {

    private final Logger log = LoggerFactory.getLogger(OcUserResource.class);

    @Inject
    private OcUserRepository ocUserRepository;

    /**
     * POST  /ocUsers -> Create a new ocUser.
     */
    @RequestMapping(value = "/ocUsers",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void create(@RequestBody OcUser ocUser) {
        log.debug("REST request to save OcUser : {}", ocUser);
        ocUserRepository.save(ocUser);
    }

    /**
     * GET  /ocUsers -> get all the ocUsers.
     */
    @RequestMapping(value = "/ocUsers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<OcUser> getAll() {
        log.debug("REST request to get all OcUsers");
        return ocUserRepository.findAll();
    }

    /**
     * GET  /ocUsers/:id -> get the "id" ocUser.
     */
    @RequestMapping(value = "/ocUsers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<OcUser> get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get OcUser : {}", id);
        OcUser ocUser = ocUserRepository.findOne(id);
        if (ocUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ocUser, HttpStatus.OK);
    }

    /**
     * DELETE  /ocUsers/:id -> delete the "id" ocUser.
     */
    @RequestMapping(value = "/ocUsers/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void delete(@PathVariable Long id) {
        log.debug("REST request to delete OcUser : {}", id);
        ocUserRepository.delete(id);
    }
}

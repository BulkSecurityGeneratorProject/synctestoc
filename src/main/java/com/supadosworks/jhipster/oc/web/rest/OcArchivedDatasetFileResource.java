package com.supadosworks.jhipster.oc.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.supadosworks.jhipster.oc.domain.OcArchivedDatasetFile;
import com.supadosworks.jhipster.oc.repository.OcArchivedDatasetFileRepository;
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
 * REST controller for managing OcArchivedDatasetFile.
 */
@RestController
@RequestMapping("/api")
public class OcArchivedDatasetFileResource {

    private final Logger log = LoggerFactory.getLogger(OcArchivedDatasetFileResource.class);

    @Inject
    private OcArchivedDatasetFileRepository ocArchivedDatasetFileRepository;

    /**
     * POST  /ocArchivedDatasetFiles -> Create a new ocArchivedDatasetFile.
     */
    @RequestMapping(value = "/ocArchivedDatasetFiles",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void create(@RequestBody OcArchivedDatasetFile ocArchivedDatasetFile) {
        log.debug("REST request to save OcArchivedDatasetFile : {}", ocArchivedDatasetFile);
        ocArchivedDatasetFileRepository.save(ocArchivedDatasetFile);
    }

    /**
     * GET  /ocArchivedDatasetFiles -> get all the ocArchivedDatasetFiles.
     */
    @RequestMapping(value = "/ocArchivedDatasetFiles",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<OcArchivedDatasetFile> getAll() {
        log.debug("REST request to get all OcArchivedDatasetFiles");
        return ocArchivedDatasetFileRepository.findAll();
    }

    /**
     * GET  /ocArchivedDatasetFiles/:id -> get the "id" ocArchivedDatasetFile.
     */
    @RequestMapping(value = "/ocArchivedDatasetFiles/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<OcArchivedDatasetFile> get(@PathVariable Long id, HttpServletResponse response) {
        log.debug("REST request to get OcArchivedDatasetFile : {}", id);
        OcArchivedDatasetFile ocArchivedDatasetFile = ocArchivedDatasetFileRepository.findOne(id);
        if (ocArchivedDatasetFile == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ocArchivedDatasetFile, HttpStatus.OK);
    }

    /**
     * DELETE  /ocArchivedDatasetFiles/:id -> delete the "id" ocArchivedDatasetFile.
     */
    @RequestMapping(value = "/ocArchivedDatasetFiles/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void delete(@PathVariable Long id) {
        log.debug("REST request to delete OcArchivedDatasetFile : {}", id);
        ocArchivedDatasetFileRepository.delete(id);
    }
}

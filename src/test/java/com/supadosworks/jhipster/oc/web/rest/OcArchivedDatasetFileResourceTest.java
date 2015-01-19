package com.supadosworks.jhipster.oc.web.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.List;

import com.supadosworks.jhipster.oc.Application;
import com.supadosworks.jhipster.oc.domain.OcArchivedDatasetFile;
import com.supadosworks.jhipster.oc.repository.OcArchivedDatasetFileRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the OcArchivedDatasetFileResource REST controller.
 *
 * @see OcArchivedDatasetFileResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class OcArchivedDatasetFileResourceTest {

    private static final String DEFAULT_NAME = "SAMPLE_TEXT";
    private static final String UPDATED_NAME = "UPDATED_TEXT";

    @Inject
    private OcArchivedDatasetFileRepository ocArchivedDatasetFileRepository;

    private MockMvc restOcArchivedDatasetFileMockMvc;

    private OcArchivedDatasetFile ocArchivedDatasetFile;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        OcArchivedDatasetFileResource ocArchivedDatasetFileResource = new OcArchivedDatasetFileResource();
        ReflectionTestUtils.setField(ocArchivedDatasetFileResource, "ocArchivedDatasetFileRepository", ocArchivedDatasetFileRepository);
        this.restOcArchivedDatasetFileMockMvc = MockMvcBuilders.standaloneSetup(ocArchivedDatasetFileResource).build();
    }

    @Before
    public void initTest() {
        ocArchivedDatasetFile = new OcArchivedDatasetFile();
        ocArchivedDatasetFile.setName(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void createOcArchivedDatasetFile() throws Exception {
        // Validate the database is empty
        assertThat(ocArchivedDatasetFileRepository.findAll()).hasSize(0);

        // Create the OcArchivedDatasetFile
        restOcArchivedDatasetFileMockMvc.perform(post("/api/ocArchivedDatasetFiles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(ocArchivedDatasetFile)))
                .andExpect(status().isOk());

        // Validate the OcArchivedDatasetFile in the database
        List<OcArchivedDatasetFile> ocArchivedDatasetFiles = ocArchivedDatasetFileRepository.findAll();
        assertThat(ocArchivedDatasetFiles).hasSize(1);
        OcArchivedDatasetFile testOcArchivedDatasetFile = ocArchivedDatasetFiles.iterator().next();
        assertThat(testOcArchivedDatasetFile.getName()).isEqualTo(DEFAULT_NAME);
    }

    @Test
    @Transactional
    public void getAllOcArchivedDatasetFiles() throws Exception {
        // Initialize the database
        ocArchivedDatasetFileRepository.saveAndFlush(ocArchivedDatasetFile);

        // Get all the ocArchivedDatasetFiles
        restOcArchivedDatasetFileMockMvc.perform(get("/api/ocArchivedDatasetFiles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(ocArchivedDatasetFile.getId().intValue()))
                .andExpect(jsonPath("$.[0].name").value(DEFAULT_NAME.toString()));
    }

    @Test
    @Transactional
    public void getOcArchivedDatasetFile() throws Exception {
        // Initialize the database
        ocArchivedDatasetFileRepository.saveAndFlush(ocArchivedDatasetFile);

        // Get the ocArchivedDatasetFile
        restOcArchivedDatasetFileMockMvc.perform(get("/api/ocArchivedDatasetFiles/{id}", ocArchivedDatasetFile.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(ocArchivedDatasetFile.getId().intValue()))
            .andExpect(jsonPath("$.name").value(DEFAULT_NAME.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingOcArchivedDatasetFile() throws Exception {
        // Get the ocArchivedDatasetFile
        restOcArchivedDatasetFileMockMvc.perform(get("/api/ocArchivedDatasetFiles/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateOcArchivedDatasetFile() throws Exception {
        // Initialize the database
        ocArchivedDatasetFileRepository.saveAndFlush(ocArchivedDatasetFile);

        // Update the ocArchivedDatasetFile
        ocArchivedDatasetFile.setName(UPDATED_NAME);
        restOcArchivedDatasetFileMockMvc.perform(post("/api/ocArchivedDatasetFiles")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(ocArchivedDatasetFile)))
                .andExpect(status().isOk());

        // Validate the OcArchivedDatasetFile in the database
        List<OcArchivedDatasetFile> ocArchivedDatasetFiles = ocArchivedDatasetFileRepository.findAll();
        assertThat(ocArchivedDatasetFiles).hasSize(1);
        OcArchivedDatasetFile testOcArchivedDatasetFile = ocArchivedDatasetFiles.iterator().next();
        assertThat(testOcArchivedDatasetFile.getName()).isEqualTo(UPDATED_NAME);
    }

    @Test
    @Transactional
    public void deleteOcArchivedDatasetFile() throws Exception {
        // Initialize the database
        ocArchivedDatasetFileRepository.saveAndFlush(ocArchivedDatasetFile);

        // Get the ocArchivedDatasetFile
        restOcArchivedDatasetFileMockMvc.perform(delete("/api/ocArchivedDatasetFiles/{id}", ocArchivedDatasetFile.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<OcArchivedDatasetFile> ocArchivedDatasetFiles = ocArchivedDatasetFileRepository.findAll();
        assertThat(ocArchivedDatasetFiles).hasSize(0);
    }
}

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
import com.supadosworks.jhipster.oc.domain.OcUser;
import com.supadosworks.jhipster.oc.repository.OcUserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the OcUserResource REST controller.
 *
 * @see OcUserResource
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class OcUserResourceTest {

    private static final String DEFAULT_LOGIN = "SAMPLE_TEXT";
    private static final String UPDATED_LOGIN = "UPDATED_TEXT";
    private static final String DEFAULT_PASSWORD = "SAMPLE_TEXT";
    private static final String UPDATED_PASSWORD = "UPDATED_TEXT";

    @Inject
    private OcUserRepository ocUserRepository;

    private MockMvc restOcUserMockMvc;

    private OcUser ocUser;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        OcUserResource ocUserResource = new OcUserResource();
        ReflectionTestUtils.setField(ocUserResource, "ocUserRepository", ocUserRepository);
        this.restOcUserMockMvc = MockMvcBuilders.standaloneSetup(ocUserResource).build();
    }

    @Before
    public void initTest() {
        ocUser = new OcUser();
        ocUser.setLogin(DEFAULT_LOGIN);
        ocUser.setPassword(DEFAULT_PASSWORD);
    }

    @Test
    @Transactional
    public void createOcUser() throws Exception {
        // Validate the database is empty
        assertThat(ocUserRepository.findAll()).hasSize(0);

        // Create the OcUser
        restOcUserMockMvc.perform(post("/api/ocUsers")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(ocUser)))
                .andExpect(status().isOk());

        // Validate the OcUser in the database
        List<OcUser> ocUsers = ocUserRepository.findAll();
        assertThat(ocUsers).hasSize(1);
        OcUser testOcUser = ocUsers.iterator().next();
        assertThat(testOcUser.getLogin()).isEqualTo(DEFAULT_LOGIN);
        assertThat(testOcUser.getPassword()).isEqualTo(DEFAULT_PASSWORD);
    }

    @Test
    @Transactional
    public void getAllOcUsers() throws Exception {
        // Initialize the database
        ocUserRepository.saveAndFlush(ocUser);

        // Get all the ocUsers
        restOcUserMockMvc.perform(get("/api/ocUsers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.[0].id").value(ocUser.getId().intValue()))
                .andExpect(jsonPath("$.[0].login").value(DEFAULT_LOGIN.toString()))
                .andExpect(jsonPath("$.[0].password").value(DEFAULT_PASSWORD.toString()));
    }

    @Test
    @Transactional
    public void getOcUser() throws Exception {
        // Initialize the database
        ocUserRepository.saveAndFlush(ocUser);

        // Get the ocUser
        restOcUserMockMvc.perform(get("/api/ocUsers/{id}", ocUser.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.id").value(ocUser.getId().intValue()))
            .andExpect(jsonPath("$.login").value(DEFAULT_LOGIN.toString()))
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingOcUser() throws Exception {
        // Get the ocUser
        restOcUserMockMvc.perform(get("/api/ocUsers/{id}", 1L))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateOcUser() throws Exception {
        // Initialize the database
        ocUserRepository.saveAndFlush(ocUser);

        // Update the ocUser
        ocUser.setLogin(UPDATED_LOGIN);
        ocUser.setPassword(UPDATED_PASSWORD);
        restOcUserMockMvc.perform(post("/api/ocUsers")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(ocUser)))
                .andExpect(status().isOk());

        // Validate the OcUser in the database
        List<OcUser> ocUsers = ocUserRepository.findAll();
        assertThat(ocUsers).hasSize(1);
        OcUser testOcUser = ocUsers.iterator().next();
        assertThat(testOcUser.getLogin()).isEqualTo(UPDATED_LOGIN);
        assertThat(testOcUser.getPassword()).isEqualTo(UPDATED_PASSWORD);
    }

    @Test
    @Transactional
    public void deleteOcUser() throws Exception {
        // Initialize the database
        ocUserRepository.saveAndFlush(ocUser);

        // Get the ocUser
        restOcUserMockMvc.perform(delete("/api/ocUsers/{id}", ocUser.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<OcUser> ocUsers = ocUserRepository.findAll();
        assertThat(ocUsers).hasSize(0);
    }
}

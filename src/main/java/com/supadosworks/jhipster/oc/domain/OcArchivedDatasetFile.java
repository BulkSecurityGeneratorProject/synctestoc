package com.supadosworks.jhipster.oc.domain;


import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * A OcArchivedDatasetFile.
 */
@Entity
@Table(name = "archived_dataset_file")
public class OcArchivedDatasetFile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "archived_dataset_file_id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Column(name = "dataset_id")
    private int datasetId;
    
    @Column(name = "export_format_id")
    private int exportFormatId;
    
    @Column(name = "file_reference")
    private String fileReference;
    
    @Column(name = "run_time")
    private int runTime;
    
    @Column(name = "file_size")
    private int fileSize;
    
    @Column(name = "owner_id")
    private int ownerId;
    
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@Column(name = "date_created")
	private DateTime dateCreated;
	
    public int getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(int datasetId) {
		this.datasetId = datasetId;
	}

	public int getExportFormatId() {
		return exportFormatId;
	}

	public void setExportFormatId(int exportFormatId) {
		this.exportFormatId = exportFormatId;
	}

	public String getFileReference() {
		return fileReference;
	}

	public void setFileReference(String fileReference) {
		this.fileReference = fileReference;
	}

	public int getRunTime() {
		return runTime;
	}

	public void setRunTime(int runTime) {
		this.runTime = runTime;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public DateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(DateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OcArchivedDatasetFile ocArchivedDatasetFile = (OcArchivedDatasetFile) o;

        if (id != null ? !id.equals(ocArchivedDatasetFile.id) : ocArchivedDatasetFile.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "OcArchivedDatasetFile{" +
                "id=" + id +
                ", name='" + name + "'" +
                '}';
    }
}

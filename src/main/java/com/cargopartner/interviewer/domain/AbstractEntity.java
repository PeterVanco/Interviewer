package com.cargopartner.interviewer.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
abstract public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "modified_on")
    private Date modifiedOn;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(final Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    @PrePersist
    @PreUpdate
    private void updateModifiedOn() {
        setModifiedOn(new Date());
    }

}

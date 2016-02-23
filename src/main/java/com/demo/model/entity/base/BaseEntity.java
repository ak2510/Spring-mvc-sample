package com.demo.model.entity.base;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

	/**
     * Gets the created on.
     * 
     * @return the created on
     */
    public Calendar getCreatedOn() {
	return createdOn;
    }

    /**
     * Sets the created on.
     * 
     * @param createdOn
     *            the new created on
     */
    public void setCreatedOn(Calendar createdOn) {
	this.createdOn = createdOn;
    }

    /**
     * Gets the created by.
     * 
     * @return the created by
     */
    public String getCreatedBy() {
	return createdBy;
    }

    /**
     * Sets the created by.
     * 
     * @param createdBy
     *            the new created by
     */
    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    /**
     * Gets the last updated on.
     * 
     * @return the last updated on
     */
    public Calendar getLastUpdatedOn() {
	return lastUpdatedOn;
    }

    /**
     * Sets the last updated on.
     * 
     * @param lastUpdatedOn
     *            the new last updated on
     */
    public void setLastUpdatedOn(Calendar lastUpdatedOn) {
	this.lastUpdatedOn = lastUpdatedOn;
    }

    /**
     * Gets the last updated by.
     * 
     * @return the last updated by
     */
    public String getLastUpdatedBy() {
	return lastUpdatedBy;
    }

    /**
     * Sets the last updated by.
     * 
     * @param lastUpdatedBy
     *            the new last updated by
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
	this.lastUpdatedBy = lastUpdatedBy;
    }

    public BaseEntity() {
	this.createdOn = Calendar.getInstance();
	this.createdBy = "ADMIN";
	this.lastUpdatedOn = Calendar.getInstance();
	this.lastUpdatedBy = "ADMIN";
    }

    @Column(name = "created_on", nullable = false)
    private Calendar createdOn;
    @Column(name = "created_by", length = 50)
    private String createdBy;
    @Column(name = "last_updated_on", nullable = false)
    private Calendar lastUpdatedOn;
    @Column(name = "last_updated_by", length = 50)
    private String lastUpdatedBy;
}

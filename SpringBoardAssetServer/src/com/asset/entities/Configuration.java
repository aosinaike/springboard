/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "configuration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Configuration.findAll", query = "SELECT c FROM Configuration c"),
    @NamedQuery(name = "Configuration.findByConfigurationid", query = "SELECT c FROM Configuration c WHERE c.configurationid = :configurationid"),
    @NamedQuery(name = "Configuration.findByDescription", query = "SELECT c FROM Configuration c WHERE c.description = :description"),
    @NamedQuery(name = "Configuration.findByConfigurationstartdate", query = "SELECT c FROM Configuration c WHERE c.configurationstartdate = :configurationstartdate"),
    @NamedQuery(name = "Configuration.findByConfigurationenddate", query = "SELECT c FROM Configuration c WHERE c.configurationenddate = :configurationenddate"),
    @NamedQuery(name = "Configuration.findByTestingstartdate", query = "SELECT c FROM Configuration c WHERE c.testingstartdate = :testingstartdate"),
    @NamedQuery(name = "Configuration.findByTestingenddate", query = "SELECT c FROM Configuration c WHERE c.testingenddate = :testingenddate"),
    @NamedQuery(name = "Configuration.findByStatus", query = "SELECT c FROM Configuration c WHERE c.status = :status")})
public class Configuration implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "configurationid")
    private Integer configurationid;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "configurationstartdate")
    private String configurationstartdate;
    @Basic(optional = false)
    @Column(name = "configurationenddate")
    private String configurationenddate;
    @Basic(optional = false)
    @Column(name = "testingstartdate")
    private String testingstartdate;
    @Basic(optional = false)
    @Column(name = "testingenddate")
    private String testingenddate;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "configurationtypeid", referencedColumnName = "configurationtypeid")
    @ManyToOne(optional = false)
    private Configurationtype configurationtypeid;
    @JoinColumn(name = "changereviewid", referencedColumnName = "changereviewid")
    @ManyToOne(optional = false)
    private Changereview changereviewid;

    public Configuration() {
    }

    public Configuration(Integer configurationid) {
        this.configurationid = configurationid;
    }

    public Configuration(Integer configurationid, String description, String configurationstartdate, String configurationenddate, String testingstartdate, String testingenddate, int status) {
        this.configurationid = configurationid;
        this.description = description;
        this.configurationstartdate = configurationstartdate;
        this.configurationenddate = configurationenddate;
        this.testingstartdate = testingstartdate;
        this.testingenddate = testingenddate;
        this.status = status;
    }

    public Integer getConfigurationid() {
        return configurationid;
    }

    public void setConfigurationid(Integer configurationid) {
        this.configurationid = configurationid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConfigurationstartdate() {
        return configurationstartdate;
    }

    public void setConfigurationstartdate(String configurationstartdate) {
        this.configurationstartdate = configurationstartdate;
    }

    public String getConfigurationenddate() {
        return configurationenddate;
    }

    public void setConfigurationenddate(String configurationenddate) {
        this.configurationenddate = configurationenddate;
    }

    public String getTestingstartdate() {
        return testingstartdate;
    }

    public void setTestingstartdate(String testingstartdate) {
        this.testingstartdate = testingstartdate;
    }

    public String getTestingenddate() {
        return testingenddate;
    }

    public void setTestingenddate(String testingenddate) {
        this.testingenddate = testingenddate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Configurationtype getConfigurationtypeid() {
        return configurationtypeid;
    }

    public void setConfigurationtypeid(Configurationtype configurationtypeid) {
        this.configurationtypeid = configurationtypeid;
    }

    public Changereview getChangereviewid() {
        return changereviewid;
    }

    public void setChangereviewid(Changereview changereviewid) {
        this.changereviewid = changereviewid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configurationid != null ? configurationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuration)) {
            return false;
        }
        Configuration other = (Configuration) object;
        if ((this.configurationid == null && other.configurationid != null) || (this.configurationid != null && !this.configurationid.equals(other.configurationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Configuration[ configurationid=" + configurationid + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "costunits")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costunits.findAll", query = "SELECT c FROM Costunits c"),
    @NamedQuery(name = "Costunits.findByCostunitid", query = "SELECT c FROM Costunits c WHERE c.costunitid = :costunitid"),
    @NamedQuery(name = "Costunits.findByName", query = "SELECT c FROM Costunits c WHERE c.name = :name"),
    @NamedQuery(name = "Costunits.findByDescription", query = "SELECT c FROM Costunits c WHERE c.description = :description"),
    @NamedQuery(name = "Costunits.findByDatecreated", query = "SELECT c FROM Costunits c WHERE c.datecreated = :datecreated"),
    @NamedQuery(name = "Costunits.findByTimecreated", query = "SELECT c FROM Costunits c WHERE c.timecreated = :timecreated"),
    @NamedQuery(name = "Costunits.findByCreatedby", query = "SELECT c FROM Costunits c WHERE c.createdby = :createdby"),
    @NamedQuery(name = "Costunits.findByStatus", query = "SELECT c FROM Costunits c WHERE c.status = :status")})
public class Costunits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "costunitid")
    private Integer costunitid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "datecreated")
    private String datecreated;
    @Basic(optional = false)
    @Column(name = "timecreated")
    private String timecreated;
    @Basic(optional = false)
    @Column(name = "createdby")
    private int createdby;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costunitid")
    private Collection<Servicecosting> servicecostingCollection;

    public Costunits() {
    }

    public Costunits(Integer costunitid) {
        this.costunitid = costunitid;
    }

    public Costunits(Integer costunitid, String name, String description, String datecreated, String timecreated, int createdby, String status) {
        this.costunitid = costunitid;
        this.name = name;
        this.description = description;
        this.datecreated = datecreated;
        this.timecreated = timecreated;
        this.createdby = createdby;
        this.status = status;
    }

    public Integer getCostunitid() {
        return costunitid;
    }

    public void setCostunitid(Integer costunitid) {
        this.costunitid = costunitid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getTimecreated() {
        return timecreated;
    }

    public void setTimecreated(String timecreated) {
        this.timecreated = timecreated;
    }

    public int getCreatedby() {
        return createdby;
    }

    public void setCreatedby(int createdby) {
        this.createdby = createdby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Servicecosting> getServicecostingCollection() {
        return servicecostingCollection;
    }

    public void setServicecostingCollection(Collection<Servicecosting> servicecostingCollection) {
        this.servicecostingCollection = servicecostingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (costunitid != null ? costunitid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costunits)) {
            return false;
        }
        Costunits other = (Costunits) object;
        if ((this.costunitid == null && other.costunitid != null) || (this.costunitid != null && !this.costunitid.equals(other.costunitid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Costunits[ costunitid=" + costunitid + " ]";
    }
    
}

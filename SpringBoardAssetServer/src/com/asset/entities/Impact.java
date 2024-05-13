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
@Table(name = "impact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Impact.findAll", query = "SELECT i FROM Impact i"),
    @NamedQuery(name = "Impact.findByImpactid", query = "SELECT i FROM Impact i WHERE i.impactid = :impactid"),
    @NamedQuery(name = "Impact.findByName", query = "SELECT i FROM Impact i WHERE i.name = :name"),
    @NamedQuery(name = "Impact.findByRange", query = "SELECT i FROM Impact i WHERE i.range = :range"),
    @NamedQuery(name = "Impact.findByDescription", query = "SELECT i FROM Impact i WHERE i.description = :description"),
    @NamedQuery(name = "Impact.findByStatus", query = "SELECT i FROM Impact i WHERE i.status = :status")})
public class Impact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "impactid")
    private Integer impactid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "range")
    private String range;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "impactid")
    private Collection<Changereview> changereviewCollection;

    public Impact() {
    }

    public Impact(Integer impactid) {
        this.impactid = impactid;
    }

    public Impact(Integer impactid, String name, String range, String status) {
        this.impactid = impactid;
        this.name = name;
        this.range = range;
        this.status = status;
    }

    public Integer getImpactid() {
        return impactid;
    }

    public void setImpactid(Integer impactid) {
        this.impactid = impactid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Changereview> getChangereviewCollection() {
        return changereviewCollection;
    }

    public void setChangereviewCollection(Collection<Changereview> changereviewCollection) {
        this.changereviewCollection = changereviewCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (impactid != null ? impactid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Impact)) {
            return false;
        }
        Impact other = (Impact) object;
        if ((this.impactid == null && other.impactid != null) || (this.impactid != null && !this.impactid.equals(other.impactid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Impact[ impactid=" + impactid + " ]";
    }
    
}

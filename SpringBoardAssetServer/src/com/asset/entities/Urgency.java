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
@Table(name = "urgency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Urgency.findAll", query = "SELECT u FROM Urgency u"),
    @NamedQuery(name = "Urgency.findByUrgencyid", query = "SELECT u FROM Urgency u WHERE u.urgencyid = :urgencyid"),
    @NamedQuery(name = "Urgency.findByName", query = "SELECT u FROM Urgency u WHERE u.name = :name"),
    @NamedQuery(name = "Urgency.findByDescription", query = "SELECT u FROM Urgency u WHERE u.description = :description"),
    @NamedQuery(name = "Urgency.findByStatus", query = "SELECT u FROM Urgency u WHERE u.status = :status")})
public class Urgency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "urgencyid")
    private Integer urgencyid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urgencyid")
    private Collection<Problem> problemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urgencyid")
    private Collection<Changereview> changereviewCollection;

    public Urgency() {
    }

    public Urgency(Integer urgencyid) {
        this.urgencyid = urgencyid;
    }

    public Urgency(Integer urgencyid, String name, String status) {
        this.urgencyid = urgencyid;
        this.name = name;
        this.status = status;
    }

    public Integer getUrgencyid() {
        return urgencyid;
    }

    public void setUrgencyid(Integer urgencyid) {
        this.urgencyid = urgencyid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Problem> getProblemCollection() {
        return problemCollection;
    }

    public void setProblemCollection(Collection<Problem> problemCollection) {
        this.problemCollection = problemCollection;
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
        hash += (urgencyid != null ? urgencyid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Urgency)) {
            return false;
        }
        Urgency other = (Urgency) object;
        if ((this.urgencyid == null && other.urgencyid != null) || (this.urgencyid != null && !this.urgencyid.equals(other.urgencyid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Urgency[ urgencyid=" + urgencyid + " ]";
    }
    
}

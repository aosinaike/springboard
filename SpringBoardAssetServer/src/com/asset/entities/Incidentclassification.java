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
@Table(name = "incidentclassification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidentclassification.findAll", query = "SELECT i FROM Incidentclassification i"),
    @NamedQuery(name = "Incidentclassification.findByIncidentclassificationid", query = "SELECT i FROM Incidentclassification i WHERE i.incidentclassificationid = :incidentclassificationid"),
    @NamedQuery(name = "Incidentclassification.findByClassification", query = "SELECT i FROM Incidentclassification i WHERE i.classification = :classification"),
    @NamedQuery(name = "Incidentclassification.findByDescription", query = "SELECT i FROM Incidentclassification i WHERE i.description = :description")})
public class Incidentclassification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "incidentclassificationid")
    private Integer incidentclassificationid;
    @Basic(optional = false)
    @Column(name = "classification")
    private String classification;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "incidentclassificationid")
    private Collection<Incident> incidentCollection;

    public Incidentclassification() {
    }

    public Incidentclassification(Integer incidentclassificationid) {
        this.incidentclassificationid = incidentclassificationid;
    }

    public Incidentclassification(Integer incidentclassificationid, String classification, String description) {
        this.incidentclassificationid = incidentclassificationid;
        this.classification = classification;
        this.description = description;
    }

    public Integer getIncidentclassificationid() {
        return incidentclassificationid;
    }

    public void setIncidentclassificationid(Integer incidentclassificationid) {
        this.incidentclassificationid = incidentclassificationid;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Incident> getIncidentCollection() {
        return incidentCollection;
    }

    public void setIncidentCollection(Collection<Incident> incidentCollection) {
        this.incidentCollection = incidentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incidentclassificationid != null ? incidentclassificationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidentclassification)) {
            return false;
        }
        Incidentclassification other = (Incidentclassification) object;
        if ((this.incidentclassificationid == null && other.incidentclassificationid != null) || (this.incidentclassificationid != null && !this.incidentclassificationid.equals(other.incidentclassificationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Incidentclassification[ incidentclassificationid=" + incidentclassificationid + " ]";
    }
    
}

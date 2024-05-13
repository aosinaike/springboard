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
@Table(name = "prioritization")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prioritization.findAll", query = "SELECT p FROM Prioritization p"),
    @NamedQuery(name = "Prioritization.findByPrioritizationid", query = "SELECT p FROM Prioritization p WHERE p.prioritizationid = :prioritizationid"),
    @NamedQuery(name = "Prioritization.findByPriority", query = "SELECT p FROM Prioritization p WHERE p.priority = :priority"),
    @NamedQuery(name = "Prioritization.findByDescription", query = "SELECT p FROM Prioritization p WHERE p.description = :description"),
    @NamedQuery(name = "Prioritization.findByStatus", query = "SELECT p FROM Prioritization p WHERE p.status = :status")})
public class Prioritization implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prioritizationid")
    private Integer prioritizationid;
    @Basic(optional = false)
    @Column(name = "priority")
    private String priority;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "priorityid")
    private Collection<Problem> problemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prioritizationid")
    private Collection<Changereview> changereviewCollection;

    public Prioritization() {
    }

    public Prioritization(Integer prioritizationid) {
        this.prioritizationid = prioritizationid;
    }

    public Prioritization(Integer prioritizationid, String priority, String description, String status) {
        this.prioritizationid = prioritizationid;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    public Integer getPrioritizationid() {
        return prioritizationid;
    }

    public void setPrioritizationid(Integer prioritizationid) {
        this.prioritizationid = prioritizationid;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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
        hash += (prioritizationid != null ? prioritizationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prioritization)) {
            return false;
        }
        Prioritization other = (Prioritization) object;
        if ((this.prioritizationid == null && other.prioritizationid != null) || (this.prioritizationid != null && !this.prioritizationid.equals(other.prioritizationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Prioritization[ prioritizationid=" + prioritizationid + " ]";
    }
    
}

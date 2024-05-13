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
@Table(name = "rfcclassification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rfcclassification.findAll", query = "SELECT r FROM Rfcclassification r"),
    @NamedQuery(name = "Rfcclassification.findByClassificationid", query = "SELECT r FROM Rfcclassification r WHERE r.classificationid = :classificationid"),
    @NamedQuery(name = "Rfcclassification.findByClass1", query = "SELECT r FROM Rfcclassification r WHERE r.class1 = :class1"),
    @NamedQuery(name = "Rfcclassification.findByDescription", query = "SELECT r FROM Rfcclassification r WHERE r.description = :description"),
    @NamedQuery(name = "Rfcclassification.findByStatus", query = "SELECT r FROM Rfcclassification r WHERE r.status = :status")})
public class Rfcclassification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "classificationid")
    private Integer classificationid;
    @Basic(optional = false)
    @Column(name = "class")
    private String class1;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classificationid")
    private Collection<Changereview> changereviewCollection;

    public Rfcclassification() {
    }

    public Rfcclassification(Integer classificationid) {
        this.classificationid = classificationid;
    }

    public Rfcclassification(Integer classificationid, String class1, String description, String status) {
        this.classificationid = classificationid;
        this.class1 = class1;
        this.description = description;
        this.status = status;
    }

    public Integer getClassificationid() {
        return classificationid;
    }

    public void setClassificationid(Integer classificationid) {
        this.classificationid = classificationid;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
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
        hash += (classificationid != null ? classificationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rfcclassification)) {
            return false;
        }
        Rfcclassification other = (Rfcclassification) object;
        if ((this.classificationid == null && other.classificationid != null) || (this.classificationid != null && !this.classificationid.equals(other.classificationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Rfcclassification[ classificationid=" + classificationid + " ]";
    }
    
}

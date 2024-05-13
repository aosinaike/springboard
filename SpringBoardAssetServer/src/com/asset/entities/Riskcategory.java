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
@Table(name = "riskcategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Riskcategory.findAll", query = "SELECT r FROM Riskcategory r"),
    @NamedQuery(name = "Riskcategory.findByRiskcategoryid", query = "SELECT r FROM Riskcategory r WHERE r.riskcategoryid = :riskcategoryid"),
    @NamedQuery(name = "Riskcategory.findByDescription", query = "SELECT r FROM Riskcategory r WHERE r.description = :description")})
public class Riskcategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "riskcategoryid")
    private Integer riskcategoryid;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "riskcategoryid")
    private Collection<Changereview> changereviewCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "riskcategoryid")
    private Collection<Requestforchange> requestforchangeCollection;

    public Riskcategory() {
    }

    public Riskcategory(Integer riskcategoryid) {
        this.riskcategoryid = riskcategoryid;
    }

    public Riskcategory(Integer riskcategoryid, String description) {
        this.riskcategoryid = riskcategoryid;
        this.description = description;
    }

    public Integer getRiskcategoryid() {
        return riskcategoryid;
    }

    public void setRiskcategoryid(Integer riskcategoryid) {
        this.riskcategoryid = riskcategoryid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Changereview> getChangereviewCollection() {
        return changereviewCollection;
    }

    public void setChangereviewCollection(Collection<Changereview> changereviewCollection) {
        this.changereviewCollection = changereviewCollection;
    }

    @XmlTransient
    public Collection<Requestforchange> getRequestforchangeCollection() {
        return requestforchangeCollection;
    }

    public void setRequestforchangeCollection(Collection<Requestforchange> requestforchangeCollection) {
        this.requestforchangeCollection = requestforchangeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (riskcategoryid != null ? riskcategoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Riskcategory)) {
            return false;
        }
        Riskcategory other = (Riskcategory) object;
        if ((this.riskcategoryid == null && other.riskcategoryid != null) || (this.riskcategoryid != null && !this.riskcategoryid.equals(other.riskcategoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Riskcategory[ riskcategoryid=" + riskcategoryid + " ]";
    }
    
}

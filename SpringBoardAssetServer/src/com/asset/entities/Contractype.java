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
@Table(name = "contractype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contractype.findAll", query = "SELECT c FROM Contractype c"),
    @NamedQuery(name = "Contractype.findByContractypeid", query = "SELECT c FROM Contractype c WHERE c.contractypeid = :contractypeid"),
    @NamedQuery(name = "Contractype.findByName", query = "SELECT c FROM Contractype c WHERE c.name = :name"),
    @NamedQuery(name = "Contractype.findByDescription", query = "SELECT c FROM Contractype c WHERE c.description = :description"),
    @NamedQuery(name = "Contractype.findByStatus", query = "SELECT c FROM Contractype c WHERE c.status = :status")})
public class Contractype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "contractypeid")
    private Integer contractypeid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contracttypeid")
    private Collection<Contract> contractCollection;

    public Contractype() {
    }

    public Contractype(Integer contractypeid) {
        this.contractypeid = contractypeid;
    }

    public Contractype(Integer contractypeid, String name, String description, String status) {
        this.contractypeid = contractypeid;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public Integer getContractypeid() {
        return contractypeid;
    }

    public void setContractypeid(Integer contractypeid) {
        this.contractypeid = contractypeid;
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
    public Collection<Contract> getContractCollection() {
        return contractCollection;
    }

    public void setContractCollection(Collection<Contract> contractCollection) {
        this.contractCollection = contractCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractypeid != null ? contractypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contractype)) {
            return false;
        }
        Contractype other = (Contractype) object;
        if ((this.contractypeid == null && other.contractypeid != null) || (this.contractypeid != null && !this.contractypeid.equals(other.contractypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Contractype[ contractypeid=" + contractypeid + " ]";
    }
    
}

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
@Table(name = "chargebacktype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chargebacktype.findAll", query = "SELECT c FROM Chargebacktype c"),
    @NamedQuery(name = "Chargebacktype.findByChargebacktypeid", query = "SELECT c FROM Chargebacktype c WHERE c.chargebacktypeid = :chargebacktypeid"),
    @NamedQuery(name = "Chargebacktype.findByName", query = "SELECT c FROM Chargebacktype c WHERE c.name = :name"),
    @NamedQuery(name = "Chargebacktype.findByStatus", query = "SELECT c FROM Chargebacktype c WHERE c.status = :status")})
public class Chargebacktype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "chargebacktypeid")
    private Integer chargebacktypeid;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chargebacktypeid")
    private Collection<Account> accountCollection;

    public Chargebacktype() {
    }

    public Chargebacktype(Integer chargebacktypeid) {
        this.chargebacktypeid = chargebacktypeid;
    }

    public Chargebacktype(Integer chargebacktypeid, String name, String status) {
        this.chargebacktypeid = chargebacktypeid;
        this.name = name;
        this.status = status;
    }

    public Integer getChargebacktypeid() {
        return chargebacktypeid;
    }

    public void setChargebacktypeid(Integer chargebacktypeid) {
        this.chargebacktypeid = chargebacktypeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Account> getAccountCollection() {
        return accountCollection;
    }

    public void setAccountCollection(Collection<Account> accountCollection) {
        this.accountCollection = accountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chargebacktypeid != null ? chargebacktypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chargebacktype)) {
            return false;
        }
        Chargebacktype other = (Chargebacktype) object;
        if ((this.chargebacktypeid == null && other.chargebacktypeid != null) || (this.chargebacktypeid != null && !this.chargebacktypeid.equals(other.chargebacktypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Chargebacktype[ chargebacktypeid=" + chargebacktypeid + " ]";
    }
    
}

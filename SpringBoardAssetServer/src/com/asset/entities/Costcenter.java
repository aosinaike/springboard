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
@Table(name = "costcenter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costcenter.findAll", query = "SELECT c FROM Costcenter c"),
    @NamedQuery(name = "Costcenter.findByCostcenterid", query = "SELECT c FROM Costcenter c WHERE c.costcenterid = :costcenterid"),
    @NamedQuery(name = "Costcenter.findByName", query = "SELECT c FROM Costcenter c WHERE c.name = :name"),
    @NamedQuery(name = "Costcenter.findByMembers", query = "SELECT c FROM Costcenter c WHERE c.members = :members"),
    @NamedQuery(name = "Costcenter.findByDescription", query = "SELECT c FROM Costcenter c WHERE c.description = :description"),
    @NamedQuery(name = "Costcenter.findByStatus", query = "SELECT c FROM Costcenter c WHERE c.status = :status")})
public class Costcenter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "costcenterid")
    private Integer costcenterid;
    @Column(name = "name")
    private String name;
    @Column(name = "members")
    private String members;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costcenterid")
    private Collection<Unit> unitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costcenterid")
    private Collection<Department> departmentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "costcenterid")
    private Collection<Account> accountCollection;

    public Costcenter() {
    }

    public Costcenter(Integer costcenterid) {
        this.costcenterid = costcenterid;
    }

    public Integer getCostcenterid() {
        return costcenterid;
    }

    public void setCostcenterid(Integer costcenterid) {
        this.costcenterid = costcenterid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
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
    public Collection<Unit> getUnitCollection() {
        return unitCollection;
    }

    public void setUnitCollection(Collection<Unit> unitCollection) {
        this.unitCollection = unitCollection;
    }

    @XmlTransient
    public Collection<Department> getDepartmentCollection() {
        return departmentCollection;
    }

    public void setDepartmentCollection(Collection<Department> departmentCollection) {
        this.departmentCollection = departmentCollection;
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
        hash += (costcenterid != null ? costcenterid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Costcenter)) {
            return false;
        }
        Costcenter other = (Costcenter) object;
        if ((this.costcenterid == null && other.costcenterid != null) || (this.costcenterid != null && !this.costcenterid.equals(other.costcenterid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Costcenter[ costcenterid=" + costcenterid + " ]";
    }
    
}

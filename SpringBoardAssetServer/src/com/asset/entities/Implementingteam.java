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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "implementingteam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Implementingteam.findAll", query = "SELECT i FROM Implementingteam i"),
    @NamedQuery(name = "Implementingteam.findByImplementingteamid", query = "SELECT i FROM Implementingteam i WHERE i.implementingteamid = :implementingteamid"),
    @NamedQuery(name = "Implementingteam.findByImplementingteamcompany", query = "SELECT i FROM Implementingteam i WHERE i.implementingteamcompany = :implementingteamcompany"),
    @NamedQuery(name = "Implementingteam.findByAddress", query = "SELECT i FROM Implementingteam i WHERE i.address = :address"),
    @NamedQuery(name = "Implementingteam.findByImplementteamlead", query = "SELECT i FROM Implementingteam i WHERE i.implementteamlead = :implementteamlead"),
    @NamedQuery(name = "Implementingteam.findByDateimplemented", query = "SELECT i FROM Implementingteam i WHERE i.dateimplemented = :dateimplemented"),
    @NamedQuery(name = "Implementingteam.findByTimeimplemented", query = "SELECT i FROM Implementingteam i WHERE i.timeimplemented = :timeimplemented"),
    @NamedQuery(name = "Implementingteam.findByStatus", query = "SELECT i FROM Implementingteam i WHERE i.status = :status")})
public class Implementingteam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "implementingteamid")
    private Integer implementingteamid;
    @Basic(optional = false)
    @Column(name = "implementingteamcompany")
    private String implementingteamcompany;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "implementteamlead")
    private String implementteamlead;
    @Basic(optional = false)
    @Column(name = "dateimplemented")
    private String dateimplemented;
    @Basic(optional = false)
    @Column(name = "timeimplemented")
    private String timeimplemented;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "implementingteamid")
    private Collection<Requestforchange> requestforchangeCollection;
    @JoinColumn(name = "implementunit", referencedColumnName = "unitid")
    @ManyToOne(optional = false)
    private Unit implementunit;
    @JoinColumn(name = "implementdepartmentid", referencedColumnName = "departmentid")
    @ManyToOne(optional = false)
    private Department implementdepartmentid;

    public Implementingteam() {
    }

    public Implementingteam(Integer implementingteamid) {
        this.implementingteamid = implementingteamid;
    }

    public Implementingteam(Integer implementingteamid, String implementingteamcompany, String address, String implementteamlead, String dateimplemented, String timeimplemented, int status) {
        this.implementingteamid = implementingteamid;
        this.implementingteamcompany = implementingteamcompany;
        this.address = address;
        this.implementteamlead = implementteamlead;
        this.dateimplemented = dateimplemented;
        this.timeimplemented = timeimplemented;
        this.status = status;
    }

    public Integer getImplementingteamid() {
        return implementingteamid;
    }

    public void setImplementingteamid(Integer implementingteamid) {
        this.implementingteamid = implementingteamid;
    }

    public String getImplementingteamcompany() {
        return implementingteamcompany;
    }

    public void setImplementingteamcompany(String implementingteamcompany) {
        this.implementingteamcompany = implementingteamcompany;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImplementteamlead() {
        return implementteamlead;
    }

    public void setImplementteamlead(String implementteamlead) {
        this.implementteamlead = implementteamlead;
    }

    public String getDateimplemented() {
        return dateimplemented;
    }

    public void setDateimplemented(String dateimplemented) {
        this.dateimplemented = dateimplemented;
    }

    public String getTimeimplemented() {
        return timeimplemented;
    }

    public void setTimeimplemented(String timeimplemented) {
        this.timeimplemented = timeimplemented;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Requestforchange> getRequestforchangeCollection() {
        return requestforchangeCollection;
    }

    public void setRequestforchangeCollection(Collection<Requestforchange> requestforchangeCollection) {
        this.requestforchangeCollection = requestforchangeCollection;
    }

    public Unit getImplementunit() {
        return implementunit;
    }

    public void setImplementunit(Unit implementunit) {
        this.implementunit = implementunit;
    }

    public Department getImplementdepartmentid() {
        return implementdepartmentid;
    }

    public void setImplementdepartmentid(Department implementdepartmentid) {
        this.implementdepartmentid = implementdepartmentid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (implementingteamid != null ? implementingteamid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Implementingteam)) {
            return false;
        }
        Implementingteam other = (Implementingteam) object;
        if ((this.implementingteamid == null && other.implementingteamid != null) || (this.implementingteamid != null && !this.implementingteamid.equals(other.implementingteamid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Implementingteam[ implementingteamid=" + implementingteamid + " ]";
    }
    
}

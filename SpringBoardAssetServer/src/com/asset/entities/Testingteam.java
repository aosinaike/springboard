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
@Table(name = "testingteam")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Testingteam.findAll", query = "SELECT t FROM Testingteam t"),
    @NamedQuery(name = "Testingteam.findByTestingteamid", query = "SELECT t FROM Testingteam t WHERE t.testingteamid = :testingteamid"),
    @NamedQuery(name = "Testingteam.findByCompany", query = "SELECT t FROM Testingteam t WHERE t.company = :company"),
    @NamedQuery(name = "Testingteam.findByAddress", query = "SELECT t FROM Testingteam t WHERE t.address = :address"),
    @NamedQuery(name = "Testingteam.findByLeadtester", query = "SELECT t FROM Testingteam t WHERE t.leadtester = :leadtester"),
    @NamedQuery(name = "Testingteam.findByDatetested", query = "SELECT t FROM Testingteam t WHERE t.datetested = :datetested"),
    @NamedQuery(name = "Testingteam.findByTimetested", query = "SELECT t FROM Testingteam t WHERE t.timetested = :timetested"),
    @NamedQuery(name = "Testingteam.findByStatus", query = "SELECT t FROM Testingteam t WHERE t.status = :status")})
public class Testingteam implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "testingteamid")
    private Integer testingteamid;
    @Basic(optional = false)
    @Column(name = "company")
    private String company;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "leadtester")
    private String leadtester;
    @Basic(optional = false)
    @Column(name = "datetested")
    private String datetested;
    @Basic(optional = false)
    @Column(name = "timetested")
    private String timetested;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "testingunitid", referencedColumnName = "unitid")
    @ManyToOne
    private Unit testingunitid;
    @JoinColumn(name = "testingdepartmentid", referencedColumnName = "departmentid")
    @ManyToOne(optional = false)
    private Department testingdepartmentid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testingteamid")
    private Collection<Requestforchange> requestforchangeCollection;

    public Testingteam() {
    }

    public Testingteam(Integer testingteamid) {
        this.testingteamid = testingteamid;
    }

    public Testingteam(Integer testingteamid, String company, String address, String leadtester, String datetested, String timetested, String status) {
        this.testingteamid = testingteamid;
        this.company = company;
        this.address = address;
        this.leadtester = leadtester;
        this.datetested = datetested;
        this.timetested = timetested;
        this.status = status;
    }

    public Integer getTestingteamid() {
        return testingteamid;
    }

    public void setTestingteamid(Integer testingteamid) {
        this.testingteamid = testingteamid;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLeadtester() {
        return leadtester;
    }

    public void setLeadtester(String leadtester) {
        this.leadtester = leadtester;
    }

    public String getDatetested() {
        return datetested;
    }

    public void setDatetested(String datetested) {
        this.datetested = datetested;
    }

    public String getTimetested() {
        return timetested;
    }

    public void setTimetested(String timetested) {
        this.timetested = timetested;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Unit getTestingunitid() {
        return testingunitid;
    }

    public void setTestingunitid(Unit testingunitid) {
        this.testingunitid = testingunitid;
    }

    public Department getTestingdepartmentid() {
        return testingdepartmentid;
    }

    public void setTestingdepartmentid(Department testingdepartmentid) {
        this.testingdepartmentid = testingdepartmentid;
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
        hash += (testingteamid != null ? testingteamid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testingteam)) {
            return false;
        }
        Testingteam other = (Testingteam) object;
        if ((this.testingteamid == null && other.testingteamid != null) || (this.testingteamid != null && !this.testingteamid.equals(other.testingteamid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Testingteam[ testingteamid=" + testingteamid + " ]";
    }
    
}

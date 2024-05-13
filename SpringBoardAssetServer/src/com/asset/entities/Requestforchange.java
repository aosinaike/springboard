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
@Table(name = "requestforchange")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requestforchange.findAll", query = "SELECT r FROM Requestforchange r"),
    @NamedQuery(name = "Requestforchange.findByRequestforchangeid", query = "SELECT r FROM Requestforchange r WHERE r.requestforchangeid = :requestforchangeid"),
    @NamedQuery(name = "Requestforchange.findByChangerequestnumber", query = "SELECT r FROM Requestforchange r WHERE r.changerequestnumber = :changerequestnumber"),
    @NamedQuery(name = "Requestforchange.findByChangescope", query = "SELECT r FROM Requestforchange r WHERE r.changescope = :changescope"),
    @NamedQuery(name = "Requestforchange.findByChangetype", query = "SELECT r FROM Requestforchange r WHERE r.changetype = :changetype"),
    @NamedQuery(name = "Requestforchange.findByLocation", query = "SELECT r FROM Requestforchange r WHERE r.location = :location"),
    @NamedQuery(name = "Requestforchange.findByAuthorizedby", query = "SELECT r FROM Requestforchange r WHERE r.authorizedby = :authorizedby"),
    @NamedQuery(name = "Requestforchange.findByOperatingguide", query = "SELECT r FROM Requestforchange r WHERE r.operatingguide = :operatingguide"),
    @NamedQuery(name = "Requestforchange.findByFallbackprocedureguide", query = "SELECT r FROM Requestforchange r WHERE r.fallbackprocedureguide = :fallbackprocedureguide"),
    @NamedQuery(name = "Requestforchange.findByApprovedby", query = "SELECT r FROM Requestforchange r WHERE r.approvedby = :approvedby"),
    @NamedQuery(name = "Requestforchange.findByPlannedchangedate", query = "SELECT r FROM Requestforchange r WHERE r.plannedchangedate = :plannedchangedate"),
    @NamedQuery(name = "Requestforchange.findByDaterequested", query = "SELECT r FROM Requestforchange r WHERE r.daterequested = :daterequested"),
    @NamedQuery(name = "Requestforchange.findByTimerequested", query = "SELECT r FROM Requestforchange r WHERE r.timerequested = :timerequested"),
    @NamedQuery(name = "Requestforchange.findByStatusdisposition", query = "SELECT r FROM Requestforchange r WHERE r.statusdisposition = :statusdisposition")})
public class Requestforchange implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "requestforchangeid")
    private Long requestforchangeid;
    @Basic(optional = false)
    @Column(name = "changerequestnumber")
    private String changerequestnumber;
    @Basic(optional = false)
    @Column(name = "changescope")
    private String changescope;
    @Basic(optional = false)
    @Column(name = "changetype")
    private String changetype;
    @Basic(optional = false)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @Column(name = "authorizedby")
    private String authorizedby;
    @Basic(optional = false)
    @Column(name = "operatingguide")
    private String operatingguide;
    @Basic(optional = false)
    @Column(name = "fallbackprocedureguide")
    private String fallbackprocedureguide;
    @Basic(optional = false)
    @Column(name = "approvedby")
    private int approvedby;
    @Basic(optional = false)
    @Column(name = "plannedchangedate")
    private String plannedchangedate;
    @Basic(optional = false)
    @Column(name = "daterequested")
    private String daterequested;
    @Basic(optional = false)
    @Column(name = "timerequested")
    private String timerequested;
    @Basic(optional = false)
    @Column(name = "statusdisposition")
    private int statusdisposition;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestforchangeid")
    private Collection<Changereview> changereviewCollection;
    @JoinColumn(name = "changerequestedby", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User changerequestedby;
    @JoinColumn(name = "implementingteamid", referencedColumnName = "implementingteamid")
    @ManyToOne(optional = false)
    private Implementingteam implementingteamid;
    @JoinColumn(name = "problemid", referencedColumnName = "problemid")
    @ManyToOne(optional = false)
    private Problem problemid;
    @JoinColumn(name = "riskcategoryid", referencedColumnName = "riskcategoryid")
    @ManyToOne(optional = false)
    private Riskcategory riskcategoryid;
    @JoinColumn(name = "testingteamid", referencedColumnName = "testingteamid")
    @ManyToOne(optional = false)
    private Testingteam testingteamid;

    public Requestforchange() {
    }

    public Requestforchange(Long requestforchangeid) {
        this.requestforchangeid = requestforchangeid;
    }

    public Requestforchange(Long requestforchangeid, String changerequestnumber, String changescope, String changetype, String location, String authorizedby, String operatingguide, String fallbackprocedureguide, int approvedby, String plannedchangedate, String daterequested, String timerequested, int statusdisposition) {
        this.requestforchangeid = requestforchangeid;
        this.changerequestnumber = changerequestnumber;
        this.changescope = changescope;
        this.changetype = changetype;
        this.location = location;
        this.authorizedby = authorizedby;
        this.operatingguide = operatingguide;
        this.fallbackprocedureguide = fallbackprocedureguide;
        this.approvedby = approvedby;
        this.plannedchangedate = plannedchangedate;
        this.daterequested = daterequested;
        this.timerequested = timerequested;
        this.statusdisposition = statusdisposition;
    }

    public Long getRequestforchangeid() {
        return requestforchangeid;
    }

    public void setRequestforchangeid(Long requestforchangeid) {
        this.requestforchangeid = requestforchangeid;
    }

    public String getChangerequestnumber() {
        return changerequestnumber;
    }

    public void setChangerequestnumber(String changerequestnumber) {
        this.changerequestnumber = changerequestnumber;
    }

    public String getChangescope() {
        return changescope;
    }

    public void setChangescope(String changescope) {
        this.changescope = changescope;
    }

    public String getChangetype() {
        return changetype;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAuthorizedby() {
        return authorizedby;
    }

    public void setAuthorizedby(String authorizedby) {
        this.authorizedby = authorizedby;
    }

    public String getOperatingguide() {
        return operatingguide;
    }

    public void setOperatingguide(String operatingguide) {
        this.operatingguide = operatingguide;
    }

    public String getFallbackprocedureguide() {
        return fallbackprocedureguide;
    }

    public void setFallbackprocedureguide(String fallbackprocedureguide) {
        this.fallbackprocedureguide = fallbackprocedureguide;
    }

    public int getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(int approvedby) {
        this.approvedby = approvedby;
    }

    public String getPlannedchangedate() {
        return plannedchangedate;
    }

    public void setPlannedchangedate(String plannedchangedate) {
        this.plannedchangedate = plannedchangedate;
    }

    public String getDaterequested() {
        return daterequested;
    }

    public void setDaterequested(String daterequested) {
        this.daterequested = daterequested;
    }

    public String getTimerequested() {
        return timerequested;
    }

    public void setTimerequested(String timerequested) {
        this.timerequested = timerequested;
    }

    public int getStatusdisposition() {
        return statusdisposition;
    }

    public void setStatusdisposition(int statusdisposition) {
        this.statusdisposition = statusdisposition;
    }

    @XmlTransient
    public Collection<Changereview> getChangereviewCollection() {
        return changereviewCollection;
    }

    public void setChangereviewCollection(Collection<Changereview> changereviewCollection) {
        this.changereviewCollection = changereviewCollection;
    }

    public User getChangerequestedby() {
        return changerequestedby;
    }

    public void setChangerequestedby(User changerequestedby) {
        this.changerequestedby = changerequestedby;
    }

    public Implementingteam getImplementingteamid() {
        return implementingteamid;
    }

    public void setImplementingteamid(Implementingteam implementingteamid) {
        this.implementingteamid = implementingteamid;
    }

    public Problem getProblemid() {
        return problemid;
    }

    public void setProblemid(Problem problemid) {
        this.problemid = problemid;
    }

    public Riskcategory getRiskcategoryid() {
        return riskcategoryid;
    }

    public void setRiskcategoryid(Riskcategory riskcategoryid) {
        this.riskcategoryid = riskcategoryid;
    }

    public Testingteam getTestingteamid() {
        return testingteamid;
    }

    public void setTestingteamid(Testingteam testingteamid) {
        this.testingteamid = testingteamid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestforchangeid != null ? requestforchangeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requestforchange)) {
            return false;
        }
        Requestforchange other = (Requestforchange) object;
        if ((this.requestforchangeid == null && other.requestforchangeid != null) || (this.requestforchangeid != null && !this.requestforchangeid.equals(other.requestforchangeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Requestforchange[ requestforchangeid=" + requestforchangeid + " ]";
    }
    
}

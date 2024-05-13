/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asset.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Abiodun-PC
 */
@Entity
@Table(name = "approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Approval.findAll", query = "SELECT a FROM Approval a"),
    @NamedQuery(name = "Approval.findByApprovalid", query = "SELECT a FROM Approval a WHERE a.approvalid = :approvalid"),
    @NamedQuery(name = "Approval.findByDatesent", query = "SELECT a FROM Approval a WHERE a.datesent = :datesent"),
    @NamedQuery(name = "Approval.findByTimesent", query = "SELECT a FROM Approval a WHERE a.timesent = :timesent"),
    @NamedQuery(name = "Approval.findByDateapproved", query = "SELECT a FROM Approval a WHERE a.dateapproved = :dateapproved"),
    @NamedQuery(name = "Approval.findByTimeapproved", query = "SELECT a FROM Approval a WHERE a.timeapproved = :timeapproved"),
    @NamedQuery(name = "Approval.findByApprovedby", query = "SELECT a FROM Approval a WHERE a.approvedby = :approvedby"),
    @NamedQuery(name = "Approval.findByStatus", query = "SELECT a FROM Approval a WHERE a.status = :status")})
public class Approval implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "approvalid")
    private Integer approvalid;
    @Basic(optional = false)
    @Column(name = "datesent")
    private String datesent;
    @Basic(optional = false)
    @Column(name = "timesent")
    private String timesent;
    @Column(name = "dateapproved")
    private String dateapproved;
    @Column(name = "timeapproved")
    private String timeapproved;
    @Basic(optional = false)
    @Column(name = "approvedby")
    private int approvedby;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "servicedeskid", referencedColumnName = "servicedeskid")
    @ManyToOne(optional = false)
    private Servicedesk servicedeskid;

    public Approval() {
    }

    public Approval(Integer approvalid) {
        this.approvalid = approvalid;
    }

    public Approval(Integer approvalid, String datesent, String timesent, int approvedby, String status) {
        this.approvalid = approvalid;
        this.datesent = datesent;
        this.timesent = timesent;
        this.approvedby = approvedby;
        this.status = status;
    }

    public Integer getApprovalid() {
        return approvalid;
    }

    public void setApprovalid(Integer approvalid) {
        this.approvalid = approvalid;
    }

    public String getDatesent() {
        return datesent;
    }

    public void setDatesent(String datesent) {
        this.datesent = datesent;
    }

    public String getTimesent() {
        return timesent;
    }

    public void setTimesent(String timesent) {
        this.timesent = timesent;
    }

    public String getDateapproved() {
        return dateapproved;
    }

    public void setDateapproved(String dateapproved) {
        this.dateapproved = dateapproved;
    }

    public String getTimeapproved() {
        return timeapproved;
    }

    public void setTimeapproved(String timeapproved) {
        this.timeapproved = timeapproved;
    }

    public int getApprovedby() {
        return approvedby;
    }

    public void setApprovedby(int approvedby) {
        this.approvedby = approvedby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Servicedesk getServicedeskid() {
        return servicedeskid;
    }

    public void setServicedeskid(Servicedesk servicedeskid) {
        this.servicedeskid = servicedeskid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (approvalid != null ? approvalid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Approval)) {
            return false;
        }
        Approval other = (Approval) object;
        if ((this.approvalid == null && other.approvalid != null) || (this.approvalid != null && !this.approvalid.equals(other.approvalid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Approval[ approvalid=" + approvalid + " ]";
    }
    
}

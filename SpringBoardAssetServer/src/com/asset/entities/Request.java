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
@Table(name = "request")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findByRequestid", query = "SELECT r FROM Request r WHERE r.requestid = :requestid"),
    @NamedQuery(name = "Request.findByRequestdescription", query = "SELECT r FROM Request r WHERE r.requestdescription = :requestdescription"),
    @NamedQuery(name = "Request.findByRequestfrom", query = "SELECT r FROM Request r WHERE r.requestfrom = :requestfrom"),
    @NamedQuery(name = "Request.findByRequestdate", query = "SELECT r FROM Request r WHERE r.requestdate = :requestdate"),
    @NamedQuery(name = "Request.findByRequesttime", query = "SELECT r FROM Request r WHERE r.requesttime = :requesttime"),
    @NamedQuery(name = "Request.findByStatus", query = "SELECT r FROM Request r WHERE r.status = :status")})
public class Request implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "requestid")
    private Long requestid;
    @Basic(optional = false)
    @Column(name = "requestdescription")
    private String requestdescription;
    @Basic(optional = false)
    @Column(name = "requestfrom")
    private String requestfrom;
    @Basic(optional = false)
    @Column(name = "requestdate")
    private String requestdate;
    @Basic(optional = false)
    @Column(name = "requesttime")
    private String requesttime;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "servicerequesttypeid", referencedColumnName = "servicerequesttypeid")
    @ManyToOne(optional = false)
    private Servicerequesttype servicerequesttypeid;
    @JoinColumn(name = "calltypeid", referencedColumnName = "calltypeid")
    @ManyToOne(optional = false)
    private Calltype calltypeid;
    @JoinColumn(name = "requestfufillmentid", referencedColumnName = "requestfufillmentid")
    @ManyToOne(optional = false)
    private Requestfulfillment requestfufillmentid;
    @JoinColumn(name = "servicedeskid", referencedColumnName = "servicedeskid")
    @ManyToOne(optional = false)
    private Servicedesk servicedeskid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestid")
    private Collection<Servicecosting> servicecostingCollection;

    public Request() {
    }

    public Request(Long requestid) {
        this.requestid = requestid;
    }

    public Request(Long requestid, String requestdescription, String requestfrom, String requestdate, String requesttime, int status) {
        this.requestid = requestid;
        this.requestdescription = requestdescription;
        this.requestfrom = requestfrom;
        this.requestdate = requestdate;
        this.requesttime = requesttime;
        this.status = status;
    }

    public Long getRequestid() {
        return requestid;
    }

    public void setRequestid(Long requestid) {
        this.requestid = requestid;
    }

    public String getRequestdescription() {
        return requestdescription;
    }

    public void setRequestdescription(String requestdescription) {
        this.requestdescription = requestdescription;
    }

    public String getRequestfrom() {
        return requestfrom;
    }

    public void setRequestfrom(String requestfrom) {
        this.requestfrom = requestfrom;
    }

    public String getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(String requestdate) {
        this.requestdate = requestdate;
    }

    public String getRequesttime() {
        return requesttime;
    }

    public void setRequesttime(String requesttime) {
        this.requesttime = requesttime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Servicerequesttype getServicerequesttypeid() {
        return servicerequesttypeid;
    }

    public void setServicerequesttypeid(Servicerequesttype servicerequesttypeid) {
        this.servicerequesttypeid = servicerequesttypeid;
    }

    public Calltype getCalltypeid() {
        return calltypeid;
    }

    public void setCalltypeid(Calltype calltypeid) {
        this.calltypeid = calltypeid;
    }

    public Requestfulfillment getRequestfufillmentid() {
        return requestfufillmentid;
    }

    public void setRequestfufillmentid(Requestfulfillment requestfufillmentid) {
        this.requestfufillmentid = requestfufillmentid;
    }

    public Servicedesk getServicedeskid() {
        return servicedeskid;
    }

    public void setServicedeskid(Servicedesk servicedeskid) {
        this.servicedeskid = servicedeskid;
    }

    @XmlTransient
    public Collection<Servicecosting> getServicecostingCollection() {
        return servicecostingCollection;
    }

    public void setServicecostingCollection(Collection<Servicecosting> servicecostingCollection) {
        this.servicecostingCollection = servicecostingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestid != null ? requestid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.requestid == null && other.requestid != null) || (this.requestid != null && !this.requestid.equals(other.requestid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Request[ requestid=" + requestid + " ]";
    }
    
}

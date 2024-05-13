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
@Table(name = "contract")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contract.findAll", query = "SELECT c FROM Contract c"),
    @NamedQuery(name = "Contract.findByContractid", query = "SELECT c FROM Contract c WHERE c.contractid = :contractid"),
    @NamedQuery(name = "Contract.findByContractstartdate", query = "SELECT c FROM Contract c WHERE c.contractstartdate = :contractstartdate"),
    @NamedQuery(name = "Contract.findByContractenddate", query = "SELECT c FROM Contract c WHERE c.contractenddate = :contractenddate"),
    @NamedQuery(name = "Contract.findByPerformancereview", query = "SELECT c FROM Contract c WHERE c.performancereview = :performancereview"),
    @NamedQuery(name = "Contract.findBySupplierimprovementplan", query = "SELECT c FROM Contract c WHERE c.supplierimprovementplan = :supplierimprovementplan"),
    @NamedQuery(name = "Contract.findByResearchreport", query = "SELECT c FROM Contract c WHERE c.researchreport = :researchreport"),
    @NamedQuery(name = "Contract.findByStatus", query = "SELECT c FROM Contract c WHERE c.status = :status")})
public class Contract implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contractid")
    private Integer contractid;
    @Basic(optional = false)
    @Column(name = "contractstartdate")
    private String contractstartdate;
    @Basic(optional = false)
    @Column(name = "contractenddate")
    private String contractenddate;
    @Basic(optional = false)
    @Column(name = "performancereview")
    private String performancereview;
    @Basic(optional = false)
    @Column(name = "supplierimprovementplan")
    private String supplierimprovementplan;
    @Basic(optional = false)
    @Column(name = "researchreport")
    private String researchreport;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "providedserviceassetitemid", referencedColumnName = "providedserviceitemid")
    @ManyToOne(optional = false)
    private Providedserviceitem providedserviceassetitemid;
    @JoinColumn(name = "contracttypeid", referencedColumnName = "contractypeid")
    @ManyToOne(optional = false)
    private Contractype contracttypeid;
    @JoinColumn(name = "providedassetcatalogueid", referencedColumnName = "providedassetid")
    @ManyToOne(optional = false)
    private Providedasset providedassetcatalogueid;

    public Contract() {
    }

    public Contract(Integer contractid) {
        this.contractid = contractid;
    }

    public Contract(Integer contractid, String contractstartdate, String contractenddate, String performancereview, String supplierimprovementplan, String researchreport, String status) {
        this.contractid = contractid;
        this.contractstartdate = contractstartdate;
        this.contractenddate = contractenddate;
        this.performancereview = performancereview;
        this.supplierimprovementplan = supplierimprovementplan;
        this.researchreport = researchreport;
        this.status = status;
    }

    public Integer getContractid() {
        return contractid;
    }

    public void setContractid(Integer contractid) {
        this.contractid = contractid;
    }

    public String getContractstartdate() {
        return contractstartdate;
    }

    public void setContractstartdate(String contractstartdate) {
        this.contractstartdate = contractstartdate;
    }

    public String getContractenddate() {
        return contractenddate;
    }

    public void setContractenddate(String contractenddate) {
        this.contractenddate = contractenddate;
    }

    public String getPerformancereview() {
        return performancereview;
    }

    public void setPerformancereview(String performancereview) {
        this.performancereview = performancereview;
    }

    public String getSupplierimprovementplan() {
        return supplierimprovementplan;
    }

    public void setSupplierimprovementplan(String supplierimprovementplan) {
        this.supplierimprovementplan = supplierimprovementplan;
    }

    public String getResearchreport() {
        return researchreport;
    }

    public void setResearchreport(String researchreport) {
        this.researchreport = researchreport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Providedserviceitem getProvidedserviceassetitemid() {
        return providedserviceassetitemid;
    }

    public void setProvidedserviceassetitemid(Providedserviceitem providedserviceassetitemid) {
        this.providedserviceassetitemid = providedserviceassetitemid;
    }

    public Contractype getContracttypeid() {
        return contracttypeid;
    }

    public void setContracttypeid(Contractype contracttypeid) {
        this.contracttypeid = contracttypeid;
    }

    public Providedasset getProvidedassetcatalogueid() {
        return providedassetcatalogueid;
    }

    public void setProvidedassetcatalogueid(Providedasset providedassetcatalogueid) {
        this.providedassetcatalogueid = providedassetcatalogueid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contractid != null ? contractid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contract)) {
            return false;
        }
        Contract other = (Contract) object;
        if ((this.contractid == null && other.contractid != null) || (this.contractid != null && !this.contractid.equals(other.contractid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Contract[ contractid=" + contractid + " ]";
    }
    
}

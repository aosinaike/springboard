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
@Table(name = "provider")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provider.findAll", query = "SELECT p FROM Provider p"),
    @NamedQuery(name = "Provider.findByProviderid", query = "SELECT p FROM Provider p WHERE p.providerid = :providerid"),
    @NamedQuery(name = "Provider.findByCompanyname", query = "SELECT p FROM Provider p WHERE p.companyname = :companyname"),
    @NamedQuery(name = "Provider.findByAddress", query = "SELECT p FROM Provider p WHERE p.address = :address"),
    @NamedQuery(name = "Provider.findByPhonenumber1", query = "SELECT p FROM Provider p WHERE p.phonenumber1 = :phonenumber1"),
    @NamedQuery(name = "Provider.findByPhonenumber2", query = "SELECT p FROM Provider p WHERE p.phonenumber2 = :phonenumber2"),
    @NamedQuery(name = "Provider.findByEmail", query = "SELECT p FROM Provider p WHERE p.email = :email"),
    @NamedQuery(name = "Provider.findByWebsite", query = "SELECT p FROM Provider p WHERE p.website = :website"),
    @NamedQuery(name = "Provider.findByServicescope", query = "SELECT p FROM Provider p WHERE p.servicescope = :servicescope"),
    @NamedQuery(name = "Provider.findByServiceindustry", query = "SELECT p FROM Provider p WHERE p.serviceindustry = :serviceindustry"),
    @NamedQuery(name = "Provider.findByStatus", query = "SELECT p FROM Provider p WHERE p.status = :status")})
public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "providerid")
    private Integer providerid;
    @Basic(optional = false)
    @Column(name = "companyname")
    private String companyname;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "phonenumber1")
    private String phonenumber1;
    @Basic(optional = false)
    @Column(name = "phonenumber2")
    private String phonenumber2;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "website")
    private String website;
    @Basic(optional = false)
    @Column(name = "servicescope")
    private String servicescope;
    @Basic(optional = false)
    @Column(name = "serviceindustry")
    private String serviceindustry;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerid")
    private Collection<Providedserviceitem> providedserviceitemCollection;
    @JoinColumn(name = "stateid", referencedColumnName = "stateid")
    @ManyToOne(optional = false)
    private State stateid;
    @JoinColumn(name = "countryid", referencedColumnName = "countryid")
    @ManyToOne(optional = false)
    private Country countryid;
    @JoinColumn(name = "providercategoryid", referencedColumnName = "providercategoryid")
    @ManyToOne(optional = false)
    private Providercategory providercategoryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerid")
    private Collection<Serviceitemportfolio> serviceitemportfolioCollection;

    public Provider() {
    }

    public Provider(Integer providerid) {
        this.providerid = providerid;
    }

    public Provider(Integer providerid, String companyname, String address, String phonenumber1, String phonenumber2, String email, String website, String servicescope, String serviceindustry, int status) {
        this.providerid = providerid;
        this.companyname = companyname;
        this.address = address;
        this.phonenumber1 = phonenumber1;
        this.phonenumber2 = phonenumber2;
        this.email = email;
        this.website = website;
        this.servicescope = servicescope;
        this.serviceindustry = serviceindustry;
        this.status = status;
    }

    public Integer getProviderid() {
        return providerid;
    }

    public void setProviderid(Integer providerid) {
        this.providerid = providerid;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber1() {
        return phonenumber1;
    }

    public void setPhonenumber1(String phonenumber1) {
        this.phonenumber1 = phonenumber1;
    }

    public String getPhonenumber2() {
        return phonenumber2;
    }

    public void setPhonenumber2(String phonenumber2) {
        this.phonenumber2 = phonenumber2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getServicescope() {
        return servicescope;
    }

    public void setServicescope(String servicescope) {
        this.servicescope = servicescope;
    }

    public String getServiceindustry() {
        return serviceindustry;
    }

    public void setServiceindustry(String serviceindustry) {
        this.serviceindustry = serviceindustry;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Providedserviceitem> getProvidedserviceitemCollection() {
        return providedserviceitemCollection;
    }

    public void setProvidedserviceitemCollection(Collection<Providedserviceitem> providedserviceitemCollection) {
        this.providedserviceitemCollection = providedserviceitemCollection;
    }

    public State getStateid() {
        return stateid;
    }

    public void setStateid(State stateid) {
        this.stateid = stateid;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }

    public Providercategory getProvidercategoryid() {
        return providercategoryid;
    }

    public void setProvidercategoryid(Providercategory providercategoryid) {
        this.providercategoryid = providercategoryid;
    }

    @XmlTransient
    public Collection<Serviceitemportfolio> getServiceitemportfolioCollection() {
        return serviceitemportfolioCollection;
    }

    public void setServiceitemportfolioCollection(Collection<Serviceitemportfolio> serviceitemportfolioCollection) {
        this.serviceitemportfolioCollection = serviceitemportfolioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (providerid != null ? providerid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provider)) {
            return false;
        }
        Provider other = (Provider) object;
        if ((this.providerid == null && other.providerid != null) || (this.providerid != null && !this.providerid.equals(other.providerid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Provider[ providerid=" + providerid + " ]";
    }
    
}

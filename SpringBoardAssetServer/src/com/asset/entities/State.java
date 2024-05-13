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
@Table(name = "state")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s"),
    @NamedQuery(name = "State.findByStateid", query = "SELECT s FROM State s WHERE s.stateid = :stateid"),
    @NamedQuery(name = "State.findByState", query = "SELECT s FROM State s WHERE s.state = :state")})
public class State implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stateid")
    private Integer stateid;
    @Basic(optional = false)
    @Column(name = "state")
    private int state;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateid")
    private Collection<Branch> branchCollection;
    @JoinColumn(name = "countryid", referencedColumnName = "countryid")
    @ManyToOne(optional = false)
    private Country countryid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateid")
    private Collection<Provider> providerCollection;

    public State() {
    }

    public State(Integer stateid) {
        this.stateid = stateid;
    }

    public State(Integer stateid, int state) {
        this.stateid = stateid;
        this.state = state;
    }

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @XmlTransient
    public Collection<Branch> getBranchCollection() {
        return branchCollection;
    }

    public void setBranchCollection(Collection<Branch> branchCollection) {
        this.branchCollection = branchCollection;
    }

    public Country getCountryid() {
        return countryid;
    }

    public void setCountryid(Country countryid) {
        this.countryid = countryid;
    }

    @XmlTransient
    public Collection<Provider> getProviderCollection() {
        return providerCollection;
    }

    public void setProviderCollection(Collection<Provider> providerCollection) {
        this.providerCollection = providerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateid != null ? stateid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.stateid == null && other.stateid != null) || (this.stateid != null && !this.stateid.equals(other.stateid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.State[ stateid=" + stateid + " ]";
    }
    
}

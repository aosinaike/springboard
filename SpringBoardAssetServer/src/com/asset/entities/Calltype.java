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
@Table(name = "calltype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calltype.findAll", query = "SELECT c FROM Calltype c"),
    @NamedQuery(name = "Calltype.findByCalltypeid", query = "SELECT c FROM Calltype c WHERE c.calltypeid = :calltypeid"),
    @NamedQuery(name = "Calltype.findByCalltypetitle", query = "SELECT c FROM Calltype c WHERE c.calltypetitle = :calltypetitle")})
public class Calltype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "calltypeid")
    private Integer calltypeid;
    @Basic(optional = false)
    @Column(name = "calltypetitle")
    private String calltypetitle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calltypeid")
    private Collection<Request> requestCollection;

    public Calltype() {
    }

    public Calltype(Integer calltypeid) {
        this.calltypeid = calltypeid;
    }

    public Calltype(Integer calltypeid, String calltypetitle) {
        this.calltypeid = calltypeid;
        this.calltypetitle = calltypetitle;
    }

    public Integer getCalltypeid() {
        return calltypeid;
    }

    public void setCalltypeid(Integer calltypeid) {
        this.calltypeid = calltypeid;
    }

    public String getCalltypetitle() {
        return calltypetitle;
    }

    public void setCalltypetitle(String calltypetitle) {
        this.calltypetitle = calltypetitle;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (calltypeid != null ? calltypeid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calltype)) {
            return false;
        }
        Calltype other = (Calltype) object;
        if ((this.calltypeid == null && other.calltypeid != null) || (this.calltypeid != null && !this.calltypeid.equals(other.calltypeid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Calltype[ calltypeid=" + calltypeid + " ]";
    }
    
}

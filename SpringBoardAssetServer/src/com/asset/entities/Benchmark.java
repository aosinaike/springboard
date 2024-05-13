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
@Table(name = "benchmark")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Benchmark.findAll", query = "SELECT b FROM Benchmark b"),
    @NamedQuery(name = "Benchmark.findByBenchmarkid", query = "SELECT b FROM Benchmark b WHERE b.benchmarkid = :benchmarkid"),
    @NamedQuery(name = "Benchmark.findByComment", query = "SELECT b FROM Benchmark b WHERE b.comment = :comment"),
    @NamedQuery(name = "Benchmark.findByOldbenchmark", query = "SELECT b FROM Benchmark b WHERE b.oldbenchmark = :oldbenchmark"),
    @NamedQuery(name = "Benchmark.findByNewbenchmark", query = "SELECT b FROM Benchmark b WHERE b.newbenchmark = :newbenchmark"),
    @NamedQuery(name = "Benchmark.findByOldbenchmarkdate", query = "SELECT b FROM Benchmark b WHERE b.oldbenchmarkdate = :oldbenchmarkdate"),
    @NamedQuery(name = "Benchmark.findByOldbenchmarktime", query = "SELECT b FROM Benchmark b WHERE b.oldbenchmarktime = :oldbenchmarktime"),
    @NamedQuery(name = "Benchmark.findByNewbenchmarkdate", query = "SELECT b FROM Benchmark b WHERE b.newbenchmarkdate = :newbenchmarkdate"),
    @NamedQuery(name = "Benchmark.findByNewbenchmarktime", query = "SELECT b FROM Benchmark b WHERE b.newbenchmarktime = :newbenchmarktime"),
    @NamedQuery(name = "Benchmark.findByUnitofmeasurement", query = "SELECT b FROM Benchmark b WHERE b.unitofmeasurement = :unitofmeasurement"),
    @NamedQuery(name = "Benchmark.findByNewbenchmarkoutcome", query = "SELECT b FROM Benchmark b WHERE b.newbenchmarkoutcome = :newbenchmarkoutcome"),
    @NamedQuery(name = "Benchmark.findByBenchmarkedby", query = "SELECT b FROM Benchmark b WHERE b.benchmarkedby = :benchmarkedby"),
    @NamedQuery(name = "Benchmark.findByStatus", query = "SELECT b FROM Benchmark b WHERE b.status = :status")})
public class Benchmark implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "benchmarkid")
    private Integer benchmarkid;
    @Basic(optional = false)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @Column(name = "oldbenchmark")
    private String oldbenchmark;
    @Basic(optional = false)
    @Column(name = "newbenchmark")
    private String newbenchmark;
    @Basic(optional = false)
    @Column(name = "oldbenchmarkdate")
    private String oldbenchmarkdate;
    @Basic(optional = false)
    @Column(name = "oldbenchmarktime")
    private String oldbenchmarktime;
    @Basic(optional = false)
    @Column(name = "newbenchmarkdate")
    private String newbenchmarkdate;
    @Basic(optional = false)
    @Column(name = "newbenchmarktime")
    private String newbenchmarktime;
    @Basic(optional = false)
    @Column(name = "unitofmeasurement")
    private int unitofmeasurement;
    @Basic(optional = false)
    @Column(name = "newbenchmarkoutcome")
    private String newbenchmarkoutcome;
    @Basic(optional = false)
    @Column(name = "benchmarkedby")
    private int benchmarkedby;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "attributesitemsid", referencedColumnName = "attributesitemsid")
    @ManyToOne(optional = false)
    private Attributesitems attributesitemsid;

    public Benchmark() {
    }

    public Benchmark(Integer benchmarkid) {
        this.benchmarkid = benchmarkid;
    }

    public Benchmark(Integer benchmarkid, String comment, String oldbenchmark, String newbenchmark, String oldbenchmarkdate, String oldbenchmarktime, String newbenchmarkdate, String newbenchmarktime, int unitofmeasurement, String newbenchmarkoutcome, int benchmarkedby, String status) {
        this.benchmarkid = benchmarkid;
        this.comment = comment;
        this.oldbenchmark = oldbenchmark;
        this.newbenchmark = newbenchmark;
        this.oldbenchmarkdate = oldbenchmarkdate;
        this.oldbenchmarktime = oldbenchmarktime;
        this.newbenchmarkdate = newbenchmarkdate;
        this.newbenchmarktime = newbenchmarktime;
        this.unitofmeasurement = unitofmeasurement;
        this.newbenchmarkoutcome = newbenchmarkoutcome;
        this.benchmarkedby = benchmarkedby;
        this.status = status;
    }

    public Integer getBenchmarkid() {
        return benchmarkid;
    }

    public void setBenchmarkid(Integer benchmarkid) {
        this.benchmarkid = benchmarkid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getOldbenchmark() {
        return oldbenchmark;
    }

    public void setOldbenchmark(String oldbenchmark) {
        this.oldbenchmark = oldbenchmark;
    }

    public String getNewbenchmark() {
        return newbenchmark;
    }

    public void setNewbenchmark(String newbenchmark) {
        this.newbenchmark = newbenchmark;
    }

    public String getOldbenchmarkdate() {
        return oldbenchmarkdate;
    }

    public void setOldbenchmarkdate(String oldbenchmarkdate) {
        this.oldbenchmarkdate = oldbenchmarkdate;
    }

    public String getOldbenchmarktime() {
        return oldbenchmarktime;
    }

    public void setOldbenchmarktime(String oldbenchmarktime) {
        this.oldbenchmarktime = oldbenchmarktime;
    }

    public String getNewbenchmarkdate() {
        return newbenchmarkdate;
    }

    public void setNewbenchmarkdate(String newbenchmarkdate) {
        this.newbenchmarkdate = newbenchmarkdate;
    }

    public String getNewbenchmarktime() {
        return newbenchmarktime;
    }

    public void setNewbenchmarktime(String newbenchmarktime) {
        this.newbenchmarktime = newbenchmarktime;
    }

    public int getUnitofmeasurement() {
        return unitofmeasurement;
    }

    public void setUnitofmeasurement(int unitofmeasurement) {
        this.unitofmeasurement = unitofmeasurement;
    }

    public String getNewbenchmarkoutcome() {
        return newbenchmarkoutcome;
    }

    public void setNewbenchmarkoutcome(String newbenchmarkoutcome) {
        this.newbenchmarkoutcome = newbenchmarkoutcome;
    }

    public int getBenchmarkedby() {
        return benchmarkedby;
    }

    public void setBenchmarkedby(int benchmarkedby) {
        this.benchmarkedby = benchmarkedby;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Attributesitems getAttributesitemsid() {
        return attributesitemsid;
    }

    public void setAttributesitemsid(Attributesitems attributesitemsid) {
        this.attributesitemsid = attributesitemsid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (benchmarkid != null ? benchmarkid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benchmark)) {
            return false;
        }
        Benchmark other = (Benchmark) object;
        if ((this.benchmarkid == null && other.benchmarkid != null) || (this.benchmarkid != null && !this.benchmarkid.equals(other.benchmarkid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asset.entities.Benchmark[ benchmarkid=" + benchmarkid + " ]";
    }
    
}

package com.barclays.programmingassessment.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trade_store")
public class TradeStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "trade_id")
    private String tradeId;

    @Column(name = "country_party_id")
    private String countryPartyId;

    @Column(name = "book_id")
    private String bookId;
    @Column(name = "expired")
    private String expired;
    @Column(name = "maturity_date")
    private Date maturityDate;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "version")
    private Integer version;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getCountryPartyId() {
        return countryPartyId;
    }

    public void setCountryPartyId(String countryPartId) {
        this.countryPartyId = countryPartId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TradeStore{" +
                "tradeId='" + tradeId + '\'' +
                ", countryPartId='" + countryPartyId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", expired='" + expired + '\'' +
                ", maturityDate=" + maturityDate +
                ", createdDate=" + createdDate +
                ", version=" + version +
                '}';
    }
}

package com.websitestatistic.org.entity;

import com.websitestatistic.org.dto.WebsiteVisitDTO;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "website_visits")
public class WebsiteVisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "website_id")
    private Long websiteId;

    @Column(name = "visit_device")
    private String visitDevice;

    @Column(name = "visit_date")
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "website_id", insertable = false, updatable = false)
    private WebsiteEntity website;

    public WebsiteVisitEntity() {
    }

    public WebsiteVisitEntity(WebsiteVisitDTO websiteVisitDTO) {

        this.id = websiteVisitDTO.getId();
        this.websiteId = websiteVisitDTO.getWebsite_id();
        this.visitDevice = websiteVisitDTO.getVisit_device();
        this.visitDate = LocalDate.now();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWebsiteId() {
        return websiteId;
    }

    public void setWebsiteId(Long websiteId) {
        this.websiteId = websiteId;
    }

    public String getVisitDevice() {
        return visitDevice;
    }

    public void setVisitDevice(String visitDevice) {
        this.visitDevice = visitDevice;
    }

    public WebsiteEntity getWebsite() {
        return website;
    }

    public void setWebsite(WebsiteEntity website) {
        this.website = website;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

}

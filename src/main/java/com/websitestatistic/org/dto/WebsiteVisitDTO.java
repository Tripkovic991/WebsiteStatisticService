package com.websitestatistic.org.dto;

import com.websitestatistic.org.entity.WebsiteVisitEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WebsiteVisitDTO {


    private Long id;

    @NotNull
    @NotEmpty
    private Long website_id;

    private String visit_device;

    public WebsiteVisitDTO() {
    }

    public WebsiteVisitDTO(WebsiteVisitEntity websiteVisitEntity) {

        this.id = websiteVisitEntity.getId();
        this.website_id = websiteVisitEntity.getWebsiteId();
        this.visit_device = websiteVisitEntity.getVisitDevice();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWebsite_id() {
        return website_id;
    }

    public void setWebsite_id(Long website_id) {
        this.website_id = website_id;
    }

    public String getVisit_device() {
        return visit_device;
    }

    public void setVisit_device(String visit_device) {
        this.visit_device = visit_device;
    }
}

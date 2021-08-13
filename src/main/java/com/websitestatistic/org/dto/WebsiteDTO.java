package com.websitestatistic.org.dto;

import com.websitestatistic.org.entity.WebsiteEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class WebsiteDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private String domain;

    @NotNull
    @NotEmpty
    private String owner;

    public WebsiteDTO() {

    }


    public WebsiteDTO(WebsiteEntity websiteEntity) {

        this.id = websiteEntity.getId();
        this.domain = websiteEntity.getDomain();
        this.owner = websiteEntity.getOwner();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}

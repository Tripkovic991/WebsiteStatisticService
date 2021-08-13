package com.websitestatistic.org.entity;

import com.websitestatistic.org.dto.WebsiteDTO;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "website")
public class WebsiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "domain")
    private String domain;

    @Column(name = "owner")
    private String owner;

    @OneToMany(mappedBy = "website", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<WebsiteVisitEntity> websiteVisitEntity = new HashSet<>();


    public WebsiteEntity() {
    }

    public WebsiteEntity(WebsiteDTO websiteDTO) {

        this.id = websiteDTO.getId();
        this.domain = websiteDTO.getDomain();
        this.owner = websiteDTO.getOwner();

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

    public Set<WebsiteVisitEntity> getWebsiteVisitEntity() {
        return websiteVisitEntity;
    }

    public void setWebsiteVisitEntity(Set<WebsiteVisitEntity> websiteVisitEntity) {
        this.websiteVisitEntity = websiteVisitEntity;
    }
}

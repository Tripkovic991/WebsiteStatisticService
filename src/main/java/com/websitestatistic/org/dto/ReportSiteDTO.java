package com.websitestatistic.org.dto;

import com.websitestatistic.org.entity.WebsiteEntity;

import java.util.ArrayList;
import java.util.List;

public class ReportSiteDTO {

    private Boolean error;

    private String message;

    private Integer number_of_visits;

    private String domain;

    private List<ReportWebsiteVisitDTO> data = new ArrayList<>();

    public ReportSiteDTO() {
    }

    public ReportSiteDTO(WebsiteEntity websiteEntity) {
        this.number_of_visits = websiteEntity.getWebsiteVisitEntity().size();
        this.domain = websiteEntity.getDomain();
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getNumber_of_visits() {
        return number_of_visits;
    }

    public void setNumber_of_visits(Integer number_of_visits) {
        this.number_of_visits = number_of_visits;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public List<ReportWebsiteVisitDTO> getData() {
        return data;
    }

    public void setData(List<ReportWebsiteVisitDTO> data) {
        this.data = data;
    }
}

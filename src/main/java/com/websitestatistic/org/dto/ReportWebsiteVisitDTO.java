package com.websitestatistic.org.dto;

import com.websitestatistic.org.entity.WebsiteVisitEntity;

public class ReportWebsiteVisitDTO {

    private String device_visit;

    private Integer google_analytics;

    private Integer positive_guys;

    public ReportWebsiteVisitDTO() {

    }

    public ReportWebsiteVisitDTO(WebsiteVisitEntity websiteVisitEntity) {

        this.device_visit = websiteVisitEntity.getVisitDevice();

    }

    public String getDevice_visit() {
        return device_visit;
    }

    public void setDevice_visit(String device_visit) {
        this.device_visit = device_visit;
    }

    public Integer getGoogle_analytics() {
        return google_analytics;
    }

    public void setGoogle_analytics(Integer google_analytics) {
        this.google_analytics = google_analytics;
    }

    public Integer getPositive_guys() {
        return positive_guys;
    }

    public void setPositive_guys(Integer positive_guys) {
        this.positive_guys = positive_guys;
    }
}

package com.nurhossen.bdjosbnurassignment.service.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Datum {

@SerializedName("jobTitle")
@Expose
private String jobTitle;
@SerializedName("deadline")
@Expose
private String deadline;
@SerializedName("recruitingCompany'sProfile")
@Expose
private String recruitingCompanySProfile;
@SerializedName("jobDetails")
@Expose
private JobDetails jobDetails;
@SerializedName("logo")
@Expose
private String logo;
@SerializedName("IsFeatured")
@Expose
private Boolean isFeatured;
@SerializedName("minExperience")
@Expose
private Object minExperience;
@SerializedName("maxExperience")
@Expose
private Integer maxExperience;
@SerializedName("minSalary")
@Expose
private String minSalary;
@SerializedName("maxSalary")
@Expose
private String maxSalary;

public String getJobTitle() {
return jobTitle;
}

public void setJobTitle(String jobTitle) {
this.jobTitle = jobTitle;
}

public String getDeadline() {
return deadline;
}

public void setDeadline(String deadline) {
this.deadline = deadline;
}

public String getRecruitingCompanySProfile() {
return recruitingCompanySProfile;
}

public void setRecruitingCompanySProfile(String recruitingCompanySProfile) {
this.recruitingCompanySProfile = recruitingCompanySProfile;
}

public JobDetails getJobDetails() {
return jobDetails;
}

public void setJobDetails(JobDetails jobDetails) {
this.jobDetails = jobDetails;
}

public String getLogo() {
return logo;
}

public void setLogo(String logo) {
this.logo = logo;
}

public Boolean getIsFeatured() {
return isFeatured;
}

public void setIsFeatured(Boolean isFeatured) {
this.isFeatured = isFeatured;
}

public Object getMinExperience() {
return minExperience;
}

public void setMinExperience(Object minExperience) {
this.minExperience = minExperience;
}

public Integer getMaxExperience() {
return maxExperience;
}

public void setMaxExperience(Integer maxExperience) {
this.maxExperience = maxExperience;
}

public String getMinSalary() {
return minSalary;
}

public void setMinSalary(String minSalary) {
this.minSalary = minSalary;
}

public String getMaxSalary() {
return maxSalary;
}

public void setMaxSalary(String maxSalary) {
this.maxSalary = maxSalary;
}

}
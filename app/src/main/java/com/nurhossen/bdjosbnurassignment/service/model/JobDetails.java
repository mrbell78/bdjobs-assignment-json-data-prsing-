package com.nurhossen.bdjosbnurassignment.service.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class JobDetails {

@SerializedName("Title")
@Expose
private String title;
@SerializedName("LastDate")
@Expose
private String lastDate;
@SerializedName("CompanyName")
@Expose
private String companyName;
@SerializedName("ApplyInstruction")
@Expose
private String applyInstruction;

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getLastDate() {
return lastDate;
}

public void setLastDate(String lastDate) {
this.lastDate = lastDate;
}

public String getCompanyName() {
return companyName;
}

public void setCompanyName(String companyName) {
this.companyName = companyName;
}

public String getApplyInstruction() {
return applyInstruction;
}

public void setApplyInstruction(String applyInstruction) {
this.applyInstruction = applyInstruction;
}

}
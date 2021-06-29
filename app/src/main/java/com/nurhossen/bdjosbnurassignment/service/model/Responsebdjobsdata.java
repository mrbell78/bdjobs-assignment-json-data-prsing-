package com.nurhossen.bdjosbnurassignment.service.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Responsebdjobsdata {

@SerializedName("statuscode")
@Expose
private String statuscode;
@SerializedName("message")
@Expose
private String message;
@SerializedName("data")
@Expose
private List<Datum> data = null;
@SerializedName("common")
@Expose
private Common common;

public String getStatuscode() {
return statuscode;
}

public void setStatuscode(String statuscode) {
this.statuscode = statuscode;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public List<Datum> getData() {
return data;
}

public void setData(List<Datum> data) {
this.data = data;
}

public Common getCommon() {
return common;
}

public void setCommon(Common common) {
this.common = common;
}

}
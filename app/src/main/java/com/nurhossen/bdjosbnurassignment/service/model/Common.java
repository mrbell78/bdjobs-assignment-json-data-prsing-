package com.nurhossen.bdjosbnurassignment.service.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Common {

@SerializedName("total_records_found")
@Expose
private Integer totalRecordsFound;
@SerializedName("totalpages")
@Expose
private Integer totalpages;

public Integer getTotalRecordsFound() {
return totalRecordsFound;
}

public void setTotalRecordsFound(Integer totalRecordsFound) {
this.totalRecordsFound = totalRecordsFound;
}

public Integer getTotalpages() {
return totalpages;
}

public void setTotalpages(Integer totalpages) {
this.totalpages = totalpages;
}

}

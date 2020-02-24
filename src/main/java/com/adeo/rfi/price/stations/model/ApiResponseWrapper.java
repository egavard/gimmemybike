package com.adeo.rfi.price.stations.model;

import java.util.List;

public class ApiResponseWrapper<T> {
    private Integer total_count;
    private List<ApiResponseRecord<T>> records;

    public ApiResponseWrapper(){
        this.total_count = null;
        this.records = null;
    }
    public ApiResponseWrapper(Integer total_count, List<ApiResponseRecord<T>> records) {
        this.total_count = total_count;
        this.records = records;
    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public List<ApiResponseRecord<T>> getRecords() {
        return records;
    }

    public void setRecords(List<ApiResponseRecord<T>> records) {
        this.records = records;
    }
}


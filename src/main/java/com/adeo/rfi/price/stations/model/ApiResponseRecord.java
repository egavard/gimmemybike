package com.adeo.rfi.price.stations.model;

public class ApiResponseRecord<T> {
    private String datasetid;
    private String recordid;
    private Record<T> record;

    public String getDatasetid() {
        return datasetid;
    }

    public void setDatasetid(String datasetid) {
        this.datasetid = datasetid;
    }

    public String getRecordid() {
        return recordid;
    }

    public void setRecordid(String recordid) {
        this.recordid = recordid;
    }

    public Record<T> getRecord() {
        return record;
    }

    public void setRecord(Record<T> record) {
        this.record = record;
    }
}

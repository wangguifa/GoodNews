package com.guifa.goodnews.bean;

import java.util.List;

/**
 * Created by wangguifa on 2017/2/19.
 */
public class CareBean {

    private boolean error;
    private List<CareNewsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<CareNewsBean> getResults() {
        return results;
    }

    public void setResults(List<CareNewsBean> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "CareBean{" +
                "error=" + error +
                ", results=" + results +
                '}';
    }
}

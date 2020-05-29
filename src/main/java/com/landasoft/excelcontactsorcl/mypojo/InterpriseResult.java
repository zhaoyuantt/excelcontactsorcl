package com.landasoft.excelcontactsorcl.mypojo;

import java.io.Serializable;
import java.util.List;

public class InterpriseResult implements Serializable {

    private String eid;

    private String ename;

    private List<InterpriseRelation> related_by;

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public List<InterpriseRelation> getRelated_by() {
        return related_by;
    }

    public void setRelated_by(List<InterpriseRelation> related_by) {
        this.related_by = related_by;
    }
}

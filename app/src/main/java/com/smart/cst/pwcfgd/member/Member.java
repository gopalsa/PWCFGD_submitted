package com.smart.cst.pwcfgd.member;

import java.io.Serializable;

public class Member implements Serializable {

    String memberName;
    String sex;
    String mobile;
    String idType;
    String farmSize;

    public Member(String memberName, String sex, String mobile, String idType, String farmSize) {
        this.memberName = memberName;
        this.sex = sex;
        this.mobile = mobile;
        this.idType = idType;
        this.farmSize = farmSize;
    }

    public String getFarmSize() {
        return farmSize;
    }

    public void setFarmSize(String farmSize) {
        this.farmSize = farmSize;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }
}

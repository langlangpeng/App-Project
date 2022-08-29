package com.team.appinfo.util;

public class AppInfoCondition extends PageParmeter{
    private String querySoftwareName;  //名称
    private Long queryStatus; //状态
    private Long queryFlatformId; //平台
    private Long queryCategoryLevel1; //分类1
    private Long queryCategoryLevel2; //分类2
    private Long queryCategoryLevel3; //分类3
    private Long devid;

    public String getQuerySoftwareName() {
        return querySoftwareName;
    }

    public void setQuerySoftwareName(String querySoftwareName) {
        this.querySoftwareName = querySoftwareName;
    }

    public Long getQueryStatus() {
        return queryStatus;
    }

    public void setQueryStatus(Long queryStatus) {
        this.queryStatus = queryStatus;
    }

    public Long getQueryFlatformId() {
        return queryFlatformId;
    }

    public void setQueryFlatformId(Long queryFlatformId) {
        this.queryFlatformId = queryFlatformId;
    }

    public Long getQueryCategoryLevel1() {
        return queryCategoryLevel1;
    }

    public void setQueryCategoryLevel1(Long queryCategoryLevel1) {
        this.queryCategoryLevel1 = queryCategoryLevel1;
    }

    public Long getQueryCategoryLevel2() {
        return queryCategoryLevel2;
    }

    public void setQueryCategoryLevel2(Long queryCategoryLevel2) {
        this.queryCategoryLevel2 = queryCategoryLevel2;
    }

    public Long getQueryCategoryLevel3() {
        return queryCategoryLevel3;
    }

    public void setQueryCategoryLevel3(Long queryCategoryLevel3) {
        this.queryCategoryLevel3 = queryCategoryLevel3;
    }

    public Long getDevid() {
        return devid;
    }

    public void setDevid(Long devid) {
        this.devid = devid;
    }
}

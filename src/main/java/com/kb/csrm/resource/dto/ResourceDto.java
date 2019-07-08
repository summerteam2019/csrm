package com.kb.csrm.resource.dto;

import org.springframework.stereotype.Component;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;

@Table(name="resource")

public class ResourceDto {
    /**
     * 主键ID
     */
    @Id
    @GeneratedValue(generator = "IDENTITY")
    private int resourceId;
    /**
     * 课程ID
     */
    @Column
    private int courseId;
    /**
     * 用户ID
     */
    @Column
    private int userId;
    /**
     * 资源名称
     */
    @Column
    private String resourceName;
    /**
     * 资源大小
     */
    @Column
    private String resourceSize;
    /**
     * 资源文件名
     */
    @Column
    private String resourceFilename;
    /**
     * 资源文件地址
     */
    @Column
    private String  resourceAddress;
    /**
     * 资源上传时间
     */
    @Column
    private Timestamp resourceTime;
    /**
     * 资源下载次数
     */
    @Column
    private int downloadCount;

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceSize() {
        return resourceSize;
    }

    public void setResourceSize(String resourceSize) {
        this.resourceSize = resourceSize;
    }

    public String getResourceFilename() {
        return resourceFilename;
    }

    public void setResourceFilename(String resourceFilename) {
        this.resourceFilename = resourceFilename;
    }

    public String getResourceAddress() {
        return resourceAddress;
    }

    public void setResourceAddress(String resourceAddress) {
        this.resourceAddress = resourceAddress;
    }

    public Timestamp getResourceTime() {
        return resourceTime;
    }

    public void setResourceTime(Timestamp resourceTime) {
        this.resourceTime = resourceTime;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

}

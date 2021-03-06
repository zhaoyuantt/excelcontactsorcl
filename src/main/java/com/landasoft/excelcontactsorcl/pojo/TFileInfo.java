package com.landasoft.excelcontactsorcl.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TFileInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.ID
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.FILE_NAME
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private String fileName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.FILE_SIZE
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private BigDecimal fileSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.FILE_PATH
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private String filePath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.FILE_TYPE
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private String fileType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.REMARK
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.CREATED
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private Date created;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.UPDATED
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_FILE_INFO.FILE_ALIAS
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    private String fileAlias;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.ID
     *
     * @return the value of T_FILE_INFO.ID
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.ID
     *
     * @param id the value for T_FILE_INFO.ID
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.FILE_NAME
     *
     * @return the value of T_FILE_INFO.FILE_NAME
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.FILE_NAME
     *
     * @param fileName the value for T_FILE_INFO.FILE_NAME
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.FILE_SIZE
     *
     * @return the value of T_FILE_INFO.FILE_SIZE
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public BigDecimal getFileSize() {
        return fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.FILE_SIZE
     *
     * @param fileSize the value for T_FILE_INFO.FILE_SIZE
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.FILE_PATH
     *
     * @return the value of T_FILE_INFO.FILE_PATH
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.FILE_PATH
     *
     * @param filePath the value for T_FILE_INFO.FILE_PATH
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.FILE_TYPE
     *
     * @return the value of T_FILE_INFO.FILE_TYPE
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.FILE_TYPE
     *
     * @param fileType the value for T_FILE_INFO.FILE_TYPE
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.REMARK
     *
     * @return the value of T_FILE_INFO.REMARK
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.REMARK
     *
     * @param remark the value for T_FILE_INFO.REMARK
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.CREATED
     *
     * @return the value of T_FILE_INFO.CREATED
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public Date getCreated() {
        return created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.CREATED
     *
     * @param created the value for T_FILE_INFO.CREATED
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.UPDATED
     *
     * @return the value of T_FILE_INFO.UPDATED
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public Date getUpdated() {
        return updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.UPDATED
     *
     * @param updated the value for T_FILE_INFO.UPDATED
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_FILE_INFO.FILE_ALIAS
     *
     * @return the value of T_FILE_INFO.FILE_ALIAS
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public String getFileAlias() {
        return fileAlias;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_FILE_INFO.FILE_ALIAS
     *
     * @param fileAlias the value for T_FILE_INFO.FILE_ALIAS
     *
     * @mbggenerated Tue May 26 09:55:44 CST 2020
     */
    public void setFileAlias(String fileAlias) {
        this.fileAlias = fileAlias == null ? null : fileAlias.trim();
    }
}
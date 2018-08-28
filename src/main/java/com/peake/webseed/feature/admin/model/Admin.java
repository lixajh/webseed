package com.peake.webseed.feature.admin.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tbl_admin")
public class Admin {
    @Id
    @Column(name = "pk_global_id")
    private String pkGlobalId;

    private String username;

    private String password;

    private String salt;

    /**
     * -1：删除，0：正常，1冻结
     */
    @Column(name = "data_status")
    private Integer dataStatus;

    private String phone;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "lupdate_time")
    private Date lupdateTime;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return pk_global_id
     */
    public String getPkGlobalId() {
        return pkGlobalId;
    }

    /**
     * @param pkGlobalId
     */
    public void setPkGlobalId(String pkGlobalId) {
        this.pkGlobalId = pkGlobalId;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取-1：删除，0：正常，1冻结
     *
     * @return data_status - -1：删除，0：正常，1冻结
     */
    public Integer getDataStatus() {
        return dataStatus;
    }

    /**
     * 设置-1：删除，0：正常，1冻结
     *
     * @param dataStatus -1：删除，0：正常，1冻结
     */
    public void setDataStatus(Integer dataStatus) {
        this.dataStatus = dataStatus;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    /**
     * @return last_login_time
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * @param lastLoginTime
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * @return lupdate_time
     */
    public Date getLupdateTime() {
        return lupdateTime;
    }

    /**
     * @param lupdateTime
     */
    public void setLupdateTime(Date lupdateTime) {
        this.lupdateTime = lupdateTime;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
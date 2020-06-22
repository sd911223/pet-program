package com.pet.model;

import java.util.Date;

/**
 * 宠物信息表
 *
 * @author shiTou
 * @date   2020/06/22
 */
public class PetInfo {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 宠物图片
     */
    private String petPhoto;

    /**
     * 宠物名
     */
    private String petName;

    /**
     * 1:公;2:母
     */
    private Integer petSex;

    /**
     * 品种编码
     */
    private Integer varietyCode;

    /**
     * 宠物生日
     */
    private Date petBirthday;

    /**
     * 宠物毛色
     */
    private String coatColor;

    /**
     * 1:大于35cm;2小于35cm
     */
    private Integer shoulderHeight;

    /**
     * 是否打疫苗0:未打;1:已
     */
    private Integer isVaccine;

    /**
     * 是否绝育0:未;1:已
     */
    private Integer isSterilization;

    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPetPhoto() {
        return petPhoto;
    }

    public void setPetPhoto(String petPhoto) {
        this.petPhoto = petPhoto;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getPetSex() {
        return petSex;
    }

    public void setPetSex(Integer petSex) {
        this.petSex = petSex;
    }

    public Integer getVarietyCode() {
        return varietyCode;
    }

    public void setVarietyCode(Integer varietyCode) {
        this.varietyCode = varietyCode;
    }

    public Date getPetBirthday() {
        return petBirthday;
    }

    public void setPetBirthday(Date petBirthday) {
        this.petBirthday = petBirthday;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
    }

    public Integer getShoulderHeight() {
        return shoulderHeight;
    }

    public void setShoulderHeight(Integer shoulderHeight) {
        this.shoulderHeight = shoulderHeight;
    }

    public Integer getIsVaccine() {
        return isVaccine;
    }

    public void setIsVaccine(Integer isVaccine) {
        this.isVaccine = isVaccine;
    }

    public Integer getIsSterilization() {
        return isSterilization;
    }

    public void setIsSterilization(Integer isSterilization) {
        this.isSterilization = isSterilization;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
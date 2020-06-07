package com.pet.model;

import java.util.Date;

/**
 * 店铺表
 *
 * @author shiTou
 * @date   2020/06/07
 */
public class PetShop {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺地址
     */
    private String shopAddress;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 省名称
     */
    private String provinceStr;

    /**
     * 市编码
     */
    private String cityCode;

    /**
     * 市名称
     */
    private String cityStr;

    /**
     * 区编码
     */
    private String areaCode;

    /**
     * 区名称
     */
    private String areaStr;

    /**
     * 营业执照
     */
    private String businessLicense;

    /**
     * 税务执照
     */
    private String taxLicense;

    /**
     * 诊疗执照
     */
    private String medicalLicense;

    /**
     * 其他执照,可能以后会多张
     */
    private String otherLicense;

    /**
     * 店铺类型
     */
    private Integer shopType;

    /**
     * 店铺状态
     */
    private Integer shopStatus;

    /**
     * 营业开始时间
     */
    private Date businessTimeStart;

    /**
     * 营业结束时间
     */
    private Date businessTimeEnd;

    /**
     * 联系电话
     */
    private String contactNumber;

    /**
     * 是否支寄养
     */
    private Integer isPlaceFeed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getProvinceStr() {
        return provinceStr;
    }

    public void setProvinceStr(String provinceStr) {
        this.provinceStr = provinceStr;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityStr() {
        return cityStr;
    }

    public void setCityStr(String cityStr) {
        this.cityStr = cityStr;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaStr() {
        return areaStr;
    }

    public void setAreaStr(String areaStr) {
        this.areaStr = areaStr;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getTaxLicense() {
        return taxLicense;
    }

    public void setTaxLicense(String taxLicense) {
        this.taxLicense = taxLicense;
    }

    public String getMedicalLicense() {
        return medicalLicense;
    }

    public void setMedicalLicense(String medicalLicense) {
        this.medicalLicense = medicalLicense;
    }

    public String getOtherLicense() {
        return otherLicense;
    }

    public void setOtherLicense(String otherLicense) {
        this.otherLicense = otherLicense;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(Integer shopStatus) {
        this.shopStatus = shopStatus;
    }

    public Date getBusinessTimeStart() {
        return businessTimeStart;
    }

    public void setBusinessTimeStart(Date businessTimeStart) {
        this.businessTimeStart = businessTimeStart;
    }

    public Date getBusinessTimeEnd() {
        return businessTimeEnd;
    }

    public void setBusinessTimeEnd(Date businessTimeEnd) {
        this.businessTimeEnd = businessTimeEnd;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getIsPlaceFeed() {
        return isPlaceFeed;
    }

    public void setIsPlaceFeed(Integer isPlaceFeed) {
        this.isPlaceFeed = isPlaceFeed;
    }
}
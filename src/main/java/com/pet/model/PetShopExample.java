package com.pet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PetShopExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNull() {
            addCriterion("shop_address is null");
            return (Criteria) this;
        }

        public Criteria andShopAddressIsNotNull() {
            addCriterion("shop_address is not null");
            return (Criteria) this;
        }

        public Criteria andShopAddressEqualTo(String value) {
            addCriterion("shop_address =", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotEqualTo(String value) {
            addCriterion("shop_address <>", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThan(String value) {
            addCriterion("shop_address >", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressGreaterThanOrEqualTo(String value) {
            addCriterion("shop_address >=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThan(String value) {
            addCriterion("shop_address <", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLessThanOrEqualTo(String value) {
            addCriterion("shop_address <=", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressLike(String value) {
            addCriterion("shop_address like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotLike(String value) {
            addCriterion("shop_address not like", value, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressIn(List<String> values) {
            addCriterion("shop_address in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotIn(List<String> values) {
            addCriterion("shop_address not in", values, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressBetween(String value1, String value2) {
            addCriterion("shop_address between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andShopAddressNotBetween(String value1, String value2) {
            addCriterion("shop_address not between", value1, value2, "shopAddress");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("province_code is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("province_code is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("province_code =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("province_code <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("province_code >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("province_code >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("province_code <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("province_code <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("province_code like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("province_code not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("province_code in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("province_code not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("province_code between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("province_code not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceStrIsNull() {
            addCriterion("province_str is null");
            return (Criteria) this;
        }

        public Criteria andProvinceStrIsNotNull() {
            addCriterion("province_str is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceStrEqualTo(String value) {
            addCriterion("province_str =", value, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrNotEqualTo(String value) {
            addCriterion("province_str <>", value, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrGreaterThan(String value) {
            addCriterion("province_str >", value, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrGreaterThanOrEqualTo(String value) {
            addCriterion("province_str >=", value, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrLessThan(String value) {
            addCriterion("province_str <", value, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrLessThanOrEqualTo(String value) {
            addCriterion("province_str <=", value, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrLike(String value) {
            addCriterion("province_str like", value, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrNotLike(String value) {
            addCriterion("province_str not like", value, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrIn(List<String> values) {
            addCriterion("province_str in", values, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrNotIn(List<String> values) {
            addCriterion("province_str not in", values, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrBetween(String value1, String value2) {
            addCriterion("province_str between", value1, value2, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andProvinceStrNotBetween(String value1, String value2) {
            addCriterion("province_str not between", value1, value2, "provinceStr");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityStrIsNull() {
            addCriterion("city_str is null");
            return (Criteria) this;
        }

        public Criteria andCityStrIsNotNull() {
            addCriterion("city_str is not null");
            return (Criteria) this;
        }

        public Criteria andCityStrEqualTo(String value) {
            addCriterion("city_str =", value, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrNotEqualTo(String value) {
            addCriterion("city_str <>", value, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrGreaterThan(String value) {
            addCriterion("city_str >", value, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrGreaterThanOrEqualTo(String value) {
            addCriterion("city_str >=", value, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrLessThan(String value) {
            addCriterion("city_str <", value, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrLessThanOrEqualTo(String value) {
            addCriterion("city_str <=", value, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrLike(String value) {
            addCriterion("city_str like", value, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrNotLike(String value) {
            addCriterion("city_str not like", value, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrIn(List<String> values) {
            addCriterion("city_str in", values, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrNotIn(List<String> values) {
            addCriterion("city_str not in", values, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrBetween(String value1, String value2) {
            addCriterion("city_str between", value1, value2, "cityStr");
            return (Criteria) this;
        }

        public Criteria andCityStrNotBetween(String value1, String value2) {
            addCriterion("city_str not between", value1, value2, "cityStr");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNull() {
            addCriterion("area_code is null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIsNotNull() {
            addCriterion("area_code is not null");
            return (Criteria) this;
        }

        public Criteria andAreaCodeEqualTo(String value) {
            addCriterion("area_code =", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotEqualTo(String value) {
            addCriterion("area_code <>", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThan(String value) {
            addCriterion("area_code >", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeGreaterThanOrEqualTo(String value) {
            addCriterion("area_code >=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThan(String value) {
            addCriterion("area_code <", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLessThanOrEqualTo(String value) {
            addCriterion("area_code <=", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeLike(String value) {
            addCriterion("area_code like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotLike(String value) {
            addCriterion("area_code not like", value, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeIn(List<String> values) {
            addCriterion("area_code in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotIn(List<String> values) {
            addCriterion("area_code not in", values, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeBetween(String value1, String value2) {
            addCriterion("area_code between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaCodeNotBetween(String value1, String value2) {
            addCriterion("area_code not between", value1, value2, "areaCode");
            return (Criteria) this;
        }

        public Criteria andAreaStrIsNull() {
            addCriterion("area_str is null");
            return (Criteria) this;
        }

        public Criteria andAreaStrIsNotNull() {
            addCriterion("area_str is not null");
            return (Criteria) this;
        }

        public Criteria andAreaStrEqualTo(String value) {
            addCriterion("area_str =", value, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrNotEqualTo(String value) {
            addCriterion("area_str <>", value, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrGreaterThan(String value) {
            addCriterion("area_str >", value, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrGreaterThanOrEqualTo(String value) {
            addCriterion("area_str >=", value, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrLessThan(String value) {
            addCriterion("area_str <", value, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrLessThanOrEqualTo(String value) {
            addCriterion("area_str <=", value, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrLike(String value) {
            addCriterion("area_str like", value, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrNotLike(String value) {
            addCriterion("area_str not like", value, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrIn(List<String> values) {
            addCriterion("area_str in", values, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrNotIn(List<String> values) {
            addCriterion("area_str not in", values, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrBetween(String value1, String value2) {
            addCriterion("area_str between", value1, value2, "areaStr");
            return (Criteria) this;
        }

        public Criteria andAreaStrNotBetween(String value1, String value2) {
            addCriterion("area_str not between", value1, value2, "areaStr");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseIsNull() {
            addCriterion("tax_license is null");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseIsNotNull() {
            addCriterion("tax_license is not null");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseEqualTo(String value) {
            addCriterion("tax_license =", value, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseNotEqualTo(String value) {
            addCriterion("tax_license <>", value, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseGreaterThan(String value) {
            addCriterion("tax_license >", value, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("tax_license >=", value, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseLessThan(String value) {
            addCriterion("tax_license <", value, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseLessThanOrEqualTo(String value) {
            addCriterion("tax_license <=", value, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseLike(String value) {
            addCriterion("tax_license like", value, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseNotLike(String value) {
            addCriterion("tax_license not like", value, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseIn(List<String> values) {
            addCriterion("tax_license in", values, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseNotIn(List<String> values) {
            addCriterion("tax_license not in", values, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseBetween(String value1, String value2) {
            addCriterion("tax_license between", value1, value2, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andTaxLicenseNotBetween(String value1, String value2) {
            addCriterion("tax_license not between", value1, value2, "taxLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseIsNull() {
            addCriterion("medical_license is null");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseIsNotNull() {
            addCriterion("medical_license is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseEqualTo(String value) {
            addCriterion("medical_license =", value, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseNotEqualTo(String value) {
            addCriterion("medical_license <>", value, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseGreaterThan(String value) {
            addCriterion("medical_license >", value, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("medical_license >=", value, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseLessThan(String value) {
            addCriterion("medical_license <", value, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseLessThanOrEqualTo(String value) {
            addCriterion("medical_license <=", value, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseLike(String value) {
            addCriterion("medical_license like", value, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseNotLike(String value) {
            addCriterion("medical_license not like", value, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseIn(List<String> values) {
            addCriterion("medical_license in", values, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseNotIn(List<String> values) {
            addCriterion("medical_license not in", values, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseBetween(String value1, String value2) {
            addCriterion("medical_license between", value1, value2, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andMedicalLicenseNotBetween(String value1, String value2) {
            addCriterion("medical_license not between", value1, value2, "medicalLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseIsNull() {
            addCriterion("other_license is null");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseIsNotNull() {
            addCriterion("other_license is not null");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseEqualTo(String value) {
            addCriterion("other_license =", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseNotEqualTo(String value) {
            addCriterion("other_license <>", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseGreaterThan(String value) {
            addCriterion("other_license >", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("other_license >=", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseLessThan(String value) {
            addCriterion("other_license <", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseLessThanOrEqualTo(String value) {
            addCriterion("other_license <=", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseLike(String value) {
            addCriterion("other_license like", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseNotLike(String value) {
            addCriterion("other_license not like", value, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseIn(List<String> values) {
            addCriterion("other_license in", values, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseNotIn(List<String> values) {
            addCriterion("other_license not in", values, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseBetween(String value1, String value2) {
            addCriterion("other_license between", value1, value2, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andOtherLicenseNotBetween(String value1, String value2) {
            addCriterion("other_license not between", value1, value2, "otherLicense");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNull() {
            addCriterion("shop_type is null");
            return (Criteria) this;
        }

        public Criteria andShopTypeIsNotNull() {
            addCriterion("shop_type is not null");
            return (Criteria) this;
        }

        public Criteria andShopTypeEqualTo(Integer value) {
            addCriterion("shop_type =", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotEqualTo(Integer value) {
            addCriterion("shop_type <>", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThan(Integer value) {
            addCriterion("shop_type >", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_type >=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThan(Integer value) {
            addCriterion("shop_type <", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeLessThanOrEqualTo(Integer value) {
            addCriterion("shop_type <=", value, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeIn(List<Integer> values) {
            addCriterion("shop_type in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotIn(List<Integer> values) {
            addCriterion("shop_type not in", values, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeBetween(Integer value1, Integer value2) {
            addCriterion("shop_type between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_type not between", value1, value2, "shopType");
            return (Criteria) this;
        }

        public Criteria andShopStatusIsNull() {
            addCriterion("shop_status is null");
            return (Criteria) this;
        }

        public Criteria andShopStatusIsNotNull() {
            addCriterion("shop_status is not null");
            return (Criteria) this;
        }

        public Criteria andShopStatusEqualTo(Integer value) {
            addCriterion("shop_status =", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotEqualTo(Integer value) {
            addCriterion("shop_status <>", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusGreaterThan(Integer value) {
            addCriterion("shop_status >", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("shop_status >=", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusLessThan(Integer value) {
            addCriterion("shop_status <", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusLessThanOrEqualTo(Integer value) {
            addCriterion("shop_status <=", value, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusIn(List<Integer> values) {
            addCriterion("shop_status in", values, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotIn(List<Integer> values) {
            addCriterion("shop_status not in", values, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusBetween(Integer value1, Integer value2) {
            addCriterion("shop_status between", value1, value2, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andShopStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("shop_status not between", value1, value2, "shopStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartIsNull() {
            addCriterion("business_time_start is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartIsNotNull() {
            addCriterion("business_time_start is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartEqualTo(Date value) {
            addCriterion("business_time_start =", value, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartNotEqualTo(Date value) {
            addCriterion("business_time_start <>", value, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartGreaterThan(Date value) {
            addCriterion("business_time_start >", value, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartGreaterThanOrEqualTo(Date value) {
            addCriterion("business_time_start >=", value, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartLessThan(Date value) {
            addCriterion("business_time_start <", value, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartLessThanOrEqualTo(Date value) {
            addCriterion("business_time_start <=", value, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartIn(List<Date> values) {
            addCriterion("business_time_start in", values, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartNotIn(List<Date> values) {
            addCriterion("business_time_start not in", values, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartBetween(Date value1, Date value2) {
            addCriterion("business_time_start between", value1, value2, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeStartNotBetween(Date value1, Date value2) {
            addCriterion("business_time_start not between", value1, value2, "businessTimeStart");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndIsNull() {
            addCriterion("business_time_end is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndIsNotNull() {
            addCriterion("business_time_end is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndEqualTo(Date value) {
            addCriterion("business_time_end =", value, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndNotEqualTo(Date value) {
            addCriterion("business_time_end <>", value, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndGreaterThan(Date value) {
            addCriterion("business_time_end >", value, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndGreaterThanOrEqualTo(Date value) {
            addCriterion("business_time_end >=", value, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndLessThan(Date value) {
            addCriterion("business_time_end <", value, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndLessThanOrEqualTo(Date value) {
            addCriterion("business_time_end <=", value, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndIn(List<Date> values) {
            addCriterion("business_time_end in", values, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndNotIn(List<Date> values) {
            addCriterion("business_time_end not in", values, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndBetween(Date value1, Date value2) {
            addCriterion("business_time_end between", value1, value2, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessTimeEndNotBetween(Date value1, Date value2) {
            addCriterion("business_time_end not between", value1, value2, "businessTimeEnd");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNull() {
            addCriterion("contact_number is null");
            return (Criteria) this;
        }

        public Criteria andContactNumberIsNotNull() {
            addCriterion("contact_number is not null");
            return (Criteria) this;
        }

        public Criteria andContactNumberEqualTo(String value) {
            addCriterion("contact_number =", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotEqualTo(String value) {
            addCriterion("contact_number <>", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThan(String value) {
            addCriterion("contact_number >", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("contact_number >=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThan(String value) {
            addCriterion("contact_number <", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLessThanOrEqualTo(String value) {
            addCriterion("contact_number <=", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberLike(String value) {
            addCriterion("contact_number like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotLike(String value) {
            addCriterion("contact_number not like", value, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberIn(List<String> values) {
            addCriterion("contact_number in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotIn(List<String> values) {
            addCriterion("contact_number not in", values, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberBetween(String value1, String value2) {
            addCriterion("contact_number between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andContactNumberNotBetween(String value1, String value2) {
            addCriterion("contact_number not between", value1, value2, "contactNumber");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedIsNull() {
            addCriterion("is_place_feed is null");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedIsNotNull() {
            addCriterion("is_place_feed is not null");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedEqualTo(Integer value) {
            addCriterion("is_place_feed =", value, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedNotEqualTo(Integer value) {
            addCriterion("is_place_feed <>", value, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedGreaterThan(Integer value) {
            addCriterion("is_place_feed >", value, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_place_feed >=", value, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedLessThan(Integer value) {
            addCriterion("is_place_feed <", value, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedLessThanOrEqualTo(Integer value) {
            addCriterion("is_place_feed <=", value, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedIn(List<Integer> values) {
            addCriterion("is_place_feed in", values, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedNotIn(List<Integer> values) {
            addCriterion("is_place_feed not in", values, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedBetween(Integer value1, Integer value2) {
            addCriterion("is_place_feed between", value1, value2, "isPlaceFeed");
            return (Criteria) this;
        }

        public Criteria andIsPlaceFeedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_place_feed not between", value1, value2, "isPlaceFeed");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
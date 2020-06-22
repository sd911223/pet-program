package com.pet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PetInfoExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPetPhotoIsNull() {
            addCriterion("pet_photo is null");
            return (Criteria) this;
        }

        public Criteria andPetPhotoIsNotNull() {
            addCriterion("pet_photo is not null");
            return (Criteria) this;
        }

        public Criteria andPetPhotoEqualTo(String value) {
            addCriterion("pet_photo =", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoNotEqualTo(String value) {
            addCriterion("pet_photo <>", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoGreaterThan(String value) {
            addCriterion("pet_photo >", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("pet_photo >=", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoLessThan(String value) {
            addCriterion("pet_photo <", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoLessThanOrEqualTo(String value) {
            addCriterion("pet_photo <=", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoLike(String value) {
            addCriterion("pet_photo like", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoNotLike(String value) {
            addCriterion("pet_photo not like", value, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoIn(List<String> values) {
            addCriterion("pet_photo in", values, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoNotIn(List<String> values) {
            addCriterion("pet_photo not in", values, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoBetween(String value1, String value2) {
            addCriterion("pet_photo between", value1, value2, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetPhotoNotBetween(String value1, String value2) {
            addCriterion("pet_photo not between", value1, value2, "petPhoto");
            return (Criteria) this;
        }

        public Criteria andPetNameIsNull() {
            addCriterion("pet_name is null");
            return (Criteria) this;
        }

        public Criteria andPetNameIsNotNull() {
            addCriterion("pet_name is not null");
            return (Criteria) this;
        }

        public Criteria andPetNameEqualTo(String value) {
            addCriterion("pet_name =", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotEqualTo(String value) {
            addCriterion("pet_name <>", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameGreaterThan(String value) {
            addCriterion("pet_name >", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameGreaterThanOrEqualTo(String value) {
            addCriterion("pet_name >=", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLessThan(String value) {
            addCriterion("pet_name <", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLessThanOrEqualTo(String value) {
            addCriterion("pet_name <=", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLike(String value) {
            addCriterion("pet_name like", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotLike(String value) {
            addCriterion("pet_name not like", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameIn(List<String> values) {
            addCriterion("pet_name in", values, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotIn(List<String> values) {
            addCriterion("pet_name not in", values, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameBetween(String value1, String value2) {
            addCriterion("pet_name between", value1, value2, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotBetween(String value1, String value2) {
            addCriterion("pet_name not between", value1, value2, "petName");
            return (Criteria) this;
        }

        public Criteria andPetSexIsNull() {
            addCriterion("pet_sex is null");
            return (Criteria) this;
        }

        public Criteria andPetSexIsNotNull() {
            addCriterion("pet_sex is not null");
            return (Criteria) this;
        }

        public Criteria andPetSexEqualTo(Integer value) {
            addCriterion("pet_sex =", value, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexNotEqualTo(Integer value) {
            addCriterion("pet_sex <>", value, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexGreaterThan(Integer value) {
            addCriterion("pet_sex >", value, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("pet_sex >=", value, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexLessThan(Integer value) {
            addCriterion("pet_sex <", value, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexLessThanOrEqualTo(Integer value) {
            addCriterion("pet_sex <=", value, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexIn(List<Integer> values) {
            addCriterion("pet_sex in", values, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexNotIn(List<Integer> values) {
            addCriterion("pet_sex not in", values, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexBetween(Integer value1, Integer value2) {
            addCriterion("pet_sex between", value1, value2, "petSex");
            return (Criteria) this;
        }

        public Criteria andPetSexNotBetween(Integer value1, Integer value2) {
            addCriterion("pet_sex not between", value1, value2, "petSex");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeIsNull() {
            addCriterion("variety_code is null");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeIsNotNull() {
            addCriterion("variety_code is not null");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeEqualTo(Integer value) {
            addCriterion("variety_code =", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeNotEqualTo(Integer value) {
            addCriterion("variety_code <>", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeGreaterThan(Integer value) {
            addCriterion("variety_code >", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("variety_code >=", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeLessThan(Integer value) {
            addCriterion("variety_code <", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeLessThanOrEqualTo(Integer value) {
            addCriterion("variety_code <=", value, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeIn(List<Integer> values) {
            addCriterion("variety_code in", values, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeNotIn(List<Integer> values) {
            addCriterion("variety_code not in", values, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeBetween(Integer value1, Integer value2) {
            addCriterion("variety_code between", value1, value2, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andVarietyCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("variety_code not between", value1, value2, "varietyCode");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayIsNull() {
            addCriterion("pet_birthday is null");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayIsNotNull() {
            addCriterion("pet_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayEqualTo(Date value) {
            addCriterion("pet_birthday =", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayNotEqualTo(Date value) {
            addCriterion("pet_birthday <>", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayGreaterThan(Date value) {
            addCriterion("pet_birthday >", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("pet_birthday >=", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayLessThan(Date value) {
            addCriterion("pet_birthday <", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("pet_birthday <=", value, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayIn(List<Date> values) {
            addCriterion("pet_birthday in", values, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayNotIn(List<Date> values) {
            addCriterion("pet_birthday not in", values, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayBetween(Date value1, Date value2) {
            addCriterion("pet_birthday between", value1, value2, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andPetBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("pet_birthday not between", value1, value2, "petBirthday");
            return (Criteria) this;
        }

        public Criteria andCoatColorIsNull() {
            addCriterion("coat_color is null");
            return (Criteria) this;
        }

        public Criteria andCoatColorIsNotNull() {
            addCriterion("coat_color is not null");
            return (Criteria) this;
        }

        public Criteria andCoatColorEqualTo(String value) {
            addCriterion("coat_color =", value, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorNotEqualTo(String value) {
            addCriterion("coat_color <>", value, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorGreaterThan(String value) {
            addCriterion("coat_color >", value, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorGreaterThanOrEqualTo(String value) {
            addCriterion("coat_color >=", value, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorLessThan(String value) {
            addCriterion("coat_color <", value, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorLessThanOrEqualTo(String value) {
            addCriterion("coat_color <=", value, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorLike(String value) {
            addCriterion("coat_color like", value, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorNotLike(String value) {
            addCriterion("coat_color not like", value, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorIn(List<String> values) {
            addCriterion("coat_color in", values, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorNotIn(List<String> values) {
            addCriterion("coat_color not in", values, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorBetween(String value1, String value2) {
            addCriterion("coat_color between", value1, value2, "coatColor");
            return (Criteria) this;
        }

        public Criteria andCoatColorNotBetween(String value1, String value2) {
            addCriterion("coat_color not between", value1, value2, "coatColor");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightIsNull() {
            addCriterion("shoulder_height is null");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightIsNotNull() {
            addCriterion("shoulder_height is not null");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightEqualTo(Integer value) {
            addCriterion("shoulder_height =", value, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightNotEqualTo(Integer value) {
            addCriterion("shoulder_height <>", value, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightGreaterThan(Integer value) {
            addCriterion("shoulder_height >", value, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("shoulder_height >=", value, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightLessThan(Integer value) {
            addCriterion("shoulder_height <", value, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightLessThanOrEqualTo(Integer value) {
            addCriterion("shoulder_height <=", value, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightIn(List<Integer> values) {
            addCriterion("shoulder_height in", values, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightNotIn(List<Integer> values) {
            addCriterion("shoulder_height not in", values, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightBetween(Integer value1, Integer value2) {
            addCriterion("shoulder_height between", value1, value2, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andShoulderHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("shoulder_height not between", value1, value2, "shoulderHeight");
            return (Criteria) this;
        }

        public Criteria andIsVaccineIsNull() {
            addCriterion("is_vaccine is null");
            return (Criteria) this;
        }

        public Criteria andIsVaccineIsNotNull() {
            addCriterion("is_vaccine is not null");
            return (Criteria) this;
        }

        public Criteria andIsVaccineEqualTo(Integer value) {
            addCriterion("is_vaccine =", value, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineNotEqualTo(Integer value) {
            addCriterion("is_vaccine <>", value, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineGreaterThan(Integer value) {
            addCriterion("is_vaccine >", value, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_vaccine >=", value, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineLessThan(Integer value) {
            addCriterion("is_vaccine <", value, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineLessThanOrEqualTo(Integer value) {
            addCriterion("is_vaccine <=", value, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineIn(List<Integer> values) {
            addCriterion("is_vaccine in", values, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineNotIn(List<Integer> values) {
            addCriterion("is_vaccine not in", values, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineBetween(Integer value1, Integer value2) {
            addCriterion("is_vaccine between", value1, value2, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsVaccineNotBetween(Integer value1, Integer value2) {
            addCriterion("is_vaccine not between", value1, value2, "isVaccine");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationIsNull() {
            addCriterion("is_sterilization is null");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationIsNotNull() {
            addCriterion("is_sterilization is not null");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationEqualTo(Integer value) {
            addCriterion("is_sterilization =", value, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationNotEqualTo(Integer value) {
            addCriterion("is_sterilization <>", value, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationGreaterThan(Integer value) {
            addCriterion("is_sterilization >", value, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_sterilization >=", value, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationLessThan(Integer value) {
            addCriterion("is_sterilization <", value, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationLessThanOrEqualTo(Integer value) {
            addCriterion("is_sterilization <=", value, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationIn(List<Integer> values) {
            addCriterion("is_sterilization in", values, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationNotIn(List<Integer> values) {
            addCriterion("is_sterilization not in", values, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationBetween(Integer value1, Integer value2) {
            addCriterion("is_sterilization between", value1, value2, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andIsSterilizationNotBetween(Integer value1, Integer value2) {
            addCriterion("is_sterilization not between", value1, value2, "isSterilization");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
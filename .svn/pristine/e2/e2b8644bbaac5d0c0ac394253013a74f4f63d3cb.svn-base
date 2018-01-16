package com.sunjays.capl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonsInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonsInfoExample() {
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
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("Name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("Name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("Name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("Name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("Name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("Name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("Name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("Name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("Name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("Name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("Name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("Name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("Sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("Sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("Sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("Sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("Sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("Sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("Sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("Sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("Sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("Sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("Sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("Sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andDevidIsNull() {
            addCriterion("DevId is null");
            return (Criteria) this;
        }

        public Criteria andDevidIsNotNull() {
            addCriterion("DevId is not null");
            return (Criteria) this;
        }

        public Criteria andDevidEqualTo(String value) {
            addCriterion("DevId =", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotEqualTo(String value) {
            addCriterion("DevId <>", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidGreaterThan(String value) {
            addCriterion("DevId >", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidGreaterThanOrEqualTo(String value) {
            addCriterion("DevId >=", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidLessThan(String value) {
            addCriterion("DevId <", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidLessThanOrEqualTo(String value) {
            addCriterion("DevId <=", value, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidIn(List<String> values) {
            addCriterion("DevId in", values, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotIn(List<String> values) {
            addCriterion("DevId not in", values, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidBetween(String value1, String value2) {
            addCriterion("DevId between", value1, value2, "devid");
            return (Criteria) this;
        }

        public Criteria andDevidNotBetween(String value1, String value2) {
            addCriterion("DevId not between", value1, value2, "devid");
            return (Criteria) this;
        }

        public Criteria andGettimeIsNull() {
            addCriterion("GetTime is null");
            return (Criteria) this;
        }

        public Criteria andGettimeIsNotNull() {
            addCriterion("GetTime is not null");
            return (Criteria) this;
        }

        public Criteria andGettimeEqualTo(Date value) {
            addCriterion("GetTime =", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotEqualTo(Date value) {
            addCriterion("GetTime <>", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeGreaterThan(Date value) {
            addCriterion("GetTime >", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeGreaterThanOrEqualTo(Date value) {
            addCriterion("GetTime >=", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLessThan(Date value) {
            addCriterion("GetTime <", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLessThanOrEqualTo(Date value) {
            addCriterion("GetTime <=", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeIn(List<Date> values) {
            addCriterion("GetTime in", values, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotIn(List<Date> values) {
            addCriterion("GetTime not in", values, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeBetween(Date value1, Date value2) {
            addCriterion("GetTime between", value1, value2, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotBetween(Date value1, Date value2) {
            addCriterion("GetTime not between", value1, value2, "gettime");
            return (Criteria) this;
        }

        public Criteria andSimnumberIsNull() {
            addCriterion("SIMNumber is null");
            return (Criteria) this;
        }

        public Criteria andSimnumberIsNotNull() {
            addCriterion("SIMNumber is not null");
            return (Criteria) this;
        }

        public Criteria andSimnumberEqualTo(String value) {
            addCriterion("SIMNumber =", value, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberNotEqualTo(String value) {
            addCriterion("SIMNumber <>", value, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberGreaterThan(String value) {
            addCriterion("SIMNumber >", value, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberGreaterThanOrEqualTo(String value) {
            addCriterion("SIMNumber >=", value, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberLessThan(String value) {
            addCriterion("SIMNumber <", value, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberLessThanOrEqualTo(String value) {
            addCriterion("SIMNumber <=", value, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberIn(List<String> values) {
            addCriterion("SIMNumber in", values, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberNotIn(List<String> values) {
            addCriterion("SIMNumber not in", values, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberBetween(String value1, String value2) {
            addCriterion("SIMNumber between", value1, value2, "simnumber");
            return (Criteria) this;
        }

        public Criteria andSimnumberNotBetween(String value1, String value2) {
            addCriterion("SIMNumber not between", value1, value2, "simnumber");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("Company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("Company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("Company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("Company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("Company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("Company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("Company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("Company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("Company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("Company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("Company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("Company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("Phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("Phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("Phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("Phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("Phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("Phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("Phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("Phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("Phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("Phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("Phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("Phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("Remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("Remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("Remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("Remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("Remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("Remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("Remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("Remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("Remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("Remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("Remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("Remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("Age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("Age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("Age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("Age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("Age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("Age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("Age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("Age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("Age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("Age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("Age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("Age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("Address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("Address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("Address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("Address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("Address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("Address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("Address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("Address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("Address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("Address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("Address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("Address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andJobnumberIsNull() {
            addCriterion("JobNumber is null");
            return (Criteria) this;
        }

        public Criteria andJobnumberIsNotNull() {
            addCriterion("JobNumber is not null");
            return (Criteria) this;
        }

        public Criteria andJobnumberEqualTo(String value) {
            addCriterion("JobNumber =", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberNotEqualTo(String value) {
            addCriterion("JobNumber <>", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberGreaterThan(String value) {
            addCriterion("JobNumber >", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberGreaterThanOrEqualTo(String value) {
            addCriterion("JobNumber >=", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberLessThan(String value) {
            addCriterion("JobNumber <", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberLessThanOrEqualTo(String value) {
            addCriterion("JobNumber <=", value, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberIn(List<String> values) {
            addCriterion("JobNumber in", values, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberNotIn(List<String> values) {
            addCriterion("JobNumber not in", values, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberBetween(String value1, String value2) {
            addCriterion("JobNumber between", value1, value2, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andJobnumberNotBetween(String value1, String value2) {
            addCriterion("JobNumber not between", value1, value2, "jobnumber");
            return (Criteria) this;
        }

        public Criteria andOntimeIsNull() {
            addCriterion("OnTime is null");
            return (Criteria) this;
        }

        public Criteria andOntimeIsNotNull() {
            addCriterion("OnTime is not null");
            return (Criteria) this;
        }

        public Criteria andOntimeEqualTo(String value) {
            addCriterion("OnTime =", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeNotEqualTo(String value) {
            addCriterion("OnTime <>", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeGreaterThan(String value) {
            addCriterion("OnTime >", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeGreaterThanOrEqualTo(String value) {
            addCriterion("OnTime >=", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeLessThan(String value) {
            addCriterion("OnTime <", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeLessThanOrEqualTo(String value) {
            addCriterion("OnTime <=", value, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeIn(List<String> values) {
            addCriterion("OnTime in", values, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeNotIn(List<String> values) {
            addCriterion("OnTime not in", values, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeBetween(String value1, String value2) {
            addCriterion("OnTime between", value1, value2, "ontime");
            return (Criteria) this;
        }

        public Criteria andOntimeNotBetween(String value1, String value2) {
            addCriterion("OnTime not between", value1, value2, "ontime");
            return (Criteria) this;
        }

        public Criteria andOfftimeIsNull() {
            addCriterion("OffTime is null");
            return (Criteria) this;
        }

        public Criteria andOfftimeIsNotNull() {
            addCriterion("OffTime is not null");
            return (Criteria) this;
        }

        public Criteria andOfftimeEqualTo(String value) {
            addCriterion("OffTime =", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeNotEqualTo(String value) {
            addCriterion("OffTime <>", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeGreaterThan(String value) {
            addCriterion("OffTime >", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeGreaterThanOrEqualTo(String value) {
            addCriterion("OffTime >=", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeLessThan(String value) {
            addCriterion("OffTime <", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeLessThanOrEqualTo(String value) {
            addCriterion("OffTime <=", value, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeIn(List<String> values) {
            addCriterion("OffTime in", values, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeNotIn(List<String> values) {
            addCriterion("OffTime not in", values, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeBetween(String value1, String value2) {
            addCriterion("OffTime between", value1, value2, "offtime");
            return (Criteria) this;
        }

        public Criteria andOfftimeNotBetween(String value1, String value2) {
            addCriterion("OffTime not between", value1, value2, "offtime");
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
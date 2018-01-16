package com.sunjays.capl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ZoneInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ZoneInfoExample() {
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

        public Criteria andWkidIsNull() {
            addCriterion("wkId is null");
            return (Criteria) this;
        }

        public Criteria andWkidIsNotNull() {
            addCriterion("wkId is not null");
            return (Criteria) this;
        }

        public Criteria andWkidEqualTo(Integer value) {
            addCriterion("wkId =", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidNotEqualTo(Integer value) {
            addCriterion("wkId <>", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidGreaterThan(Integer value) {
            addCriterion("wkId >", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wkId >=", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidLessThan(Integer value) {
            addCriterion("wkId <", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidLessThanOrEqualTo(Integer value) {
            addCriterion("wkId <=", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidIn(List<Integer> values) {
            addCriterion("wkId in", values, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidNotIn(List<Integer> values) {
            addCriterion("wkId not in", values, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidBetween(Integer value1, Integer value2) {
            addCriterion("wkId between", value1, value2, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidNotBetween(Integer value1, Integer value2) {
            addCriterion("wkId not between", value1, value2, "wkid");
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

        public Criteria andGps1IsNull() {
            addCriterion("GPS1 is null");
            return (Criteria) this;
        }

        public Criteria andGps1IsNotNull() {
            addCriterion("GPS1 is not null");
            return (Criteria) this;
        }

        public Criteria andGps1EqualTo(String value) {
            addCriterion("GPS1 =", value, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1NotEqualTo(String value) {
            addCriterion("GPS1 <>", value, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1GreaterThan(String value) {
            addCriterion("GPS1 >", value, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1GreaterThanOrEqualTo(String value) {
            addCriterion("GPS1 >=", value, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1LessThan(String value) {
            addCriterion("GPS1 <", value, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1LessThanOrEqualTo(String value) {
            addCriterion("GPS1 <=", value, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1Like(String value) {
            addCriterion("GPS1 like", value, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1NotLike(String value) {
            addCriterion("GPS1 not like", value, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1In(List<String> values) {
            addCriterion("GPS1 in", values, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1NotIn(List<String> values) {
            addCriterion("GPS1 not in", values, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1Between(String value1, String value2) {
            addCriterion("GPS1 between", value1, value2, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps1NotBetween(String value1, String value2) {
            addCriterion("GPS1 not between", value1, value2, "gps1");
            return (Criteria) this;
        }

        public Criteria andGps2IsNull() {
            addCriterion("GPS2 is null");
            return (Criteria) this;
        }

        public Criteria andGps2IsNotNull() {
            addCriterion("GPS2 is not null");
            return (Criteria) this;
        }

        public Criteria andGps2EqualTo(String value) {
            addCriterion("GPS2 =", value, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2NotEqualTo(String value) {
            addCriterion("GPS2 <>", value, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2GreaterThan(String value) {
            addCriterion("GPS2 >", value, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2GreaterThanOrEqualTo(String value) {
            addCriterion("GPS2 >=", value, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2LessThan(String value) {
            addCriterion("GPS2 <", value, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2LessThanOrEqualTo(String value) {
            addCriterion("GPS2 <=", value, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2Like(String value) {
            addCriterion("GPS2 like", value, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2NotLike(String value) {
            addCriterion("GPS2 not like", value, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2In(List<String> values) {
            addCriterion("GPS2 in", values, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2NotIn(List<String> values) {
            addCriterion("GPS2 not in", values, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2Between(String value1, String value2) {
            addCriterion("GPS2 between", value1, value2, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps2NotBetween(String value1, String value2) {
            addCriterion("GPS2 not between", value1, value2, "gps2");
            return (Criteria) this;
        }

        public Criteria andGps3IsNull() {
            addCriterion("GPS3 is null");
            return (Criteria) this;
        }

        public Criteria andGps3IsNotNull() {
            addCriterion("GPS3 is not null");
            return (Criteria) this;
        }

        public Criteria andGps3EqualTo(String value) {
            addCriterion("GPS3 =", value, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3NotEqualTo(String value) {
            addCriterion("GPS3 <>", value, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3GreaterThan(String value) {
            addCriterion("GPS3 >", value, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3GreaterThanOrEqualTo(String value) {
            addCriterion("GPS3 >=", value, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3LessThan(String value) {
            addCriterion("GPS3 <", value, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3LessThanOrEqualTo(String value) {
            addCriterion("GPS3 <=", value, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3Like(String value) {
            addCriterion("GPS3 like", value, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3NotLike(String value) {
            addCriterion("GPS3 not like", value, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3In(List<String> values) {
            addCriterion("GPS3 in", values, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3NotIn(List<String> values) {
            addCriterion("GPS3 not in", values, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3Between(String value1, String value2) {
            addCriterion("GPS3 between", value1, value2, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps3NotBetween(String value1, String value2) {
            addCriterion("GPS3 not between", value1, value2, "gps3");
            return (Criteria) this;
        }

        public Criteria andGps4IsNull() {
            addCriterion("GPS4 is null");
            return (Criteria) this;
        }

        public Criteria andGps4IsNotNull() {
            addCriterion("GPS4 is not null");
            return (Criteria) this;
        }

        public Criteria andGps4EqualTo(String value) {
            addCriterion("GPS4 =", value, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4NotEqualTo(String value) {
            addCriterion("GPS4 <>", value, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4GreaterThan(String value) {
            addCriterion("GPS4 >", value, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4GreaterThanOrEqualTo(String value) {
            addCriterion("GPS4 >=", value, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4LessThan(String value) {
            addCriterion("GPS4 <", value, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4LessThanOrEqualTo(String value) {
            addCriterion("GPS4 <=", value, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4Like(String value) {
            addCriterion("GPS4 like", value, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4NotLike(String value) {
            addCriterion("GPS4 not like", value, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4In(List<String> values) {
            addCriterion("GPS4 in", values, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4NotIn(List<String> values) {
            addCriterion("GPS4 not in", values, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4Between(String value1, String value2) {
            addCriterion("GPS4 between", value1, value2, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps4NotBetween(String value1, String value2) {
            addCriterion("GPS4 not between", value1, value2, "gps4");
            return (Criteria) this;
        }

        public Criteria andGps5IsNull() {
            addCriterion("GPS5 is null");
            return (Criteria) this;
        }

        public Criteria andGps5IsNotNull() {
            addCriterion("GPS5 is not null");
            return (Criteria) this;
        }

        public Criteria andGps5EqualTo(String value) {
            addCriterion("GPS5 =", value, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5NotEqualTo(String value) {
            addCriterion("GPS5 <>", value, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5GreaterThan(String value) {
            addCriterion("GPS5 >", value, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5GreaterThanOrEqualTo(String value) {
            addCriterion("GPS5 >=", value, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5LessThan(String value) {
            addCriterion("GPS5 <", value, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5LessThanOrEqualTo(String value) {
            addCriterion("GPS5 <=", value, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5Like(String value) {
            addCriterion("GPS5 like", value, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5NotLike(String value) {
            addCriterion("GPS5 not like", value, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5In(List<String> values) {
            addCriterion("GPS5 in", values, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5NotIn(List<String> values) {
            addCriterion("GPS5 not in", values, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5Between(String value1, String value2) {
            addCriterion("GPS5 between", value1, value2, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps5NotBetween(String value1, String value2) {
            addCriterion("GPS5 not between", value1, value2, "gps5");
            return (Criteria) this;
        }

        public Criteria andGps6IsNull() {
            addCriterion("GPS6 is null");
            return (Criteria) this;
        }

        public Criteria andGps6IsNotNull() {
            addCriterion("GPS6 is not null");
            return (Criteria) this;
        }

        public Criteria andGps6EqualTo(String value) {
            addCriterion("GPS6 =", value, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6NotEqualTo(String value) {
            addCriterion("GPS6 <>", value, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6GreaterThan(String value) {
            addCriterion("GPS6 >", value, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6GreaterThanOrEqualTo(String value) {
            addCriterion("GPS6 >=", value, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6LessThan(String value) {
            addCriterion("GPS6 <", value, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6LessThanOrEqualTo(String value) {
            addCriterion("GPS6 <=", value, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6Like(String value) {
            addCriterion("GPS6 like", value, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6NotLike(String value) {
            addCriterion("GPS6 not like", value, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6In(List<String> values) {
            addCriterion("GPS6 in", values, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6NotIn(List<String> values) {
            addCriterion("GPS6 not in", values, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6Between(String value1, String value2) {
            addCriterion("GPS6 between", value1, value2, "gps6");
            return (Criteria) this;
        }

        public Criteria andGps6NotBetween(String value1, String value2) {
            addCriterion("GPS6 not between", value1, value2, "gps6");
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

        public Criteria andRemarkLike(String value) {
            addCriterion("Remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("Remark not like", value, "remark");
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

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(Integer value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(Integer value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(Integer value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(Integer value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(Integer value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<Integer> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<Integer> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(Integer value1, Integer value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("Remark2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("Remark2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("Remark2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("Remark2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("Remark2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("Remark2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("Remark2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("Remark2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("Remark2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("Remark2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("Remark2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("Remark2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("Remark2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("Remark2 not between", value1, value2, "remark2");
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
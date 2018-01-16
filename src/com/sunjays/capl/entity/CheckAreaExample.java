package com.sunjays.capl.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckAreaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CheckAreaExample() {
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

        public Criteria andWkidIsNull() {
            addCriterion("wkid is null");
            return (Criteria) this;
        }

        public Criteria andWkidIsNotNull() {
            addCriterion("wkid is not null");
            return (Criteria) this;
        }

        public Criteria andWkidEqualTo(Integer value) {
            addCriterion("wkid =", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidNotEqualTo(Integer value) {
            addCriterion("wkid <>", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidGreaterThan(Integer value) {
            addCriterion("wkid >", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidGreaterThanOrEqualTo(Integer value) {
            addCriterion("wkid >=", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidLessThan(Integer value) {
            addCriterion("wkid <", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidLessThanOrEqualTo(Integer value) {
            addCriterion("wkid <=", value, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidIn(List<Integer> values) {
            addCriterion("wkid in", values, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidNotIn(List<Integer> values) {
            addCriterion("wkid not in", values, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidBetween(Integer value1, Integer value2) {
            addCriterion("wkid between", value1, value2, "wkid");
            return (Criteria) this;
        }

        public Criteria andWkidNotBetween(Integer value1, Integer value2) {
            addCriterion("wkid not between", value1, value2, "wkid");
            return (Criteria) this;
        }

        public Criteria andUnitpartIsNull() {
            addCriterion("unitpart is null");
            return (Criteria) this;
        }

        public Criteria andUnitpartIsNotNull() {
            addCriterion("unitpart is not null");
            return (Criteria) this;
        }

        public Criteria andUnitpartEqualTo(String value) {
            addCriterion("unitpart =", value, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartNotEqualTo(String value) {
            addCriterion("unitpart <>", value, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartGreaterThan(String value) {
            addCriterion("unitpart >", value, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartGreaterThanOrEqualTo(String value) {
            addCriterion("unitpart >=", value, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartLessThan(String value) {
            addCriterion("unitpart <", value, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartLessThanOrEqualTo(String value) {
            addCriterion("unitpart <=", value, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartIn(List<String> values) {
            addCriterion("unitpart in", values, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartNotIn(List<String> values) {
            addCriterion("unitpart not in", values, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartBetween(String value1, String value2) {
            addCriterion("unitpart between", value1, value2, "unitpart");
            return (Criteria) this;
        }

        public Criteria andUnitpartNotBetween(String value1, String value2) {
            addCriterion("unitpart not between", value1, value2, "unitpart");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNull() {
            addCriterion("creattime is null");
            return (Criteria) this;
        }

        public Criteria andCreattimeIsNotNull() {
            addCriterion("creattime is not null");
            return (Criteria) this;
        }

        public Criteria andCreattimeEqualTo(Date value) {
            addCriterion("creattime =", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotEqualTo(Date value) {
            addCriterion("creattime <>", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThan(Date value) {
            addCriterion("creattime >", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("creattime >=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThan(Date value) {
            addCriterion("creattime <", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeLessThanOrEqualTo(Date value) {
            addCriterion("creattime <=", value, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeIn(List<Date> values) {
            addCriterion("creattime in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotIn(List<Date> values) {
            addCriterion("creattime not in", values, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeBetween(Date value1, Date value2) {
            addCriterion("creattime between", value1, value2, "creattime");
            return (Criteria) this;
        }

        public Criteria andCreattimeNotBetween(Date value1, Date value2) {
            addCriterion("creattime not between", value1, value2, "creattime");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("remark1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("remark1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("remark1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("remark1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("remark1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("remark1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("remark1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("remark1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("remark1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("remark1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("remark1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("remark1 not between", value1, value2, "remark1");
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
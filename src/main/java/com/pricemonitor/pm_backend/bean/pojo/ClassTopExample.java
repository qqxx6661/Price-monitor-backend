package com.pricemonitor.pm_backend.bean.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassTopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassTopExample() {
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

        public Criteria andClassTopIdIsNull() {
            addCriterion("class_top_id is null");
            return (Criteria) this;
        }

        public Criteria andClassTopIdIsNotNull() {
            addCriterion("class_top_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassTopIdEqualTo(Integer value) {
            addCriterion("class_top_id =", value, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdNotEqualTo(Integer value) {
            addCriterion("class_top_id <>", value, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdGreaterThan(Integer value) {
            addCriterion("class_top_id >", value, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_top_id >=", value, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdLessThan(Integer value) {
            addCriterion("class_top_id <", value, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_top_id <=", value, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdIn(List<Integer> values) {
            addCriterion("class_top_id in", values, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdNotIn(List<Integer> values) {
            addCriterion("class_top_id not in", values, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdBetween(Integer value1, Integer value2) {
            addCriterion("class_top_id between", value1, value2, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_top_id not between", value1, value2, "classTopId");
            return (Criteria) this;
        }

        public Criteria andClassTopNameIsNull() {
            addCriterion("class_top_name is null");
            return (Criteria) this;
        }

        public Criteria andClassTopNameIsNotNull() {
            addCriterion("class_top_name is not null");
            return (Criteria) this;
        }

        public Criteria andClassTopNameEqualTo(String value) {
            addCriterion("class_top_name =", value, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameNotEqualTo(String value) {
            addCriterion("class_top_name <>", value, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameGreaterThan(String value) {
            addCriterion("class_top_name >", value, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameGreaterThanOrEqualTo(String value) {
            addCriterion("class_top_name >=", value, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameLessThan(String value) {
            addCriterion("class_top_name <", value, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameLessThanOrEqualTo(String value) {
            addCriterion("class_top_name <=", value, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameLike(String value) {
            addCriterion("class_top_name like", value, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameNotLike(String value) {
            addCriterion("class_top_name not like", value, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameIn(List<String> values) {
            addCriterion("class_top_name in", values, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameNotIn(List<String> values) {
            addCriterion("class_top_name not in", values, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameBetween(String value1, String value2) {
            addCriterion("class_top_name between", value1, value2, "classTopName");
            return (Criteria) this;
        }

        public Criteria andClassTopNameNotBetween(String value1, String value2) {
            addCriterion("class_top_name not between", value1, value2, "classTopName");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNull() {
            addCriterion("gmt_modified is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("gmt_modified is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("gmt_modified =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("gmt_modified <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("gmt_modified >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modified >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("gmt_modified <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modified <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("gmt_modified in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("gmt_modified not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("gmt_modified between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modified not between", value1, value2, "gmtModified");
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
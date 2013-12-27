package com.glacier.permission.entity;

import java.util.ArrayList;
import java.util.List;

public class DepExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public DepExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andDepIdIsNull() {
            addCriterion("temp_dep.dep_id is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("temp_dep.dep_id is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(String value) {
            addCriterion("temp_dep.dep_id =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(String value) {
            addCriterion("temp_dep.dep_id <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(String value) {
            addCriterion("temp_dep.dep_id >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(String value) {
            addCriterion("temp_dep.dep_id >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(String value) {
            addCriterion("temp_dep.dep_id <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(String value) {
            addCriterion("temp_dep.dep_id <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLike(String value) {
            addCriterion("temp_dep.dep_id like", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotLike(String value) {
            addCriterion("temp_dep.dep_id not like", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<String> values) {
            addCriterion("temp_dep.dep_id in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<String> values) {
            addCriterion("temp_dep.dep_id not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(String value1, String value2) {
            addCriterion("temp_dep.dep_id between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(String value1, String value2) {
            addCriterion("temp_dep.dep_id not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("temp_dep.dep_name is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("temp_dep.dep_name is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("temp_dep.dep_name =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("temp_dep.dep_name <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("temp_dep.dep_name >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("temp_dep.dep_name >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("temp_dep.dep_name <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("temp_dep.dep_name <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("temp_dep.dep_name like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("temp_dep.dep_name not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("temp_dep.dep_name in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("temp_dep.dep_name not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("temp_dep.dep_name between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("temp_dep.dep_name not between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("temp_dep.pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("temp_dep.pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("temp_dep.pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("temp_dep.pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("temp_dep.pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("temp_dep.pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("temp_dep.pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("temp_dep.pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("temp_dep.pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("temp_dep.pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("temp_dep.pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("temp_dep.pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("temp_dep.pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("temp_dep.pid not between", value1, value2, "pid");
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
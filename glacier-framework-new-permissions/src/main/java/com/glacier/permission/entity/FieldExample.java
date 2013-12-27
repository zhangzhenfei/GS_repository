package com.glacier.permission.entity;

import java.util.ArrayList;
import java.util.List;

public class FieldExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public FieldExample() {
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

        public Criteria andFieldIdIsNull() {
            addCriterion("temp_field.field_id is null");
            return (Criteria) this;
        }

        public Criteria andFieldIdIsNotNull() {
            addCriterion("temp_field.field_id is not null");
            return (Criteria) this;
        }

        public Criteria andFieldIdEqualTo(String value) {
            addCriterion("temp_field.field_id =", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotEqualTo(String value) {
            addCriterion("temp_field.field_id <>", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThan(String value) {
            addCriterion("temp_field.field_id >", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdGreaterThanOrEqualTo(String value) {
            addCriterion("temp_field.field_id >=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThan(String value) {
            addCriterion("temp_field.field_id <", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLessThanOrEqualTo(String value) {
            addCriterion("temp_field.field_id <=", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdLike(String value) {
            addCriterion("temp_field.field_id like", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotLike(String value) {
            addCriterion("temp_field.field_id not like", value, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdIn(List<String> values) {
            addCriterion("temp_field.field_id in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotIn(List<String> values) {
            addCriterion("temp_field.field_id not in", values, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdBetween(String value1, String value2) {
            addCriterion("temp_field.field_id between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIdNotBetween(String value1, String value2) {
            addCriterion("temp_field.field_id not between", value1, value2, "fieldId");
            return (Criteria) this;
        }

        public Criteria andFieldIsNull() {
            addCriterion("temp_field.field is null");
            return (Criteria) this;
        }

        public Criteria andFieldIsNotNull() {
            addCriterion("temp_field.field is not null");
            return (Criteria) this;
        }

        public Criteria andFieldEqualTo(String value) {
            addCriterion("temp_field.field =", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotEqualTo(String value) {
            addCriterion("temp_field.field <>", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThan(String value) {
            addCriterion("temp_field.field >", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldGreaterThanOrEqualTo(String value) {
            addCriterion("temp_field.field >=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThan(String value) {
            addCriterion("temp_field.field <", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLessThanOrEqualTo(String value) {
            addCriterion("temp_field.field <=", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldLike(String value) {
            addCriterion("temp_field.field like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotLike(String value) {
            addCriterion("temp_field.field not like", value, "field");
            return (Criteria) this;
        }

        public Criteria andFieldIn(List<String> values) {
            addCriterion("temp_field.field in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotIn(List<String> values) {
            addCriterion("temp_field.field not in", values, "field");
            return (Criteria) this;
        }

        public Criteria andFieldBetween(String value1, String value2) {
            addCriterion("temp_field.field between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNotBetween(String value1, String value2) {
            addCriterion("temp_field.field not between", value1, value2, "field");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNull() {
            addCriterion("temp_field.field_name is null");
            return (Criteria) this;
        }

        public Criteria andFieldNameIsNotNull() {
            addCriterion("temp_field.field_name is not null");
            return (Criteria) this;
        }

        public Criteria andFieldNameEqualTo(String value) {
            addCriterion("temp_field.field_name =", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotEqualTo(String value) {
            addCriterion("temp_field.field_name <>", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThan(String value) {
            addCriterion("temp_field.field_name >", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameGreaterThanOrEqualTo(String value) {
            addCriterion("temp_field.field_name >=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThan(String value) {
            addCriterion("temp_field.field_name <", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLessThanOrEqualTo(String value) {
            addCriterion("temp_field.field_name <=", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameLike(String value) {
            addCriterion("temp_field.field_name like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotLike(String value) {
            addCriterion("temp_field.field_name not like", value, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameIn(List<String> values) {
            addCriterion("temp_field.field_name in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotIn(List<String> values) {
            addCriterion("temp_field.field_name not in", values, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameBetween(String value1, String value2) {
            addCriterion("temp_field.field_name between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andFieldNameNotBetween(String value1, String value2) {
            addCriterion("temp_field.field_name not between", value1, value2, "fieldName");
            return (Criteria) this;
        }

        public Criteria andValueFieldIsNull() {
            addCriterion("temp_field.value_field is null");
            return (Criteria) this;
        }

        public Criteria andValueFieldIsNotNull() {
            addCriterion("temp_field.value_field is not null");
            return (Criteria) this;
        }

        public Criteria andValueFieldEqualTo(String value) {
            addCriterion("temp_field.value_field =", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldNotEqualTo(String value) {
            addCriterion("temp_field.value_field <>", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldGreaterThan(String value) {
            addCriterion("temp_field.value_field >", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldGreaterThanOrEqualTo(String value) {
            addCriterion("temp_field.value_field >=", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldLessThan(String value) {
            addCriterion("temp_field.value_field <", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldLessThanOrEqualTo(String value) {
            addCriterion("temp_field.value_field <=", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldLike(String value) {
            addCriterion("temp_field.value_field like", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldNotLike(String value) {
            addCriterion("temp_field.value_field not like", value, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldIn(List<String> values) {
            addCriterion("temp_field.value_field in", values, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldNotIn(List<String> values) {
            addCriterion("temp_field.value_field not in", values, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldBetween(String value1, String value2) {
            addCriterion("temp_field.value_field between", value1, value2, "valueField");
            return (Criteria) this;
        }

        public Criteria andValueFieldNotBetween(String value1, String value2) {
            addCriterion("temp_field.value_field not between", value1, value2, "valueField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldIsNull() {
            addCriterion("temp_field.display_field is null");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldIsNotNull() {
            addCriterion("temp_field.display_field is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldEqualTo(String value) {
            addCriterion("temp_field.display_field =", value, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldNotEqualTo(String value) {
            addCriterion("temp_field.display_field <>", value, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldGreaterThan(String value) {
            addCriterion("temp_field.display_field >", value, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldGreaterThanOrEqualTo(String value) {
            addCriterion("temp_field.display_field >=", value, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldLessThan(String value) {
            addCriterion("temp_field.display_field <", value, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldLessThanOrEqualTo(String value) {
            addCriterion("temp_field.display_field <=", value, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldLike(String value) {
            addCriterion("temp_field.display_field like", value, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldNotLike(String value) {
            addCriterion("temp_field.display_field not like", value, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldIn(List<String> values) {
            addCriterion("temp_field.display_field in", values, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldNotIn(List<String> values) {
            addCriterion("temp_field.display_field not in", values, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldBetween(String value1, String value2) {
            addCriterion("temp_field.display_field between", value1, value2, "displayField");
            return (Criteria) this;
        }

        public Criteria andDisplayFieldNotBetween(String value1, String value2) {
            addCriterion("temp_field.display_field not between", value1, value2, "displayField");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNull() {
            addCriterion("temp_field.enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("temp_field.enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Byte value) {
            addCriterion("temp_field.enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Byte value) {
            addCriterion("temp_field.enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Byte value) {
            addCriterion("temp_field.enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("temp_field.enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Byte value) {
            addCriterion("temp_field.enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("temp_field.enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Byte> values) {
            addCriterion("temp_field.enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Byte> values) {
            addCriterion("temp_field.enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Byte value1, Byte value2) {
            addCriterion("temp_field.enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("temp_field.enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("temp_field.sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("temp_field.sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("temp_field.sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("temp_field.sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("temp_field.sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("temp_field.sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("temp_field.sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("temp_field.sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("temp_field.sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("temp_field.sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("temp_field.sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("temp_field.sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("temp_field.remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("temp_field.remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("temp_field.remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("temp_field.remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("temp_field.remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("temp_field.remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("temp_field.remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("temp_field.remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("temp_field.remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("temp_field.remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("temp_field.remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("temp_field.remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("temp_field.remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("temp_field.remark not between", value1, value2, "remark");
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
package com.nmid.items.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TalkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TalkExample() {
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

        public Criteria andTidIsNull() {
            addCriterion("tid is null");
            return (Criteria) this;
        }

        public Criteria andTidIsNotNull() {
            addCriterion("tid is not null");
            return (Criteria) this;
        }

        public Criteria andTidEqualTo(Integer value) {
            addCriterion("tid =", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotEqualTo(Integer value) {
            addCriterion("tid <>", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThan(Integer value) {
            addCriterion("tid >", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidGreaterThanOrEqualTo(Integer value) {
            addCriterion("tid >=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThan(Integer value) {
            addCriterion("tid <", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidLessThanOrEqualTo(Integer value) {
            addCriterion("tid <=", value, "tid");
            return (Criteria) this;
        }

        public Criteria andTidIn(List<Integer> values) {
            addCriterion("tid in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotIn(List<Integer> values) {
            addCriterion("tid not in", values, "tid");
            return (Criteria) this;
        }

        public Criteria andTidBetween(Integer value1, Integer value2) {
            addCriterion("tid between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andTidNotBetween(Integer value1, Integer value2) {
            addCriterion("tid not between", value1, value2, "tid");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("context in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("context not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andTalkTimeIsNull() {
            addCriterion("talk_time is null");
            return (Criteria) this;
        }

        public Criteria andTalkTimeIsNotNull() {
            addCriterion("talk_time is not null");
            return (Criteria) this;
        }

        public Criteria andTalkTimeEqualTo(Date value) {
            addCriterion("talk_time =", value, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeNotEqualTo(Date value) {
            addCriterion("talk_time <>", value, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeGreaterThan(Date value) {
            addCriterion("talk_time >", value, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("talk_time >=", value, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeLessThan(Date value) {
            addCriterion("talk_time <", value, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeLessThanOrEqualTo(Date value) {
            addCriterion("talk_time <=", value, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeIn(List<Date> values) {
            addCriterion("talk_time in", values, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeNotIn(List<Date> values) {
            addCriterion("talk_time not in", values, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeBetween(Date value1, Date value2) {
            addCriterion("talk_time between", value1, value2, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkTimeNotBetween(Date value1, Date value2) {
            addCriterion("talk_time not between", value1, value2, "talkTime");
            return (Criteria) this;
        }

        public Criteria andTalkUseridIsNull() {
            addCriterion("talk_userid is null");
            return (Criteria) this;
        }

        public Criteria andTalkUseridIsNotNull() {
            addCriterion("talk_userid is not null");
            return (Criteria) this;
        }

        public Criteria andTalkUseridEqualTo(Integer value) {
            addCriterion("talk_userid =", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridNotEqualTo(Integer value) {
            addCriterion("talk_userid <>", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridGreaterThan(Integer value) {
            addCriterion("talk_userid >", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("talk_userid >=", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridLessThan(Integer value) {
            addCriterion("talk_userid <", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridLessThanOrEqualTo(Integer value) {
            addCriterion("talk_userid <=", value, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridIn(List<Integer> values) {
            addCriterion("talk_userid in", values, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridNotIn(List<Integer> values) {
            addCriterion("talk_userid not in", values, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridBetween(Integer value1, Integer value2) {
            addCriterion("talk_userid between", value1, value2, "talkUserid");
            return (Criteria) this;
        }

        public Criteria andTalkUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("talk_userid not between", value1, value2, "talkUserid");
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
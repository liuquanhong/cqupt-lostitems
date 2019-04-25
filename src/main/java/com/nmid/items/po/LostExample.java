package com.nmid.items.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LostExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LostExample() {
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

        public Criteria andLidIsNull() {
            addCriterion("lid is null");
            return (Criteria) this;
        }

        public Criteria andLidIsNotNull() {
            addCriterion("lid is not null");
            return (Criteria) this;
        }

        public Criteria andLidEqualTo(Integer value) {
            addCriterion("lid =", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotEqualTo(Integer value) {
            addCriterion("lid <>", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThan(Integer value) {
            addCriterion("lid >", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThanOrEqualTo(Integer value) {
            addCriterion("lid >=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThan(Integer value) {
            addCriterion("lid <", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThanOrEqualTo(Integer value) {
            addCriterion("lid <=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidIn(List<Integer> values) {
            addCriterion("lid in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotIn(List<Integer> values) {
            addCriterion("lid not in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidBetween(Integer value1, Integer value2) {
            addCriterion("lid between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotBetween(Integer value1, Integer value2) {
            addCriterion("lid not between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andLostTimeIsNull() {
            addCriterion("lost_time is null");
            return (Criteria) this;
        }

        public Criteria andLostTimeIsNotNull() {
            addCriterion("lost_time is not null");
            return (Criteria) this;
        }

        public Criteria andLostTimeEqualTo(Date value) {
            addCriterion("lost_time =", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeNotEqualTo(Date value) {
            addCriterion("lost_time <>", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeGreaterThan(Date value) {
            addCriterion("lost_time >", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lost_time >=", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeLessThan(Date value) {
            addCriterion("lost_time <", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeLessThanOrEqualTo(Date value) {
            addCriterion("lost_time <=", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeIn(List<Date> values) {
            addCriterion("lost_time in", values, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeNotIn(List<Date> values) {
            addCriterion("lost_time not in", values, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeBetween(Date value1, Date value2) {
            addCriterion("lost_time between", value1, value2, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeNotBetween(Date value1, Date value2) {
            addCriterion("lost_time not between", value1, value2, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostAddressIsNull() {
            addCriterion("lost_address is null");
            return (Criteria) this;
        }

        public Criteria andLostAddressIsNotNull() {
            addCriterion("lost_address is not null");
            return (Criteria) this;
        }

        public Criteria andLostAddressEqualTo(String value) {
            addCriterion("lost_address =", value, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressNotEqualTo(String value) {
            addCriterion("lost_address <>", value, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressGreaterThan(String value) {
            addCriterion("lost_address >", value, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressGreaterThanOrEqualTo(String value) {
            addCriterion("lost_address >=", value, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressLessThan(String value) {
            addCriterion("lost_address <", value, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressLessThanOrEqualTo(String value) {
            addCriterion("lost_address <=", value, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressLike(String value) {
            addCriterion("lost_address like", value, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressNotLike(String value) {
            addCriterion("lost_address not like", value, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressIn(List<String> values) {
            addCriterion("lost_address in", values, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressNotIn(List<String> values) {
            addCriterion("lost_address not in", values, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressBetween(String value1, String value2) {
            addCriterion("lost_address between", value1, value2, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andLostAddressNotBetween(String value1, String value2) {
            addCriterion("lost_address not between", value1, value2, "lostAddress");
            return (Criteria) this;
        }

        public Criteria andSpeciesIsNull() {
            addCriterion("species is null");
            return (Criteria) this;
        }

        public Criteria andSpeciesIsNotNull() {
            addCriterion("species is not null");
            return (Criteria) this;
        }

        public Criteria andSpeciesEqualTo(String value) {
            addCriterion("species =", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotEqualTo(String value) {
            addCriterion("species <>", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesGreaterThan(String value) {
            addCriterion("species >", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesGreaterThanOrEqualTo(String value) {
            addCriterion("species >=", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesLessThan(String value) {
            addCriterion("species <", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesLessThanOrEqualTo(String value) {
            addCriterion("species <=", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesLike(String value) {
            addCriterion("species like", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotLike(String value) {
            addCriterion("species not like", value, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesIn(List<String> values) {
            addCriterion("species in", values, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotIn(List<String> values) {
            addCriterion("species not in", values, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesBetween(String value1, String value2) {
            addCriterion("species between", value1, value2, "species");
            return (Criteria) this;
        }

        public Criteria andSpeciesNotBetween(String value1, String value2) {
            addCriterion("species not between", value1, value2, "species");
            return (Criteria) this;
        }

        public Criteria andLostUseridIsNull() {
            addCriterion("lost_userid is null");
            return (Criteria) this;
        }

        public Criteria andLostUseridIsNotNull() {
            addCriterion("lost_userid is not null");
            return (Criteria) this;
        }

        public Criteria andLostUseridEqualTo(Integer value) {
            addCriterion("lost_userid =", value, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridNotEqualTo(Integer value) {
            addCriterion("lost_userid <>", value, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridGreaterThan(Integer value) {
            addCriterion("lost_userid >", value, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("lost_userid >=", value, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridLessThan(Integer value) {
            addCriterion("lost_userid <", value, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridLessThanOrEqualTo(Integer value) {
            addCriterion("lost_userid <=", value, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridIn(List<Integer> values) {
            addCriterion("lost_userid in", values, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridNotIn(List<Integer> values) {
            addCriterion("lost_userid not in", values, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridBetween(Integer value1, Integer value2) {
            addCriterion("lost_userid between", value1, value2, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andLostUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("lost_userid not between", value1, value2, "lostUserid");
            return (Criteria) this;
        }

        public Criteria andCharacterStrIsNull() {
            addCriterion("character_str is null");
            return (Criteria) this;
        }

        public Criteria andCharacterStrIsNotNull() {
            addCriterion("character_str is not null");
            return (Criteria) this;
        }

        public Criteria andCharacterStrEqualTo(String value) {
            addCriterion("character_str =", value, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrNotEqualTo(String value) {
            addCriterion("character_str <>", value, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrGreaterThan(String value) {
            addCriterion("character_str >", value, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrGreaterThanOrEqualTo(String value) {
            addCriterion("character_str >=", value, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrLessThan(String value) {
            addCriterion("character_str <", value, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrLessThanOrEqualTo(String value) {
            addCriterion("character_str <=", value, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrLike(String value) {
            addCriterion("character_str like", value, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrNotLike(String value) {
            addCriterion("character_str not like", value, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrIn(List<String> values) {
            addCriterion("character_str in", values, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrNotIn(List<String> values) {
            addCriterion("character_str not in", values, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrBetween(String value1, String value2) {
            addCriterion("character_str between", value1, value2, "characterStr");
            return (Criteria) this;
        }

        public Criteria andCharacterStrNotBetween(String value1, String value2) {
            addCriterion("character_str not between", value1, value2, "characterStr");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andFindUseridIsNull() {
            addCriterion("find_userid is null");
            return (Criteria) this;
        }

        public Criteria andFindUseridIsNotNull() {
            addCriterion("find_userid is not null");
            return (Criteria) this;
        }

        public Criteria andFindUseridEqualTo(Integer value) {
            addCriterion("find_userid =", value, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridNotEqualTo(Integer value) {
            addCriterion("find_userid <>", value, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridGreaterThan(Integer value) {
            addCriterion("find_userid >", value, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("find_userid >=", value, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridLessThan(Integer value) {
            addCriterion("find_userid <", value, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridLessThanOrEqualTo(Integer value) {
            addCriterion("find_userid <=", value, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridIn(List<Integer> values) {
            addCriterion("find_userid in", values, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridNotIn(List<Integer> values) {
            addCriterion("find_userid not in", values, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridBetween(Integer value1, Integer value2) {
            addCriterion("find_userid between", value1, value2, "findUserid");
            return (Criteria) this;
        }

        public Criteria andFindUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("find_userid not between", value1, value2, "findUserid");
            return (Criteria) this;
        }

        public Criteria andLostStatusIsNull() {
            addCriterion("lost_status is null");
            return (Criteria) this;
        }

        public Criteria andLostStatusIsNotNull() {
            addCriterion("lost_status is not null");
            return (Criteria) this;
        }

        public Criteria andLostStatusEqualTo(Integer value) {
            addCriterion("lost_status =", value, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusNotEqualTo(Integer value) {
            addCriterion("lost_status <>", value, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusGreaterThan(Integer value) {
            addCriterion("lost_status >", value, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("lost_status >=", value, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusLessThan(Integer value) {
            addCriterion("lost_status <", value, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusLessThanOrEqualTo(Integer value) {
            addCriterion("lost_status <=", value, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusIn(List<Integer> values) {
            addCriterion("lost_status in", values, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusNotIn(List<Integer> values) {
            addCriterion("lost_status not in", values, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusBetween(Integer value1, Integer value2) {
            addCriterion("lost_status between", value1, value2, "lostStatus");
            return (Criteria) this;
        }

        public Criteria andLostStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("lost_status not between", value1, value2, "lostStatus");
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
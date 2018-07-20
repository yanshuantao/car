package com.yst.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemExample  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1873879078318022037L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdIsNull() {
            addCriterion("brand_modle_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdIsNotNull() {
            addCriterion("brand_modle_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdEqualTo(Integer value) {
            addCriterion("brand_modle_id =", value, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdNotEqualTo(Integer value) {
            addCriterion("brand_modle_id <>", value, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdGreaterThan(Integer value) {
            addCriterion("brand_modle_id >", value, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_modle_id >=", value, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdLessThan(Integer value) {
            addCriterion("brand_modle_id <", value, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_modle_id <=", value, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdIn(List<Integer> values) {
            addCriterion("brand_modle_id in", values, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdNotIn(List<Integer> values) {
            addCriterion("brand_modle_id not in", values, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_modle_id between", value1, value2, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andBrandModleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_modle_id not between", value1, value2, "brandModleId");
            return (Criteria) this;
        }

        public Criteria andLabelsIsNull() {
            addCriterion("labels is null");
            return (Criteria) this;
        }

        public Criteria andLabelsIsNotNull() {
            addCriterion("labels is not null");
            return (Criteria) this;
        }

        public Criteria andLabelsEqualTo(String value) {
            addCriterion("labels =", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsNotEqualTo(String value) {
            addCriterion("labels <>", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsGreaterThan(String value) {
            addCriterion("labels >", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsGreaterThanOrEqualTo(String value) {
            addCriterion("labels >=", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsLessThan(String value) {
            addCriterion("labels <", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsLessThanOrEqualTo(String value) {
            addCriterion("labels <=", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsLike(String value) {
            addCriterion("labels like", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsNotLike(String value) {
            addCriterion("labels not like", value, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsIn(List<String> values) {
            addCriterion("labels in", values, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsNotIn(List<String> values) {
            addCriterion("labels not in", values, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsBetween(String value1, String value2) {
            addCriterion("labels between", value1, value2, "labels");
            return (Criteria) this;
        }

        public Criteria andLabelsNotBetween(String value1, String value2) {
            addCriterion("labels not between", value1, value2, "labels");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNull() {
            addCriterion("property_type is null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIsNotNull() {
            addCriterion("property_type is not null");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeEqualTo(Integer value) {
            addCriterion("property_type =", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotEqualTo(Integer value) {
            addCriterion("property_type <>", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThan(Integer value) {
            addCriterion("property_type >", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("property_type >=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThan(Integer value) {
            addCriterion("property_type <", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("property_type <=", value, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeIn(List<Integer> values) {
            addCriterion("property_type in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotIn(List<Integer> values) {
            addCriterion("property_type not in", values, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeBetween(Integer value1, Integer value2) {
            addCriterion("property_type between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPropertyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("property_type not between", value1, value2, "propertyType");
            return (Criteria) this;
        }

        public Criteria andPriceHighIsNull() {
            addCriterion("price_high is null");
            return (Criteria) this;
        }

        public Criteria andPriceHighIsNotNull() {
            addCriterion("price_high is not null");
            return (Criteria) this;
        }

        public Criteria andPriceHighEqualTo(BigDecimal value) {
            addCriterion("price_high =", value, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighNotEqualTo(BigDecimal value) {
            addCriterion("price_high <>", value, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighGreaterThan(BigDecimal value) {
            addCriterion("price_high >", value, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_high >=", value, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighLessThan(BigDecimal value) {
            addCriterion("price_high <", value, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_high <=", value, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighIn(List<BigDecimal> values) {
            addCriterion("price_high in", values, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighNotIn(List<BigDecimal> values) {
            addCriterion("price_high not in", values, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_high between", value1, value2, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceHighNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_high not between", value1, value2, "priceHigh");
            return (Criteria) this;
        }

        public Criteria andPriceLowIsNull() {
            addCriterion("price_low is null");
            return (Criteria) this;
        }

        public Criteria andPriceLowIsNotNull() {
            addCriterion("price_low is not null");
            return (Criteria) this;
        }

        public Criteria andPriceLowEqualTo(BigDecimal value) {
            addCriterion("price_low =", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowNotEqualTo(BigDecimal value) {
            addCriterion("price_low <>", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowGreaterThan(BigDecimal value) {
            addCriterion("price_low >", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_low >=", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowLessThan(BigDecimal value) {
            addCriterion("price_low <", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_low <=", value, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowIn(List<BigDecimal> values) {
            addCriterion("price_low in", values, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowNotIn(List<BigDecimal> values) {
            addCriterion("price_low not in", values, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_low between", value1, value2, "priceLow");
            return (Criteria) this;
        }

        public Criteria andPriceLowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_low not between", value1, value2, "priceLow");
            return (Criteria) this;
        }

        public Criteria andIsAutoIsNull() {
            addCriterion("is_auto is null");
            return (Criteria) this;
        }

        public Criteria andIsAutoIsNotNull() {
            addCriterion("is_auto is not null");
            return (Criteria) this;
        }

        public Criteria andIsAutoEqualTo(Boolean value) {
            addCriterion("is_auto =", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotEqualTo(Boolean value) {
            addCriterion("is_auto <>", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoGreaterThan(Boolean value) {
            addCriterion("is_auto >", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_auto >=", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLessThan(Boolean value) {
            addCriterion("is_auto <", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoLessThanOrEqualTo(Boolean value) {
            addCriterion("is_auto <=", value, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoIn(List<Boolean> values) {
            addCriterion("is_auto in", values, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotIn(List<Boolean> values) {
            addCriterion("is_auto not in", values, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoBetween(Boolean value1, Boolean value2) {
            addCriterion("is_auto between", value1, value2, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsAutoNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_auto not between", value1, value2, "isAuto");
            return (Criteria) this;
        }

        public Criteria andIsChineseIsNull() {
            addCriterion("is_chinese is null");
            return (Criteria) this;
        }

        public Criteria andIsChineseIsNotNull() {
            addCriterion("is_chinese is not null");
            return (Criteria) this;
        }

        public Criteria andIsChineseEqualTo(Boolean value) {
            addCriterion("is_chinese =", value, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseNotEqualTo(Boolean value) {
            addCriterion("is_chinese <>", value, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseGreaterThan(Boolean value) {
            addCriterion("is_chinese >", value, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_chinese >=", value, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseLessThan(Boolean value) {
            addCriterion("is_chinese <", value, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseLessThanOrEqualTo(Boolean value) {
            addCriterion("is_chinese <=", value, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseIn(List<Boolean> values) {
            addCriterion("is_chinese in", values, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseNotIn(List<Boolean> values) {
            addCriterion("is_chinese not in", values, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseBetween(Boolean value1, Boolean value2) {
            addCriterion("is_chinese between", value1, value2, "isChinese");
            return (Criteria) this;
        }

        public Criteria andIsChineseNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_chinese not between", value1, value2, "isChinese");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxIsNull() {
            addCriterion("speed_box is null");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxIsNotNull() {
            addCriterion("speed_box is not null");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxEqualTo(Integer value) {
            addCriterion("speed_box =", value, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxNotEqualTo(Integer value) {
            addCriterion("speed_box <>", value, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxGreaterThan(Integer value) {
            addCriterion("speed_box >", value, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxGreaterThanOrEqualTo(Integer value) {
            addCriterion("speed_box >=", value, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxLessThan(Integer value) {
            addCriterion("speed_box <", value, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxLessThanOrEqualTo(Integer value) {
            addCriterion("speed_box <=", value, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxIn(List<Integer> values) {
            addCriterion("speed_box in", values, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxNotIn(List<Integer> values) {
            addCriterion("speed_box not in", values, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxBetween(Integer value1, Integer value2) {
            addCriterion("speed_box between", value1, value2, "speedBox");
            return (Criteria) this;
        }

        public Criteria andSpeedBoxNotBetween(Integer value1, Integer value2) {
            addCriterion("speed_box not between", value1, value2, "speedBox");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
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

        public Criteria andStockIsNull() {
            addCriterion("stock is null");
            return (Criteria) this;
        }

        public Criteria andStockIsNotNull() {
            addCriterion("stock is not null");
            return (Criteria) this;
        }

        public Criteria andStockEqualTo(Integer value) {
            addCriterion("stock =", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotEqualTo(Integer value) {
            addCriterion("stock <>", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThan(Integer value) {
            addCriterion("stock >", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock >=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThan(Integer value) {
            addCriterion("stock <", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockLessThanOrEqualTo(Integer value) {
            addCriterion("stock <=", value, "stock");
            return (Criteria) this;
        }

        public Criteria andStockIn(List<Integer> values) {
            addCriterion("stock in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotIn(List<Integer> values) {
            addCriterion("stock not in", values, "stock");
            return (Criteria) this;
        }

        public Criteria andStockBetween(Integer value1, Integer value2) {
            addCriterion("stock between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andStockNotBetween(Integer value1, Integer value2) {
            addCriterion("stock not between", value1, value2, "stock");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable{

        /**
		 * 
		 */
		private static final long serialVersionUID = -2577336948374879739L;

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
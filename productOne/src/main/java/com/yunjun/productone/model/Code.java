package com.yunjun.productone.model;

import java.io.Serializable;
import java.util.Date;

public class Code implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.code
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Long code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.parentId
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Long parentid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.value
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private String value;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.order
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Integer order;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.desc
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.is_delete
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Integer isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.create_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.update_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column code.version
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Long version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table code
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.id
     *
     * @return the value of code.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.id
     *
     * @param id the value for code.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.code
     *
     * @return the value of code.code
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Long getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.code
     *
     * @param code the value for code.code
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setCode(Long code) {
        this.code = code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.parentId
     *
     * @return the value of code.parentId
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Long getParentid() {
        return parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.parentId
     *
     * @param parentid the value for code.parentId
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.value
     *
     * @return the value of code.value
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.value
     *
     * @param value the value for code.value
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.order
     *
     * @return the value of code.order
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.order
     *
     * @param order the value for code.order
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.desc
     *
     * @return the value of code.desc
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.desc
     *
     * @param desc the value for code.desc
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.is_delete
     *
     * @return the value of code.is_delete
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.is_delete
     *
     * @param isDelete the value for code.is_delete
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.create_date
     *
     * @return the value of code.create_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.create_date
     *
     * @param createDate the value for code.create_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.update_date
     *
     * @return the value of code.update_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.update_date
     *
     * @param updateDate the value for code.update_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column code.version
     *
     * @return the value of code.version
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Long getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column code.version
     *
     * @param version the value for code.version
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table code
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", parentid=").append(parentid);
        sb.append(", value=").append(value);
        sb.append(", order=").append(order);
        sb.append(", desc=").append(desc);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
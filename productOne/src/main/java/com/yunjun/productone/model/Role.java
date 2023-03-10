package com.yunjun.productone.model;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.role_name
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.desc
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.is_delete
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Integer isDelete;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.create_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.update_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role.version
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Long version;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table role
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.id
     *
     * @return the value of role.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.id
     *
     * @param id the value for role.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.role_name
     *
     * @return the value of role.role_name
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.role_name
     *
     * @param roleName the value for role.role_name
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.desc
     *
     * @return the value of role.desc
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.desc
     *
     * @param desc the value for role.desc
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.is_delete
     *
     * @return the value of role.is_delete
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.is_delete
     *
     * @param isDelete the value for role.is_delete
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.create_date
     *
     * @return the value of role.create_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.create_date
     *
     * @param createDate the value for role.create_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.update_date
     *
     * @return the value of role.update_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.update_date
     *
     * @param updateDate the value for role.update_date
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role.version
     *
     * @return the value of role.version
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Long getVersion() {
        return version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role.version
     *
     * @param version the value for role.version
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role
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
        sb.append(", roleName=").append(roleName);
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
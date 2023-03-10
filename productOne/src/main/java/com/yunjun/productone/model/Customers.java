package com.yunjun.productone.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Customers implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.Id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.name
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.age
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.address
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customers.salary
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private BigDecimal salary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customers
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.Id
     *
     * @return the value of customers.Id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.Id
     *
     * @param id the value for customers.Id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.name
     *
     * @return the value of customers.name
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.name
     *
     * @param name the value for customers.name
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.age
     *
     * @return the value of customers.age
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.age
     *
     * @param age the value for customers.age
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.address
     *
     * @return the value of customers.address
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.address
     *
     * @param address the value for customers.address
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customers.salary
     *
     * @return the value of customers.salary
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customers.salary
     *
     * @param salary the value for customers.salary
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customers
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
        sb.append(", name=").append(name);
        sb.append(", age=").append(age);
        sb.append(", address=").append(address);
        sb.append(", salary=").append(salary);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
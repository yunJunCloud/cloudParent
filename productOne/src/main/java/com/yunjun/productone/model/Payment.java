package com.yunjun.productone.model;

import java.io.Serializable;

public class Payment implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column payment.serial
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private String serial;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table payment
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payment.id
     *
     * @return the value of payment.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payment.id
     *
     * @param id the value for payment.id
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column payment.serial
     *
     * @return the value of payment.serial
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public String getSerial() {
        return serial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column payment.serial
     *
     * @param serial the value for payment.serial
     *
     * @mbg.generated Sun Feb 26 21:00:41 CST 2023
     */
    public void setSerial(String serial) {
        this.serial = serial;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table payment
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
        sb.append(", serial=").append(serial);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
package com.yunjun.cloudcommon.model;

import lombok.*;

import java.io.Serializable;

/**
 * @PACKAGE_NAME: com.yunjun.producttwo.model
 * @NAME: User
 * @USER: jack
 * @DATE: 2/28/2023
 * @PROJECT_NAME: cloudParent
 **/

@Data
@AllArgsConstructor
public class User implements Serializable {

    Integer id;

    String name;
}

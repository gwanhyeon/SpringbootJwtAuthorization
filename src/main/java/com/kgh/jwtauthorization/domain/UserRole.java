package com.kgh.jwtauthorization.domain;

import javax.persistence.Entity;


// 역할 지정
public enum UserRole{
    ROLE_NOT_PERMITTED, ROLE_USER, ROLE_MANAGER, ROLE_ADMIN
}

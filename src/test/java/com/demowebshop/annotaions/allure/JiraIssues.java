package com.demowebshop.annotaions.allure;

import com.demowebshop.annotaions.allure.JiraIssue;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface JiraIssues {
    JiraIssue[] value();
}
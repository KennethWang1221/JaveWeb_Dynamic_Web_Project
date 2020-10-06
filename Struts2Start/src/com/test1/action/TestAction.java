package com.test1.action;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
    public String add() {
        System.out.println("add........");
        return NONE;
    }

    public String update() {
        System.out.println("update.....");
        return NONE;
    }
}

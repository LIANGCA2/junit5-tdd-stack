package com.thoughtworks.tdd.controller;

import com.thoughtworks.tdd.Request;

public  interface Controllor {
    void setRequest(Request request);
     String process();
     void setPath(String path);
}

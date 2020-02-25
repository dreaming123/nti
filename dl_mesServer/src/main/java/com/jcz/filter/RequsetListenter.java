package com.jcz.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.util.Enumeration;

@WebListener

public class RequsetListenter implements ServletRequestListener {


    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {

    }
}

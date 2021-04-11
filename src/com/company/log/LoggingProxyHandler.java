package com.company.log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class LoggingProxyHandler<T> implements InvocationHandler {
    private T target;

    public LoggingProxyHandler(T target){
    this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Date date = new Date();
        System.out.println(date.getTime() +  "invoked method " + method.getName());
        return  method.invoke(target, args);
    }
}

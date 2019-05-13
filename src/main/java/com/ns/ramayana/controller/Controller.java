package com.ns.ramayana.controller;

public interface Controller<I,R>  {
    public R execute(I cmd);
}

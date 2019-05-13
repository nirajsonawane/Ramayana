package com.ns.ramayana.controller;

import com.ns.ramayana.view.BaseView;

public abstract class BaseController<G,T extends  BaseView> {

    abstract void setView(T t);

    abstract G execute();




}

package com.ns.ramayana.controller;

import com.ns.ramayana.domain.game.Player;

public interface Controller<I,R>  {
    public R execute(I cmd);
}

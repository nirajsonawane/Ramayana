package com.ns.ramayana.util;

import java.util.concurrent.ThreadLocalRandom;

public class RamayanaUtil {

    public static Long getRandomGameId(){
       return ThreadLocalRandom
                .current().nextLong(10000);
    }
}

package com.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomGenerator {
    public static int nextInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static double nextDouble(double min, double max){
        return ThreadLocalRandom.current().nextDouble(min,max);
    }
    public static boolean chance(double percent){
        return ThreadLocalRandom.current().nextDouble(0, 100) < percent;
    }
}

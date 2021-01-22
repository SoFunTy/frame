package com.cn.frame.common.util;

import java.util.Random;

/**
 * Create By SoFunTy
 * 2020/11/18  9:54
 */
public class IdWorkerUtil {
    private static final int LENGTH = 16;

    private static final IdWorker IDWORKER = new IdWorker(new Random().nextInt(LENGTH));

    public static long getLongId() {
        return IDWORKER.nextId();
    }

    public static String getStringId() {
        return String.valueOf(IDWORKER.nextId());
    }

    public static String getStringId(int length) {
        String id = String.valueOf(IDWORKER.nextId()).substring(LENGTH - length, 16);
        if (id.startsWith("0")) {
            id = id.replaceFirst("0", "1");
        }

        return id;
    }
}

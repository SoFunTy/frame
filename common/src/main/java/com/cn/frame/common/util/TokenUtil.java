package com.cn.frame.common.util;

/**
 * Create By SoFunTy
 * 2020/11/16  12:56
 */
public class TokenUtil {

    private static String AESKEY = "uhgdyjnckisoaltdkseqsr";

    /**
     * TODO：Create Token
     * @return
     */
    public static String createToken(Integer memberId){
        String str = "";
        for (int i = 0; i < 6; i++) {
            str += Math.random() * 10;
        }
        str += "_" + "76" + "_" + memberId;
        return AESUtil.encrypt(str, AESKEY);
    }

}

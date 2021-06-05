/**
 * Author: 老洋
 * Date:  2021/6/5 19:45
 */
package com.yyy.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String code(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");

            for(int offset = 0; offset < byteDigest.length; offset++){
                i = byteDigest[offset];
                if(i < 0)
                    i += 256;

                if(i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }

            return buf.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
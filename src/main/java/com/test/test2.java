package com.test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class test2 {

    private static byte[] initKey() throws Exception {                             //获取密钥
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey.getEncoded();
    }

    public static byte[] encryptDES(byte[] key, byte[] data) throws Exception {       //加密方法
        SecretKey secretKey = new SecretKeySpec(key, "des");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] resultBytes = cipher.doFinal(data);
        return resultBytes;
    }

    public static String decryptDES(byte[] key, byte[] data) throws Exception {      //解密方法
        SecretKey secretKey = new SecretKeySpec(key, "DES");
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] resultBytes = cipher.doFinal(data);
        return new String(resultBytes);
    }

    public static String bytesToHexString(byte[] src) {    //将byte[]转化为16进制字符串
        StringBuilder stringBuilder = new StringBuilder("");   //将byte转换成int，然后利用Integer.toHexString(int)
        if (src == null || src.length <= 0) {                  //@param src byte[] data ；@return hex string
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {         //测试
        // TODO code application logic here
        String data = "renjiaqinggasdhfasdfhjgkasdfkasdfasdkfgkasdfsadgfsdkjasdfjlsahdfdlsajkfhs";
        byte[] key = initKey();
        byte[] resultBytes = encryptDES(key, data.getBytes());
        String resultEncrypt = bytesToHexString(resultBytes);
        System.out.println("加密：" + resultEncrypt);
        String resultDecrypt = decryptDES(key, resultBytes);
        System.out.println("解密：" + resultDecrypt);
    }
}

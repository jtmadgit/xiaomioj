package com;

import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class SSOEnDeUtil
{
  public static String SSO_BASE64_KEY = "TIPb64SSOkey";
  public static final String CHARSET_NAME = "UTF-8";

  public static String deBase64XorString(String str, String key)
    throws UnsupportedEncodingException
  {
    String r4 = getFromBase64(str);
    byte[] r5 = xorWithKey(r4.getBytes(), key.getBytes());
    String str5 = new String(r5, "utf-8");
    String r6 = getFromBase64(str5);
    return r6;
  }

  public static byte[] xorWithKey(byte[] a, byte[] key) {
    byte[] out = new byte[a.length];
    for (int i = 0; i < a.length; i++) {
      out[i] = (byte)(a[i] ^ key[(i % key.length)]);
    }
    return out;
  }

  public static String getFromBase64(String s)
  {
    byte[] b = null;
    String result = null;
    if (s != null) {
      BASE64Decoder decoder = new BASE64Decoder();
      try {
        b = decoder.decodeBuffer(s);
        result = new String(b, "utf-8");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  public static String getBase64(String str)
  {
    byte[] b = null;
    String s = null;
    try {
      b = str.getBytes("utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    if (b != null) {
      s = new BASE64Encoder().encode(b);
    }
    return s;
  }
  
    /**
     * demo-解密
     *
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        // 第一个参数是加密后密码, 第二个参数是秘钥
        String pwd = SSOEnDeUtil.deBase64XorString("HCw3RQAcHAwwRjlCfWBsTg==", "xdesertghutr3456dr46789jhygfdrse");
        
        //[sbms] HSMrGgEfLgkwRjlDfGB0Tg==       xdesertghutr3456dr46789jhygfdrse
        pwd = SSOEnDeUtil.deBase64XorString("HSM3HgQ6HAwwRjkLfnBeTg==", "xdesertghutr3456dr46789jhygfdrse");
        System.out.println(pwd);
    }
}
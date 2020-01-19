package cn.lianhy.demo.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class GenPasswordUtils {
    public static String getPwd(){
        SimpleHash hash=new SimpleHash("MD5","123456",ByteSource.Util.bytes("admin"),2);
        return hash.toString();
    }
}

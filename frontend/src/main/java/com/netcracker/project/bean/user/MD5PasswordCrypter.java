package com.netcracker.project.bean.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5PasswordCrypter {

    public String crypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passBytes = password.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            // TODO: 02.12.2017 log
            throw new RuntimeException("Runtime exception. No such algorithm to crypt password.");
//            Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

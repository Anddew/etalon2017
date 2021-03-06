package com.netcracker.project.security.impl;

import com.netcracker.project.security.Encrypter;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class MD5Encrypter implements Encrypter {

    private Logger logger = Logger.getLogger(MD5Encrypter.class);

    private static final String CRYPT_ALGORITHM = "MD5";
    private static final String NO_SUCH_CRYPT_ALGORITHM_ERROR_MESSAGE = "Runtime exception. No such algorithm to crypt password - ";


    @Override
    public String encrypt(String target) {
        try {
            MessageDigest crypter = MessageDigest.getInstance(CRYPT_ALGORITHM);
            byte[] passwordBytes = crypter.digest(target.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < passwordBytes.length; ++i) {
                sb.append(Integer.toHexString((passwordBytes[i] & 0xFF) | 0x100).substring(1,3));
            }
            logger.debug("Password was successfully encrypted.");
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.warn("No such password encryption algorithm found - '" + CRYPT_ALGORITHM +",.");
            throw new RuntimeException(NO_SUCH_CRYPT_ALGORITHM_ERROR_MESSAGE + CRYPT_ALGORITHM, e);
        }
    }

}

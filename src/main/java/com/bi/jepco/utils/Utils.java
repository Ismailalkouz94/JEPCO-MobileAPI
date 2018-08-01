package com.bi.jepco.utils;

import com.bi.jepco.controller.SmsVerificationController;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.apache.log4j.Logger;

import java.security.SecureRandom;
import java.util.Random;

public class Utils {

    private static final Logger logger = Logger.getLogger(Utils.class);


    public static String randomNumber(int length) {

        char[] characterSet = "0123456789".toCharArray();

        Random random = new SecureRandom();

        char[] result = new char[length];

        for (int i = 0; i < result.length; i++) {
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return new String(result);
    }

    public static String formatE164(String countryCode, String number) {
        try {
            PhoneNumberUtil util     = PhoneNumberUtil.getInstance();
            int parsedCountryCode    = Integer.parseInt(countryCode);
            Phonenumber.PhoneNumber parsedNumber = util.parse(number,
                    util.getRegionCodeForCountryCode(parsedCountryCode));

            return util.format(parsedNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
        } catch (NumberParseException | NumberFormatException npe) {
            logger.debug("Exception", npe);
        }

        return "+"                                                     +
                countryCode.replaceAll("[^0-9]", "").replaceAll("^0*", "") +
                number.replaceAll("[^0-9]", "");
    }
}

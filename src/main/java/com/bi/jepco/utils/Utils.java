package com.bi.jepco.utils;

import com.bi.jepco.entities.CustomerSubAccount;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Random;

public class Utils {


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

            boolean validationFlag = PhoneNumberUtil.getInstance().isValidNumber(parsedNumber);

            if(!validationFlag){
                throw new Exception();
            }
            return util.format(parsedNumber, PhoneNumberUtil.PhoneNumberFormat.E164);
        } catch (Exception ex) {
            return "0";
        }
    }


    public static CustomerSubAccount initFileNumberTokens(CustomerSubAccount customerSubAccount){

        String fileNumber = customerSubAccount.getFileNumber();

        customerSubAccount.getCustomerSubInfoPK().setCity(Integer.parseInt(fileNumber.substring(0,2)));
        customerSubAccount.getCustomerSubInfoPK().setRound(Integer.parseInt(fileNumber.substring(2 , 3)));
        customerSubAccount.getCustomerSubInfoPK().setDept(Integer.parseInt(fileNumber.substring(3,5)));
        customerSubAccount.getCustomerSubInfoPK().setColl(Integer.parseInt(fileNumber.substring(5 , 7)));
        customerSubAccount.getCustomerSubInfoPK().setCons(Integer.parseInt(fileNumber.substring( 7)));

        return customerSubAccount;
    }

    public static boolean validateNationalNumber(String nationalNumber){

        if(nationalNumber.length() != 10){
            return false;
        }

        String birthYear = nationalNumber.substring(0,3);

        switch (birthYear){
            case "200":
                return true;
            case "500":
                return true;
            case "900":
                return true;
            default:
                int year = Integer.parseInt(birthYear);
                if( (year < 940) || (year >999)) {
                    return false;
                }
                int gender = Integer.parseInt(nationalNumber.substring(3,4));
                if( (gender != 0) && (gender != 1)){
                    return false;
                }
                int constant = Integer.parseInt(nationalNumber.substring(4,5));
                if(constant != 0){
                    return false;
                }
                return true;
        }

    }


    public static int sendSms(String msg, String mobileNumber) throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("http://corporatesms.jo.zain.com/http/send_sms_http.php?login_name=jepco&login_password=Jj@123456&msg="+(msg)+"&mobile_number="+mobileNumber+"&from=JEPCO&charset=UTF-8&unicode=0")
                .get()
                .addHeader("cache-control", "no-cache")
                .addHeader("charset", "UTF-8")
                .build();

        Response response = client.newCall(request).execute();

        return response.code();
    }

}

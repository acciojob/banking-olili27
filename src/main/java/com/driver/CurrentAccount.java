package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name, balance, 5000);

        this.tradeLicenseId = tradeLicenseId;

        if (balance < 5000) throw new Exception("Insufficient Balance");

    }

    public void validateLicenseId() throws Exception {
       if (!isNumberValid(tradeLicenseId)) {

           String reArrangedId = reArrangeString(tradeLicenseId);
           if (reArrangedId.equals("")) {
               throw new Exception("Valid License can not be generated");
           }
           else {
                tradeLicenseId = reArrangedId;
           }
       }
    }

    public String reArrangeString(String str) {
        int n = str.length();

        int [] count = new int[26];

        for (char ch: str.toCharArray()) {
            count[ch - 'A']++;
        }

        char mostFreqChar = findMostFreq(count);
        int highestFreq = count[mostFreqChar - 'A'];

        if (n % 2 == 0) {
            if (highestFreq > (n / 2) + 1) {
                return  "";
            }
        } else {
            if (highestFreq > (n / 2) + 2) {
                return  "";
            }
        }

        char [] ans = new char[n];

        int index;

        // fill the most frequent character
        for (index = 0; index < n; index += 2) {
            if (count[mostFreqChar - 'A'] > 0) {
                ans[index] = mostFreqChar;
                count[mostFreqChar - 'A']--;
            }
            else break;
        }

        // fill the remaining characters
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);

            while (count[ch - 'A'] > 0) {
                if (index >= n) {
                    index = 1;
                }

                ans[index] = ch;
                index += 2;
                count[ch - 'A']--;
            }
        }

        return ans.toString();
    }

    public char findMostFreq(int [] arr) {
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = i;
        }

        return (char) ('A' + max);
    }

    public boolean isNumberValid(String licenseId) {
        for (int i =0; i < licenseId.length() - 1; i++) {
            if (licenseId.charAt(i) == licenseId.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

}

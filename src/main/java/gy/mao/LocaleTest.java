package gy.mao;

import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale t : locales) {
            System.out.println(t.getCountry()+"|"
                    +t.getDisplayCountry()+"|"
                    +t.getDisplayLanguage()+"|"
                    +t.getDisplayName()+"|"
                    +t.getDisplayVariant()+"|"
                    +t.getISO3Language()+"|"
                    +t.getLanguage()+"|"
                    +t.getVariant());
        }
    }
}

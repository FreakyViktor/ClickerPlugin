package org.stjernemix.clickerplugin.util;

import net.md_5.bungee.api.ChatColor;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class StringUtil {

    // THANKS TO "https://github.com/DoodieDev" for the String Utility.
    private final static NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.GERMANY);

    static {
        numberFormat.setMaximumFractionDigits(5);
    }

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String formatNum(double input) {
        return numberFormat.format(input);
    }

    public static String formatNum(BigDecimal input) {
        return numberFormat.format(input);
    }
}

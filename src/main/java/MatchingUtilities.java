import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingUtilities {

    public void matchSymbols(String txt){
        Pattern matchSymbols = Pattern.compile("[(:@^*%)]");
        Matcher matchSymbolMatcher = matchSymbols.matcher(txt);
    }

    public static long matchMilkOccu(String txt){
        Pattern p = Pattern.compile("(?i)(m..k\\Wprice:\\d)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchMilkPrice123(String txt){
        Pattern p = Pattern.compile("(?i)(m..k\\Wprice:1.23)");
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchBreadPrice123(String txt){
        Pattern p = Pattern.compile("(?i)(b...d\\Wprice:1.23)");
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchMilkPrice323(String txt){
        Pattern p = Pattern.compile("(?i)(m..k\\Wprice:3.23)");
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchCookiesPrice(String txt){
        Pattern p = Pattern.compile("(?i)(c.....s\\Wprice:2.25)");
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchApplesPrice25(String txt){
        Pattern p = Pattern.compile("(?i)(a....s\\Wprice:0.25)");
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchApplesPrice23(String txt){
        Pattern p = Pattern.compile("(?i)(a....s\\Wprice:0.23)");
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchApplesOccu(String txt){
        Pattern p = Pattern.compile("(?i)(a....s)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchCookiesOccu(String txt){
        Pattern p = Pattern.compile("(?i)(c.....s)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchBreadOccu(String txt){
        Pattern p = Pattern.compile("(?i)(b...d)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchItemWithoutPrice(String txt){
        Pattern p = Pattern.compile("(?i)(\\Wprice:\\D)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(txt);
        return m.results().count();
    }

    public static long matchItemWithoutName(String txt){
        Pattern p = Pattern.compile("(?i)(\\Wname:\\W)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(txt);
        return m.results().count();
    }
}

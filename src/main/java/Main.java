import org.apache.commons.io.IOUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        System.out.printf("name:\tMilk \t\t seen: %d times\n", MatchingUtilities.matchMilkOccu(output));
        System.out.println("============= \t \t =============");
        System.out.printf("Price: \t 3.23\t\t seen: %d times\n", MatchingUtilities.matchMilkPrice323(output));
        System.out.println("-------------\t\t -------------");
        System.out.printf("Price:   1.23\t\t seen: %d time\n", MatchingUtilities.matchMilkPrice123(output));
        System.out.printf("\nname:   Bread\t\t seen: %d times\n", MatchingUtilities.matchBreadOccu(output));
        System.out.println("=============\t\t =============");
        System.out.printf("Price:   1.23\t\t seen: %d times\n", MatchingUtilities.matchBreadPrice123(output));
        System.out.println("-------------\t\t -------------\n");
        System.out.printf("name: Cookies     \t seen: %d times\n", MatchingUtilities.matchCookiesOccu(output));
        System.out.println("============= \t \t =============");
        System.out.printf("Price:   2.25        seen: %d times\n", MatchingUtilities.matchCookiesPrice(output));
        System.out.println("-------------\t\t -------------\n");
        System.out.printf("name:  Apples     \t seen: %d times\n", MatchingUtilities.matchApplesOccu(output));
        System.out.println("============= \t \t =============");
        System.out.printf("Price:   0.25     \t seen: %d times\n", MatchingUtilities.matchApplesPrice25(output));
        System.out.println("-------------\t\t -------------");
        System.out.printf("Price:   0.23  \t \t seen: %d times\n", MatchingUtilities.matchApplesPrice23(output));
        System.out.printf("\nErrors         \t \t seen: %d times", MatchingUtilities.matchItemWithoutPrice(output) + MatchingUtilities.matchItemWithoutName(output));
    }
}

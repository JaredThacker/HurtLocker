import org.apache.commons.io.IOUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

   public static HashMap<String, String> leetSpeakMap = new HashMap<>(Map.of("0", "o", "1", "i", "3", "e", "5", "s", "7", "t"));

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();

        HashMap<String, HashMap<Float, Integer>> groceryList = new LinkedHashMap<>();

        String[] items = output.split("##");
        int exceptionCount = 0;
        for (String eachItem : items) {
            try {
                String[] parts = eachItem.split(";");
                String name = parts[0].chars().mapToObj(e -> {
                    String parsedCharacter = String.valueOf(Character.valueOf((char)e));
                    return leetSpeakMap.getOrDefault(parsedCharacter, parsedCharacter);
                }).collect(Collectors.joining()).substring(parts[0].indexOf(":") + 1).toLowerCase();
                Float parsedPrice = Float.parseFloat(parts[1].substring(parts[1].indexOf(":") + 1));

                if (name.isEmpty()) {
                    throw new Exception("!!JERKSON ERROR DETECTED!!: NAME INVALID");
                }

                if (groceryList.containsKey(name)) {
                    if (groceryList.get(name).containsKey(parsedPrice)) {
                        groceryList.get(name).put(parsedPrice, groceryList.get(name).get(parsedPrice) + 1);
                        groceryList.put(name, groceryList.get(name));
                    } else {
                        groceryList.get(name).put(parsedPrice, 1);
                    }
                } else {
                    groceryList.put(name, new HashMap<>(Map.of(parsedPrice, 1)));
                }
            } catch (Exception exception) {
                exceptionCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String eachKey : groceryList.keySet()) {
            long sumOccurrences = groceryList.get(eachKey).values().stream().mapToInt(e -> e).sum();
            sb.append(String.format("name: %7s\t\t seen: %d times\n", eachKey.substring(0,1).toUpperCase() + eachKey.substring(1).toLowerCase(), sumOccurrences)).append("============= \t \t =============\n"); ;
            for (Float eachPrice : groceryList.get(eachKey).keySet()) {
                sb.append(String.format("Price: \t %.2f\t\t seen: %d times\n", eachPrice, groceryList.get(eachKey).get(eachPrice))).append("-------------\t\t -------------\n");
            }
            sb.append("\n");
        }
        sb.append(String.format("Errors         \t \t seen: %d times", exceptionCount));
        System.out.println(sb);
    }
}

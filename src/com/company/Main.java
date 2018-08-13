package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("C:\\IdeaProjects\\Task6\\src\\com\\company\\File"));
        String string = in.nextLine();
        String[] words = string.split("\\s+");
        HashMap<String, Integer> wordToCount = new HashMap<String, Integer>();
        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        List<String> mapValues = new ArrayList<String>(wordToCount.keySet());
        Collections.sort(mapValues);
        System.out.println("Отсортированный список:");
        for (String sortWords: mapValues)
            System.out.println(sortWords);

        System.out.println("Статистика повторений:");
        for (String word : wordToCount.keySet()) {
            System.out.println(word + " " + wordToCount.get(word));
        }

        HashMap.Entry <String, Integer> maxEntry = null;
        for (HashMap.Entry<String, Integer> entry : wordToCount.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println("Слово с максимальным количеством повторений = количество повторений:");
        System.out.println(maxEntry);

    }
}
package JCDZ4;


import java.util.*;

public class SetOfWorlds {
    public static void main (String[] args) {
        String [] words = {"cat", "dog", "parrot", "cat", "sheep", "cow", "horse", "cat", "mouse", "dog", "goose",
        "cat", "duck", "parrot", "sheep", "cow", "donkey", "goose", "hen", "goat"};
        Set<String> unique = new HashSet<>(Arrays.asList(words));
        System.out.println(unique);

        Map<String, Integer> setOfWord = new HashMap<>();
        for (String word : words) {
            setOfWord.put(word, setOfWord.getOrDefault(word, 0) + 1);
        }
        System.out.println(setOfWord);

    }
}

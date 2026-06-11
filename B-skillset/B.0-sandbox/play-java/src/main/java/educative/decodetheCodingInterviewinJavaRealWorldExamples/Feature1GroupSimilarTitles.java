package educative.decodetheCodingInterviewinJavaRealWorldExamples;

import java.util.*;

/**
 * https://www.educative.io/courses/decode-coding-interview-java/feature-1-group-similar-titles
 * <p>
 * Feature #1: Group Similar Titles
 * Explore how to group similar titles using frequency vectors in Java to handle misspelled searches. Understand how to precompute and map anagrams with hash maps for efficient retrieval, improving search accuracy and performance.
 * <p>
 * Description
 * First, we need to figure out a way to individually group all the character combinations of each title. Suppose the content library contains the following titles: "duel", "dule", "speed", "spede", "deul", "cars". How would you efficiently implement a functionality so that if a user misspells speed as spede, they are shown the correct title?
 * <p>
 * We want to split the list of titles into sets of words so that all words in a set are anagrams. In the above list, there are three sets: {"duel", "dule", "deul"}, {"speed", "spede"}, and {"cars"}. Search results should comprise all members of the set that the search string is found in. We should pre-compute these sets instead of forming them when the user searches a title.
 * <p>
 * Here is an illustration of this process:
 * ["duel", "dule", "speed", "spede", "deul", "cars"]
 * <p>
 * [["duel", "dule", "deul"], ["speed", "spede"], ["cars"]]
 * set 1                   set 2          set3
 * <p>
 * Solution
 * From the above description, we see that all members of each set are characterized by the same frequency of each alphabet. This means that the frequency of each alphabet in words belonging to the same group is equal. In the set {{"speed", "spede"}}, the frequency of the characters s, p, e, and d are the same in each word.
 * <p>
 * Let’s see how we might implement this functionality:
 * <p>
 * For each title, compute a 26-element vector. Each element in this vector represents the frequency of an English letter in the corresponding title. This frequency count will be represented as a string delimited with # characters. For example, abbccc will be represented as #1#2#3#0#0#0...#0. This mapping will generate identical vectors for strings that are anagrams.
 * <p>
 * Use this vector as a key to insert the titles into a Hash Map. All anagrams will be mapped to the same entry in this Hash Map. When a user searches a word, compute the 26-element English letter frequency vector based on the word. Search in the Hash Map using this vector and return all the map entries.
 * <p>
 * Store the vector of the calculated character counts in the same Hash Map as a key and assign the respective set of anagrams as its value.
 * <p>
 * Return the values of the Hash Map, since each value will be an individual set.
 * <p>
 * Let’s look at the following illustration to clarify this process:
 * <p>
 * 26 int vals          similar grpd strs
 * { #2#1#1#0#0 ..... #0 : [abac, aabc, abac, caab] }
 * <p>
 * The left list represents the count of each character from a-z that appears in the words on the right
 */
public class Feature1GroupSimilarTitles {

    /**
     *
     * @param strs  array of titles in string
     * @return      [[]] a list of a list of strings
     */
    public static List<List<String>> groupTitles(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> res = new HashMap<String, List<String>>();

        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0); // sets all elements of count array to 0
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                count[index]++;
            }
//            System.out.println(Arrays.toString(count));

            StringBuilder delimStr = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                delimStr.append('#');
                delimStr.append(count[i]);
            }

            String key = delimStr.toString();
            if (!res.containsKey(key))
                res.put(key, new ArrayList<String>());

            res.get(key).add(s);
        }

        return new ArrayList<List<String>>(res.values());
    }

    public static void main(String[] args) {
        // Driver code
        String titles[] = {"duel", "dule", "speed", "spede", "deul", "cars"}; // edge case: "SPEED", throws index -14 out of bounds for lenght 26

        List<List<String>> gt = groupTitles(titles);

        String query = "spede";

        // Searching for all titles
        for (List<String> g : gt) {
            if (g.contains(query))
                System.out.println(g);
        }
    }
}

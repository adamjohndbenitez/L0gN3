package amazon.sdeii.q1;

import java.util.ArrayList;
import java.util.List;

// TODO: aj - bring all cases here and make a junit tests of it all.
// TODO: aj - Study more on greedy algorithm

public class CodeQuestion1Solution {
    /*
     * Complete the 'getHeaviestPackage' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_ARRAY packageWeights as parameter.
     */
    public static long getHeaviestPackage(List<Integer> packageWeights) {
        // Write your code here
        int n = packageWeights.size();

        long current = packageWeights.get(n - 1);
        long best = current;

        for (int i = n - 2; i >= 0; i--) {
            if (packageWeights.get(i) < current) {
                current += packageWeights.get(i);
            } else {
                current = packageWeights.get(i);
            }
            best = Math.max(best, current);
        }

        return best;
    }

    public static void main(String[] args) {
        long output = getHeaviestPackage(
                new ArrayList<>(
                        List.of(2, 9, 10, 3, 7)
                )
        );
        System.out.println(output);
    }
}

// Below code is the original:
//    import java.io.*;
//    import java.util.*;
//    import java.util.stream.*;
//
//    class Result {
//
//        /*
//         * Complete the 'getHeaviestPackage' function below.
//         *
//         * The function is expected to return a LONG_INTEGER.
//         * The function accepts INTEGER_ARRAY packageWeights as parameter.
//         */
//        public static long getHeaviestPackage(List<Integer> packageWeights) {
//            // Write your code here
//        }
//    }
//
//    public class Solution {
//        public static void main(String[] args) throws IOException {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//            int packageWeightsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//            List<Integer> packageWeights = IntStream.range(0, packageWeightsCount)
//                    .mapToObj(i -> {
//                        try {
//                            return bufferedReader.readLine().replaceAll("\\s+$", "");
//                        } catch (IOException ex) {
//                            throw new RuntimeException(ex);
//                        }
//                    })
//                    .map(String::trim)
//                    .map(Integer::parseInt)
//                    .collect(Collectors.toList());
//
//            long result = Result.getHeaviestPackage(packageWeights);
//
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
//
//            bufferedReader.close();
//            bufferedWriter.close();
//        }
//    }

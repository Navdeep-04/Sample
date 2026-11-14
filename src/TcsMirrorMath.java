import java.util.*;
public class TcsMirrorMath {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Mirror map
            Map<Integer, int[]> mirrorMap = new HashMap<>();
            mirrorMap.put(0, new int[]{0, 0, 0});
            mirrorMap.put(1, new int[]{1, 1, 1});
            mirrorMap.put(2, new int[]{5, 5, 2});
            mirrorMap.put(3, new int[]{-1, 3, 3});   // None -> -1
            mirrorMap.put(4, new int[]{-1, -1, 4});
            mirrorMap.put(5, new int[]{2, 2, 5});
            mirrorMap.put(6, new int[]{-1, -1, 6});
            mirrorMap.put(7, new int[]{-1, -1, 7});
            mirrorMap.put(8, new int[]{8, 8, 8});
            mirrorMap.put(9, new int[]{-1, -1, 9});

            // Input values
            String num = sc.nextLine().trim();
            String dirs = sc.nextLine().trim().toUpperCase();

            // Direction index mapping
            Map<Character, Integer> dirIndex = new HashMap<>();
            dirIndex.put('L', 0);
            dirIndex.put('R', 0);
            dirIndex.put('U', 1);
            dirIndex.put('D', 1);
            dirIndex.put('S', 2);

            // Validate lengths
            if (num.length() != dirs.length()) {
                sc.close();
                return;
            }

            // Result list
            List<Integer> result = new ArrayList<>();

            // Process each character
            for (int i = 0; i < num.length(); i++) {
                int digit = Character.getNumericValue(num.charAt(i));
                char dir = dirs.charAt(i);

                int index = dirIndex.get(dir);
                int mirrored = mirrorMap.get(digit)[index];

                // Skip invalid
                if (mirrored != -1) {
                    result.add(mirrored);
                }
            }

            // Handle empty or all zeros
            if (result.isEmpty() || result.stream().allMatch(x -> x == 0)) {
                System.out.println(0);
                sc.close();
                return;
            }

            // Separate zeros and non-zeros
            List<Integer> zeros = new ArrayList<>();
            List<Integer> nonZeros = new ArrayList<>();

            for (int x : result) {
                if (x == 0) zeros.add(x);
                else nonZeros.add(x);
            }

            Collections.sort(nonZeros);

            // Build final result: first non-zero, then zeros, then remaining non-zeros
            List<Integer> finalResult = new ArrayList<>();
            finalResult.add(nonZeros.get(0));
            finalResult.addAll(zeros);
            for (int i = 1; i < nonZeros.size(); i++) {
                finalResult.add(nonZeros.get(i));
            }

            // Convert to integer and print (remove leading zeros)
            StringBuilder sb = new StringBuilder();
            for (int val : finalResult) {
                sb.append(val);
            }
            System.out.print(Integer.parseInt(sb.toString()));

            sc.close();
        }
    }


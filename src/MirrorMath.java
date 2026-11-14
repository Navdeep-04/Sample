import java.util.*;

public class MirrorMath {

    // Build and return the mirror map
    static Map<Integer, int[]> createMirrorMap() {
        Map<Integer, int[]> mirrorMap = new HashMap<>();
        mirrorMap.put(0, new int[]{0, 0, 0});
        mirrorMap.put(1, new int[]{1, 1, 1});
        mirrorMap.put(2, new int[]{5, 5, 2});
        mirrorMap.put(3, new int[]{-1, 3, 3});  // -1 means no valid mirror
        mirrorMap.put(4, new int[]{-1, -1, 4});
        mirrorMap.put(5, new int[]{2, 2, 5});
        mirrorMap.put(6, new int[]{-1, -1, 6});
        mirrorMap.put(7, new int[]{-1, -1, 7});
        mirrorMap.put(8, new int[]{8, 8, 8});
        mirrorMap.put(9, new int[]{-1, -1, 9});
        return mirrorMap;
    }

    // Build direction index mapping
    static Map<Character, Integer> createDirectionMap() {
        Map<Character, Integer> dirMap = new HashMap<>();
        dirMap.put('L', 0);
        dirMap.put('R', 0);
        dirMap.put('U', 1);
        dirMap.put('D', 1);
        dirMap.put('S', 2);
        return dirMap;
    }

    // Convert number based on direction using for-each loop
    static List<Integer> processDigits(String num, String dirs, Map<Integer, int[]> mirrorMap, Map<Character, Integer> dirIndex) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < num.length(); i++) {
            int digit = Character.getNumericValue(num.charAt(i));
            char dir = Character.toUpperCase(dirs.charAt(i));

            if (!dirIndex.containsKey(dir)) continue;

            int index = dirIndex.get(dir);
            int mirrored = mirrorMap.get(digit)[index];

            if (mirrored != -1) result.add(mirrored);
        }
        return result;
    }

    // Filter and arrange the digits
    static List<Integer> rearrangeDigits(List<Integer> result) {
        if (result.isEmpty() || result.stream().allMatch(x -> x == 0)) {
            return Collections.singletonList(0);
        }

        List<Integer> zeros = new ArrayList<>();
        List<Integer> nonZeros = new ArrayList<>();

        // Using enhanced for loop
        for (int val : result) {
            if (val == 0) zeros.add(val);
            else nonZeros.add(val);
        }

        Collections.sort(nonZeros);

        // New list: smallest non-zero first, then zeros, then rest
        List<Integer> finalResult = new ArrayList<>();
        finalResult.add(nonZeros.get(0));
        finalResult.addAll(zeros);
        for (int i = 1; i < nonZeros.size(); i++) {
            finalResult.add(nonZeros.get(i));
        }
        return finalResult;
    }

    // Convert list to integer string
    static String listToNumber(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int val : list) sb.append(val);
        return String.valueOf(Integer.parseInt(sb.toString())); // remove leading zeros
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input number and directions
        String num = sc.nextLine().trim();
        String dirs = sc.nextLine().trim();
        // Validate length
        if (num.length() != dirs.length()) {
            sc.close();
            return;
        }

        // Initialize maps
        Map<Integer, int[]> mirrorMap = createMirrorMap();
        Map<Character, Integer> dirIndex = createDirectionMap();

        // Process digits
        List<Integer> mirroredDigits = processDigits(num, dirs, mirrorMap, dirIndex);

        // Rearrange and form final result
        List<Integer> finalDigits = rearrangeDigits(mirroredDigits);

        // Output result using while loop
        StringBuilder output = new StringBuilder();
        int idx = 0;
        while (idx < finalDigits.size()) {
            output.append(finalDigits.get(idx));
            idx++;
        }

        System.out.print(Integer.parseInt(output.toString()));
        sc.close();
    }
}

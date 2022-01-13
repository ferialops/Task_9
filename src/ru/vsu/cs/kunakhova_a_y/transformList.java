package ru.vsu.cs.kunakhova_a_y;

import java.util.ArrayList;
import java.util.List;

public class transformList {
    public static List<Integer> uniq(List<Integer> input) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {

            if (indexOf(output, input.get(i)) == -1) {
                output.add(input.get(i));
            }
        }
        return output;
    }

    public static int indexOf(List<Integer> output, int value) {
        int index = -1;
        for (int j = 0; j < output.size(); j++) {
            if (output.get(j) == value) {
                index = j;
            }
        }
        return index;
    }
}

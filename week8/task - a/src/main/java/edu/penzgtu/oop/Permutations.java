package edu.penzgtu.oop;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> perms(List<Integer> data) {
        if (data.isEmpty()) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> element = new ArrayList<>();

        generate(result, element, data, 0);

        return result;
    }

    private static void generate(List<List<Integer>> result, List<Integer> element, List<Integer> data, int number){
        if(number == data.size()){
            result.add(element);
            return;
        }

        for(int i = 0; i <= element.size(); i++){
            List<Integer> temp = new ArrayList<>(element);
            temp.add(i, data.get(number));
            generate(result, temp, data, number + 1);
        }
    }
}

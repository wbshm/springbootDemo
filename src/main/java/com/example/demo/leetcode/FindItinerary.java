package com.example.demo.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName FindItinerary
 * @Description TODO
 * @Author wangrq
 * @Date 2020/8/27 9:07
 */
public class FindItinerary {

    HashMap<String, ArrayList<String>> journey;
    LinkedList<HashMap<String, ArrayList<String>>> properlyMap = new LinkedList<>();
    LinkedList<ArrayList<String>> properlyList = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        journey = new HashMap<>(tickets.size());
        String val, key;
        for (List<String> ticket : tickets) {
            val = ticket.get(1);
            key = ticket.get(0);
            ArrayList<String> strings = journey.get(key);
            if (Objects.isNull(strings)) {
                strings = new ArrayList<>();
                strings.add(val);
            } else {
                strings.add(val);
                Collections.sort(strings);
            }
            journey.put(key, strings);
        }
        ArrayList<String> res = new ArrayList<>();
        String start = "JFK";
        res.add(start);
        List<String> doit = doit(res, journey, start);
        List<String> tmp;
        while (!properlyList.isEmpty()) {
            ArrayList<String> list = properlyList.pop();
            HashMap<String, ArrayList<String>> map = properlyMap.pop();
            start = list.get(list.size() - 1);
            tmp = doit(list, map, start);
            if (tmp == null) {
                continue;
            }
            System.out.println(tmp);
            if (doit == null) {
                doit = tmp;
                continue;
            }
            for (int i = 0; i < tmp.size(); i++) {
                if (tmp.get(i).compareTo(doit.get(i)) != 0) {
                    doit = tmp.get(i).compareTo(doit.get(i)) > 0 ? doit : tmp;
                    break;
                }
            }
        }
        System.out.println(doit);
        return doit;
    }

    public List<String> doit(ArrayList<String> res, HashMap<String, ArrayList<String>> map, String start) {
        HashMap<String, ArrayList<String>> copy = new HashMap<>(map);
        while (!map.isEmpty()) {
            ArrayList<String> list = map.get(start);
            if (Objects.isNull(list)) {
                return null;
            }
            Collections.sort(list);
            if (list.size() == 1) {
                map.remove(start);
                start = list.get(0);
                res.add(start);
            } else {
                String pop;
                LinkedList<String> cpList = new LinkedList<>(list);
                List<String> cpRes = new ArrayList<>(res);
                String cpStart = start;
                boolean check = false;
                for (int i = 0; i < cpList.size(); i++) {
                    if (copy.containsKey(cpList.get(i))) {
                        if (!check) {
                            pop = list.remove(i);
                            map.put(start, list);
                            start = pop;
                            res.add(pop);
                            check = true;
                        } else {
                            ArrayList<String> cpList2 = new ArrayList<>(cpList);
                            Map<String, ArrayList<String>> copyMap;
                            copyMap = copy.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> new ArrayList<>(e.getValue())));
                            ArrayList<String> cpRes2 = new ArrayList<>(cpRes);
                            pop = cpList2.remove(i);
                            cpRes2.add(pop);
                            copyMap.put(cpStart, cpList2);
                            properlyList.push(cpRes2);
                            properlyMap.push(new HashMap<>(copyMap));
                        }
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(new ArrayList<>(Arrays.asList("EZE", "TIA")));
        tickets.add(new ArrayList<>(Arrays.asList("EZE", "HBA")));
        tickets.add(new ArrayList<>(Arrays.asList("AXA", "TIA")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "AXA")));
        tickets.add(new ArrayList<>(Arrays.asList("ANU", "JFK")));
        tickets.add(new ArrayList<>(Arrays.asList("ADL", "ANU")));
        tickets.add(new ArrayList<>(Arrays.asList("TIA", "AUA")));
        tickets.add(new ArrayList<>(Arrays.asList("ANU", "AUA")));
        tickets.add(new ArrayList<>(Arrays.asList("ADL", "EZE")));
        tickets.add(new ArrayList<>(Arrays.asList("ADL", "EZE")));
        tickets.add(new ArrayList<>(Arrays.asList("EZE", "ADL")));
        tickets.add(new ArrayList<>(Arrays.asList("AXA", "EZE")));
        tickets.add(new ArrayList<>(Arrays.asList("AUA", "AXA")));
        tickets.add(new ArrayList<>(Arrays.asList("JFK", "AXA")));
        tickets.add(new ArrayList<>(Arrays.asList("AXA", "AUA")));
        tickets.add(new ArrayList<>(Arrays.asList("AUA", "ADL")));
        tickets.add(new ArrayList<>(Arrays.asList("ANU", "EZE")));
        tickets.add(new ArrayList<>(Arrays.asList("TIA", "ADL")));
        tickets.add(new ArrayList<>(Arrays.asList("EZE", "ANU")));
        tickets.add(new ArrayList<>(Arrays.asList("AUA", "ANU")));
        List<String> solution = findItinerary(tickets);
        List<String> res = new ArrayList<>(Arrays.asList("JFK", "AXA", "AUA", "ADL", "ANU", "AUA", "ANU", "EZE", "ADL", "EZE", "ANU", "JFK", "AXA", "EZE", "TIA", "AUA", "AXA", "TIA", "ADL", "EZE", "HBA"));
//        res = new ArrayList<>(Arrays.asList("JFK", "AXA", "AUA", "ADL", "ANU", "AUA", "ANU", "EZE", "ADL", "EZE", "TIA", "AUA", "AXA", "EZE", "ANU", "JFK", "AXA", "TIA", "ADL", "EZE", "HBA"));
        System.err.println(res);
        assert solution.equals(res);
    }
}

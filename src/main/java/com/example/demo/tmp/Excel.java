package com.example.demo.tmp;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName Excel
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/7 12:58
 */
public class Excel {
    final String path = "C:\\Users\\wangrq\\Desktop\\";
    final String name = "部门考勤月统计-8月视图.csv";


    @Test
    public void test() throws IOException {
        File file = new File(path + name);
        BufferedReader buf = new BufferedReader(new FileReader(file));
        String str;
        HashMap<String, String> list = new HashMap<>();
        ArrayList<String> date = new ArrayList<>();
        while ((str = buf.readLine()) != null) {
            String[] split = str.split(",");
            if (split.length <= 4) {
                continue;
            }
            if ("上班卡".equalsIgnoreCase(split[3])) {
                continue;
            }
            if ("所属大区".equalsIgnoreCase(split[0])) {
                date = new ArrayList<>(Arrays.asList(split));
            } else {
                int index;
                int sumHour = 0;
                for (int i = 3; i < split.length; i += 2) {
                    index = i;
                    if (isWeekend(date.get(index))) {
                        if (split[i].length() > 0) {
                            if (i + 1 >= split.length) {
                                continue;
                            }
                            if (split[i + 1].length() == 0) {
                                list.compute(date.get(index), (k, v) -> v == null ? split[2] : v + "," + split[2]);
                            } else {
                                int i1 = checkDiff(split[i], split[i + 1]);
                                sumHour += Math.max(i1 - 2, 0);
                            }
                        }
                    } else {
                        if (split[i].length() > 0) {
                            if (i + 1 >= split.length) {
                                continue;
                            }
                            if (split[i + 1].length() == 0) {
                                list.compute(date.get(index), (k, v) -> v == null ? split[2] : v + "," + split[2]);
                            } else {
                                int i1 = checkDiff("19:00:00", split[i + 1]);
                                sumHour += Math.max(i1, 0);
                            }
                        }
                    }
                }
                System.out.println(split[2] + ":" + sumHour);
            }
        }
        for (Map.Entry<String, String> val : list.entrySet()) {
            System.out.println(val.getKey() + "  " + val.getValue());
        }
        buf.close();
    }

    public static boolean isWeekend(String bDate) {
        DateFormat format1 = new SimpleDateFormat("yyyy年MM月dd日");
        Date bdate;
        try {
            bdate = format1.parse(bDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(bdate);
            return (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Date toDate(String hour) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            return sdf.parse(hour);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static int checkDiff(String strGo, String strBack) {
        Date go = toDate(strGo);
        Date back = toDate(strBack);
        long l = back.getTime() - go.getTime();
        return (int) (l / (3600 * 1000));
    }

    @Test
    public void test2() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("蓝龙海", 58);
        map.put("郑国滨", 130);
        map.put("徐剑楠", 130);
        map.put("王乾", 130);
        map.put("李靖", 58);
        map.put("庄盛", 26);
        map.put("吴杨杨", 26);
        map.put("陈煌", 26);
        map.put("张仁杰", 26);
        map.put("方礼楷", 26);
        map.put("温利东", 130);
        map.put("郭梦思", 26);
        map.put("林聪", 17);
        map.put("张驰", 26);
        map.put("张春辉", 26);
        map.put("陈发灵", 87);
        map.put("董华翔", 26);
        map.put("康剑雄", 26);
        map.put("骆至坤", 104);
        map.put("张清榕", 104);
        map.put("王子豪", 104);
        map.put("陈梅秀", 104);
        map.put("彭素婷", 26);
        map.put("杨海波", 104);
        map.put("覃丽娟", 130);
        map.put("丁恩泽", 130);
        map.put("郑贵财", 130);

        map.compute("王远春", (k, v) -> v == null ? 23 : v + 23);
        map.compute("蓝龙海", (k, v) -> v == null ? 10 : v + 10);
        map.compute("江振华", (k, v) -> v == null ? 53 : v + 53);
        map.compute("叶弢", (k, v) -> v == null ? 7 : v + 7);
        map.compute("刘昌照", (k, v) -> v == null ? 21 : v + 21);
        map.compute("卢汉金", (k, v) -> v == null ? 27 : v + 27);
        map.compute("吴薇薇", (k, v) -> v == null ? 18 : v + 18);
        map.compute("李靖", (k, v) -> v == null ? 8 : v + 8);
        map.compute("林聪", (k, v) -> v == null ? 1 : v + 1);
        map.compute("陈梅秀", (k, v) -> v == null ? 0 : v + 0);
        map.compute("骆至坤", (k, v) -> v == null ? 0 : v + 0);
        map.compute("张清榕", (k, v) -> v == null ? 1 : v + 1);
        map.compute("张驰001", (k, v) -> v == null ? 12 : v + 12);
        map.compute("庄盛", (k, v) -> v == null ? 39 : v + 39);
        map.compute("张春辉", (k, v) -> v == null ? 20 : v + 20);
        map.compute("曾少聪", (k, v) -> v == null ? 8 : v + 8);
        map.compute("陈发灵", (k, v) -> v == null ? 11 : v + 11);
        map.compute("吴杨扬", (k, v) -> v == null ? 63 : v + 63);
        map.compute("方礼楷", (k, v) -> v == null ? 20 : v + 20);
        map.compute("王子豪", (k, v) -> v == null ? 0 : v + 0);
        map.compute("陈煌", (k, v) -> v == null ? 50 : v + 50);
        map.compute("林奕全", (k, v) -> v == null ? 2 : v + 2);
        map.compute("郭梦思", (k, v) -> v == null ? 0 : v + 0);
        map.compute("张仁杰", (k, v) -> v == null ? 21 : v + 21);
        map.compute("陈孝城", (k, v) -> v == null ? 10 : v + 10);
        map.compute("林和杰", (k, v) -> v == null ? 15 : v + 15);
        map.compute("徐达雄", (k, v) -> v == null ? 55 : v + 55);
        map.compute("丁善贤", (k, v) -> v == null ? 14 : v + 14);
        map.compute("黄贞杰", (k, v) -> v == null ? 61 : v + 61);
        map.compute("钟晓英001", (k, v) -> v == null ? 48 : v + 48);
        map.compute("黄艺纯", (k, v) -> v == null ? 98 : v + 98);
        map.compute("张建铭", (k, v) -> v == null ? 19 : v + 19);
        map.compute("郑阳", (k, v) -> v == null ? 16 : v + 16);
        map.compute("陈霞燕", (k, v) -> v == null ? 18 : v + 18);
        map.compute("黄德生", (k, v) -> v == null ? 22 : v + 22);
        map.compute("张高阳", (k, v) -> v == null ? 18 : v + 18);
        map.compute("林瑛瑶", (k, v) -> v == null ? 43 : v + 43);
        map.compute("康剑雄", (k, v) -> v == null ? 23 : v + 23);
        map.compute("钟振峰", (k, v) -> v == null ? 17 : v + 17);
        map.compute("汪渊向", (k, v) -> v == null ? 34 : v + 34);
        map.compute("黄耀威", (k, v) -> v == null ? 9 : v + 9);
        map.compute("朱志敏", (k, v) -> v == null ? 27 : v + 27);
        map.compute("黎夙斌", (k, v) -> v == null ? 27 : v + 27);
        map.compute("翁文鑫", (k, v) -> v == null ? 42 : v + 42);
        map.compute("林旺", (k, v) -> v == null ? 4 : v + 4);
        map.compute("钟佳冰", (k, v) -> v == null ? 15 : v + 15);
        map.compute("蓝哲", (k, v) -> v == null ? 1 : v + 1);
        map.compute("陈伟滨", (k, v) -> v == null ? 5 : v + 5);
        map.compute("黄楷文", (k, v) -> v == null ? 8 : v + 8);
        map.compute("李闽浩", (k, v) -> v == null ? 1 : v + 1);
        map.compute("董华翔", (k, v) -> v == null ? 2 : v + 2);
        map.compute("钟国鸿", (k, v) -> v == null ? 7 : v + 7);
        map.compute("洪明武", (k, v) -> v == null ? 7 : v + 7);
        map.compute("陈丽月", (k, v) -> v == null ? 4 : v + 4);
        map.compute("彭素婷", (k, v) -> v == null ? 0 : v + 0);
        map.compute("范立文", (k, v) -> v == null ? 54 : v + 54);
        map.compute("林巧彬", (k, v) -> v == null ? 5 : v + 5);
        map.compute("田文滨", (k, v) -> v == null ? 0 : v + 0);
        map.compute("刘洪南", (k, v) -> v == null ? 3 : v + 3);
        map.compute("李曼", (k, v) -> v == null ? 1 : v + 1);
        map.compute("陈伟坤", (k, v) -> v == null ? 1 : v + 1);
        map.compute("经纬和", (k, v) -> v == null ? 1 : v + 1);
        map.compute("杨海波", (k, v) -> v == null ? 0 : v + 0);
        map.compute("唐浩巍", (k, v) -> v == null ? 1 : v + 1);
        map.compute("叶祖炯", (k, v) -> v == null ? 6 : v + 6);
        map.compute("肖春翠", (k, v) -> v == null ? 6 : v + 6);
        map.compute("林雯", (k, v) -> v == null ? 0 : v + 0);

        String[] arr = new String[]{
                "王远春",
                "蓝龙海",
                "江振华",
                "叶弢",
                "刘昌照",
                "林旺",
                "钟佳冰",
                "陈伟滨",
                "李闽浩",
                "蓝哲",
                "黄楷文",
                "俞泽龙",
                "董华翔",
                "钟国鸿",
                "吴薇薇",
                "李靖",
                "林聪",
                "张清榕",
                "温利东001",
                "卢汉金",
                "骆至坤",
                "陈梅秀",
                "张驰001",
                "吴杨扬",
                "庄盛",
                "曾少聪",
                "张春辉",
                "陈发灵",
                "方礼楷",
                "王子豪",
                "林奕全",
                "陈孝城",
                "张仁杰",
                "陈煌",
                "林和杰",
                "郭梦思",
                "徐达雄",
                "丁善贤",
                "黄贞杰",
                "张建铭",
                "徐剑楠",
                "钟晓英001",
                "郑阳",
                "张志文",
                "陈霞燕",
                "黄德生",
                "张高阳",
                "黄艺纯",
                "钟振锋",
                "黎夙斌",
                "王乾",
                "郑国滨",
                "林瑛瑶",
                "朱志敏",
                "汪渊向",
                "翁文鑫",
                "陈伟坤",
                "唐浩巍",
                "叶祖炯",
                "经纬和",
                "洪明武",
                "陈丽月",
                "彭素婷",
                "杨海波",
                "肖春翠",
                "覃丽娟",
                "丁恩泽",
                "王瑞祥",
                "田文滨",
                "刘洪南",
                "李曼",
                "范立文",
                "林巧彬",
                "康剑雄",
                "黄耀威",
                "林雯",
                "曾艺敏",
                "梁启虬",
        };

        int sum = 0;
        for (String key : arr) {
            sum += map.get(key) == null ? 0 : map.get(key);
            map.remove(key);
        }
        System.out.println(map);

        System.out.println(sum);

    }

}


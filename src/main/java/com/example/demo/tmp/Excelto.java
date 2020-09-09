package com.example.demo.tmp;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Excelto
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/8 11:58
 */
public class Excelto {
    @Test
    public void test() throws IOException, InterruptedException {
        File file = new File("C:\\Users\\wangrq\\Desktop\\柳州人民医院现场人员名单_202008(1).csv");

        String[] strArr = new String[]{"王远春", "蓝龙海", "江振华", "叶弢", "刘昌照", "林旺", "钟佳冰", "陈伟滨", "李闽浩", "蓝哲", "黄楷文", "俞泽龙", "董华翔", "钟国鸿", "吴薇薇", "李靖", "林聪", "张清榕", "温利东001", "卢汉金", "骆至坤", "陈梅秀", "张驰001", "吴杨扬", "庄盛", "曾少聪", "张春辉", "陈发灵", "方礼楷", "王子豪", "林奕全", "陈孝城", "张仁杰", "陈煌", "林和杰", "郭梦思", "梁启虬", "徐达雄", "丁善贤", "黄贞杰", "张建铭", "徐剑楠", "钟晓英001", "郑阳", "张志文", "陈霞燕", "黄德生", "张高阳", "黄艺纯", "钟振峰", "黎夙斌", "王乾", "郑国滨", "林瑛瑶", "朱志敏", "汪渊向", "翁文鑫", "陈伟坤", "唐浩巍", "叶祖炯", "经纬和", "洪明武", "陈丽月", "彭素婷", "杨海波", "肖春翠", "覃丽娟", "丁恩泽", "王瑞祥", "田文滨", "刘洪南", "李曼", "范立文", "林巧彬", "康剑雄", "黄耀威", "林雯", "曾艺敏", "胡治宪", "詹三妹", "郑加福", "赵恩光",};
        HashMap<String, String> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] split = str.split(",");
                if (split.length > 1) {
                    map.put(split[1], str);
                }
            }
        }
        StringBuilder str = new StringBuilder();
        double sum = 0;
        for (String key : strArr) {
            if (map.containsKey(key)) {
                String remove = map.remove(key);
                String[] split = remove.split(",");
                sum += Double.parseDouble(split[7]);
                System.out.println(split[0] + "," + split[1] + "," + split[7]);
            } else {
                str.append(",").append(key);
            }
        }
        TimeUnit.SECONDS.sleep(1);
        System.err.println(sum);
        System.err.println(str.toString());
        for (String key : map.keySet()) {
            String s = map.get(key);
            String[] split = s.split(",");
            if (split.length >= 7) {
                sum += Double.parseDouble(split[7]);
                System.out.println(split[0] + "," + split[1] + "," + split[7]);
            }
        }
        System.out.println(sum);
    }
}

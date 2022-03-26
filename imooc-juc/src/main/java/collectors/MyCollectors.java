package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class MyCollectors {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("456","423","789","1101","212121121","asdaa","3e3e3e","2321eew");
        //toCollectionTest(list);
        //toListTest(list);
        //toSetList(list);
        //joiningTest(list);
        //mappingTest(list);
        //connectingAndThen(list);
        //countingTest(list);
        //maxByAndminByTest(list);
        //summingTest(list);
        //averagingTest(list);
        //reduceingTest(list);
        //groupByTest(list);
        //partitioningByTest(list);
        //toMapTest(list);
        summarizingTest(list);

    }

    /**
     * 在这些返回值中包含有流中元素的指定结果的数量、和、最大值、最小值、平均值。所有仅仅针对数值结果。
     * @param list
     */
    public static void summarizingTest(List<String> list){
        IntSummaryStatistics collect = list.stream().collect(Collectors.summarizingInt(String::length));
        LongSummaryStatistics collect1 = list.stream().limit(3).collect(Collectors.summarizingLong(Long::valueOf));
        DoubleSummaryStatistics collect3 = list.stream().limit(3).collect(Collectors.summarizingDouble(Double::valueOf));
        System.out.println(collect.toString()+"==="+collect1.toString()+"===="+collect3.toString());
    }

    /**
     * toMap方法是根据给定的键生成器和值生成器生成的键和值保存到一个map中返回，键和值的生成都依赖于元素，可以指定出现重复键时的处理方案和保存结果的map。
     * @param list
     */
    public static void toMapTest(List<String> list){
        Map<String, String> collect = list.stream().limit(3).collect(Collectors.toMap(e -> e.substring(0, 1), e -> e+"lala"));
        System.out.println(collect);
        Map<String, String> collect1 = list.stream().limit(3).collect(Collectors.toMap(e -> e.substring(0, 1), e -> e+"lala",(a,b) -> b));
        System.out.println(collect1);
        Map<String, String> collect3 = list.stream().limit(3).collect(Collectors.toMap(e -> e.substring(0, 1), e -> e+"lala",(a,b) -> b,HashMap::new));
        System.out.println(collect3);

    }

    /**
     * 该方法将流中的元素按照给定的校验规则的结果分为两个部分，放到一个map中返回，map的键是Boolean类型，值为元素的列表List。
     * @param list
     */
    public static void partitioningByTest(List<String> list){
        Map<Boolean, List<String>> collect = list.stream().collect(Collectors.partitioningBy(m -> m.length() > 5));
        System.out.println(collect);
        Map<Boolean, Set<String>> collect1 = list.stream().collect(Collectors.partitioningBy(m -> m.length() > 5, Collectors.toSet()));
        System.out.println(collect1);
    }


    /**
     * 这个方法是用于生成一个拥有分组功能的Collector，它也有三个重载方法：
     * @param list
     */
    public static void groupByTest(List<String> list){
        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(collect);
        Map<Integer, List<String>> collect1 = list.stream().collect(Collectors.groupingBy(String::length,Collectors.toList()));
        System.out.println(collect1);
        Map<Integer, Set<String>> collect2 = list.stream().collect(Collectors.groupingBy(String::length,HashMap::new,Collectors.toSet()));
        System.out.println(collect2);
    }

    /**
     * reducing方法有三个重载方法，其实是和Stream里的三个reduce方法对应的，二者是可以替换使用的，作用完全一致，也是对流中的元素做统计归纳作用。
     * @param list
     */
    public static void reduceingTest(List<String> list){
        System.out.println(list.stream().limit(3).map(String::length).collect(Collectors.reducing(Integer::sum)).get());
        System.out.println(list.stream().limit(3).map(String::length).collect(Collectors.reducing(1,Integer::sum)));
        System.out.println(list.stream().limit(3).collect(Collectors.reducing(1,String::length,Integer::sum)));

        System.out.println(list.stream().limit(3).map(String::length).reduce(1,Integer::sum));

    }

    /**
     * 生成一个用于求元素平均值的Collector，首选通过参数将元素转换为指定的类型。
     * 参数的作用就是将元素转换为指定的类型，求平均值涉及到除法操作，结果一律为Double类型。
     * @param list
     */
    public static void averagingTest(List<String> list){
        System.out.println(list.stream().limit(3).collect(Collectors.averagingInt(Integer::valueOf)));
        System.out.println(list.stream().limit(3).collect(Collectors.averagingLong(Long::valueOf)));
        System.out.println(list.stream().limit(3).collect(Collectors.averagingDouble(Double::valueOf)));
    }

    /**
     * 生成一个用于求元素和的Collector，首先通过给定的mapper将元素转换类型，然后再求和。
     * 参数的作用就是将元素转换为指定的类型，最后结果与转换后类型一致。
     * @param list
     */
    public static void summingTest(List<String> list){
        System.out.println(list.stream().limit(3).collect(Collectors.summingInt(Integer::valueOf)));
        System.out.println(list.stream().limit(3).collect(Collectors.summingLong(Long::valueOf)));
        System.out.println(list.stream().limit(3).collect(Collectors.summingDouble(Double::valueOf)));
    }

    /**
     * 生成一个用于获取最小/最大值的Optional结果的Collector。
     * @param list
     */
    public static void maxByAndminByTest(List<String> list){
        System.out.println(list.stream().limit(3).collect(Collectors.maxBy((a, b) -> Integer.parseInt(a) - Integer.parseInt(b))).get());
        System.out.println(list.stream().limit(3).collect(Collectors.minBy((a, b) -> Integer.parseInt(a) - Integer.parseInt(b))).get());

    }

    /**
     * 该方法用于计数。
     * @param list
     */
    public static void countingTest(List<String> list){
        long size = list.stream().collect(Collectors.counting());
        System.out.println(size);
    }

    /**
     * 该方法是在归纳动作结束之后，对归纳的结果进行再处理。
     * @param list
     */
    public static void connectingAndThen(List<String> list){
        int result = list.stream().collect(Collectors.collectingAndThen(Collectors.toList(),e->e.size()));
        System.out.println(result);
        System.out.println("===============");
        long result1 = list.stream().count();
        System.out.println(result1);
    }

    /**
     * 这个映射是首先对流中的每个元素进行映射，即类型转换，然后再将新元素以给定的Collector进行归纳。
     * @param list
     */
    public static void  mappingTest(List<String> list){
        List<Integer> result = list.stream().limit(5).collect(Collectors.mapping(Integer::valueOf,Collectors.toList()));
        System.out.println(result);
    }


    /**
     * joining的目的是将流中的元素全部以字符序列的方式连接到一起，可以指定连接符，甚至是结果的前后缀。
     * @param list
     */
    public static void joiningTest(List<String> list){
        String result = list.stream().collect(Collectors.joining());
        System.out.println(result);

        String result1 = list.stream().collect(Collectors.joining("-"));
        System.out.println(result1);

        String result2 = list.stream().collect(Collectors.joining("-","S","E"));
        System.out.println(result2);


    }

    /**
     *将流中的元素放置到一个无序集set中去。默认为HashSet。
     * @param list
     */
    public static void toSetList(List<String> list){
        Set<String> li = list.stream().collect(Collectors.toSet());
        System.out.println(li);
    }

    /**
     * 将流中的元素放置到一个列表集合中去。这个列表默认为ArrayList。
     * @param list
     */
    public static void toListTest(List<String> list){
        List<String> li = list.stream().collect(Collectors.toList());
        System.out.println(li);
    }


    /**
     * 将流中的元素全部放置到一个集合中返回，这里使用Collection，泛指多种集合。
     * @param list
     */
    public static void toCollectionTest(List<String> list){
        List<String> li = list.stream().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(li);
    }






}

package cn.partner.demo.lambda;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Slf4j
public class Demo03 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 3, 5, 2, 4);
        testConsumer(list);
        testFunction(list);
        testPrecidate(list);
    }

    static void testFunction(List<Integer> list) {
        Map<String, Integer> map = Maps.newHashMap();
        list.forEach(a -> map.put(a.toString(), a));
        log.info("orgin:{}", map);
        map.replaceAll((k, v) -> v * 10);
        log.info("current:{}", map);
    }

    static void testConsumer(List<Integer> list) {
        Consumer<Integer> action = a -> log.info("consume data {}", a);
        list.forEach(action);
    }

    static void testPrecidate(List<Integer> list) {
        Predicate<Integer> filter = a -> (a % 2 == 0);
        list.removeIf(filter);
        testConsumer(list);
    }
}

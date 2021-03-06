package cn.partner.demo.lambda;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * introduction of some class in package java.util.function. Consumer & Function & Precidate &
 * Supplier
 * 
 * @author qiao.yongxin
 * @date 2015年10月26日
 */
@Slf4j
public class Demo03 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 3, 5, 2, 4);
        testConsumer(list);
        testFunction(list);
        testPrecidate(list);
        testSupplier();
        testUnaryOperator(list);
    }

    static void testConsumer(List<Integer> list) {
        Consumer<Integer> action = a -> log.info("consume data {}", a);
        list.forEach(action);
    }

    static void testFunction(List<Integer> list) {
        Map<String, Integer> map = Maps.newHashMap();
        list.forEach(a -> map.put(a.toString(), a));
        log.info("orgin:{}", map);
        BiFunction<String, Integer, Integer> function = (k, v) -> v * 10;
        map.replaceAll(function);
        log.info("current:{}", map);
    }

    static void testPrecidate(List<Integer> list) {
        Predicate<Integer> filter = a -> (a % 2 == 0);
        list.removeIf(filter);
        testConsumer(list);
    }

    static void testSupplier() {
        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        log.info("random data : {}", supplier.get());
    }

    static void testUnaryOperator(List<Integer> list) {
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(String::valueOf, UnaryOperator.identity()));
        log.info("convert list to map, {}", map);
    }
}

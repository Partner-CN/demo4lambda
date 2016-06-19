package cn.partner.demo.lambda;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.math3.primes.Primes;

import com.google.common.collect.Lists;

/**
 * example of Stream
 * 
 * @author qiao.yongxin
 * @date 2015年10月27日
 */
@Slf4j
public class Demo05 {

    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
        testFilter(list);
        testMatch(list);
        testCollectMap(list);
        list.forEach(System.out::println);
        
    }

    static void testFilter(List<Integer> list) {
        List<Integer> newList = list.stream().filter(Primes::isPrime)
                .collect(Collectors.toList());
        log.info("filter: {}", newList);
    }

    static void testMatch(List<Integer> list) {
        boolean anyMatch = list.stream().anyMatch(Primes::isPrime);
        boolean allMatch = list.stream().allMatch(Primes::isPrime);
        boolean noneMatch = list.stream().noneMatch(Primes::isPrime);

        log.info("anyMatch: {}", anyMatch);
        log.info("allMatch: {}", allMatch);
        log.info("noneMatch: {}", noneMatch);
    }

    static void testCollectMap(List<Integer> list) {
        Map<Integer, Boolean> map = list.stream().collect(
                Collectors.toMap(Integer::new, Primes::isPrime));
        log.info("collect map: {}", map);
    }

}

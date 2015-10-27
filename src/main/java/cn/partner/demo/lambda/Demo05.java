package cn.partner.demo.lambda;

import java.util.List;
import java.util.stream.Stream;

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
        testMatch(list.stream());
    }

    static void testMatch(Stream<Integer> stream) {
        boolean anyMatch = stream.anyMatch(Primes::isPrime);
        boolean allMatch = stream.allMatch(Primes::isPrime);
        boolean noneMatch = stream.noneMatch(Primes::isPrime);

        log.info("anyMatch: {}", anyMatch);
        log.info("allMatch: {}", allMatch);
        log.info("noneMatch: {}", noneMatch);
    }
}

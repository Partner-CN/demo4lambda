package cn.partner.demo.lambda;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.Lists;

/**
 * reduce function of stream
 * 
 * @author qiao.yongxin
 * @date 2015年11月26日
 */
public class Demo06 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4);
        testReduce1(list);
        testReduce2(list);
        testReduce3(list);
    }

    private static void testReduce1(List<Integer> list) {
        Optional<Integer> result = list.stream().reduce((sum, element) -> sum + element);
        System.out.println(result.isPresent() ? result.get() : 0);
    }

    private static void testReduce2(List<Integer> list) {
        Integer result = list.stream().reduce(0, (sum, element) -> sum + element);
        System.out.println(result);
    }

    private static void testReduce3(List<Integer> list) {
        String result = list.stream().reduce("", (sum, element) -> sum + element, (identity, sum) -> "");
        System.out.println(result);
    }


}

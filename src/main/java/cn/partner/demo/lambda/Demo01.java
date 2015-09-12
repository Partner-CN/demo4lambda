package cn.partner.demo.lambda;

import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Lists;

@Slf4j
public class Demo01 {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 3, 5, 2, 4);
        iterateList(list);
        descCollection(list);
        iterateList(list);
    }

    static void descCollection(List<Integer> list) {
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
    }

    static void iterateList(List<Integer> list) {
        log.info("=======iterate list========");
        list.forEach(e -> log.info("value:{}", e));
    }
}

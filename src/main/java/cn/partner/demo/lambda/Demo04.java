package cn.partner.demo.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.IntConsumer;

import lombok.extern.slf4j.Slf4j;

import com.google.common.collect.Lists;

@Slf4j
public class Demo04 {

    public static void main(String[] args) {
        testIntConsumer();
    }

    static void testIntConsumer() {
        IntConsumer cons = i -> log.info("2^{}={}", i, (int) Math.pow(2, i));
        IntArrayList list = new IntArrayList(Lists.newArrayList(1, 2, 3, 4, 5));
        list.forEachInt(cons);
    }
}


class IntArrayList extends ArrayList<Integer> {

    private static final long serialVersionUID = -3272924427506042566L;

    public void forEachInt(IntConsumer cons) {
        this.forEach(e -> cons.accept(e));
    }

    public IntArrayList(Collection<? extends Integer> c) {
        super(c);
    }
}

package cn.partner.demo.lambda;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Demo02 {

	private FuncInterface fi;

	public Demo02(FuncInterface fi) {
		this.fi = fi;
	}

	public void print() {
		fi.printMe();
	}

	public static void main(String[] args) {
		Demo02 demo = new Demo02(
				() -> log.info("lambda used as a function interface"));
		demo.print();
		FuncInterface fi = () -> log
				.info("the function interface can use an annoation @FunctionalInterface");
		demo.setFi(fi);
		demo.print();
	}
}

// @FunctionalInterface
interface FuncInterface {
	void printMe();
}
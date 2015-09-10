package cn.partner.demo.lambda;

import lombok.extern.slf4j.Slf4j;

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
	}
}

interface FuncInterface {
	void printMe();
}
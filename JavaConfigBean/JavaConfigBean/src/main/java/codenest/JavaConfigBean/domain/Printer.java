package codenest.JavaConfigBean.domain;

import javax.annotation.Resource;

public class Printer {

	@Resource
	private ColorInk colorInk;

	public ColorInk getColorInk() {
		return colorInk;
	}

	public void setColorInk(ColorInk colorInk) {
		this.colorInk = colorInk;
	}

	public void print() {
		System.out.println(String.format("Color: %s", colorInk.getColor()));
	}

}

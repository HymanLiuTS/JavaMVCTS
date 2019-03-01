package codenest.JavaConfigBean.domain;

public class ColorInk {

	private String color;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void init() {
		this.color = "Red";
		System.out.println("ColorInk init");
	}

	public void destroy() {
		System.out.println("ColorInk destroy");
	}
}

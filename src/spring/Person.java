package spring;

public class Person {

	private Axe axe;

	public Axe getAxe() {
		return axe;
	}

	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	public void useAxe() {
		System.out.println("我打算去砍柴");
		System.out.println(axe.chop());
	}
}

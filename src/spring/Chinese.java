package spring;

public class Chinese implements Person {

	private Axe axe;
	public Chinese() {
	}
	public Chinese(Axe axe) {
		this.axe = axe;
	}

	public Axe getAxe() {
		return axe;
	}

	public void setAxe(Axe axe) {
		this.axe = axe;
	}

	@Override
	public void useAxe() {
		System.out.println(axe.chop());
		
	}
	
}

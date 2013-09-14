package pl.bb.gof.chain;

public class Criteria {
	public int age;

	public Criteria(int age) {
		super();
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criteria other = (Criteria) obj;
		if (age != other.age)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Criteria [age=" + age + "]";
	}

}

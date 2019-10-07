package Part2;

import java.util.List;

public abstract class Measurable implements Comparable<Measurable> {

	@Override
	public int compareTo(Measurable measurable) {
		return Float.compare(this.getMeasure(), measurable.getMeasure());
	}
	
	static <T extends Part2.Measurable> float average(List<T> items) {
		if (items.isEmpty())
			return 0;
		float total = 0;
		for (T m : items) {
			total += m.getMeasure();
		}
		return total / items.size();
	}
	
	abstract float getMeasure();
}

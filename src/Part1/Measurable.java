package Part1;

import java.util.List;

public interface Measurable {
	static <T extends Measurable> float average(List<T> items) {
		if (items.isEmpty())
			return 0;
		float total = 0;
		for (T m : items) {
			total += m.getMeasure();
		}
		return total / items.size();
	}
	
	float getMeasure();
}


package git.lab.experiment1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.magicwerk.brownies.collections.BigList;
import org.magicwerk.brownies.collections.GapList;

import git.lab.equipment.measurement.TimeMeasurement;

public class CollectionPerformanceTest {

	private static final Logger logger = Logger.getLogger(CollectionPerformanceTest.class.getSimpleName());

	private static final Random random = new Random(42);

	public static void main(String[] args) {

		//executePerformanceMeasurement(1000);
		//executePerformanceMeasurement(100000);
		executePerformanceMeasurement(1000000);
	}

	private static void executePerformanceMeasurement(int n) {
		logger.log(Level.INFO, "Executing Performance Test for size = " + n);

		List[] contestants = new List[3];
		contestants[0] = new ArrayList();
		contestants[1] = new GapList();
		contestants[2] = new BigList();

		measureSerialFill(contestants, n);
		measureSerialIteration(contestants, n);
		measureRandomAccess(contestants, n);
		measureAddAtIndex(contestants, n);
		measureRemoveAtIndex(contestants, n);
	}

	private static final void measureSerialFill(List[] contestants, int n) {
		int[] values = buildValueArray(n);

		measurePerformance("Add at End", contestants, n, (list) -> {
			for (int value : values) {
				list.add(value);
			}
		});
	}

	private static final void measureSerialIteration(List[] contestants, int n) {
		int[] values = buildValueArray(n);

		measurePerformance("Serial Iteration", contestants, n, (list) -> {
			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {
				int value = (int) iterator.next();
			}
		});
	}

	private static final void measureRandomAccess(List[] contestants, int n) {
		int[] indices = buildValueArray(n);

		measurePerformance("Random Access", contestants, n, (list) -> {
			for (int index : indices) {
				int value = (int) list.get(index);
			}
		});
	}

	private static final void measureAddAtIndex(List[] contestants, int n) {
		int[] valuesToAdd = buildValueArray(n);

		measurePerformance("Add at Index", contestants, n, (list) -> {
			for (int index = 0; index < valuesToAdd.length; index++) {
				list.add(index, valuesToAdd[index]);
			}
		});
	}

	private static final void measureRemoveAtIndex(List[] contestants, int n) {

		measurePerformance("Remove at Index", contestants, n, (list) -> {
			for (int index = n - 1; index >= 0; index--) {
				list.remove(index * 2);
			}
		});
	}

	private static final void measurePerformance(String title, List[] contestants, int n, Consumer<List> task) {

		for (List contestant : contestants) {
			TimeMeasurement timeMeasurement = new TimeMeasurement();
			timeMeasurement.start();

			task.accept(contestant);
			timeMeasurement.stop();

			long elapsedTime = timeMeasurement.getElapsedTime();

			logger.log(Level.INFO,
					title + "(" + n + ") - " + contestant.getClass().getSimpleName() + " " + elapsedTime + " ns.");
		}

	}

	private static int[] buildValueArray(int n) {
		int[] result = new int[n];

		for (int i = 0; i < n; i++) {
			result[i] = random.nextInt(n);
		}

		return result;
	}

}

package pl.bb.practicalUnitTesting.carSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarSearch {
	private final Set<Car> cars = new HashSet<Car>();

	public void addCar(Car car) {
		cars.add(car);
	}

	@Deprecated
	public List<Car> findSportCars() {
		List<Car> sportCars = new ArrayList<Car>();
		for (Car car : cars) {
			if (car.getEngine().getCylindersCount() > 6 && Color.RED.equals(car.getColor())
					&& "Ferrari".equals(car.getManufacturer().getName())) {
				sportCars.add(car);
			}
		}
		return sportCars;
	}

	public Set<Car> findSportCars2() {
		Set<Car> sportCars = new HashSet<Car>();
		for (Car car : cars) {
			if (car.isSportCar()) {
				sportCars.add(car);
			}
		}
		return sportCars;
	}
}

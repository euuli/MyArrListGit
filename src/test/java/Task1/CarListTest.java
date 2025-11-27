package Task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {

    private CarList carList;

    @BeforeEach
    void setUp() {
        carList = new CarArrayList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexThenSizeMustBeDecreased() {
        assertTrue(carList.removeAt(5));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedThenSizeMustBeDecreased() {
        Car car = new Car("Toyota", 15);
        carList.add(car);
        assertEquals(101, carList.size());
        assertTrue(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistingElementRemovedThenReturnFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedThenSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrowException() {
        assertThrows(IndexOutOfBoundsException.class, () -> {carList.get(100);});
    }

    @Test
    public void methodGetReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("BMW", 11);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("BMW", car.getBrand());
    }

    @Test
    public void insertIntoBeginning() {
        Car car = new Car("BMW", 11);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", car.getBrand());
    }

    @Test
    public void insertIntoEnding() {
        Car car = new Car("BMW", 11);
        Car car99 = carList.get(99);
        carList.add(car, 99);
        Car carFromList = carList.get(99);
        assertEquals("BMW", car.getBrand());
        assertEquals(carList.get(100).getBrand(), car99.getBrand());
    }

    @Test
    public void insertIntoEnding2() {
        Car car = new Car("BMW", 11);
        carList.add(car, 100);
        Car carFromList = carList.get(100);
        assertEquals("BMW", car.getBrand());
    }

    @Test
    public void whenRemoveAt50ArrayGet50MustBeBrand51() {
        assertTrue(carList.removeAt(50));
        assertEquals("Brand51", carList.get(50).getBrand());
        assertEquals(99, carList.size());
    }
}
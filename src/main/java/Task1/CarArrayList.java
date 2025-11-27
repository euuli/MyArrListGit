package Task1;

import java.util.Arrays;

public class CarArrayList implements CarList {
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car get(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        if ( size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
//            Car[] newArray = new Car[array.length * 2];
//            for (int i = 0; i < array.length; i++) {
//                newArray[i] = array[i];
//            }
//            array = newArray;
        }
        array[size] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(car)) {
                return removeAt(i);
            }
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
//        for (int i = index, j = index + 1; i < size - 1; i++) {
//            array[i] = array[j];
//            j++;
//        }
//        array[size - 1] = null;
//        size--;
        Car[] newArray = new Car[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size - index);
        array = newArray;
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    @Override
    public void add(Car car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        size++;
        Car[] newArray = new Car[size];
//        for (int i = 0; i < size; i++) {
//            if (i < index) {
//                newArray[i] = array[i];
//            } else if (i == index) {
//                newArray[i] = car;
//            } else {
//                newArray[i] = array[i - 1];
//            }
//        }
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = car;
        System.arraycopy(array, index, newArray, index + 1, size - 1 - index);
        array = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}

<!-- CI/CD demo trigger -->

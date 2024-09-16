package ClinicProject.Sorting;

import ClinicProject.Patient.Patient;

import java.util.ArrayList;
import java.util.List;

public class SortingList<T> {
    private final List<T> elementList = new ArrayList<>();

    public boolean IsEmpty(){
        return elementList.isEmpty();
    }

    public void add(T element) {
        elementList.add(element);
    }

    public T pop() {
        return elementList.removeFirst();
    }
}

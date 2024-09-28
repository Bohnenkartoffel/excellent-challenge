package de.exxcellent.challenge;

import java.util.ArrayList;

public abstract class categorizedColumn<T> implements Column<T>{
    private String category;
    private ArrayList<T> values;

    categorizedColumn(String category) {
        super();
        this.category = category;
        this.values = new ArrayList<>();
    }

    @Override
    public void setValue(T value, int row) throws IndexOutOfBoundsException {
        values.set(row, value);
    }

    @Override
    public T getValue(int row) throws IndexOutOfBoundsException {
        return values.get(row);
    }

    @Override
    public void addValue(T value) {
        values.add(value);
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(category);
        for (T value : values) {
            string.append("\n").append(value.toString());
        }
        return string.toString();
    }
}

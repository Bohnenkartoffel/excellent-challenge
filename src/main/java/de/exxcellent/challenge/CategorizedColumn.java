package de.exxcellent.challenge;

import java.util.ArrayList;

/**
 * A column with a String category name
 * @param <T> type of values stored in this column
 */
public abstract class CategorizedColumn<T> implements Column<T>{
    private String category;
    private ArrayList<T> values;

    /**
     * Creates a new column under the given category name
     * @param category categroy of the column
     */
    CategorizedColumn(String category) {
        super();
        this.category = category;
        this.values = new ArrayList<>();
    }

    /**
     * sets the value at the given index
     * @param value to be entered
     * @param row index of the value to be overwritten
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void setValue(T value, int row) throws IndexOutOfBoundsException {
        values.set(row, value);
    }

    /**
     * gets the value at the given index
     * @param row index of the value to be retrieved
     * @return
     * @throws IndexOutOfBoundsException
     */
    @Override
    public T getValue(int row) throws IndexOutOfBoundsException {
        return values.get(row);
    }

    /**
     * adds a new value at the end of the column
     * @param value value to be entered into the column
     */
    @Override
    public void addValue(T value) {
        values.add(value);
    }

    /**
     * creates a String representation of the category and values stored in this column
     * @return String representation of this CategorizedColumn
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(category);
        for (T value : values) {
            string.append("\n").append(value.toString());
        }
        return string.toString();
    }
}

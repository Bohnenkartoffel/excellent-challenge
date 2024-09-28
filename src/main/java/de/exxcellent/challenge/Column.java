package de.exxcellent.challenge;

/**
 * column of values
 * @param <T> type of values to be stored in this column
 */
public interface Column<T>{
    /**
     * get value stored at the given row
     * @param row index of the value to be retrieved
     * @return value at given index
     * @throws Exception exception if index exceeds column length
     */
    T getValue(int row) throws Exception;

    /**
     * overwrite existing value at the given row
     * @param value to be entered
     * @param row index of the value to be overwritten
     * @throws Exception exception if index exceeds column length
     */
    void setValue(T value, int row) throws Exception;

    /**
     * add a new value into the column, appending it at the end
     * @param value value to be entered into the column
     */
    void addValue(T value);
}

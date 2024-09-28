package de.exxcellent.challenge;

import de.exxcellent.challenge.utils.CategorizedColumn;
import de.exxcellent.challenge.utils.CategorizedColumns;
import de.exxcellent.challenge.utils.Challenge;

import java.util.ArrayList;

public class WeatherChallenge extends Challenge {

    /**
     * Creates a new Weather Challenge with the given data
     *
     * @param filepath to the CSV data
     */
    public WeatherChallenge(String filepath) {
        super(filepath);
    }

    @Override
    protected CategorizedColumns extractColumnValues(ArrayList<String> categories) throws Exception {
        CategorizedColumns columns = new CategorizedColumns();

        //Initialize columns with categories supplied
        for (String category : categories) {
            CategorizedColumn<?> column;
            if (category.equals("Day")) {
                column = new CategorizedColumn<Integer>(category);
            } else {
                column = new CategorizedColumn<Float>(category);
            }
            columns.addColumn(column);
        }

        //Add values to each column row by row, Integer for the Day column and Float for the others
        while (reader.hasNextLine()) {
            ArrayList<String> tokens = reader.nextLine();
            int index = 0;
            for (String category : categories) {
                String token = tokens.get(index);
                if (category.equals("Day")) {
                    Integer value = Integer.parseInt(token);

                    //There are probably prettier ways to do this, but I know that I can cast here given that I
                    //created these columns in the previous step
                    CategorizedColumn<Integer> tempColumn = (CategorizedColumn<Integer>) columns.getColumn(category);
                    tempColumn.addValue(value);
                    columns.addColumn(tempColumn);
                } else {
                    Float value = Float.parseFloat(token);

                    //There are probably prettier ways to do this, but I know that I can cast here given that I
                    //created these columns in the previous step
                    CategorizedColumn<Float> tempColumn = (CategorizedColumn<Float>) columns.getColumn(category);
                    tempColumn.addValue(value);
                    columns.addColumn(tempColumn);
                }
                index++;
            }
        }
        return columns;
    }
}

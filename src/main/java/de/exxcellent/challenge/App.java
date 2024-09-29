package de.exxcellent.challenge;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {
        String resourcesDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\de\\exxcellent\\challenge\\";

        switch (args.length) {
            case 0:
                runWeather(resourcesDirectory + "weather.csv");
                runFootball(resourcesDirectory + "football.csv");
                break;
            case 2:
                switch (args[0]) {
                    case "--weather":
                        runWeather(resourcesDirectory + args[1]);
                        break;
                    case "--football":
                        runFootball(resourcesDirectory + args[1]);
                        break;
                    default:
                        System.out.println("Please choose a valid mode if you provide arguments");
                        System.out.println("Usage: --mode [--football | --weather] filepath");
                }
                break;
            default:
                System.out.println("Please provide a valid number of arguments");
                System.out.println("Either 0 to execute both challenges");
                System.out.println("Or 2 to execute a specific challenge and choose the CSV file manually");
                System.out.println("Usage: --mode [--football | --weather] filepath");
        }
    }

    private static void runWeather(String filepath){
        WeatherChallenge weather = new WeatherChallenge(filepath);
        String dayWithSmallestTempSpread = weather.run();
        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
    }

    private static void runFootball(String filepath){
        FootballChallenge football = new FootballChallenge(filepath);
        String teamWithSmallestGoalSpread = football.run();
        System.out.printf("Team with smallest goal spread : %s%n", teamWithSmallestGoalSpread);
    }
}

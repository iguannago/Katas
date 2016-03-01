package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */
public class ParentalControlLevelsImpl implements ParentalControlLevelsService {

    private MovieService movieService;

    public boolean isCustomerAbleToWatchMovie(String movieId, String customerParentalControlLelelPreference) {
        boolean result = false;
        try {
            if (ParentalControlLevel.getLevelForTheGivenLevelCode(movieService.getParentalControlLevel(movieId)) ==
                    ParentalControlLevel.getLevelForTheGivenLevelCode(customerParentalControlLelelPreference)) {
                result = true;
            }
        } catch (TitleNotFoundException e) {
            e.printStackTrace();
        } catch (TechnicalFailureException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}

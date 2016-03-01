package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */
public class ParentalControlLevelsImpl implements ParentalControlLevelsService {

    private MovieService movieService;

    public boolean isCustomerAbleToWatchMovie(String movieId, String customerParentalControlLevelPreference)
            throws TechnicalFailureException, TitleNotFoundException {
        boolean result = false;
            if (ParentalControlLevel.getLevelForTheGivenLevelCode(movieService.getParentalControlLevel(movieId)) <=
                    ParentalControlLevel.getLevelForTheGivenLevelCode(customerParentalControlLevelPreference)) {
                result = true;
            }
        return result;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}

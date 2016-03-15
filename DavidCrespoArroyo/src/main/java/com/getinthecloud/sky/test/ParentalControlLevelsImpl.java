package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */
public class ParentalControlLevelsImpl implements ParentalControlLevelsService {

    private MovieService movieService;

    public boolean isCustomerAbleToWatchMovie(String movieId, String customerParentalControlLevelPreference)
            throws TechnicalFailureException, TitleNotFoundException {
        if (ParentalControlLevelDefinition.
                getParentalControlLevelDefinition(movieService.getParentalControlLevel(movieId)).getLevel() <=
                ParentalControlLevelDefinition.
                        getParentalControlLevelDefinition(customerParentalControlLevelPreference).getLevel()) {
            return true;
        }
        return false;
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}

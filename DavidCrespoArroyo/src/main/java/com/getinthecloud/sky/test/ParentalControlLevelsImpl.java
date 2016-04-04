package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */
public class ParentalControlLevelsImpl implements ParentalControlService {

    private MovieService movieService;

    public boolean isCustomerAbleToWatchMovie(String movieId, String customerParentalCtrlLevelPref)
            throws TechnicalFailureException, TitleNotFoundException {
        if (isMovieParentalControlLowerOrEqualToCustomerParentalCtrlPreference(movieId, customerParentalCtrlLevelPref)) {
            return true;
        }
        return false;
    }

    private boolean isMovieParentalControlLowerOrEqualToCustomerParentalCtrlPreference(String movieId,
                                                                                       String customerParentalCtrlLevelPref)
            throws TitleNotFoundException, TechnicalFailureException {
        return ParentalControlLevelDefinition.
                getParentalControlLevelDefinition(movieService.getParentalControlLevel(movieId)).getLevel() <=
                ParentalControlLevelDefinition.
                        getParentalControlLevelDefinition(customerParentalCtrlLevelPref).getLevel();
    }

    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }
}

package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */
public interface ParentalControlLevelsService {
    boolean isCustomerAbleToWatchMovie(String movieId, String customerParentalControlLelelPreference)
            throws TechnicalFailureException, TitleNotFoundException;
}

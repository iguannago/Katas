package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */
public interface ParentalControlService {
    boolean isCustomerAbleToWatchMovie(String movieId, String customerParentalControlLevelPreference)
            throws TechnicalFailureException, TitleNotFoundException;
}

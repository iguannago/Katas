package com.getinthecloud.sky.test;

/**
 * Created by davicres on 01/03/2016.
 */
public interface MovieService {
    String getParentalControlLevel(String movieId)  throws TitleNotFoundException, TechnicalFailureException;
}

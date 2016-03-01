package com.getinthecloud.sky.test;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by davicres on 01/03/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ParentalControlLevelsServiceTest {

    private ParentalControlLevelsImpl parentalControlLevelsImpl;
    @Mock
    private MovieService movieServiceMock;

    @Before
    public void setUp() throws Exception {
        parentalControlLevelsImpl = new ParentalControlLevelsImpl();
        parentalControlLevelsImpl.setMovieService(movieServiceMock);
    }

    /**
     * If the parental control level of the movie is equal to or less than the customer’s preference, indicate
     * to the caller that the customer can watch the movie
     */
    @Test
    public void parentalControlLevelOfMovieIsUAndCustomerPreferenceLevelIsUThenReturnTrueTest()
            throws TechnicalFailureException, TitleNotFoundException {
        //mock the expected behaviour for this test
        when(movieServiceMock.getParentalControlLevel(anyString())).thenReturn("U");
        String customerParentalControlLevelPreference = "U";
        boolean isCustomerAbleToWatchMovie = parentalControlLevelsImpl.isCustomerAbleToWatchMovie(
                anyString(), customerParentalControlLevelPreference);
        assertEquals(true, isCustomerAbleToWatchMovie);
    }

    @Test@Ignore
    public void parentalControlLevelOfMovieIsPGAndCustomerPreferenceLevelIsUThenReturnFalseTest() {
        String movieId = "movieId";
        String customerParentalControlLevelPreference = "U";
        boolean isCustomerAbleToWatchMovie = parentalControlLevelsImpl.isCustomerAbleToWatchMovie(
                movieId, customerParentalControlLevelPreference);
        assertEquals(false, isCustomerAbleToWatchMovie);
    }


}

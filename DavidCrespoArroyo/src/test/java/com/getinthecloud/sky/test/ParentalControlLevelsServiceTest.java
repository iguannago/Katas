package com.getinthecloud.sky.test;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by davicres on 01/03/2016.
 */
@RunWith(JUnitParamsRunner.class)
public class ParentalControlLevelsServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

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
    @Parameters(method = "getMovieAndCustomerParentalControlLevels")
    public void parentalControlLevelOfMovieIsEqualOrLessThanCustomerPreferenceLevelThenReturnTrueTest(
            String movieParentalControlLevel, String customerParentalControlLevelPreference)
            throws TechnicalFailureException, TitleNotFoundException {
        //mock the expected behaviour for this test
        when(movieServiceMock.getParentalControlLevel(anyString())).thenReturn(movieParentalControlLevel);
        boolean isCustomerAbleToWatchMovie = parentalControlLevelsImpl.isCustomerAbleToWatchMovie(
                anyString(), customerParentalControlLevelPreference);
        assertEquals(true, isCustomerAbleToWatchMovie);
    }

    private static final Object[] getMovieAndCustomerParentalControlLevels() {
        return new String[][]{
                {"U", "U"}, {"U", "PG"}, {"U", "12"}, {"U", "15"}, {"U", "18"},
                {"PG", "PG"}, {"PG", "12"}, {"PG", "15"},
        };
    }




}

package com.katas.footballTeam;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by davicres on 21/11/2016.
 */
public class FootballTeamTest {

    @Test
    public void constructorTest() {
        FootballTeam footballTeam = new FootballTeam(2);
        assertNotNull(footballTeam);
    }

    @Test
    public void sortFootballTeamsTest() {
        List<FootballTeam> footballTeamList = new ArrayList<>();
        Collections.sort(footballTeamList);
    }

}

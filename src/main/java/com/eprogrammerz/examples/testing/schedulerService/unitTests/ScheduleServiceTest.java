package com.eprogrammerz.examples.testing.schedulerService.unitTests;

import com.eprogrammerz.examples.testing.schedulerService.CurrentDayService;
import com.eprogrammerz.examples.testing.dateManipulator.DateManipulator;
import com.eprogrammerz.examples.testing.schedulerService.Schedule;
import com.eprogrammerz.examples.testing.schedulerService.ScheduleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by 542596 on 3/3/2017.
 */
public class ScheduleServiceTest {
    private ScheduleService classUnderTest;

    private CurrentDayService currentDayServiceMock;
    @Before
    public void setUp() throws Exception {
        currentDayServiceMock = Mockito.mock(CurrentDayService.class);
        classUnderTest = new ScheduleService(currentDayServiceMock);
    }

    @After
    public void tearDown() throws Exception {
        classUnderTest = null;
    }

    @Test
    public void whenGetTodayScheduleThenReturnScheduleOfToday() throws Exception {

        Mockito.when(currentDayServiceMock.getCurrentDay()).thenReturn(3);
        Schedule todaySchedule = classUnderTest.getTodaySchedule();
        assertThat("Schedule is string", todaySchedule.getDescription(), equalTo("Schedule for day: 3"));
    }
}

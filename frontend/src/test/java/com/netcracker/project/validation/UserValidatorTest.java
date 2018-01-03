package com.netcracker.project.validation;


import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserValidatorTest {

    private UserValidator userValidator;

    @Before
    public void setUp() throws Exception {
        userValidator = new UserValidator();
    }


    @Test
    public void validateAvgScore() {
        assertTrue(userValidator.validateAvgScoreField("7.77"));
        assertTrue(userValidator.validateAvgScoreField("1"));
        assertFalse(userValidator.validateAvgScoreField("11.0"));
        assertFalse(userValidator.validateAvgScoreField(""));
        assertFalse(userValidator.validateAvgScoreField("!"));
    }

    @Test
    public void validateEducationForm() {
        assertFalse(userValidator.validateEducationForm(null));
        assertTrue(userValidator.validateEducationForm("FULL_TIME"));
    }


}

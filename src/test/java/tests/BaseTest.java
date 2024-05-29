package tests;

import core.steps.BaseSteps;
import core.utils.DriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
    protected static final ThreadLocal<BaseSteps> STEPS = new ThreadLocal<>();

    @BeforeAll
    public static void setUp() {
        STEPS.set(new BaseSteps());
        STEPS.get().setUpDriverSettings();
    }

    @AfterAll
    public static void tearDown() {
        DriverManager.driverKill();

    }
}

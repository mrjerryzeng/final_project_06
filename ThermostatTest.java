import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThermostatTest {
    private Thermostat ts;
    private ProgrammedSettings ps;
    @BeforeEach
    void setUp() {
        ts = new Thermostat();
        ps = new ProgrammedSettings();
    }

    @AfterEach
    void tearDown() {
        ts.setHeaterOn(false);
    }

    @Test
    void PC_Frq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,70);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(2);
        ts.setMinLag(5);
        ts.turnHeaterOn(ps);
        boolean Frq = ts.getHeaterOn();
        assertFalse(Frq);
    }

    @Test
    void PC_Trq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,70);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(40);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(30);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean Trq = ts.getHeaterOn();
        assertTrue(Trq);
    }

    @Test
    void CC_TTTTrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,70);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean TTTTrq = ts.getHeaterOn();
        assertTrue(TTTTrq);
    }

    @Test
    void CC_FFFFrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,70);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(90);
        ts.setThresholdDiff(5);
        ts.setOverride(false);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean FFFFrq = ts.getHeaterOn();
        assertFalse(FFFFrq);
    }

    @Test
    void CACC_A_TTFTrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,70);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(30);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean TTFTrq = ts.getHeaterOn();
        assertTrue(TTFTrq);
    }

    @Test
    void CACC_A_FFTTrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,36);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(false);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean FFTTrq = ts.getHeaterOn();
        assertFalse(FFTTrq);
    }

    @Test
    void CACC_B_FTTTrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,36);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean FTTTrq = ts.getHeaterOn();
        assertTrue(FTTTrq);
    }

    @Test
    void CACC_B_FFTTrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,36);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(false);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean FFTTrq = ts.getHeaterOn();
        assertFalse(FFTTrq);
    }

    @Test
    void CACC_C_FTTTrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,36);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean FTTTrq = ts.getHeaterOn();
        assertTrue(FTTTrq);
    }

    @Test
    void CACC_C_FTFTrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,36);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(30);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean FTFTrq = ts.getHeaterOn();
        assertFalse(FTFTrq);
    }

    @Test
    void CACC_D_TTTTrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,70);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(5);
        ts.setMinLag(2);
        ts.turnHeaterOn(ps);
        boolean TTTTrq = ts.getHeaterOn();
        assertTrue(TTTTrq);
    }

    @Test
    void CACC_D_TTTFrq() {
        ps.setSetting( Period.MORNING, DayType.WEEKDAY,70);
        ts.setPeriod(Period.MORNING);
        ts.setDay(DayType.WEEKDAY);
        ts.setCurrentTemp(34);
        ts.setThresholdDiff(5);
        ts.setOverride(true);
        ts.setOverTemp(68);
        ts.setTimeSinceLastRun(2);
        ts.setMinLag(5);
        ts.turnHeaterOn(ps);
        boolean TTTFrq = ts.getHeaterOn();
        assertFalse(TTTFrq);
    }
}

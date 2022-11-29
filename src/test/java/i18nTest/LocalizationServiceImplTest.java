package i18nTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import ru.netology.entity.Country;

import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceImplTest {

    LocalizationServiceImpl localizationService;

    @BeforeEach
    void start() {
        localizationService = new LocalizationServiceImpl();
    }

    @ParameterizedTest
    @EnumSource(value = Country.class, names = {"GERMANY", "USA", "BRAZIL"})
    void localeTest(Country country) {
        String expected = "Welcome";
        String actual = localizationService.locale(country);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void localeTestRu() {
        String expected = "Добро пожаловать";
        String actual = localizationService.locale(Country.RUSSIA);

        Assertions.assertEquals(expected, actual);
    }

}

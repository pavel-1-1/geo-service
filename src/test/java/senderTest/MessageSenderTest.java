package senderTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

public class MessageSenderTest {

    @Test
    void testMessageSenderImplRussia() {
        Map<String, String> headersTest = new HashMap<>();
        headersTest.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.");

        GeoService geoService = Mockito.mock(GeoService.class);

        Mockito.when(geoService.byIp("172.")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headersTest);

        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMessageSenderImplUsa() {
        Map<String, String> headersTest = new HashMap<>();
        headersTest.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.");

        GeoService geoService = Mockito.mock(GeoService.class);

        Mockito.when(geoService.byIp("96.")).thenReturn(new Location("New York", Country.USA, null, 0));

        LocalizationService localizationService = Mockito.mock(LocalizationService.class);

        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");

        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);
        String actual = messageSender.send(headersTest);

        String expected = "Welcome";
        Assertions.assertEquals(expected, actual);
    }
}

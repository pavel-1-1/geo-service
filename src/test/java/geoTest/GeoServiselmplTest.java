package geoTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiselmplTest {
    GeoServiceImpl geoService;

    @BeforeEach
    void start() {
        geoService = new GeoServiceImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"172.0.0.1", "172."})
    void testByIpRu(String ip) {
        Country expected = Country.RUSSIA;
        Location actual = geoService.byIp(ip);

        Assertions.assertEquals(expected, actual.getCountry());
    }

    @ParameterizedTest
    @ValueSource(strings = {"96.", "96.78.7.879"})
    void testByIpUsa(String ip) {
        Country expected = Country.USA;
        Location actual = geoService.byIp(ip);

        Assertions.assertEquals(expected, actual.getCountry());
    }
}

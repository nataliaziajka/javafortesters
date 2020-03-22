package pl.stqa.javafortesters.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GeoIPServiceTests {


    @Test
  public void testMyIp() {
      GeoIPService geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("89.187.249.26");
    assertEquals(geoIP.getGeoIPServiceSoap().getLocation(),"POL");
  }
  @Test
  public void testInvalidIp() {
    GeoIPService geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("89.187.249.26" );
    //assertEquals(geoIP., "POL");
    assertEquals(geoIP.getGeoIPServiceSoap().getLocation(), "POL");

  }
}
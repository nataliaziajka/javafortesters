//package pl.stqa.javafortesters.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class GeoIPServiceTests {


    @Test
  public void testMyIp() {
      String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("89.187.249.26");
    assertEquals(geoIP,"<GeoIP><Country>PL</Country><State>77</State></GeoIP>");
  }
  @Test
  public void testInvalidIp() {
    String geoIP = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("89.187.249.xx" );
    assertEquals(geoIP, "<GeoIP><Country>US</Country><State>CA</State></GeoIP>");

  }
}
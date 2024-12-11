package ipapi.java;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class IpapiTest {

    @Test
    public void testQueryIp() throws Exception {
        IPInfo ipInfo = Ipapi.queryIp("8.8.8.8");
        assertNotNull(ipInfo);
        System.out.println(ipInfo.getIp());
    }

    @Test
    public void testQueryBulk() throws Exception {
        List<String> ips = List.of("8.8.8.8", "1.1.1.1");
        List<IPInfo> ipInfos = Ipapi.queryBulk(ips);
        assertEquals(2, ipInfos.size());
    }

    @Test
    public void testQueryOwnIp() throws Exception {
        String ip = Ipapi.queryOwnIp();
        assertNotNull(ip);
        System.out.println("Your IP Address: " + ip);
    }
}

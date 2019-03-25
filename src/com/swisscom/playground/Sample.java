package com.swisscom.playground;

import com.swisscom.playground.util.ApiClientUtils;
import com.vmware.vapi.client.ApiClient;

import com.vmware.nsx.TransportZones;
import com.vmware.nsx.model.TransportZone;
import com.vmware.nsx.model.TransportZoneListResult;

import org.apache.http.HttpHost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sample {

    public static void main(String[] args) {

        System.setProperty("https.proxyHost","localhost");
        System.setProperty("https.proxyPort","5001");

        HttpHost myProxy = new HttpHost("localhost", 5001, "http");
        HttpClientBuilder.create().useSystemProperties().setProxy(myProxy).build();

        ApiClient apiClient = ApiClientUtils.createApiClient(
                "https://100.107.89.169:443",
                "admin",
                get_password("gopass PKS/NSX-T/admin").toCharArray()
        );

        TransportZones zoneService = apiClient.createStub(TransportZones.class);

        TransportZoneListResult zones = zoneService.list(null, null, null, null, null, null);
        System.out.println("Initial list of transport zones - " + zones.getResultCount() + " zones");
        System.out.println(zones);
    }

    private static String get_password(String command) {
        try {
            Runtime r = Runtime.getRuntime();
            Process p = r.exec(command);
            p.waitFor();
            BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));

            return b.readLine();
        } catch(Exception e) { }

        return "";
    }
}

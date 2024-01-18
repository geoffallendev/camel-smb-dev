package com.redhat.geoallen;

import java.io.IOException;
import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import com.hierynomus.smbj.share.File;

import io.quarkus.logging.Log;

/**
 * A Camel Java DSL Router
 */
public class SMBRouteBuilder extends RouteBuilder {

    /**
     * Let's configure the Camel routing rules using Java code...
     */
    public void configure() {

        //from("smb://geoallen-mac.attlocal.net?username=geoallen&path=/smb-share")
        from("smb://geoallen-mac.attlocal.net/smb-share?password=xxxxx&username=geoallen")
        //from("smb:%s/%s?username=%s&password=%s&path=/")
            .step().setBody(constant("Successfully connected to SMB Server"))
            .process(this::process)
            //.to("mock:result")
            .log("Connected to SMB: ${body}");
    }


    private void process(Exchange exchange) throws IOException {
    final File file = exchange.getMessage().getBody(File.class);
    try (InputStream inputStream = file.getInputStream()) {
        Log.info("Read exchange: {}, with contents: {}" + file.getFileInformation() + new String(inputStream.readAllBytes()));
    }
}


  

}
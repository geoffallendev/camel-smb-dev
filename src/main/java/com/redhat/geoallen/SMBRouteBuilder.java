package com.redhat.geoallen;

import java.io.IOException;
import java.io.InputStream;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import com.hierynomus.smbj.share.File;

import io.quarkus.logging.Log;

public class SMBRouteBuilder extends RouteBuilder {

  @Override
  public void configure() {

    from("smb://{{smb.host}}:{{smb.port:445}}/{{smb.share}}?username={{smb.username}}&password=RAW({{smb.password}})&delay=5000")
      .log("Processing file [${body}]")
      .process(this::process)
    ;
  }

  private void process(Exchange exchange) throws IOException {

    final File file = exchange.getMessage().getBody(File.class);
    try (InputStream inputStream = file.getInputStream()) {
      Log.info(String.format("Read exchange: [%s], with contents: [%s]", file.getFileName(), new String(inputStream.readAllBytes())));
    }
  }
}

# camel-smb-demo

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Getting Started

https://quarkus.io/get-started/

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/camel-smb-demo-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Camel Core ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/core.html)): Camel core functionality and basic Camel languages: Constant, ExchangeProperty, Header, Ref, Simple and Tokenize


- Quarkus Config - https://quarkus.io/guides/config-reference

## Goals
    1. Establish Java/Quarkus Development Environment

    2.  Configuration Example for Pre-Release versions Camel-SMB Component 
        1. Properly Configured with Community Versions of Quarkus and Camel
        2. Quarkus 3.6.6
        3. Camel 4.3
        4. Camel-SMB 4.3

    3. Demostrate Quarkus Dev Mode and Application Properties

    4. Collaborate on connectivity to SMB Share - Update URL

    5. Build Executable Jar

    6. Build Container 
    






## Current Exception

2024-01-19 17:34:14,055 WARN  [org.apa.cam.com.smb.SmbConsumer] (Camel (camel-1) thread #1 - smb://ZENGACLOUD/smb-user) Failed polling endpoint: smb://ZENGACLOUD/smb-user. Will try again at next poll. Caused by: [java.net.BindException - Can't assign requested address]: java.net.BindException: Can't assign requested address
        at java.base/sun.nio.ch.Net.connect0(Native Method)
        at java.base/sun.nio.ch.Net.connect(Net.java:579)
        at java.base/sun.nio.ch.Net.connect(Net.java:568)
        at java.base/sun.nio.ch.NioSocketImpl.connect(NioSocketImpl.java:588)
        at java.base/java.net.Socket.connect(Socket.java:633)
        at com.hierynomus.protocol.commons.socket.ProxySocketFactory.createSocket(ProxySocketFactory.java:87)
        at com.hierynomus.protocol.commons.socket.ProxySocketFactory.createSocket(ProxySocketFactory.java:63)
        at com.hierynomus.smbj.transport.tcp.direct.DirectTcpTransport.connect(DirectTcpTransport.java:95)
        at com.hierynomus.smbj.connection.Connection.connect(Connection.java:139)
        at com.hierynomus.smbj.SMBClient.getEstablishedOrConnect(SMBClient.java:96)
        at com.hierynomus.smbj.SMBClient.connect(SMBClient.java:83)
        at org.apache.camel.component.smb.SmbConsumer.poll(SmbConsumer.java:48)
        at org.apache.camel.support.ScheduledPollConsumer.doRun(ScheduledPollConsumer.java:203)
        at org.apache.camel.support.ScheduledPollConsumer.run(ScheduledPollConsumer.java:117)
        at java.base/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:539)
        at java.base/java.util.concurrent.FutureTask.runAndReset(FutureTask.java:305)
        at java.base/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:305)
        at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
        at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
        at java.base/java.lang.Thread.run(Thread.java:833)
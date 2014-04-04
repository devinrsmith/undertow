package dsmith;

import io.undertow.Undertow;
import io.undertow.server.handlers.resource.FileResourceManager;

import java.io.File;
import java.io.IOException;

import static io.undertow.Handlers.resource;

public class App {
    public static void main(String[] args) throws IOException {
        final Undertow server = Undertow.builder()
                .addHttpListener(Integer.parseInt(args[1]), "localhost")
                .setHandler(resource(new FileResourceManager(new File(args[0]), 100))
                        .setDirectoryListingEnabled(true))
                .build();
        server.start();
    }
}

package jmpjct;

/*
 * Java Mysql Proxy
 * Main binary. Just listen for connections and pass them over
 * to the proxy module
 */

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;
import java.io.FileInputStream;

public class JMP {
    public static Properties config = new Properties();

    public static int proxyPort;
    public static String proxyHost;
    public static int port;
    public static String host;

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));

        InputStream resourceAsStream = JMP.class.getClassLoader().getResourceAsStream("conf/jmp.properties");
        JMP.config.load(resourceAsStream);

        Logger logger = Logger.getLogger("JMP");

        resourceAsStream = JMP.class.getClassLoader().getResourceAsStream("conf/log.conf");
        PropertyConfigurator.configure(resourceAsStream);

        for (String arg : args) {
            if (arg.startsWith("--proxyHost")) {
                String[] argPieces = arg.split("=");
                proxyHost = argPieces[1];
            } else if (arg.startsWith("--proxyPort")) {
                String[] argPieces = arg.split("=");
                proxyPort = Integer.parseInt(argPieces[1]);
            } else if (arg.startsWith("--host")) {
                String[] argPieces = arg.split("=");
                host = argPieces[1];
            } else if (arg.startsWith("--port")) {
                String[] argPieces = arg.split("=");
                port = Integer.parseInt(argPieces[1]);
            }
        }

        new jmpjct.JMP_Thread(proxyPort).run();
    }
}

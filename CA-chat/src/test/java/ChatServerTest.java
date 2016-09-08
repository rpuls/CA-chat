

import dummyclient.Client;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import server.ChatServer;

/**
 *
 * @author cherr
 */
public class ChatServerTest {
    public static Client c;
    public ChatServerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String[] args = new String[2];
                args[0] = "localhost";
                args[1] = "7777";
                ChatServer.main(args);
            }
        }).start();
        c = new Client("localhost",7777,
        new Runnable(){
            @Override
            public void run() {
                String[] args = new String[2];
                args[0] = "localhost";
                args[1] = "7777";
                ChatServer.main(args);
            }
        });
    }
    
    @AfterClass
    public static void tearDownClass() {
        ChatServer.stopServer();
    }
    
//    
//    @Test
//    public void runServerThruMainTest(){
//        String[] args = new String[2];
//        args[0] = "localhost";
//        args[1] = "7777";
//        ChatServer.main(args);
//        assertTrue(ChatServer.keepRunning);
//    }
    
//    @Test
//    public void 

}

package hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.config.NearCacheConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.io.FileNotFoundException;


public class ClientDeclarativeConfigurationExample {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            ClientDeclarativeConfigurationExample obj = new ClientDeclarativeConfigurationExample();
//			obj.initHzServer();
//			Thread.sleep(5000);
            obj.initHzClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initHzClient() {
        Thread t = new Thread(() -> {
            try {
//				System.out.println("Working Directory = " + System.getProperty("user.dir"));
//				Path pathOfFile = Paths.get(System.getProperty("user.dir") + "/custom-path/hazelcast-client.xml");
//				ClientConfig config = new XmlClientConfigBuilder(
//						newInputStream(pathOfFile)).build();
//				System.out.println("config..............." + config);
                ClientConfig config = new ClientConfig();
//                config.setClusterName("dev");
                config.setClusterName("game");

                // network configuration
                ClientNetworkConfig networkConfig = config.getNetworkConfig();
                networkConfig.addAddress("194.233.93.111:15701");
//                networkConfig.addAddress("127.0.0.1:5701");
//				networkConfig.addAddress("127.0.0.1:5702");
//				networkConfig.addAddress("127.0.0.1:5703");
//                networkConfig.addAddress("154.26.133.227:15701");
//                networkConfig.addAddress("154.26.133.227:15702");
//                networkConfig.addAddress("154.26.133.227:15703");
                config.setNetworkConfig(networkConfig);
                config.getNetworkConfig().setSmartRouting(false);
                config.setInstanceName("zzzzzzzzzzzz");
//                config.addNearCacheConfig(new NearCacheConfig("userMap2"));

                HazelcastInstance hz = HazelcastClient.newHazelcastClient(config);

                System.out.println("Hz client started");

                long startTime = System.currentTimeMillis();

                IMap<Integer, User> userMap = hz.getMap("userMap");

                long stopTime = System.currentTimeMillis();

                System.out.println("Hz client started put");
                long startTimePut = System.currentTimeMillis();
                for (int i = 0; i < 10000; i++) {
                   userMap.put(i, User.builder().name(String.valueOf(i)).age(i).address("somethings address" + i).build());
                }
                long stopTimePut = System.currentTimeMillis();
                System.out.println("timePut.............." + String.valueOf(stopTimePut  - startTimePut));

//                myMap.forEach((k, v) -> {
//                    System.out.println("key: " + k + " value: " + v);
//                });
//                userMap.forEach((k, v) -> {
//                    System.out.println("key: " + k + " value: " + v);
//                });
//                User user = userMap.get(1);
//                System.out.println("user..
//                ............" + user);
                System.out.println("time.............." + String.valueOf(stopTime - startTime));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
    }

}


package hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.XmlClientConfigBuilder;
import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class DeclarativeConfWithCustomPath {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			DeclarativeConfWithCustomPath obj = new DeclarativeConfWithCustomPath();
			obj.initHzServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initHzServer() {
		Thread t = new Thread(() -> {
			try {
				Config config = new XmlConfigBuilder(
						new FileInputStream(new File("/Users/shandilya/Documents/Programming/hazelcast-tutorial/custom-path/hazelcast.xml"))).build();
				HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
				
				IMap<Integer, String> myMap = hz.getMap("myMap");
				myMap.put(1, "test1");
				myMap.set(2, "test2");
				myMap.entrySet().forEach(System.out::println);
				
				System.out.println("initHzServer successful");
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		t.start();
	}
}

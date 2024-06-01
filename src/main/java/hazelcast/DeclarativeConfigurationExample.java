package hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.XmlConfigBuilder;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class DeclarativeConfigurationExample {
	
	public static void main(String[] args) throws FileNotFoundException {
		Config config = new XmlConfigBuilder(new FileInputStream(new File(
				"/Users/shandilya/Documents/Programming/hazelcast-tutorial/custom-path/hazelcast.xml"))).build();
		HazelcastInstance     hz    = Hazelcast.newHazelcastInstance(config);
		IMap<Integer, String> myMap = hz.getMap("myMap");
		myMap.put(1, "test");
		myMap.put(1, "test1");
		myMap.set(2, "test2");
		
		for (Map.Entry<Integer, String> e : myMap.entrySet()) {
			System.out.println(e.getKey() + ": " + e.getValue());
		}
	}
}

package hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.EntryListenerConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Map;

public class ProgrammaticConfigurationExample {
	
	public static void main(String[] args) {
		
		MapConfig mapConfig = new MapConfig("myMap");
		mapConfig.setBackupCount(2);
		mapConfig.setAsyncBackupCount(2);
		mapConfig.addEntryListenerConfig(new EntryListenerConfig("Hazelcast.HazelcastTutorial.MyMapListener", false, true));
		
		Config config = new Config();
		config.addMapConfig(mapConfig);
		
		HazelcastInstance     hz    = Hazelcast.newHazelcastInstance(config);
		IMap<Integer, String> myMap = hz.getMap("myMap");
		myMap.set(1, "test");
		for (Map.Entry<Integer, String> e : myMap.entrySet()) {
			System.out.println(e.getValue());
		}
	}
	
}

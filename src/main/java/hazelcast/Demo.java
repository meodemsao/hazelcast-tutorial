package hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Map;

public class Demo {
	
	public static void main(String[] args) {
		
		HazelcastInstance     hz    = Hazelcast.newHazelcastInstance(null);
		IMap<Integer, String> myMap = hz.getMap("myMap");
		
		for (int i = 0; i < 5; i++) {
			myMap.put(i, "Value " + i);
		}
		for (Map.Entry<Integer, String> e : myMap.entrySet()) {
			System.out.println("Key : " + e.getKey() + " Value : " + e.getValue());
		}
	}
}

package hazelcast.deployment;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HzClient {
	public static void main(String[] args) {
		HazelcastInstance      client = HazelcastClient.newHazelcastClient();
		IMap<Integer, Integer> map    = client.getMap("mymap");
		
		map.put(1, 1);
		map.put(2, 2);
		map.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
	}
}

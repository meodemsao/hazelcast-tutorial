package hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class MyHazelcastClient {
	
	public static void main(String[] args) {
		
		HazelcastInstance     hz    = HazelcastClient.newHazelcastClient();
		IMap<Integer, String> myMap = hz.getMap("myMap");
		
		try {
			myMap.set(1, "sample");
		} catch (Exception exception) {
			System.out.println("Exception in client : " + exception);
		}
	}
	
}

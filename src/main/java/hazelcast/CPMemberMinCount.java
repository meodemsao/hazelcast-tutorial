package hazelcast;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class CPMemberMinCount {
	public static void main(String[] args) {
		new CPMemberMinCount().start();
	}
	
	public void start() {
		try {
			int hzMemberCount = 3;
			while (hzMemberCount-- > 0) {
				HazelcastInstance hz = Hazelcast.newHazelcastInstance();
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

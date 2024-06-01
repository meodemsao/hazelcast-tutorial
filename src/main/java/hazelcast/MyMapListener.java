package hazelcast;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.EntryUpdatedListener;

public class MyMapListener
		implements EntryAddedListener<Integer, String>, EntryUpdatedListener<Integer, String>, EntryRemovedListener<Integer, String> {
	
	public void entryRemoved(EntryEvent<Integer, String> event) {
		System.out.println("Entry Removed Called");
	}
	
	public void entryUpdated(EntryEvent<Integer, String> event) {
		System.out.println("Entry Updated Called");
	}
	
	public void entryAdded(EntryEvent<Integer, String> event) {
		System.out.println("Entry Added Called");
	}
}

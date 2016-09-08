
public class CustomHashMap<K,V> {
	
	private Entry<K,V>[] table; //array of Entry
	private int capacity = 10; //initial capacity
	
	static class Entry<K,V>
	{
		K key;
		V value;
		Entry<K,V> next;
		
		public Entry(K key, V value, Entry<K,V> next)
		{
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	@SuppressWarnings("unchecked")
	public CustomHashMap()
	{
		table = new Entry[capacity];
	}

	private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }
	
	public void put(K newKey, V data)
	{
		if(newKey == null)
			return;
		int hash = hash(newKey);
		Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
		
		if(table[hash] == null)
		{
			table[hash] = newEntry;
		}
		
		else
		{
			Entry<K,V> prev = null;
			Entry<K,V> current = table[hash];
			
			while(current!=null)
			{
				if(current.key.equals(newKey)){
					if(prev == null)
					{
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					}
					else
					{
						newEntry.next = current.next;
						prev.next = newEntry;
						return;
					}
				}
				prev = current;
				current = current.next;
			}
			prev.next = newEntry;
	
		}
		
	}
	
	public V get(K key)
	{
		int hash = hash(key);
		if(table[hash]==null)
			return null;
		else
		{
			Entry<K,V> temp = table[hash];
			while(temp!=null)
			{
				if(temp.key.equals(key))
				{
					return temp.value;
					
				}
				temp = temp.next;
			}
			return null;
		}
	}
	
	public boolean delete(K deleteKey)
	{
		int hash = hash(deleteKey);
		if(table[hash] == null)
			return false;
		
		else
		{
			Entry<K,V> prev = null;
			Entry<K,V> current = table[hash];
			
			while(current != null)
			{
				if(current.key.equals(deleteKey))
				{
					if(prev == null)
					{
						table[hash] = table[hash].next;
						return true;
					}
					else
					{
						prev.next = current.next;
						return true;
					}
					
					
				}
				prev=current;
				current = current.next;
				
			}
			return false;
		}
	}
}

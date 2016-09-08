import java.io.*;
import java.util.*;
import java.util.Map.Entry;

//Sorting hashmap by key and value

public class SortMap {
	
	public static ArrayList<String> sortMaps(HashMap<String,String> empMap)
	{
		Set<String> tset = new TreeSet<String>();
		tset.addAll(empMap.keySet()); //sort by keys
		tset.addAll(empMap.values()); //sort by values; not viable as values can repeat
		Map<String,String> tmap = new TreeMap<String,String>(empMap);
				
		return new ArrayList<String>(tmap.keySet());
	}
	
	//public static LinkedHashMap
	public static void sortMaps2(HashMap<String,String> map)
	{
		Set<Entry<String,String>> hset = map.entrySet();
		List<Entry<String,String>> hlist = new LinkedList<Entry<String,String>>(hset);
		

		Collections.sort(hlist, new Comparator<Entry<String,String>>() {

            @Override
            public int compare(Entry<String, String> ele1,
                    Entry<String, String> ele2) {
                
                return ele1.getValue().compareTo(ele2.getValue());
            }
        });
		Map<String,String> aMap2 = new LinkedHashMap<String, String>();
        for(Entry<String,String> entry: hlist) {
            aMap2.put(entry.getKey(), entry.getValue());
        }
        
        // printing values after storing of map
        System.out.println("Value " + " - " + "Key");
        for(Entry<String,String> entry : aMap2.entrySet()) {
            System.out.println(entry.getValue() + " - " + entry.getKey());
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> h1 = new HashMap<String, String>();
		h1.put("ab10", "Adam");
		h1.put("ab11", "John");
		h1.put("hgfh", "Jim");
		h1.put("12po", "Tom");
		h1.put("jkjk", "Jane");
		h1.put("9088", "Andy");
		h1.put("drr5", "Molly");
		h1.put("al10", "Pam");
		
		ArrayList<String> arr = sortMaps(h1);
		System.out.println(arr.toString());
		//sortMaps2(h1);

	}

}

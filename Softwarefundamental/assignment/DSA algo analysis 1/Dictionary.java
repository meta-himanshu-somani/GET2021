
import java.util.Map;

/*Q1 Define the interface for a dictionary and implement it using a binary search tree. 
 * The interface should support 
-->constructor to create a dictionary with a specified initial dictionary entries*, 
-->add a key-value pair to dictionary, 
-->delete a key value pair from the dictionary, 
-->get the value corresponding to a specified key, 
-->return sorted list of key value pairs, 
-->return the sorted list of key value pairs for all the keys >=K1 and <=K2.

*The constructor will receive a list of key value pairs to be inserted in the dictionary. The list will be provided as a JSON value.
*/
public interface Dictionary {
	public void addEntry(String key,String value );
	public void deleteEntry(String key,String value);
	public String getValue(String key);
	public Map<String,String> sortedKey(); 
	public Map<String,String> sortedKeyFrom(String key1,String key2 );

}

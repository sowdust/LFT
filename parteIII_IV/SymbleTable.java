import java.util.*;

public class SymbleTable {

	private Map<String, Type> stt = new Hashtable<String,Type>();
	private Map<String, Integer>  sta = new Hashtable<String,Integer>();

	public void insert(String s, Type t, int a) {
		if (sta.get(s)==null)		{
			stt.put(s,t);
			sta.put(s,a);
		}else{
			throw new RuntimeException("Variabile "+s+" gia dichiarata");
		}

	}

	public Type lookupType(String s) {
		if (null==stt.get(s))	throw new RuntimeException("Variabile "+s+" non dichiarata");
		Type t=stt.get(s);
		return t;
	}

	public int lookupAddress(String s) {
		if(null==sta.get(s))	throw new RuntimeException("Variabile "+s+" non dichiarata");
		return sta.get(s);
	}
}
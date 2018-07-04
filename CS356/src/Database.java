public interface Database<T> {
	
	// TODO: Decide if this is really necessary, and implement properly if so
	
	public T get(String s);
	
	public boolean contains(String s);
	
	public int addEntry(String c, T o);
	
	public boolean removeEntry(int key);
}

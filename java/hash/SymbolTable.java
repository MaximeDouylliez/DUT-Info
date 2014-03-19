
public interface SymbolTable
{
	public void put(int key, Object value) throws HashTableException;
	public Object get(int key) throws HashTableException;
	public void remove(int key) throws HashTableException;
	public boolean contains(int key);
	public int size();
}
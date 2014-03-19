
import java.util.*; // Math et Random

public class HashTable implements SymbolTable
{
	private Bucket[] bucketArray;        // Tableau contenant les paires "clé-valeur"
	private int nbrObject = 0;           // Nombre d'éléments insérés
	
	// Valeurs pour le hachage
	private int a, b, p;
	
	
	public HashTable(int size)
	{
		bucketArray = new Bucket[size];
		
		Random generator = new Random();

		p = 1073676287;
		
		a = (Math.abs(generator.nextInt()) % p)  + 1;
		b = Math.abs(generator.nextInt()) % p;
	}
	
	private int hash(String s)
	{
		int h = 0;
		
		// Etape 1 : hashcode
		for(int i = 0 ; i < s.length() ; i++)
		{
			h = (h << 5) | (h >>> 27);
			h += (int) s.charAt(i);
		}
		
		// Etape 2 : compression
		return ( Math.abs( a * h + b ) % p ) % bucketArray.length;
	}
	
	public void put(int key, Object value)
	{
		int index = hash(new Integer(key).toString());

		Entry e = new Entry(key, value);
		
		if(bucketArray[index] != null)
		{
			if(bucketArray[index].add(e))
				nbrObject++;

		}
		else
		{
			bucketArray[index] = new Bucket(e);
			nbrObject++;
		}
	}
	
	public Object get(int key) throws HashTableException
	{
		
		if(nbrObject == 0)
			throw new HashTableException("Table vide.");
			
		int index = hash(new Integer(key).toString());
		
		if(bucketArray[index] == null || bucketArray[index].getNbrNode() == 0)
			throw new HashTableException("Clée non trouvée");
		
		Node n = bucketArray[index].get(key);
		
		if(n != null)
			return n.getValue();
		else
			throw new HashTableException("Clée non trouvée");
	}
	
	public void remove(int key) throws HashTableException
	{
		if(nbrObject == 0)
			throw new HashTableException("Table vide.");
			
		int index = hash(new Integer(key).toString());
		
		if(bucketArray[index] == null)
			throw new HashTableException("Clée non trouvée");
		
		bucketArray[index].remove(key);
		nbrObject--;
	}
	
	public boolean contains(int key)
	{
		if(nbrObject == 0)
			return false;
			
		int index = hash(new Integer(key).toString());
		Bucket b = bucketArray[index];
		
		return (b != null && b.contains(key));
	}
	
	public int size()
	{
		return nbrObject;
	}
}
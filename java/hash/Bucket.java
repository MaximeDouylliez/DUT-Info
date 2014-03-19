
public class Bucket
{
	private int nbrNode = 0;

	private Node list;
	
	public Bucket(Entry e)
	{
		this.list = new Node(e);
	}
	public Node getFirstNode()
	{
		if(list == null || nbrNode == 0)
			return null;
		
		Node newList = list.getNext();
		
		if(newList != null)
			newList.setPrev(null);
		
		list = newList;
		nbrNode--;
		return list;
	}
	public boolean add(Entry e)
	{
		Node n = get(e.getKey());

		if(n != null) // Si la clé est déjà dans la liste, on change la valeur
		{ 
			n.setValue(e.getValue());
			return false;
		}

		// Si la clé n'est pas dans la liste, on ajoute un noeud
		
		nbrNode++;
		Node v = new Node(e, list); // Nouveau noeud, future tête de liste
			
		if(list != null) // S'il y a déjà un noeud en tête, on met à jour la référence prev
			list.setPrev(v);
			
		list = v; // Mise à jour de la tête de liste
			
		return true;
	}
	
	public void remove(int key) throws HashTableException
	{
		Node n = get(key);
		
		if(n == null)
			throw new HashTableException("Clé non trouvée.");
		
		nbrNode--;
		
		if(n.getPrev() != null) // Si le noeud est dans la liste
			n.getPrev().setNext(n.getNext());
		else // Si le noeud est le premier de la liste
			list = n.getNext();
		
		if(n.getNext() != null)
			n.getNext().setPrev(n.getPrev());
	}
	
	public Node get(int key)
	{
		Node n = list;
		
		while(n != null && n.getKey() != key)
			n = n.getNext();
		return n;
	}
	
	public boolean contains(int key)
	{
		return (get(key) != null);
	}
	
	public int getNbrNode()
	{
		return nbrNode;
	}
}

public class Node
{
	private Entry entry;
	private Node next, prev;
	
	public Node(Entry entry)
	{
		this(entry, null);
	}
	
	public Node(Entry entry, Node next)
	{
		this.entry = entry;
		this.next = next;
		this.prev = null;
	}
	
	// Accesseurs
	public int getKey() 		{ return entry.getKey();   }
	public Object getValue()	{ return entry.getValue(); }
	public Node getNext()		{ return next;  }
	public Node getPrev()		{ return prev;  }
	
	// Mutateurs
	public void setValue(Object value)  { entry.setValue(value); }
	public void setNext(Node next) 		{ this.next = next;      }
	public void setPrev(Node prev) 		{ this.prev = prev;      }
}
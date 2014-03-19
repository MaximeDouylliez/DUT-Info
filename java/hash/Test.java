
public class Test
{
	public static void main(String[] argv) throws Exception
	{
		HashTable table = new HashTable(4);

		for(int i = 0 ; i < 15 ; i++)
		{
			System.out.println("Ajout de " + i);
			table.put(i, new Integer(i));
		}
	}
}
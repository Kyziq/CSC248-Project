public class LinkedList
{
	private Node first;
	private Node last;
	private Node current;

	public LinkedList()
	{
		first = null;
		last = null;
		current = null;
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	public void insertAtFront(Object data)
	{
		Node newNode = new Node(data);
		if (isEmpty())
		{ first = newNode;
		last = newNode;
		}
		else
		{
			newNode.next = first;
			first = newNode;
		}
	}
	public void insertAtBack(Object data)
	{
		Node newNode = new Node(data);
		if (isEmpty())
		{ first = newNode;
		last = newNode;
		}
		else
		{
			last.next = newNode;
			last = newNode;
		}
	}

	public Object removeFromFront()
	{
		Object removeItem = null;
		if (isEmpty())
		{
			return removeItem;
		}
		removeItem = first.data;
		if ( first == last)
		{
			first = null;
			last = null;
		}
		else
			first = first.next;
		return removeItem; }

	public Object removeFromBack()
	{
		Object removeItem = null;
		if (isEmpty())
		{
			return removeItem;
		}
		removeItem = last.data;
		if ( first == last)
		{
			first = null;
			last = null;
		}
		else
		{
			current = first;
			while (current.next != last)
				current = current.next;
			last = current;
			last.next = null;
		}
		return removeItem; }

	public Object getFirst()
	{
		if (isEmpty())
			return null;
		else
		{
			current = first;
			return current.data;
		}
	}

	public Object getNext()
	{
		if (current == last)
			return null;
		else
		{
			current = current.next;
			return current.data;
		}
	}

	public void deleteNode(int key) 
	{
		Node temp = first, prev=null;

		// If head node itself holds the key to be deleted
		if(temp != null && temp.data.equals(Integer.valueOf(key)))
		{
			first = temp.next;
			return;
		}

		// Search for the key to be deleted, keep track of
		// the previous node as we need to change temp.next
		while(temp !=null && !temp.data.equals(Integer.valueOf(key)))
		{
			prev =temp;
			temp = temp.next;
		}
		
		// If key was not present in linked list
		if(temp == null)
		{
			return;
		}
		
		//Unlink the node from Linked List
		prev.next = temp.next;
	}

}

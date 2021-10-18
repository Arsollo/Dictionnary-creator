//----------------------------------------------------
//Assignment #4
//Written by: Arsany Fahmy (40157267)
//----------------------------------------------------
public class CellList 
{
	private CellNode head;
	private int size;
	
	//default constructor
	public CellList()
	{
		head = null;
	}
	
	//copy constructor
	public CellList (CellList cop)
	{
		head = cop.head;
	}
	
	//add to start 
	public void addToStart(CellPhone obj)
	{
		head = new CellNode(obj,head);
	}
	
	public void insertAtindex(CellPhone obj, int index)
	{
		
	}
	
	
	
	
	
	
	
	
	//CellNode inner class
	private class CellNode
	{
		private CellPhone cell;
		private CellNode node;
		
		//constructor
		public CellNode()
		{
			cell = null;
			node = null;
		}
		
		//constructor
		public CellNode(CellPhone cellphone, CellNode ob)
		{
			cell = cellphone;
			node = ob;
		}
			
		
		//Copy constructor
		public CellNode (CellNode cop)
		{
			cell = cop.cell;
			node = cop.node;
		}
		
		//clone
		public Object clone() 
		{ 
			try {
				return super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Eroor couldn't clone ";
			}
		}

		
		//Getters and Setters
		public CellPhone getCell() 
		{
			return cell;
		}

		public void setCell(CellPhone cell) 
		{
			this.cell = cell;
		}

		public CellNode getObj() 
		{
			return node;
		}

		public void setObj(CellNode obj) 
		{
			this.node = obj;
		}
		
		
		
		
		
	}
}

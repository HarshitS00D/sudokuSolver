import java.util.*;
class Main
{	
	public int[][] s={{1,2,3,4,5,6,7,8,9},
					  {4,5,6,7,8,9,1,2,3},
					  {7,8,9,1,2,3,4,5,1},
					  {2,1,4,3,6,5,8,9,7},
					  {3,6,5,8,9,7,2,1,4},
					  {8,9,7,2,1,4,3,6,5},
					  {5,3,1,6,4,2,9,7,8},
					  {6,4,2,9,7,8,5,3,1},
					  {9,7,8,5,3,1,6,4,2}};

	public void print()
	{
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(s[i][j]+" ");
			}
			System.out.println();
		}

	}
	public boolean solve(int r,int c)
	{
		if(c==9)
		{
			r++; c=0;
		}
		if(r==9)
			return true;
		
		if(s[r][c]==0)
		{
			for(int i=1;i<10;i++)
			{
				if(checkrow(r,c,i) && checkcol(r,c,i) && checksubgrid(r,c,i))
				{
					s[r][c]=i;
					if(solve(r,c+1))
						return true;
				}

			}
		}
		else return solve(r,c+1);

		s[r][c]=0;
		return false;
	}
	
	public boolean checkrow(int r,int c,int k)
	{
		for(int i=0;i<9;i++)
		{
			if(i==c)
			continue;
			if(s[r][i]==k)
				return false;
		}
		return true;
	}
	public boolean checkcol(int r,int c,int k)
	{
		for(int i=0;i<9;i++)
		{
			if(i==r)
				continue;
			if(s[i][c]==k)
				return false;
		}
		return true;
	}
	public boolean checksubgrid(int r,int c,int k)
	{
		int x=r-r%3;
		int y=c-c%3;
		for(int i=x;i<x+3;i++)
		{
			for(int j=y;j<y+3;j++)
			{
				if(i==r&&j==c)
					continue;
				if(s[i][j]==k)
					return false;
			}
		}
			return true;
	}
	
	public boolean checkInput()
	{
		for(int i=0;i<9;i++)
		 {
		 	for(int j=0;j<9;j++)
		 	{
		 		if(s[i][j]!=0)
		 		{
		 			if(checkrow(i,j,s[i][j])&&checkcol(i,j,s[i][j])&&checksubgrid(i,j,s[i][j]))
		 			{
		 				continue;
		 			}
		 			return false;
		 		}
		 	}
		 }
		 return true;
	}
	public static void main(String[] args)
	{
		
		 Main ob=new Main();
		 
		 if(ob.checkInput())
		 {
		 	if(ob.solve(0,0))
			{
			ob.print();
			}
			else 
			System.out.print("Not Possible");
		 }
		 else System.out.print("Wrong Input");
		
		
	}

}
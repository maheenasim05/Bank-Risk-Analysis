/*Name:                Maheen Asim
 * 
 *Project Description: This project is called 'Bank Risk Analysis' which takes input from the user about 
 *					   the bank's details such as number of banks, the limit of these banks and which bank has
 *					   borrowed a certain amount of loan from a specific bank. The program's purpose is to 
 *					   find out which bank is unsafe by comparing the total asset of a bank with the limit 
 *					   provided by the user.
 *
 *Start Date: 		   15th February, 2024
 *End Date:            14th March, 2024 //3
10000
5000 2 1 3000 2 3000
12000 1 2 10000
8000 0
 *
 **/

package project1;
import java.util.Scanner;


public class Banks
{

	static Scanner scnr = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		
		
		System.out.println("Enter the number of banks: ");
		int n = scnr.nextInt(); 										//input number of banks
		
		System.out.println("Enter the limit of the banks: ");
		double limit = scnr.nextDouble(); 								//input the limit of the banks
		
		double [] balances = new double [n]; 							//a 1D array of balances of the banks 
		double [][]	borrowers = new double [n][n]; 						// a 2D array of the loans given to the borrowers
		
		
		getInfo(n,borrowers,balances); 									//calling the method
		
		isUnsafe(n,limit,balances,borrowers); 							//calling the method
		
	}
	
	public static void getInfo(int n, double[][] borrowers, double [] balances ) //a method to get the bank information from the user
	{ 
																		
		for (int i=0; i<n; i++)
		{
			System.out.println("Enter this bank's balance: ");
			balances[i] = scnr.nextDouble(); 							//input: this bank's balance
			
			System.out.println("Enter the number of borrowers for this bank:");
			int numberOfBorrowers = scnr.nextInt(); 					//input: no. of borrowers for this bank
			
			for (int k=0; k<numberOfBorrowers; k++)
			{
				System.out.println("Enter the borrower's ID: ");
				int borrowerId = scnr.nextInt(); 						//input: borrower IDs for this bank's borrowers
				
				System.out.println("Enter the loan amount:");
				borrowers[i][borrowerId] = scnr.nextDouble(); 			//input: the loan given to this borrower
			}	
		}
	}
	
	
	
	public static void isUnsafe(int n, double limit, double[]balances, double[][]borrowers)
	{
		 																//to check and print the unsafe banks
		boolean [] isSafe = new boolean [n];					
		boolean unsafeFound = true;										
		int nOfBanks = 0;												//number of banks that are unsafe			
		
		
		for (int i=0; i<n; i++)
		{
			isSafe[i]=true; 											//all banks are safe initially
		}
		
		while(unsafeFound) 
		{
			unsafeFound = false;
			for (int i=0; i<n; i++)
			{
				
				double totalAsset = calcAssets(i,n,balances,borrowers); //calling the method
			
				if(isSafe[i] && totalAsset<limit)						//if the bank is true and total assets is less than the limit provided
				{
					isSafe[i] = false;									//the bank is unsafe
					unsafeFound = true;									//unsafe bank found
					nOfBanks++;											//number of unsafe banks increases by 1
				
				
					for(int k=0; k<n; k++) 								//removing bank i which is unsafe
					{ 
						borrowers[k][i] =0; 							//Bank i's borrowed loans are removed
					}
				}
			}
		}
		
		if(nOfBanks>0)
		{
			System.out.print("Unsafe banks are ");
			for (int i=0; i<n; i++)
			{
				if(!isSafe[i]) 											//if bank is unsafe
				{
					System.out.print(i+" ");							//print bank number
				}
			}
		}
			
			
		
		
	}
	
	public static double calcAssets(int bankID,int n,double[]balances, double[][]borrowers) 
	{
																		//calculating the total assets of the bank
		double totalAssets = 0;											//total assets is initially zero
		
		totalAssets += balances[bankID];								//total assets + balances
		for(int i=0; i<n; i++)
		{
			totalAssets += borrowers[bankID][i];						//total assets + loan borrowed
		}
		
		return totalAssets;												//returning value of totalAssets to the variable when the method is called
	}
	
}

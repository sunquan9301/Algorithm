package com.sun.Algorithm;

import java.util.Scanner;

public class MaxSequence {

	public int row;
	public int column;
	public int fixNumber;
	public int operations;
	public int[][] data;
	public int[] rowSum;
	public int[] columnSum;
	public int singleRowSum;
	public int singleColumnSum;
	public int allSum=0;   
	public int maxIndexRow;
	public int maxIndexColumn;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxSequence m=new MaxSequence();
		m.init();
		m.calSum();
		m.process();
		System.out.println(m.allSum);
	}
	public void process()
	{
		int count=0;
		while(count<operations)
		{
			int[] signs=singleOperator();
			if(signs[0]==-1)
			{
				break;
			}
			if(signs[0]==0)
			{//替换行
				allSum=allSum+singleRowSum-signs[2];
				int rowLine=signs[1];
			
				//更新行值
				rowSum[rowLine]=singleRowSum;
				//更新列值
				for (int i = 0; i < columnSum.length; i++) {
					columnSum[i]=columnSum[i]+fixNumber-data[rowLine][i];
				}
				//修改数据
				for (int i = 0; i < column; i++) {
					data[rowLine][i]=fixNumber;
				}
			}else {
				//替换列
				allSum=allSum+singleColumnSum-signs[2];
				int columnLine=signs[1];
				
				//更新列值
				columnSum[columnLine]=singleColumnSum;
				//更新行值
				for (int i = 0; i < rowSum.length; i++) {
					rowSum[i]=rowSum[i]+fixNumber-data[i][columnLine];
				}
				for (int i = 0; i <row; i++) {
					data[i][columnLine]=fixNumber;
				}
			}
		}
	}
	public int[] singleOperator()
	{
		//行返回0，列返回1，否则返回-1；
		int[] result=new int[3]; //0标志，1索引，2值
		int rowMinIndex=0,rowMinValue=rowSum[0],columnMinIndex=0,columnMinValue=columnSum[0];
		for (int i = 0; i < rowSum.length; i++) {
			if(rowSum[i]<rowMinValue){
				rowMinIndex=i;
				rowMinValue=rowSum[i];
			}
		}
		
		for (int i = 0; i < columnSum.length; i++) {
			if(columnSum[i]<columnMinValue)
			{
				columnMinIndex=i;
				columnMinValue=columnSum[i];
			}
		}
		if(rowMinValue<singleRowSum||columnMinValue<singleColumnSum)
		{
			if((singleRowSum-rowMinValue)>(singleColumnSum-columnMinValue))
			{
				//行大
				if(rowMinIndex==maxIndexRow)
				{
					result[0]=1;
					result[1]=columnMinIndex;
					result[2]=columnMinValue;
				}
				else{
					result[0]=0;
					result[1]=rowMinIndex;
					result[2]=rowMinValue;
				}
			}else{
				//列里面
				if(columnMinIndex==maxIndexColumn)
				{
					result[0]=0;
					result[1]=rowMinIndex;
					result[2]=rowMinValue;
				}else{
					result[0]=1;
					result[1]=columnMinIndex;
					result[2]=columnMinValue;
				}
			}
		}else{
			result[0]=-1;
		}
		return result;
	}
	public void calSum(){
		for (int i = 0; i < rowSum.length; i++) {
			rowSum[i]=0;
			for (int j = 0; j < column; j++) {
				rowSum[i]+=data[i][j];
			}
		}
		for (int i = 0; i < column; i++) {
			columnSum[i]=0;
			for (int j = 0; j < row; j++) {
				columnSum[i]+=data[j][i];
			}
		}
	}
	public void init()
	{
		Scanner cin=new Scanner(System.in);
		this.row=Integer.parseInt(cin.nextLine());
		this.column=Integer.parseInt(cin.nextLine());
		this.fixNumber=Integer.parseInt(cin.nextLine());
		this.operations=Integer.parseInt(cin.nextLine());
		data=new int[row][column];
		rowSum=new int[row];
		columnSum=new int[column];
		for (int i = 0; i < this.row; i++) {
			String[] strs=cin.nextLine().split(" ");
			for (int j = 0; j < column; j++) {
				data[i][j]=Integer.parseInt(strs[j]);
				allSum+=data[i][j];
			}
		}
		cin.close();
		singleRowSum=fixNumber*column;
		singleColumnSum=fixNumber*row;
		maxIndexColumn=0;
		maxIndexRow=0;
		int maxValue=data[0][0];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				if(maxValue<data[i][j])
				{
					maxValue=data[i][j];
					maxIndexColumn=j;
					maxIndexRow=i;
				}
			}
		}
	}
}

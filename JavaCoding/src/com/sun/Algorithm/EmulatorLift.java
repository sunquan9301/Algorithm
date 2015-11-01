package com.sun.Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EmulatorLift {
	public ArrayList<People> peoples=new ArrayList<People>();
	public int nowFloor;
	public int nowTime;
	public int pup;
	public int pdown;
	public HashMap<Integer,ArrayList<People>> peopleInfor=new HashMap<Integer,ArrayList<People>>();
	public void init()
	{
		int applyNumbers,liftFloors;
		Scanner cin=new Scanner(System.in);
		applyNumbers=cin.nextInt();
		liftFloors=cin.nextInt();
		int i=0;
		while(i<applyNumbers)
		{
			peoples.add(new People(cin.nextInt(), cin.nextInt(), cin.nextInt(), false));
			i++;
		}
		cin.close();
		nowFloor=0;
		nowTime=0;
	}
//	public void processInfo()
//	{
//		for (int i = 0; i < peoples.size(); i++) {
//			People peo=peoples.get(i);
//			if(peopleInfor.get(peo.sourceFloor)==null)
//			{
//				ArrayList<People> floorPeo=new ArrayList<People>();
//				floorPeo.add(peo);
//				peopleInfor.put(peo.sourceFloor, floorPeo);
//			}else{
//				peopleInfor.get(peo.sourceFloor).add(peo);
//			}
//		}
//	}
	public void run()
	{
		while(true)
		{
			if(checkIsRun()){
				//能运行
				getInLift();           //进电梯
				int[] result=calcPuPAndPdown();
				pup=result[0];
				pdown=result[1];
				if(pup>=pdown)
				{
					updateLiftState(1);  //1表示往上
				}else{
					updateLiftState(0); //往下
				}
			}else{
				//不能运行
				break;
			}
		}
	}
	private void updateLiftState(int i) {
		// TODO Auto-generated method stub
		nowTime++;
		if(i==1)
		{
			nowFloor++;
		}else{
			nowFloor--;
		}
		leaveLift();
	}
	private void leaveLift() {
		// TODO Auto-generated method stub
		for (int i = 0; i < peoples.size(); i++) {
			People peo=peoples.get(i);
			if(!peo.leaveState)
			{
				if(peo.targetFloor==nowFloor)
				{
					peo.leaveLiftTime=nowTime;
					peo.leaveState=true;
				}
			}
		}
	}
	private void getInLift() {
		// TODO Auto-generated method stub
		for (int i = 0; i < peoples.size(); i++) {
			People peo=peoples.get(i);
			if(!peo.leaveState)
			{
				if(peo.applyTime<=nowTime&&peo.sourceFloor==nowFloor)
				{
					peo.isInLift=true;
				}
			}
		}
	}
	private int[] calcPuPAndPdown() {
		// TODO Auto-generated method stub
		int[] result=new int[2];
		for (int i = 0; i < peoples.size(); i++) {
			People peo=peoples.get(i);
			if(!peo.leaveState)
			{
				if(peo.isInLift)
				{
					if(peo.targetFloor>nowFloor)
					{
						result[0]++;
					}else if(peo.targetFloor<nowFloor)
					{
						result[1]++;
					}
				}else{
					if(peo.applyTime<=nowTime&&peo.sourceFloor>nowFloor)
					{
						result[0]++;
					}else if(peo.sourceFloor<nowFloor&&peo.applyTime<=nowTime)
					{
						result[1]++;
					}
				}
			}
		}
		return result;
	}
	private boolean checkIsRun() {
		// TODO Auto-generated method stub
		int inLiftNums=0;
		int outLiftNums=0;
		for (int i = 0; i < peoples.size(); i++) {
			if(!peoples.get(i).leaveState)
			{
				if(peoples.get(i).isInLift)
				{
					inLiftNums++;
				}else {
					outLiftNums++;
				}
			}
		}
		if(inLiftNums==0&&outLiftNums==0)
		{
			return false;
		}else{
			return true;
		}
	}
	public void print()
	{
		for (int i = 0; i < peoples.size(); i++) {
			System.out.println(peoples.get(i).leaveLiftTime);
		}
	}
	public static void main(String[] args)
	{
		EmulatorLift el=new EmulatorLift();
		el.init();
		//el.processInfo();
		el.run();
		el.print();
		
	}
}

class People{
	public int applyTime;
	public int sourceFloor;
	public int targetFloor;
	public int leaveLiftTime;
	public boolean leaveState=false;
	public boolean isInLift=false;
	public People(int applyTime,int sourceFloor,int targetFloor,boolean isInLift){
		this.applyTime=applyTime;
		this.sourceFloor=sourceFloor;
		this.targetFloor=targetFloor;
		this.isInLift=isInLift;
	}
}
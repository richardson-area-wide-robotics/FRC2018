package org.usfirst.frc.team1745.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Servo;

public class Winch {
	
	TalonSRX lWinch, rWinch;
	
	Servo holder;
	
	boolean deployed;
	
	public Winch()
	{
		lWinch = new TalonSRX(26);
		rWinch = new TalonSRX(27);
		
		lWinch.follow(rWinch);
		
		lWinch.setInverted(true);
		holder = new Servo(0);
	}
	
	public void controlWinch(double set)
	{
		if(deployed) {
		rWinch.set(ControlMode.PercentOutput, set);
		} else {
			rWinch.set(ControlMode.PercentOutput, 0);
		}
	}
	
	public void deploy()
	{
		holder.set(0);
		deployed = true;
	}
	
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  Orchestra m_orchestra;
  ArrayList<TalonFX> m_motors;
  String badApplePath = "badapple.chrp";

  @Override
  public void robotInit() {
    m_motors = new ArrayList<>();
    
    for(int motorID : Constants.MOTOR_IDS) {
      m_motors.add(new WPI_TalonFX(motorID));
    }

    m_orchestra = new Orchestra(m_motors);
  }

  @Override
  public void teleopInit() {
    m_orchestra.loadMusic(badApplePath);
    m_orchestra.play();
  }
}

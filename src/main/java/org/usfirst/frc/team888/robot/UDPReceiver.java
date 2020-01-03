package org.usfirst.frc.team888.robot;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.ByteBuffer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UDPReceiver extends Thread {

    // declare objects for receiving data
    DatagramSocket socket;
    DatagramPacket dat;
    byte[] receiveData = new byte[16]; // data should be 4 floats in
                                       // length
    final Float ERROR = 2f;

    // data values from the Jetson
    public float XValue;
    public float YValue;
    public float angle;
    public double heading;

    public UDPReceiver() {

        try {
            // open a datagram socket to receive messages
            // should be a different port than the sender
            socket = new DatagramSocket(RobotMap.JETSON_SOCKET);

            // create a datagram packet to receive data of a certain length
            dat = new DatagramPacket(receiveData, receiveData.length);
        }
        catch (SocketException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        receiveMessage();
    }

    public synchronized void receiveMessage() {
        try {
            socket.receive(dat);

            ByteBuffer bbuf = ByteBuffer.wrap(dat.getData());
            XValue = bbuf.getFloat(4);
            YValue = bbuf.getFloat(8);
            angle = bbuf.getFloat(12);
            // heading = Math.atan2((double) XValue, (double) YValue) *
            // (180/Math.PI);

            SmartDashboard.putNumber("X Value", (double) XValue);
            SmartDashboard.putNumber("Y Value", (double) YValue);
            SmartDashboard.putNumber("angle", (double) angle);
            // SmartDashboard.putNumber("line heading", (double) heading);
            if (XValue != -1 && YValue != -1 && angle != -1) {
                SmartDashboard.putBoolean("vision", true);
            }
            else {
                SmartDashboard.putBoolean("vision", false);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized double[] getTarget() {
        return new double[] { XValue, YValue, angle };
    }

}

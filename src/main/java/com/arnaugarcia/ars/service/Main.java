package com.arnaugarcia.ars.service;

import com.fazecast.jSerialComm.SerialPort;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    static SerialPort chosenPort;
    static int x = 0;

    public static void test(String[] args) {

        // create and configure the window
        JFrame window = new JFrame();
        window.setTitle("Sensor Graph GUI");
        window.setSize(600, 400);
        window.setLayout(new BorderLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // create a drop-down box and connect button, then place them at the top of the window
        JComboBox portList = new JComboBox();
        JButton connectButton = new JButton("Connect");
        JPanel topPanel = new JPanel();
        topPanel.add(portList);
        topPanel.add(connectButton);
        window.add(topPanel, BorderLayout.NORTH);

        // populate the drop-down box
        SerialPort[] portNames = SerialPort.getCommPorts();
        for(int i = 0; i < portNames.length; i++)
            portList.addItem(portNames[i].getSystemPortName());


        // configure the connect button and use another thread to listen for data
        connectButton.addActionListener(arg0 -> {
            if(connectButton.getText().equals("Connect")) {
                // attempt to connect to the serial port
                chosenPort = SerialPort.getCommPort(portList.getSelectedItem().toString());
                chosenPort.setComPortTimeouts(SerialPort.TIMEOUT_SCANNER, 0, 0);
                if(chosenPort.openPort()) {
                    connectButton.setText("Disconnect");
                    portList.setEnabled(false);
                }

                // create a new thread that listens for incoming text and populates the graph
                Thread thread = new Thread(() -> {
                    System.out.println("connected read");
                    Scanner scanner = new Scanner(chosenPort.getInputStream());

                    while(scanner.hasNextLine()) {
                        try {
                            String line = scanner.nextLine();
                            System.out.println(line);
                            window.repaint();
                        } catch(Exception ignored) {}
                    }
                    scanner.close();
                });
                thread.start();


                // create a new thread that listens for incoming text and populates the graph
                Thread thread2 = new Thread(() -> {
                    System.out.println("connected write");
                    Scanner scan = new Scanner(System.in);
                    String input = "";
                    PrintWriter output = new PrintWriter(chosenPort.getOutputStream());
                    while (true) {
                        input = scan.nextLine();
                        output.print(input);
                        output.flush();
                    }
                    // output.close();
                });
                thread2.start();


            } else {
                // disconnect from the serial port
                chosenPort.closePort();
                portList.setEnabled(true);
                connectButton.setText("Connect");
                x = 0;
            }
        });

        // show the window
        window.setVisible(true);
    }

}

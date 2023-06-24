package com.example.controlebb;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Controller2 {
    @FXML
    private TextField MymsgID;
    @FXML
    private TextField PortID;

    @FXML
    private TextField HostID;
    PrintWriter pw;
    @FXML
    private ListView testview;

    @FXML
    protected void onconnect() throws IOException {
        String host=HostID.getText();
        int port = Integer.parseInt(PortID.getText());
        Socket s = new Socket(host,port);
        InputStream is = s.getInputStream();
        InputStreamReader isr=new InputStreamReader(is);
        BufferedReader br= new BufferedReader(isr);
        OutputStream os = s.getOutputStream();
        String Ip = s.getRemoteSocketAddress().toString();
         pw = new PrintWriter(os,true);
        new Thread(()->{
            while(true){
                try {
                    String reponse = br.readLine();
                    Platform.runLater(()->{
                        testview.getItems().add(reponse);
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }

    @FXML
    public void onsubmit(){
          String message=MymsgID.getText();
          pw.println(message);
    }

}

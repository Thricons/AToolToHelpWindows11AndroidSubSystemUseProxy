package me.miliblue;

import javax.swing.*;
import java.io.IOException;

/**
 * Code by MiLiBlue, At 2022/11/11
 **/
public class Main {
    public static void main(String[] args) {
        //ask user mode
        boolean isCleanerMode = JOptionPane.showConfirmDialog(null, "消除代理?", "Made by MiLiBlue with love",JOptionPane.OK_OPTION) == 0 ? true : false;
        if(!isCleanerMode) {
            int port = Integer.parseInt(JOptionPane.showInputDialog("Plz input your proxy port, like 11451 / 请输入你的代理端口,比如11451"));

            //start
            try {
                Process process = Runtime.getRuntime().exec("adb connect 127.0.0.1:58526 && adb shell \"settings put global http_proxy `ip route list match 0 table all scope global | cut -F3`:" + port + "\"");
                JOptionPane.showMessageDialog(null, "Message Back:" + process.getInputStream().read());
                System.exit(114514);
            } catch (IOException e) {
                throw new RuntimeException("A Exception catch! EXIT!");
            }
        }
        if(isCleanerMode){
            Process process = null;
            try {
                process = Runtime.getRuntime().exec("adb shell settings put global http_proxy :0");
                JOptionPane.showMessageDialog(null, "Message Back:" + process.getInputStream().read());
                System.exit(114514);
            } catch (IOException e) {
                throw new RuntimeException("A Exception catch! EXIT!");
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test2;

import javax.swing.*;
import java.awt.event.*;
public class Main {
    JFrame f;
    public Main(){
        f=new JFrame("Select Place");
        final JLabel label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setSize(400,100);
        JButton b=new JButton("Submit");
        b.setBounds(200,100,75,20);
        String languages[]={"Andheri","Bandra","Bhandup","Borivali","Byculla","Dongri","Fort","Ghatkopar","Girgaon","Goregaon","Jogeshwari","Kandivali","Kanjurmarg","Khar","Kurla","Malad","Mulund","Mumbai Central","Parel","Santacruz","Sion","Thane","Vikhroli","Vile Parle"};
        final JComboBox cb=new JComboBox(languages);
        cb.setBounds(50, 100,90,20);
        f.add(cb); f.add(label); f.add(b);
        f.setLayout(null);
        f.setSize(350,350);
        f.setVisible(true);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String value = (String) cb.getSelectedItem(); // get the selected item in the combobox
        switch(value){
        case "Andheri":
            MainAndheri b1 = new MainAndheri(); // call the class
            b1.setVisible(true);    // set the jframe to visible 
            break;
        case "Bandra":
            MainBandra b2 = new MainBandra();
            b2.setVisible(true);
            break;
        case "Bhandup":
            MainBhandup b3 = new MainBhandup();
            b3.setVisible(true);
            break;
        case "Borivali":
            MainBorivali b4 = new MainBorivali();
            b4.setVisible(true);
            break;
        case "Byculla":
            MainByculla b5 = new MainByculla();
            b5.setVisible(true);
            break;
        case "Dongri":
            MainDongri b6 = new MainDongri();
            b6.setVisible(true);
            break;
        case "Fort":
            MainFort b7 = new MainFort();
            b7.setVisible(true);
            break;
        case "Ghatkopar":
            MainGhatkopar b8 = new MainGhatkopar();
            b8.setVisible(true);
            break;
        case "Girgaon":
            MainGirgaon b9 = new MainGirgaon();
            b9.setVisible(true);
            break;
        case "Goregaon":
            MainGoregaon b10 = new MainGoregaon();
            b10.setVisible(true);
            break;
        case "Jogeshwari":
            MainJogeshwari b11 = new MainJogeshwari();
            b11.setVisible(true);
            break;
        case "Kandivali":
            MainKandivali b12 = new MainKandivali();
            b12.setVisible(true);
            break;
        case "Kanjurmarg":
            MainKanjurmarg b13 = new MainKanjurmarg();
            b13.setVisible(true);
            break;
        case "Khar":
            MainKhar b14 = new MainKhar();
            b14.setVisible(true);
            break;
        case "Kurla":
            MainKurla b15 = new MainKurla();
            b15.setVisible(true);
            break;
        case "Malad":
            MainMalad b16 = new MainMalad();
            b16.setVisible(true);
            break;
        case "Mulund":
            MainMulund b17 = new MainMulund();
            b17.setVisible(true);
            break;
        case "Mumbai Central":
            MainMumbaicentral b18 = new MainMumbaicentral();
            b18.setVisible(true);
            break;
        case "Parel":
            MainParel b19 = new MainParel();
            b19.setVisible(true);
            break;
        case "Santacruz":
            MainSantacruz b20 = new MainSantacruz();
            b20.setVisible(true);
            break;
        case "Sion":
            MainSion b21 = new MainSion();
            b21.setVisible(true);
            break;
        case "Thane":
            MainThane b22 = new MainThane();
            b22.setVisible(true);
            break;
        case "Vikhroli":
            MainVikhroli b23 = new MainVikhroli();
            b23.setVisible(true);
            break;
        case "Vile Parle":
            MainVileparle b24 = new MainVileparle();
            b24.setVisible(true);
            break;    
              }
            }
        });
    }
    public static void main(String[] args) {
        new Main();
    }
}


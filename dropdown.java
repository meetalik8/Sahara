import javax.swing.*;
import java.awt.event.*;


class dropdown extends JFrame implements ActionListener{
    JLabel l1,l2;
    JComboBox cb1,cb2;
    JButton b;
    @SuppressWarnings("unchecked")

    dropdown(){
        JFrame f = new JFrame();
        JLabel l1 = new JLabel("City");
        l1.setBounds(20, 20, 80, 30);
        f.add(l1);
        String city[] = {"Mumbai","Delhi"};
        cb1 = new JComboBox(city);
		cb1.setBounds(100,170,90, 20);
		f.add(l1);
		f.add(cb1);

        JLabel l2 = new JLabel("Area");
        l1.setBounds(70, 20, 80, 30);
        f.add(l2);
        String area[] = {"Borivali","Kandivali"};
        cb1 = new JComboBox(city);
		cb1.setBounds(200,170,90, 20);
		f.add(l2);
		f.add(cb2);

        JButton b = new JButton("Submit");
		b.setBounds(140,280,75, 20);
		f.add(b);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setVisible(true);
		f.setSize(400, 500);
    }

    public void actionPerformed (ActionEvent e) {
        String city = cb1.getItemAt(cb1.getSelectedIndex()).toString();
        String area = cb2.getItemAt(cb2.getSelectedIndex()).toString();

    }

    public static void main(String[] args){
        new dropdown();
    }


}
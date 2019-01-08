import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.*;

import java.util.*;



public class Fenetrebis extends JFrame{

    private static final long serialVersionUID = 1L;
    private ArrayList<Morceau> listmorc = new ArrayList<>();
    private JPanel container = new JPanel();
    private JLabel label = new JLabel("Les titres");
    Morceau morceau1,morceau2;
    private int nbMorceaux=listmorc.size();
    
    JLabel trier = new JLabel("trier par");
    JButton buttonType = new JButton("Type");
    JButton buttonArtiste = new JButton("Artiste");
    JButton buttonMorceau = new JButton("Morceau");

    public Fenetrebis(){
        this.setTitle("Mes Musiques");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel north = new JPanel();
        JPanel button = new JPanel();
        JMenuBar barreDeMenus = new JMenuBar();
        JMenu menu = new JMenu("CD favoris");
        barreDeMenus.add(menu);
        buttonType.setEnabled(true);
        buttonType.addActionListener(new TriTypeMusique(buttonType,container,listmorc));
        buttonArtiste.addActionListener(new TriAuteur(buttonArtiste,container,listmorc));
        buttonMorceau.addActionListener(new TriMorceau(buttonMorceau,container,listmorc));

        Font police = new Font("Tahoma", Font.BOLD, 16);
        label.setFont(police);
        label.setForeground(Color.blue);
        label.setHorizontalAlignment(JLabel.CENTER);
        north.setLayout(new GridLayout(3,1));

        buttonArtiste.setPreferredSize(new Dimension(40, 40));
        JPanel container2 = new JPanel();
        container2.setLayout(new GridLayout(3,1));
        container2.add(buttonArtiste);
        container2.add(buttonMorceau);
        container2.add(buttonType);
        
        north.add(label);
        north.add(container);
        north.add(container2);

        lecture();
        container.setBackground(Color.white);
        container.setLayout(new GridLayout(nbMorceaux,4));
        

        this.setContentPane(north);
        this.setVisible(true);
    }

    void lecture(){
        try{
            Scanner sc = new Scanner(new File("./Musiques-20181212/listeMorceaux.csv" ));

            while (sc.hasNext()){
                String line = sc.nextLine();
                Scanner sc2 = new Scanner(line).useDelimiter(",");
                Morceau e = new Morceau(sc2.next(),sc2.next(),sc2.next(),sc2.next());
               
                listmorc.add(e);
                e.ajouteMorceau(container);

            }



        }
        catch (FileNotFoundException e){
            System.out.println("Fichier non trouve");
        }
    }





}
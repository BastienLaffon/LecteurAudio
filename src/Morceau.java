

import javax.print.attribute.standard.Media;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Morceau {
    String album;
    String nom;
    String auteur;
    String file;


    private JLabel texte;
    private JButton bouton = new JButton("Go");
    private JButton bouton2 = new JButton("Stop");
    private JButton bouton3 = new JButton("10 sec");
    private AudioMp3 audioMp3;

    public Morceau(String album,String auteur,String nom,String file){
        audioMp3 = new AudioMp3("Musiques-20181212/"+file);
        texte = new JLabel(nom);
        this.file =file;
        this.auteur=auteur;
        this.album=album;
        this.nom=nom;
    }

    public void ajouteMorceau(JPanel panel){
        Border blackline = BorderFactory.createLineBorder(Color.black);

        texte.setBackground(Color.BLACK);
        texte.setBorder(blackline);
        texte.setHorizontalAlignment(JLabel.CENTER);
        panel.add(texte);
        bouton.addActionListener(new BoutonListener());
        bouton.setEnabled(true);
        bouton2.addActionListener(new Bouton2Listener());
        bouton2.setEnabled(false);
        bouton3.addActionListener(new Bouton3Listener());
        bouton3.setEnabled(true);

        panel.add(bouton);
        panel.add(bouton2);
        panel.add(bouton3);
    }

    class BoutonListener implements ActionListener {
        public void actionPerformed(ActionEvent arg0) {
            System.out.println();
            bouton.setEnabled(false);
            bouton2.setEnabled(true);
            bouton3.setEnabled(false);
            audioMp3.joue();


        }
    }

    class Bouton2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            bouton.setEnabled(true);
            bouton2.setEnabled(false);
            bouton3.setEnabled(true);
            audioMp3.stop();
        }
    }
    class Bouton3Listener implements ActionListener{
        public void actionPerformed(ActionEvent arg0){
            bouton.setEnabled(true);
            bouton2.setEnabled(true);
            bouton3.setEnabled(true);
            audioMp3.joue();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            audioMp3.stop();

        }
    }

    public String getNom() {
        return nom;
    }

    public String getAlbum() {
        return album;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getNomFile() {
        return file;
    }




}
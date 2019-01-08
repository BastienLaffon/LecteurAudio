import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TriTypeMusique  implements ActionListener {
    JButton button;
    JPanel container;
    ArrayList<Morceau> morceau;
    
    public TriTypeMusique(JButton button, JPanel container, ArrayList<Morceau> morceau){
        this.button = button;
        this.container = container;
        this.morceau = morceau;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Collections.sort(morceau, new Comparator<Morceau>() {
            @Override
            public int compare(Morceau m1, Morceau m2) {
                return m1.getAlbum().compareTo(m2.getAlbum());
            }
        });
        container.removeAll();
        container.revalidate();
        for (Morceau m : morceau) {
            System.out.println(m.getAlbum()+"/"+m.getNom()+"/"+m.getAuteur());
            m.ajouteMorceau(container);
        }
        container.repaint();
    }
}
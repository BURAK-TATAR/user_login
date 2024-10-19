import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Ana çerçeve oluşturuluyor
        JFrame frame = new JFrame("Site Arayüzü");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Menü paneli
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout());
        menuPanel.setBackground(new Color(240, 240, 240)); // Açık gri arka plan rengi

        // Logo paneli
   /*     JPanel logoPanel = new JPanel();
        JLabel logoLabel = new JLabel("Şirket Logosu", SwingConstants.CENTER);
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoPanel.add(logoLabel,BorderLayout.CENTER); //borderLayout ben ekledim
        logoPanel.setBackground(Color.LIGHT_GRAY);

    */

        // Logo paneli
        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new BorderLayout());

        // Logo resmi ekleyin
        ImageIcon logoIcon = new ImageIcon("src/logo.jpeg"); // Resim dosyasının yolu
        JLabel logoLabel = new JLabel(logoIcon, SwingConstants.CENTER);
        logoPanel.add(logoLabel, BorderLayout.CENTER); // Logoyu merkeze yerleştir
        logoPanel.setBackground(Color.LIGHT_GRAY);




        // Kategori paneli
        JPanel kategoriPanel = new JPanel();
        kategoriPanel.setLayout(new GridLayout(0, 1));

        // Kategori butonları
        String[] kategoriler = {"Beyaz Eşya", "Araba", "Motor", "Telefon", "Tablet", "Bilgisayar", "Diğer"};
        for (String kategori : kategoriler) {
            JButton kategoriButton = new JButton(kategori);
            kategoriButton.setPreferredSize(new Dimension(200, 50));  //kategori butonlarının genişlik ve yüksekliğini ayarla
            kategoriButton.setBackground(new Color(100, 150, 255)); // Mavi arka plan
            kategoriButton.setForeground(Color.WHITE); // Beyaz metin
            kategoriButton.setFocusPainted(false);
            kategoriButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Kenar boşlukları
            kategoriButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Buton tıklama olayını buraya ekleyebilirsiniz
                    System.out.println(kategori + " butonuna tıklandı!");
                }
            });
            kategoriPanel.add(kategoriButton);
        }

        // Menü panelini oluşturalım
        menuPanel.add(logoPanel, BorderLayout.NORTH);
        menuPanel.add(kategoriPanel, BorderLayout.CENTER);

        // Ana panelin bileşenlerini ekliyoruz
        frame.add(menuPanel, BorderLayout.WEST); // Menü panelini solda yerleştir

        // Çerçeveyi görünür yapıyoruz
        frame.setVisible(true);
    }
}

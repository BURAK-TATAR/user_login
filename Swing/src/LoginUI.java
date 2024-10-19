import javax.swing.*;
import java.awt.*;

public class LoginUI {

    public static void main(String[] args) {
        // Ana pencere (frame)
        JFrame frame = new JFrame("My Account");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);  // Pencere boyutlandırmayı engelle

        // Üst arka plan paneli (Başlık ve ikon)
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0x2D3E50));

        // İkon ekleme
        JLabel iconLabel = new JLabel();
        try {
            ImageIcon userIcon = new ImageIcon("src/user_icon.png");
            Image scaledIcon = userIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            iconLabel.setIcon(new ImageIcon(scaledIcon));
        } catch (Exception e) {
            System.out.println("İkon yüklenemedi: " + e.getMessage());
        }
        iconLabel.setHorizontalAlignment(JLabel.CENTER);

        // Başlık
        JLabel titleLabel = new JLabel("My Account", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        topPanel.add(titleLabel, BorderLayout.NORTH);
        topPanel.add(iconLabel, BorderLayout.CENTER);

        // Giriş paneli
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
        loginPanel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        loginPanel.setBackground(Color.WHITE);

        // Kullanıcı adı alanı
        JTextField loginField = new JTextField();
        loginField.setFont(new Font("Arial", Font.PLAIN, 14));
        loginField.setPreferredSize(new Dimension(200, 30));
        loginField.setMaximumSize(new Dimension(200, 30));
        loginField.setBorder(BorderFactory.createTitledBorder("Login"));

        // Şifre alanı
        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setPreferredSize(new Dimension(200, 30));
        passwordField.setMaximumSize(new Dimension(200, 30));
        passwordField.setBorder(BorderFactory.createTitledBorder("Password"));

        // Yuvarlak giriş butonu
        JButton signInButton = new RoundButton("Sign In");
        signInButton.setBackground(new Color(0xF2784B));
        signInButton.setForeground(Color.WHITE);
        signInButton.setFont(new Font("Arial", Font.BOLD, 16));
        signInButton.setFocusPainted(false);
        signInButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Bileşenleri ekle
        loginPanel.add(loginField);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // Boşluk
        loginPanel.add(passwordField);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        loginPanel.add(signInButton);

        // Ana pencereye ekle
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(loginPanel, BorderLayout.CENTER);

        // Pencereyi göster
        frame.setVisible(true);
    }

    // Yuvarlak buton için özel sınıf
    static class RoundButton extends JButton {
        public RoundButton(String label) {
            super(label);
            setOpaque(false);  // Saydam arka plan
            setFocusPainted(false);  // Odak çizgisini kapat
            setBorderPainted(false);  // Kenar çizgilerini kapat
            setContentAreaFilled(false);  // İçeriğin boyanmasını engelle
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Yuvarlak arka plan boyama
            g2.setColor(getBackground());
            g2.fillOval(0, 0, getWidth(), getHeight());

            // Yazıyı ortalama ve çizme
            FontMetrics fm = g2.getFontMetrics();
            int textWidth = fm.stringWidth(getText());
            int textHeight = fm.getAscent();
            g2.setColor(getForeground());
            g2.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - 4);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(2380, 80);  // Yuvarlak butonun boyutu
        }
    }
}

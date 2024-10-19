import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomLoginUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);

        // Arka plan paneli
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 94, 98),
                        0, getHeight(), new Color(137, 42, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setBounds(0, 0, 400, 600);
        frame.add(backgroundPanel);
        backgroundPanel.setLayout(null);

        // Giriş paneli
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(50, 150, 300, 300);
        loginPanel.setBackground(new Color(255, 255, 255, 230));
        loginPanel.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));

        // Başlık etiketi
        JLabel titleLabel = new JLabel("Login", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(0, 10, 300, 40);
        loginPanel.add(titleLabel);

        // Kullanıcı adı alanı + İkon
        JPanel usernamePanel = createInputFieldWithIcon("Username", "src/user-icon.png", 24, 24);
        usernamePanel.setBounds(30, 70, 240, 40);
        loginPanel.add(usernamePanel);

        // Şifre alanı + İkon
        JPanel passwordPanel = createInputFieldWithIcon("Password", "src/lock-icon.png", 24, 24);
        passwordPanel.setBounds(30, 120, 240, 40);
        loginPanel.add(passwordPanel);

        // Login butonu
        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(30, 180, 240, 50);
        loginButton.setForeground(Color.WHITE);
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setBackground(new Color(255, 94, 98));
        loginButton.setBorder(new LineBorder(Color.PINK, 2, true));

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Giriş Yapıldı!");
            }
        });

        loginPanel.add(loginButton);

        // Sign up etiketi
        JLabel signUpLabel = new JLabel("SIGN UP", SwingConstants.CENTER);
        signUpLabel.setBounds(0, 240, 300, 30);
        signUpLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        signUpLabel.setForeground(Color.GRAY);
        loginPanel.add(signUpLabel);

        backgroundPanel.add(loginPanel);
        frame.setVisible(true);
    }

    // İkonlu giriş alanı oluşturan yardımcı fonksiyon
    private static JPanel createInputFieldWithIcon(String placeholder, String iconPath, int iconWidth, int iconHeight) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));

        // İkon etiketi (Boyutlandırılmış ikon ekleniyor)
        JLabel iconLabel = new JLabel(resizeIcon(iconPath, iconWidth, iconHeight));
        iconLabel.setBorder(new EmptyBorder(0, 5, 0, 5)); // İkon ile metin alanı arası boşluk
        panel.add(iconLabel, BorderLayout.WEST);

        // Metin alanı (kullanıcı adı veya şifre)
        JTextField textField = placeholder.equals("Password") ? new JPasswordField() : new JTextField();
        textField.setBorder(new EmptyBorder(5, 5, 5, 5));
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setText(placeholder); // Placeholder
        panel.add(textField, BorderLayout.CENTER);

        return panel;
    }

    // İkon boyutlandırma fonksiyonu
    private static ImageIcon resizeIcon(String iconPath, int width, int height) {
        ImageIcon icon = new ImageIcon(iconPath);
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}

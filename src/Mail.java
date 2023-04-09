import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;


public class Mail {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Göndericinin maili nedir?");
        String emailGonderen = scanner.nextLine();
        System.out.println("Parolanız nedir?");
        String sifre = scanner.nextLine();
        System.out.println("Mail başlığı:");
        String mailBasligi = scanner.nextLine();
        System.out.println("Mailinizi yazınız:");
        String mailIcerigi = scanner.nextLine();

       String host = "smtp.gmail.com";
        int port = 587;

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("kullanıcılar.txt");
            br = new BufferedReader(fr);

            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                String[] kullaniciBilgileri = currentLine.split(":");
                if (kullaniciBilgileri.length == 3) {
                    String kullaniciAdi = kullaniciBilgileri[0];
                    String email = kullaniciBilgileri[2];

                    sendEmail(emailGonderen, sifre, email, mailBasligi, mailIcerigi, host, port);
                }
            }
            br.close();
        } catch (IOException e) {


            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }


    }

    public static void sendEmail(String emailGonderen, String sifre, String emailAlici, String mailBasligi, String mailIcerigi, String host, int port)
        {

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailGonderen, sifre);
                }
            });

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(emailGonderen));
                message.setRecipients(Message.RecipientType.TO,
                        InternetAddress.parse(emailAlici));
                message.setSubject(mailBasligi);
                message.setText(mailIcerigi);

                Transport.send(message);

                System.out.println("Mail Gönderildi!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

    }

public static void sendEmail(int y){
        if(y==1){
            Mail mail=new Mail();

        }
}

}
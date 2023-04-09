import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        String acıklama = "1- Elit üye ekleme\n" +
                "2- Genel Üye ekleme\n" +
                "3- Mail Gönderme";
        System.out.println("**********************");
        System.out.println(acıklama);
        System.out.println("***********************");
        while (true) {
            System.out.print("Yapmak istediğiniz işlem nedir:");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();

            if (x == 1) {
                System.out.println("Eklenecek olan elit üyenin ismi nedir?");
                String isim = scanner.nextLine();
                System.out.println("Eklenecek olan elit üyenin soyismi nedir?");
                String soyisim = scanner.nextLine();
                System.out.println("Eklenecek olan elit üyenin emali nedir?");
                String email = scanner.nextLine();
                File dosya = new File("kullanıcılar.txt");
                try {
                    FileWriter yazici = new FileWriter(dosya, true);
                    yazici.write("Elit Üye:" + isim + " " + soyisim+":" + email + " \n ");
                    yazici.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("Bilgileri girilen elit üye kaydedildi.");
            } else if (x == 2) {
                System.out.println("Eklenecek olan genel üyenin ismi nedir?");
                String isim = scanner.nextLine();
                System.out.println("Eklenecek olan genel üyenin soyismi nedir?");
                String soyisim = scanner.nextLine();
                System.out.println("Eklenecek olan genel üyenin emali nedir?");
                String email = scanner.nextLine();

                File dosya = new File("kullanıcılar.txt");
                try {
                    FileWriter yazici = new FileWriter(dosya, true);
                    yazici.write("Genel Üye:" + isim + " " + soyisim + email + " \n ");
                    yazici.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Bilgileri girilen genel üye kaydedildi.");
            } else if (x == 3) {

              String acıklama1 = "1-Elit üyelere mail\n" +
                        " 2- Genel üyelere mail\n" +
                        " 3- Tüm üyelere mail\n";
                System.out.println(acıklama1);
                System.out.println("**********************");
                System.out.println("Hangi işlemi yapmak istiyorsunuz?");
                int y = scanner.nextInt();
                if (y == 1) {

                } else if (y == 2) {

                }

                else if (y == 3) {

                }
            }
            else
                System.out.println("Yanlış karakter girdiniz!!");
            break;
        }
    }
}

/*


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
*/    //Bu mail class'ını main class'ındaki ikinci menüye bağlayamadım. Ama gene de mail gönderme class'ını yaptım çalışır halde.
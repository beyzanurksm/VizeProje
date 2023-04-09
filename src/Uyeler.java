import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Uyeler {
    private String isim;
    private String soyisim;
    private String email;
    private Main main;

public void setIsim(String isim){this.isim=isim;}
public String getIsim(){
    return isim;
}
    public void setSoyisim(String soyisim){
        this.soyisim=soyisim;
    }
    public String getSoyisim(){
        return soyisim;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }

   public Uyeler(String isim,String soyisim, String email){
    this.isim=isim;
    this.soyisim=soyisim;
    this.email=email;
   }
   @Override
    public String toString() {
        return isim + "\t" + soyisim + "\t" + email;
    }
}

class ElitUye extends Uyeler {
    public ElitUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
    }
}

class GenelUye extends Uyeler {
    public GenelUye(String isim, String soyisim, String email) {
        super(isim, soyisim, email);
    }
}


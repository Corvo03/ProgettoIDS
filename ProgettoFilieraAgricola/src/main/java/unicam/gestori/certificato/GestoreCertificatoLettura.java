package unicam.gestori.certificato;

import java.util.ArrayList;
import java.util.List;

public class GestoreCertificatoLettura {
    protected final List<Certificato> listaCertificati = new ArrayList<>();

    public List<Certificato> getListaCertificati(){
        return listaCertificati;
    }
}

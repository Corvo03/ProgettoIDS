package unicam;

public class InformazioniDaApprovare {
    private int id;
    private boolean DaApprovare;
    private boolean approvata;
    public InformazioniDaApprovare() {
        this.DaApprovare = true;
        this.approvata = false;

    }

    public boolean isDaApprovare() {
        return DaApprovare;
    }

    public void setDaApprovare(boolean daApprovare) {
        DaApprovare = daApprovare;
    }

    public boolean isApprovata() {
        return approvata;
    }

    public void setApprovata(boolean approvata) {
        this.approvata = approvata;
    }
}

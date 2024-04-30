package be.odisee;

public class BankAccount {
    private String naam;
    private double balans;
    private int nummer;

    public BankAccount(String naam, double balans, int nummer) {
        this.naam = naam;
        this.balans = balans;
        this.nummer = nummer;
    }

    public BankAccount(String naam, int nummer) {
        this.naam = naam;
        this.nummer = nummer;
        this.balans = 0;
    }

    public double getBalans() {
        return balans;
    }

    public int getNummer() {
        return nummer;
    }

    /**
     * @param bedrag bij te voegen bedrag
     *
     */
    public void storten(double bedrag) {
        balans+=bedrag;
    }
    /**
     * @param bedrag af te trekken bedrag
     * @return was de transacttie succesvol geregistreerd?
     *
     */
    public boolean afhalen(double bedrag) {
        if(getBalans()<bedrag) {
            return false;
        } else {
            balans-=bedrag;
            return true;
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "naam='" + naam + '\'' +
                ", bedrag=" + balans +
                ", nummer=" + nummer +
                '}';
    }


}

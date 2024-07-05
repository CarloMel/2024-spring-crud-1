package org.exercise.exercise.ContoBancario.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContoBancario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int saldo;

    public ContoBancario (int saldo) {
        setSaldo(saldo);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void deposita(int somma) throws Exception {

        if (somma <= 0 ){
            throw new Exception("La somma dev'essere maggiore di 1");
        }

        setSaldo(getSaldo() + somma);
    }

    public void preleva(int somma) throws Exception {
        
        if (somma > getSaldo()) {
            throw new Exception("Non puoi ritirare più di quanto possiedi");
        }

        setSaldo(getSaldo() - somma);
    }

    @Override
    public String toString() {
        return "Conto bancario:\n"
        + "saldo :" + getSaldo();
    }
}

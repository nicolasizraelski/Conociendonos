package cuidandonos;


import lombok.Getter;
import lombok.Setter;


public class Parada {


    private String direccion;
    private double minutosDeDetencion;


    public String getDireccion (){
        return direccion;
    }

    public double getDetencion (){
        return minutosDeDetencion;
    }
}

package cuidandonos;


import lombok.Getter;
import lombok.Setter;


public class Parada {


    private String direccion;
    private Integer minutosDeDetencion;


    public String getDireccion (){
        return direccion;
    }
}

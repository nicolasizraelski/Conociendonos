package cuidandonos;

import cuidandonos.adapters.CalculadorDemora;
import cuidandonos.adapters.CalculadorDistancia;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class Viaje {
    private String direccionInicial;
    private List<Cuidador> cuidadores;
    private Transeunte viajero;
    private boolean habilitado;
    private double demoraAproximadaEnMins;
    private List<Parada> paradas;
    private TipoViaje tipoViaje;
    private InteraccionParada tipoInteraccionConParada;


    private boolean esViajePorParadas () {
        return paradas.size() > 1;
    }
    public void calcularDemoraAproximada(CalculadorDistancia calculadorDeDistancia, CalculadorDemora calculadorDeDemora) {
        Parada primeraParada = paradas.get(0);
        double primeraDistancia = calculadorDeDistancia.calcualarDistancia(direccionInicial, primeraParada.getDireccion());
        double primerDemora = calculadorDeDemora.demoraEnMins(primeraDistancia);

        if(esViajePorParadas()){
            double acumDemoras = primerDemora;
            for(int i = 1; i < paradas.size() - 1 ; i++){
                Parada inicio = paradas.get(i);
                Parada destino = paradas.get(i + 1);

                double dist = calculadorDeDistancia.calcualarDistancia(inicio.getDireccion(), destino.getDireccion());
                double dem = calculadorDeDemora.demoraEnMins(dist);

                acumDemoras += dem;
            }

            demoraAproximadaEnMins = acumDemoras;
        }else{
            demoraAproximadaEnMins = primerDemora;
        }

    }
}

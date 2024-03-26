package CuerposCelestes;

import java.util.*;

public class Main {

    public static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    public static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {

        //Creamos y añadimos a mercurio
        CuerpoCeleste mercurio = new Planeta("Mercurio", 88);
        planetas.add(mercurio);
        sistemaSolar.put("mer", mercurio);

        CuerpoCeleste venus = new Planeta("Venus", 225);
        CuerpoCeleste laTierra = new Planeta("La Tierra", 365);
        CuerpoCeleste marte = new Planeta("Marte", 687);
        CuerpoCeleste jupiter = new Planeta("Jupier", 4332);
        CuerpoCeleste saturno = new Planeta("Saturno", 10759);
        CuerpoCeleste urano = new Planeta("Urano", 30660);
        CuerpoCeleste neptuno = new Planeta("Neptuno", 665);
        CuerpoCeleste pluton = new Planeta("Plutón", 248);

        planetas.add(venus);
        planetas.add(laTierra);
        planetas.add(marte);
        planetas.add(jupiter);
        planetas.add(saturno);
        planetas.add(urano);
        planetas.add(neptuno);
        planetas.add(pluton);
        sistemaSolar.put("ven", venus);
        sistemaSolar.put("tie", laTierra);
        sistemaSolar.put("mar", marte);
        sistemaSolar.put("jup", jupiter);
        sistemaSolar.put("sat", saturno);
        sistemaSolar.put("ura", urano);
        sistemaSolar.put("nep", neptuno);
        sistemaSolar.put("plu", pluton);

        //Creamos luna y la añadimos a la Tierra
        CuerpoCeleste luna = new Luna("Luna", 27);
        laTierra.addSatelite(luna);
        sistemaSolar.put("lun", luna);

        //Creamos el resto de lunas y las añadimos a sus respetivos planetas
        CuerpoCeleste deimos = new Luna("Deimos", 1.3);
        CuerpoCeleste phobos = new Luna("Phobos", 0.3);
        marte.addSatelite(deimos);
        marte.addSatelite(phobos);
        sistemaSolar.put("dei", deimos);
        sistemaSolar.put("pho", phobos);

        CuerpoCeleste io = new Luna("Io", 1.8);
        CuerpoCeleste europa = new Luna("Europa", 3.5);
        CuerpoCeleste ganymede = new Luna("Ganymede", 7.1);
        CuerpoCeleste callisto = new Luna("Callisto", 16.7);
        jupiter.addSatelite(io);
        jupiter.addSatelite(europa);
        jupiter.addSatelite(ganymede);
        jupiter.addSatelite(callisto);
        sistemaSolar.put("io", io);
        sistemaSolar.put("eur", europa);
        sistemaSolar.put("gan", ganymede);
        sistemaSolar.put("cal", callisto);


        //Bucle for each para imprimir el conjunto Set de planetas
        System.out.println("Imprimimos el conjunto Set de planetas con un bucle for each: ");
        for(CuerpoCeleste planet: planetas){
            System.out.println(planet);
        }

        System.out.println('\n');

        //Obetemos del mapa sistema solar todas las lunas de marte
        System.out.println("Obetemos del mapa sistema solar todas las lunas de marte: ");
        for(CuerpoCeleste lunas: marte.getSatelites()){
            System.out.println(lunas);
        }

        System.out.println('\n');

        //Obtenemos la union de todas las lunas y las imprimimos
        System.out.println("Obtenemos la union de todas las lunas y las imprimimos: ");
        Set<CuerpoCeleste> lunas = new HashSet<>();
        for(CuerpoCeleste unionLunas: planetas){
            lunas.addAll(unionLunas.getSatelites());
        }

        for(CuerpoCeleste imprimLunas: lunas){
            System.out.println(imprimLunas);
        }

        System.out.println(" ");

        //Creación del nuevo pluton como planeta y impresion de todos los planetas
        System.out.println("Añadiendo un nuevo Plutón como planeta(No se añade):");
        CuerpoCeleste pluton2 = new Planeta("Plutón", 884);
        planetas.add(pluton2);

        for(CuerpoCeleste imprimirPlanetas: planetas){
            System.out.println(imprimirPlanetas.toString());
        }
        //No se añade porque es el mismo nombre y tipo de planeta por el equals.

        System.out.println(" ");

        //Creación de pluton como planeta enano
        System.out.println("Añadiendo un nuevo Plutón como planetaEnano(Si se añade):");
        CuerpoCeleste pluton3 = new PlanetaEnano("Plutón", 884);
        planetas.add(pluton3);

        for(CuerpoCeleste imprimirPlanetas: planetas){
            System.out.println(imprimirPlanetas.toString());
        }
        //Si se añade porque es el mismo nombre pero distinto tipo de planeta.


        System.out.println(" ");

        //Probando la diferencia y la intersección

        Set<CuerpoCeleste> nuevoPlanetas = new HashSet<>();
        CuerpoCeleste planeta1 = new Planeta("Planeta1", 789);
        CuerpoCeleste planeta2 = new Planeta("Planeta2", 200);
        nuevoPlanetas.add(laTierra);
        nuevoPlanetas.add(venus);
        nuevoPlanetas.add(planeta1);
        nuevoPlanetas.add(planeta2);

        System.out.println("Prueba de intersección(devuelve los valores repetidos en ambos sets): ");
        nuevoPlanetas.retainAll(planetas);

        for(CuerpoCeleste plan: nuevoPlanetas){
            System.out.println(plan.toString());
        }

        System.out.println("Prueba de diferencia(devuelve los valores que no son iguales en ambos sets(devuelve los valores del primer set))");

        CuerpoCeleste planeta11 = new Planeta("Planeta1", 789);
        CuerpoCeleste planeta22 = new Planeta("Planeta2", 200);

        nuevoPlanetas.add(planeta11);
        nuevoPlanetas.add(planeta22);
        
        nuevoPlanetas.removeAll(planetas);

        for(CuerpoCeleste plan: nuevoPlanetas){
            System.out.println(plan.toString());
        }

    }

}

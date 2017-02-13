package es.uniovi.asw.dbupdate;

import es.uniovi.asw.dbupdate.util.Hibernate_Jpa;
import es.uniovi.asw.model.Citizen;

import java.util.List;

/**
 * Created by Pelayo Garcia Lartategui on 10/02/2017.
 */
public class CitizenFinder {

    public static Citizen findByNif(String numero_identificativo){
        List<Citizen> list = Hibernate_Jpa.getManager()
                .createNamedQuery("Citizen.findByNif",Citizen.class)
                .setParameter(1,numero_identificativo).getResultList();
        if(!list.isEmpty()){
            return list.get(0);
        }
        return null;
    }
}

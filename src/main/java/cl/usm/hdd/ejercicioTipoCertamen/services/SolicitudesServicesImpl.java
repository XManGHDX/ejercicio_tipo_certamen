package cl.usm.hdd.ejercicioTipoCertamen.services;

import cl.usm.hdd.ejercicioTipoCertamen.entities.Solicitud;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SolicitudesServicesImpl implements SolicitudesServices{

    private static List<Solicitud> solicitudes = new ArrayList<>();


    @Override
    public Solicitud crear(Solicitud solicitud) {
        solicitudes.add(solicitud);
        return solicitud;
    }

    @Override
    public List<Solicitud> obtener() {
        return solicitudes;
    }

    @Override
    public List<Solicitud> filtrar(String tipoSolicitud) {
        return solicitudes.stream()
                .filter(s->s.getTipoSolicitud()
                        .equalsIgnoreCase(tipoSolicitud))
                .collect(Collectors.toList());
    }


}

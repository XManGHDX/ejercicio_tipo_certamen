package cl.usm.hdd.ejercicioTipoCertamen.services;

import cl.usm.hdd.ejercicioTipoCertamen.entities.Solicitud;

import java.util.List;

public interface SolicitudesServices {
    Solicitud crear(Solicitud solicitud);
    List<Solicitud> obtener();

    List<Solicitud> filtrar(String tipoSolicitud);
}

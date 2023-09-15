package cl.usm.hdd.ejercicioTipoCertamen.controllers;

import cl.usm.hdd.ejercicioTipoCertamen.entities.Solicitud;
import cl.usm.hdd.ejercicioTipoCertamen.services.SolicitudesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
public class SolicitudesControllers {
    @Autowired
    private SolicitudesServices solicitudesServices;
    private boolean esTipoValido(String tipoSolicitud){
        String [] tipos = {"SolicitudCedula"
                ,"RetiroCedula"
                ,"SolicitudCertificadoNac"
                ,"SolicitudCertificadoDef"};
        return Stream.of(tipos).anyMatch(t->t.equalsIgnoreCase(tipoSolicitud));
    }

    @GetMapping("/verSolicitudes/{tipo}")
    public ResponseEntity<List<Solicitud>> filtrar(@PathVariable String tipo){
        try {
            return ResponseEntity.ok(this.solicitudesServices.filtrar(tipo));
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping("/verSolicitudes")
    public ResponseEntity<List<Solicitud>> obtener(){
        try {
            return ResponseEntity.ok(this.solicitudesServices.obtener());
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();

        }
    }

    @PostMapping("ingresarSolicitud")
    public ResponseEntity<Solicitud> crear(@RequestBody Solicitud solicitud){

        if(!esTipoValido(solicitud.getTipoSolicitud())){
            return ResponseEntity.badRequest().build();
        }try {
            Solicitud sol = solicitudesServices.crear(solicitud);
            return ResponseEntity.ok(sol);
        }catch (Exception ex
        ){
            return ResponseEntity.internalServerError().build();
        }

    }

}

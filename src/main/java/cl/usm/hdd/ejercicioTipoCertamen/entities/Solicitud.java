package cl.usm.hdd.ejercicioTipoCertamen.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {
    private String rut;
    private String nombre;
    private String apellido;
    private String tipoSolicitud;

}

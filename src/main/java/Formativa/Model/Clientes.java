package Formativa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {

    private int id;
    private String nombre;
    private String rut;
    private String edad;
    private String email;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String pais;

}
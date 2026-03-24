package Formativa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {

    private int id;
    private String name;
    private String rut;
    private String edad;
    private String email;
    private String telefono;
    private String dirección;
    private String ciudad;
    private String país;

}
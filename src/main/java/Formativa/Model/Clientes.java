package Formativa.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clientes {

    private int id;

    @NotBlank(message = "el nombre es obligatorio")
    private String name;

    @NotBlank(message = "el rut es obligatorio")
    private String rut;

    @NotBlank(message = "la edad es obligatoria")
    private String edad;

    @NotNull(message = "el email es obligatorio")
    private String email;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String pais;

    public String getName() {return name;}
    public String getRut() {return rut;}
    public String getEdad() {return edad;}
    public String getEmail() {return email;}
}
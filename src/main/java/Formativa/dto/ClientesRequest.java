package Formativa.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;
import org.aspectj.bridge.IMessage;

@Data
public class ClientesRequest {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El rut no debe estar vacío")
    private String rut;

    @Positive(message = "La edad debe ser mayor a cero")
    @NotNull(message = "La edad es obligatoria")
    private int age;

    @NotBlank(message = "El email no puede estar vacío")
    private String email;
}

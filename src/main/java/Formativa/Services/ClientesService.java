package Formativa.Services;

import Formativa.Model.Clientes;
import Formativa.Repository.ClientesRepository;
import Formativa.dto.ClientesDTO;
import Formativa.dto.ClientesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public ClientesDTO guardar(ClientesRequest request){
        Clientes clientes = new Clientes();
        clientes.setName(request.getName());
        clientes.setRut(request.getRut());
        clientes.setAge(request.getAge());
        clientes.setEmail(request.getEmail());

        Clientes guardado = clientesRepository.save(clientes);
        return convertirADTO(guardado);
    }

    public List<ClientesDTO> listar() {
        return clientesRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Clientes buscarPorId(int id) {
        Clientes clientes = clientesRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return convertirADTO(clientes);
    }

    public Clientes actualizar(int id, ClientesRequest request) {
        Clientes clienteExistente = clientesRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        clienteExistente.setName(request.getName());
        clienteExistente.setRut(request.getRut());
        clienteExistente.setAge(request.getAge());
        clienteExistente.setEmail(request.getEmail());

        Clientes actualizado = clientesRepository.save(clienteExistente);
        return convertirADTO(actualizado);
    }

    public String eliminar(int id) {
        clientesRepository.delete(id);
    }

    private ClientesDTO convertirADTO(Clientes clientes) {
        ClientesDTO dto = new ClientesDTO();
        dto.setId(clientes.getId());
        dto.setName(clientes.getName());
        dto.setRut(clientes.getRut());
        dto.setAge(clientes.getAge());
        dto.setEmail(clientes.getEmail());
        return dto;
    }
}
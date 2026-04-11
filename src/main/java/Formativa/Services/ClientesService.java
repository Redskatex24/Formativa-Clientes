package Formativa.Services;

import Formativa.Model.Clientes;
import Formativa.Repository.ClientesRepository;
import Formativa.dto.ClientesDTO;
import Formativa.dto.ClientesRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    //public List<Clientes> getClientes(){

      //  return clientesRepository.getClass();
    //}

    //public Clientes getClienteId(int id) {

      //  return clientesRepository.getReferenceById(id);
    //}

    //public Clientes updateCliente(Clientes cliente, int id) {

      //  return clientesRepository.update(cliente, id);
    //}

    //public String deleteCliente(int id) {
      //  clientesRepository.delete(id);
        //return "Cliente removido";
    //}

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
package Formativa.Services;

import Formativa.Model.Clientes;
import Formativa.Repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> getClientes(){
        return clientesRepository.obtenerClientes();
    }

    public Clientes saveCliente(Clientes cliente){
        return clientesRepository.guardar(cliente);
    }

    public Clientes getClienteId(int id) {
        return clientesRepository.buscarPorId(id);
    }

    public Clientes updateCliente(Clientes cliente) {
        return clientesRepository.actualizar(cliente);
    }

    public String deleteCliente(int id) {
        clientesRepository.eliminar(id);
        return "Cliente removido";
    }
}
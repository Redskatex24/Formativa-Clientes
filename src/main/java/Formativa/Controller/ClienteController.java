package Formativa.Controller;

import Formativa.Model.Clientes;
import Formativa.Services.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClientesService clientesService;

    @GetMapping
    public List<Clientes> listarClientes(){
        return clientesService.getClientes();
    }

    @PostMapping
    public Clientes cadastrarClientes(@RequestBody Clientes clientes) {
        return clientesService.saveCliente(clientes);
    }

    @GetMapping("{id}")
    public Clientes buscarClientes(@PathVariable int id){
        return clientesService.getClienteId(id);
    }

    @PutMapping("{id}")
    public Clientes atualizarClientes(@PathVariable int id, @RequestBody Clientes clientes) {
        return clientesService.updateCliente(clientes);
    }

    @DeleteMapping("{id}")
    public String eliminarClientes(@PathVariable int id){
        return clientesService.deleteCliente(id);
    }
}
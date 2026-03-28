package Formativa.Repository;

import Formativa.Model.Clientes;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientesRepository {

    private List<Clientes> listaClientes = new ArrayList<>();

    public List<Clientes> obtenerClientes() {
        return listaClientes;
    }

    public Clientes buscarPorId(int id) {
        for (Clientes clientes : listaClientes) {
            if (clientes.getId() == id) {
                return clientes;
            }
        }
        return null;
    }

    public Clientes guardar(Clientes clientes) {
        listaClientes.add(clientes);
        return clientes;
    }

    public Clientes actualizar(Clientes clientes, int id) {
        int idPosicion = 0;

        for (int i = 0; i<listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == id) {
                idPosicion = i;
            }
        }

        Clientes clientes1 = new Clientes();
        clientes1.setId(id);
        clientes1.setName(clientes.getName());
        clientes1.setRut(clientes.getRut());
        clientes1.setEdad(clientes.getEdad());
        clientes1.setDirección(clientes.getDirección());
        clientes1.setCiudad(clientes.getCiudad());
        clientes1.setPaís(clientes.getPaís());
        clientes1.setTelefono(clientes.getTelefono());
        clientes1.setEmail(clientes.getEmail());

        listaClientes.set(idPosicion, clientes1);
        return clientes1;

    }

    public void eliminar(int id) {
        listaClientes.removeIf(client -> client.getId() == id);
    }
}

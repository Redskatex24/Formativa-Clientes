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

    public Clientes actualizar(Clientes clientes) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i<listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == clientes.getId()) {
                id = listaClientes.get(i).getId();
                idPosicion = i;
            }
        }

        Clientes clientes1 = new Clientes();
        clientes1.setId(id);
        clientes1.setName(listaClientes.get(id).getName());
        clientes1.setRut(listaClientes.get(id).getRut());
        clientes1.setEdad(listaClientes.get(id).getEdad());
        clientes1.setDirección(listaClientes.get(id).getDirección());
        clientes1.setCiudad(listaClientes.get(id).getCiudad());
        clientes1.setPaís(listaClientes.get(id).getPaís());
        clientes1.setTelefono(listaClientes.get(id).getTelefono());
        clientes1.setEmail(listaClientes.get(id).getEmail());

        listaClientes.set(idPosicion, clientes1);
        return clientes1;

    }

    public void eliminar(int id) {
        int idPosicion = 0;
        for (int i = 0; i<listaClientes.size(); i++) {
            if (listaClientes.get(i).getId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaClientes.remove(idPosicion);
        }
    }
}

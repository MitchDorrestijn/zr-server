//package org.han.ica.oose.boterbloem.service;
//
//import org.han.ica.oose.boterbloem.dao.ClientDAO;
//import org.han.ica.oose.boterbloem.domain.Client;
//
//import java.util.List;
//
//public class ClientService {
//
//    ClientDAO clientDAO = new ClientDAO();
//
//    public ClientService() {
//        //Empty constructor
//    }
//
//    public void createClient(Client client) {
//        clientDAO.create(client);
//    }
//
//    /**
//     * @return method returns a list of all found clients
//     */
//    public List<Client> getAllClients() {
//        return clientDAO.getAllClients();
//    }
//
//    /**
//     * @param id the clientId thats used for the query
//     * @return A specific clients with the given id
//     */
//    public Client findById(int id) {
//        return clientDAO.getClientById(id);
//    }
//}
//

import java.net.InetAddress; 
import java.net.InetSocketAddress; 
import java.net.ServerSocket; 

public class Serveur { 
    private static ServerSocket Listener; 
    // Application Serveur 
    public static void main(String[] args) throwsException { 
        // Compteur incrémentéà chaqueconnexion d'un client au serveur 
        int clientNumber= 0; 
        // Adresseet port du serveur 
        // String serverAddress= "127.0.0.1"; 
        // intserverPort= 5000; 
        // Créationde la connexion pour communiquer avec les clients 
        Listener= newServerSocket(); 
        Listener.setReuseAddress(true); 
        InetAddressserverIP= InetAddress.getByName(serverAddress); 
        // Association de l'adresse et du port à la connexion 
        Listener.bind(newInetSocketAddress(serverIP, serverPort)); 
        System.out.format("The server is running on %s:%d%n", serverAddress, serverPort); 
        try { 
            // À chaque fois qu'un nouveau client se connecte, on exécute la fonction 
            // run() de l'objet ClientHandler 
            while(true) { 
                // Important : la fonction accept() est bloquante: attend qu'un prochain client se connecte 
                // Une nouvelle connexion : on incémente le compteur clientNumber 
                newClientHandler(Listener.accept(), clientNumber++).start();
            } 
        } finally { 
            // Fermeture de la connexion 
            Listener.close(); 
        }
    }
}
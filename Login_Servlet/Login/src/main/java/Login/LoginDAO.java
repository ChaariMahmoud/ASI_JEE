package Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    // Méthode pour établir la connexion à la base de données
    private Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Charger le pilote JDBC pour MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Informations de connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/mydatabasee?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
            String username = "admin";
            String password = "admin";
            
            // Établir la connexion
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Méthode pour vérifier les informations d'identification de l'utilisateur dans la base de données
    public boolean isValidUser(String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // Obtenir une connexion à la base de données
            connection = getConnection();
            
            // Préparer la requête SQL pour récupérer l'utilisateur avec le nom d'utilisateur et le mot de passe fournis
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            // Exécuter la requête SQL
            resultSet = preparedStatement.executeQuery();
            
            // Vérifier si un enregistrement a été trouvé dans la base de données
            if (resultSet.next()) {
                // L'utilisateur a été trouvé
                return true;
            } else {
                // Aucun utilisateur trouvé avec ces informations d'identification
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les exceptions SQL appropriées
            return false;
        } finally {
            // Fermer les ressources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


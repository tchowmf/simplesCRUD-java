package chuteira;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BD {
    static final String banco = "jdbc:mysql://localhost:3306/fut";
    Connection conexao = null;
    java.sql.Statement consula = null;
    PreparedStatement minhaConsulta = null;

    public void Inserir(String marca, String modelo, int tamanho, double preco) {
        try {
            conexao = DriverManager.getConnection(banco, "root", "");
            minhaConsulta = conexao.prepareStatement("INSERT INTO chuteira (Marca, Modelo, Tamanho, Preco) VALUES (?,?,?,?);");
            minhaConsulta.setString(1, marca);
            minhaConsulta.setString(2, modelo);
            minhaConsulta.setInt(3, tamanho);
            minhaConsulta.setDouble(4, preco);
            minhaConsulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            

        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            try {
                if (minhaConsulta != null) {
                    minhaConsulta.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException erronovo) {
                erronovo.printStackTrace();
            }
        }
    }
    
    public void Excluir(int id){
        try{
            conexao = DriverManager.getConnection(banco, "root", "");
            minhaConsulta = conexao.prepareStatement("DELETE FROM chuteira where Id = ?");
            minhaConsulta.setInt(1, id);
            minhaConsulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dado deletado com sucesso!");
            
        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            try {
                if (minhaConsulta != null) {
                    minhaConsulta.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException erronovo) {
                erronovo.printStackTrace();
            }
        }
    }
    
    public void Buscar(int id, Chuteira chuteira){
        try{
            conexao = DriverManager.getConnection(banco, "root", "");
            minhaConsulta = conexao.prepareStatement("Select marca, modelo, tamanho, preco FROM chuteira WHERE id = ?");
            minhaConsulta.setInt(1, id);
            ResultSet resultados = minhaConsulta.executeQuery();
           
                       
            ResultSetMetaData colunas = resultados.getMetaData();
            int numeroColunas = colunas.getColumnCount();
            
            if(resultados.next()){                
                String marca = resultados.getString("marca");
                String modelo = resultados.getString("modelo");
                int tamanho = resultados.getInt("tamanho");
                double preco = resultados.getDouble("preco");
                               
                
                
                chuteira.setMarca(marca);               
                chuteira.setModelo(modelo);
                chuteira.setTamanho(tamanho);
                chuteira.setPreco(preco);
                JOptionPane.showMessageDialog(null, "Dados buscados com sucesso");
            
            }
            
        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            try {
                if (minhaConsulta != null) {
                    minhaConsulta.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException erronovo) {
                erronovo.printStackTrace();
            }
        }
    }
    
public void Alterar(String marca, String modelo, int tamanho, double preco, int id) {
        try {
            conexao = DriverManager.getConnection(banco, "root", "");
            minhaConsulta = conexao.prepareStatement("UPDATE chuteira SET marca = ?, Modelo=?, tamanho = ?, preco = ? WHERE  Id=?;");
            minhaConsulta.setString(1, marca);
            minhaConsulta.setString(2, modelo);
            minhaConsulta.setInt(3, tamanho);
            minhaConsulta.setDouble(4, preco);
            minhaConsulta.setInt(5, id);
            minhaConsulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            

        } catch (SQLException erro) {
            erro.printStackTrace();
        } finally {
            try {
                if (minhaConsulta != null) {
                    minhaConsulta.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException erronovo) {
                erronovo.printStackTrace();
            }
        }
    }

public static Connection obterConexao() {
        Connection conn = null;
        try {
            // Registrar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Estabelecer a conexão
            conn = DriverManager.getConnection(banco, "root", "");
            System.out.println("Conexao com o banco de dados estabelecida.");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro: Driver JDBC não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erro: Falha na conexão com o banco de dados.");
            e.printStackTrace();
        }
        return conn;
    }

    public static void fecharConexao(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Conexao com o banco de dados fechada.");
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar a conexao com o banco de dados.");
                ex.printStackTrace();
            }
        }
    }
}

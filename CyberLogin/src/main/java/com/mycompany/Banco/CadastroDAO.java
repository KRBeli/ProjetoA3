package com.mycompany.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CadastroDAO {

    public void inserirEvento(CadastroEvento cadastroEvento){
        String sql = "insert into eventos (nome, descricao, datainicio, datafim, horainicio, horafim) values (?, ?, ?, ?, ?, ?);";
                try (Connection conn = Conexao.obterConexao();
                     PreparedStatement ps = conn.prepareStatement(sql);) {
                    ps.setString(1, cadastroEvento.getNomeEvento());
                    ps.setString(2, cadastroEvento.getDescricao());
                    ps.setString(3, cadastroEvento.getDataInicio());
                    ps.setString(4, cadastroEvento.getDataFim());
                    ps.setString(5, cadastroEvento.getHoraInicio());
                    ps.setString(6, cadastroEvento.getHoraFim());
                    ps.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//DAO quer dizer Data Access Object
    public void inserir(Cadastro cadastro){
String sql = "insert into cliente (nome, email, idade, cpf, sexo, senha) values (?, ?, ?, ?, ?, ?);";
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, cadastro.getNome());
            ps.setString(2, cadastro.getEmail());
            ps.setInt(3, cadastro.getIdade());
            ps.setString(4, cadastro.getCpf());
            ps.setString(5, cadastro.getSexo());
            ps.setString(6, cadastro.getSenha());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Cadastro buscar(int id) {
        String sql = "select * from cliente where ID_CLIENTE = ?;";
        try (Connection conn = Conexao.obterConexao();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    String email = rs.getString("email");
                    String cpf = rs.getString("cpf");
                    String sexo = rs.getString("sexo");
                    int idade = rs.getInt("idade");
                    String senha = rs.getString("senha");
                    return new Cadastro(nome, email, cpf,sexo,senha,idade);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean checkLogin (String email, String senha) throws SQLException{
        Connection con = Conexao.obterConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try{
            stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE email = ? and senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }
        }catch (SQLException ex){
            Logger.getLogger(CadastroDAO.class.getName()).log(Level.SEVERE,null,ex);
        }
        return check;
    }
}

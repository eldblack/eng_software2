/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import bd.ConexaoSQlite;
import classes.Reserva;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author pedro
 */
public class VerificaChoquedeHorario {
    public static boolean verifica(Reserva reserva) throws SQLException{
         boolean valido = true; 
      ConexaoSQlite conec = new  ConexaoSQlite();    
       conec.conectar();
       
          ResultSet resultset = null;
           Statement statement = null;
        
          
          String sql = "SELECT * FROM tbl_reserva;";
          statement = conec.criarStatement();
           resultset = statement.executeQuery(sql);
           while (resultset.next()) {

                   
                            if(resultset.getInt("numMesa") == reserva.getNumMesa()){
                                               System.out.println("1");
                                String[] separa =  resultset.getString("data").split("/");
                                String[] rese = reserva.getData().split("/");
                                    if(separa[2].equals(rese[2])){
                                                       System.out.println("1");
                                        if(separa[1].equals(rese[1])){
                                            if(separa[0].equals(rese[0])){
                                                String[] recebehora = resultset.getString("hora").split(":");
                                                String[] horareserva = reserva.getHora().split(":");
                                                String concatenarecebehora ="";
                                                concatenarecebehora = concatenarecebehora.concat(recebehora[0]+recebehora[1]);
                                                String concatenahorareserva = "";
                                                concatenahorareserva = concatenahorareserva.concat(horareserva[0]+horareserva[1]);
                                                int hora1 = Integer.valueOf(concatenarecebehora);
                                                int hora2 = Integer.valueOf( concatenahorareserva);
                                                    if(hora1==hora2 || (hora1+100)>hora2 || (hora1-100)>hora2 ){
                                                        valido = false;
                                                    }
                                            }
                                        }
                                    }
                                
                            }

    }
           return valido;
}
}
    


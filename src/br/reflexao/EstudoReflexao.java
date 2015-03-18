package br.reflexao;

import java.lang.reflect.Field;

/**
 * Created by juliosossai on 18/03/2015.
 */
public class EstudoReflexao {

    public static String descobreNome(Cliente nomeTabela){
        String nome = nomeTabela.getClass().getName();
        String nomeCanonico = nomeTabela.getClass().getCanonicalName();
        String nomeSimples = nomeTabela.getClass().getSimpleName();

        StringBuffer nomeTab = new StringBuffer();
        nomeTab.append("create table ");
        nomeTab.append(nomeSimples);
        return nomeTab.toString();

    }

    public static String descobreAtributos(Cliente nomeCampo){
        Field[] fields = nomeCampo.getClass().getDeclaredFields();

        StringBuffer nomeColuna = new StringBuffer();
        for (int i = 0; i < fields.length; i++){
            nomeColuna.append(" ");
            nomeColuna.append(fields[i].getName());
            nomeColuna.append(",");
        }
        return nomeColuna.toString();

        /*for (int i = 0; i < fields.length; i++){
            System.out.println("create table "+ fields[i].getName());
        }*/
    }

    public static void main(String[] args) {
          // descobreAtributos(new Cliente());
        StringBuffer create = new StringBuffer();
        create.append(descobreNome(new Cliente()));
        create.append(descobreAtributos(new Cliente()));

        System.out.println(create.toString());

    }
}

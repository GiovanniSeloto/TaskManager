package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BancoDadosEquipe {
private static final String CAMINHO = "EQUIPE.data";
	
	public void escreverArquivoData(Equipe equipe) {
		
		List<Equipe> lista = leituraBancoDados(); // Recupera o que já existe
        lista.add(equipe);
			try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO))) {
				oos.writeObject(lista);
	            oos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public static List<Equipe> leituraBancoDados() 
	{
        File arquivo = new File(CAMINHO);
        if (!arquivo.exists()) return new ArrayList<Equipe>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CAMINHO))) {
            return (List<Equipe>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        	return new ArrayList<Equipe>(null); // Retorna equipe vazio se houver erro ou arquivo vazio
        }
	}
	
	public static void removerEquipeData(Equipe equipe) {
		List<Equipe> lista = leituraBancoDados();
		for(int i = 0; i< lista.size(); i++) {
			if(lista.get(i).getNomeEquipe().equals(equipe.getNomeEquipe())) {
				lista.remove(i);
			}
		}
		lista.forEach(System.out::println);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO))) {
            oos.writeObject(lista);
            //oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void alterarEquipeData(Equipe comDadosAntigos, Equipe comDadosNovos) {
		List<Equipe> lista = leituraBancoDados();
		for(int i = 0; i< lista.size(); i++) {
			if(lista.get(i).getNomeEquipe().equals(comDadosAntigos.getNomeEquipe())) {
				lista.set(i, comDadosNovos);
			}
		}
		lista.forEach(System.out::println);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO))) {
            oos.writeObject(lista);
            //oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	protected static Equipe retornarEquipePeloNome(String nome) {
		List<Equipe> aux = leituraBancoDados();
		for(Equipe i : aux) {
			if(i.getNomeEquipe().equals(nome)) {
				return i;
			}
		}
		return null;
	}
}

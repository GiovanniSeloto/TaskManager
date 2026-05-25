package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BancoDadosUsuario {
	
	private static final String CAMINHO = "USUARIO.data";
	
	public void escreverArquivoData(Usuario user) {

		List<Usuario> lista = leituraBancoDados(); // Recupera o que já existe
        lista.add(user);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO))) {
			oos.writeObject(lista);
	        oos.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }	
	}
	
	public static List<Usuario> leituraBancoDados() 
	{
        File arquivo = new File(CAMINHO);
        if (!arquivo.exists()) return new ArrayList<Usuario>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CAMINHO))) {
            return (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        	return new ArrayList<Usuario>(null); // Retorna usuario vazio se houver erro ou arquivo vazio
        }
	}
	
	public static void removerUsuarioData(Usuario user) {
		List<Usuario> lista = leituraBancoDados();
		for(int i = 0; i< lista.size(); i++) {
			if(lista.get(i).getNomeUsuario().equals(user.getNomeUsuario())) {
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
	
	public static void alterarUsuarioData(Usuario comDadosAntigos, Usuario comDadosNovos) {
		List<Usuario> lista = leituraBancoDados();
		for(int i = 0; i< lista.size(); i++) {
			if(lista.get(i).getCPFUsuario().equals(comDadosAntigos.getCPFUsuario())) {
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
	
	protected static Usuario retornarUsuarioPeloCPF(String CPF) {
		List<Usuario> aux = leituraBancoDados();
		for(Usuario i : aux) {
			if(i.getCPFUsuario().equals(CPF)) {
				return i;
			}
		}
		return null;
	}
	
	protected static Usuario retornarUsuarioPeloNome(String nome) {
		List<Usuario> aux = leituraBancoDados();
		for(Usuario i : aux) {
			if(i.getNomeUsuario().equals(nome)) {
				return i;
			}
		}
		return null;
	}
}
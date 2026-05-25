package Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BancoDadosProjeto {
	
	private static final String CAMINHO = "PROJETO.data";
	
	public void escreverArquivoData(Projeto project) {
		
		List<Projeto> lista = leituraBancoDados(); // Recupera o que já existe
        
		lista.add(project);
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO))) {
			oos.writeObject(lista);
	        oos.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	public static List<Projeto> leituraBancoDados() 
	{
        File arquivo = new File(CAMINHO);
        if (!arquivo.exists()) return new ArrayList<Projeto>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(CAMINHO))) {
            return (List<Projeto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
        	return new ArrayList<Projeto>(null); // Retorna usuario vazio se houver erro ou arquivo vazio
        }
	}
	
	public static void removerProjetoData(Projeto project) {
		List<Projeto> lista = leituraBancoDados();
		for(int i = 0; i< lista.size(); i++) {
			if(lista.get(i).getNomeProjeto().equals(project.getNomeProjeto())) {
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
	
	protected static List<Usuario> retornarUsuariosGerente() {
		List<Usuario> aux = BancoDadosUsuario.leituraBancoDados();
		List<Usuario> usuarioGerente = new ArrayList<Usuario>();
		for(Usuario i : aux) {
			if(i.getPerfil().equals(PerfilUsuarios.GERENTE)) {
				usuarioGerente.add(i);
			}
		}
		return usuarioGerente;
	}

	public List<Projeto> retornarTodosProjetos() {
		return leituraBancoDados();
	}
	
	protected static Projeto retornarUsuarioPeloNome(String nome) {
		List<Projeto> aux = leituraBancoDados();
		for(Projeto i : aux) {
			if(i.getNomeProjeto().equals(nome)) {
				return i;
			}
		}
		return null;
	}

	public Projeto retornarProjetoPeloNome(String nome) {
		List<Projeto> aux = leituraBancoDados();
		for(Projeto i : aux) {
			if(i.getNomeProjeto().equals(nome)) {
				return i;
			}
		}
		return null;
	}
	
	public static void alterarUsuarioData(Projeto comDadosAntigos, Projeto comDadosNovos) {
		List<Projeto> lista = leituraBancoDados();
		for(int i = 0; i< lista.size(); i++) {
			if(lista.get(i).getNomeProjeto().equals(comDadosAntigos.getNomeProjeto())) {
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
	
}
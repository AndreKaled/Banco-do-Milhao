package Util;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JLabel;

import modelo.Itens;

public class RandomItem {

	private Set<Itens> lista = new LinkedHashSet<Itens>();
	private Itens[] itens = { new Itens("Ursinho"), new Itens("Carrinho"), new Itens("Boneco"), new Itens("Dado"), new Itens("Bolinha de Gude"), new Itens("Peteca"), new Itens("Quebra-Cabeça"), 
			new Itens("Cama"), new Itens("Sofá"), new Itens("Mesa"), new Itens("Lençol"), new Itens("Travesseiro"), new Itens("Guarda-Roupa"), new Itens("Air Frever"),
			new Itens("Celular"), new Itens("Notebook"), new Itens("Computador"), new Itens("Televisão"), new Itens("Mouse"), new Itens("Micro-Ondas"),
			new Itens("Bola"), new Itens("Tênis de corrida"), new Itens("Patins"), new Itens("Skate"), new Itens("Raquete"), new Itens("Rede"), new Itens("Caneleira"),
			new Itens("Guitarra"), new Itens("Baixo"), new Itens("Bateria"), new Itens("Baqueta"), new Itens("Flauta"), new Itens("Piano"),
			new Itens("Pedra"), new Itens("Tijolo"), new Itens("Cimento"), new Itens("Picareta"), new Itens("Areia"), new Itens("Pá"), new Itens("Concreto"),
			new Itens("Camisa"), new Itens("Saia"), new Itens("Cueca"), new Itens("Jaqueta"), new Itens("Bota"), new Itens("Pulseira"), new Itens("Colar"),
			new Itens("Café"), new Itens("Leite"), new Itens("Capuccino"), new Itens("Pão"), new Itens("Bolo"), new Itens("Café Expresso"), new Itens("tapioca"),
			new Itens("Flor Tulipa"), new Itens("Girassol"), new Itens("Rosa"), new Itens("Gardênia"), new Itens("Lavanda"), new Itens("Vaso"), new Itens("Adubo"),
			new Itens("Jóia"), new Itens("Colar"), new Itens("Brinco"), new Itens("Gargantilha"), new Itens("Anel"), new Itens("Aliança"), new Itens("Cordão"),
			new Itens("X-Salada"), new Itens("Pão com atum"), new Itens("Refrigerante"), new Itens("MilkShake"), new Itens("Batata frita"), new Itens("Salgadinho"), new Itens("Suco de laranja"),
			new Itens("Livro de matemática"), new Itens("O Grande Príncipe"), new Itens("O Trono de Pedra"), new Itens("Histórias para dormir"), new Itens("Bonézinho Vermelho"), new Itens("Os Três Macacos"), new Itens("Dicionário"),
			new Itens("Arroz"), new Itens("Macarrão"), new Itens("Pasta de Dente"), new Itens("Papel Higiênico"), new Itens("Biscoito"), new Itens("Enlatados"), new Itens("Queijo"),
			new Itens("Papel"), new Itens("Lápis"), new Itens("Borracha"), new Itens("Apontador"), new Itens("Caneta"), new Itens("Caderno"), new Itens("Tesoura"),
			new Itens("Perfume"), new Itens("Sabonete"), new Itens("Shampoo"), new Itens("Condicionador"), new Itens("Máscara"), new Itens("Esmalte"), new Itens("Batom"),
			new Itens("Ração"), new Itens("Pente para cachorro"), new Itens("Ossinho de brinquedo"), new Itens("Coleira"), new Itens("Casinha de cachorro"), new Itens("Mordedor"), new Itens("Shampoo de cachorro"),
			new Itens("Petit Gateau"), new Itens("Lagosta Frita"), new Itens("Suco de Uva"), new Itens("Tambaqui"), new Itens("Picanha"), new Itens("Sopa"), new Itens("Sorvete"),
			new Itens("Tênis"), new Itens("Bota"), new Itens("Sapato"), new Itens("Graxa"), new Itens("Meia"), new Itens("Cadarço"), new Itens("Sapatilha")
			};
	private Random r = new Random();
	private static final int QUANT = 6;

	/*
	 * 1. LOJA DE BRINQUEDOS
	 * 2. LOJA DE COISAS DA CASA
	 * 3. LOJA DE ELETRONICOS (espaço tech)
	 * 4. LOJA DE ESPORTE
	 * 5. LOJA DE INSTRUMENTOS MUSICAIS
	 * 6. LOJA DE MATERIAIS DE CONSTRUÇÃO
	 * 7. BRECHÓ
	 * 8. CAFETERIA
	 * 11. FLORICULTURA
	 * 12. JOALHERIA
	 * 13. LANCHONETE
	 * 14. LIVRARIA
	 * 15. MERCADINHO
	 * 16. PAPELARIA
	 * 17. COSMÉTICOS
	 * 18. PET SHOP
	 * 19. RESTAURANTE
	 * 20. SAPATARIA
	 */
	
	public RandomItem() {
		gerarItens();
		mostrar();
	}

	public void gerarItens() {
		while(lista.size() != QUANT)
			lista.add(itens[r.nextInt(itens.length)]);
	}

	public void mostrar() {
		for (Itens o : lista) {
			System.out.println(o);
		}
	}

	public LinkedHashSet<Itens> verLista(){
		return (LinkedHashSet<Itens>) lista;
	}
	
	public Itens[] verItens() {
		Itens[] itens = new Itens[lista.size()];
		int i=0;
		
		Iterator<Itens> iteratorItens = lista.iterator();
		while(iteratorItens.hasNext()) {
			itens[i] = iteratorItens.next();
			i++;
		}
		
		return itens;
		
	}
	
}

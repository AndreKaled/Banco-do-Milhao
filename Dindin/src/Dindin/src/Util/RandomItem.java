package Util;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import modelo.Itens;
import modelo.Jogador;

public class RandomItem {

	private Set<Itens> lista = new LinkedHashSet<Itens>();
	private Itens[] itens = { new Itens("Ursinho"), new Itens("Carrinho"), new Itens("Boneco"), new Itens("Dado"), new Itens("Bolinha de Gude"), new Itens("Peteca"), new Itens("Quebra-Cabe�a"), 
			new Itens("Cama"), new Itens("Sof�"), new Itens("Mesa"), new Itens("Len�ol"), new Itens("Travesseiro"), new Itens("Guarda-Roupa"), new Itens("Air Frever"),
			new Itens("Celular"), new Itens("Notebook"), new Itens("Computador"), new Itens("Televis�o"), new Itens("Mouse"), new Itens("Micro-Ondas"),
			new Itens("Bola"), new Itens("T�nis de corrida"), new Itens("Patins"), new Itens("Skate"), new Itens("Raquete"), new Itens("Rede"), new Itens("Caneleira"),
			new Itens("Guitarra"), new Itens("Baixo"), new Itens("Bateria"), new Itens("Baqueta"), new Itens("Flauta"), new Itens("Piano"),
			new Itens("Pedra"), new Itens("Tijolo"), new Itens("Cimento"), new Itens("Picareta"), new Itens("Areia"), new Itens("P�"), new Itens("Concreto"),
			new Itens("Camisa"), new Itens("Saia"), new Itens("Cueca"), new Itens("Jaqueta"), new Itens("Bota"), new Itens("Pulseira"), new Itens("Colar"),
			new Itens("Caf�"), new Itens("Leite"), new Itens("Capuccino"), new Itens("P�o"), new Itens("Bolo"), new Itens("Caf� Expresso"), new Itens("tapioca"),
			new Itens("Flor Tulipa"), new Itens("Girassol"), new Itens("Rosa"), new Itens("Gard�nia"), new Itens("Lavanda"), new Itens("Vaso"), new Itens("Adubo"),
			new Itens("J�ia"), new Itens("Colar"), new Itens("Brinco"), new Itens("Gargantilha"), new Itens("Anel"), new Itens("Alian�a"), new Itens("Cord�o"),
			new Itens("X-Salada"), new Itens("P�o com atum"), new Itens("Refrigerante"), new Itens("MilkShake"), new Itens("Batata frita"), new Itens("Salgadinho"), new Itens("Suco de laranja"),
			new Itens("Livro de matem�tica"), new Itens("O Grande Pr�ncipe"), new Itens("O Trono de Pedra"), new Itens("Hist�rias para dormir"), new Itens("Bon�zinho Vermelho"), new Itens("Os Tr�s Macacos"), new Itens("Dicion�rio"),
			new Itens("Arroz"), new Itens("Macarr�o"), new Itens("Pasta de Dente"), new Itens("Papel Higi�nico"), new Itens("Biscoito"), new Itens("Enlatados"), new Itens("Queijo"),
			new Itens("Papel"), new Itens("L�pis"), new Itens("Borracha"), new Itens("Apontador"), new Itens("Caneta"), new Itens("Caderno"), new Itens("Tesoura"),
			new Itens("Perfume"), new Itens("Sabonete"), new Itens("Shampoo"), new Itens("Condicionador"), new Itens("M�scara"), new Itens("Esmalte"), new Itens("Batom"),
			new Itens("Ra��o"), new Itens("Pente para cachorro"), new Itens("Ossinho de brinquedo"), new Itens("Coleira"), new Itens("Casinha de cachorro"), new Itens("Mordedor"), new Itens("Shampoo de cachorro"),
			new Itens("Petit Gateau"), new Itens("Lagosta Frita"), new Itens("Suco de Uva"), new Itens("Tambaqui"), new Itens("Picanha"), new Itens("Sopa"), new Itens("Sorvete"),
			new Itens("T�nis"), new Itens("Bota"), new Itens("Sapato"), new Itens("Graxa"), new Itens("Meia"), new Itens("Cadar�o"), new Itens("Sapatilha")
			};
	private Random r = new Random();
	private static final int QUANT = 6;

	/*
	 * 1. LOJA DE BRINQUEDOS
	 * 2. LOJA DE COISAS DA CASA
	 * 3. LOJA DE ELETRONICOS (espa�o tech)
	 * 4. LOJA DE ESPORTE
	 * 5. LOJA DE INSTRUMENTOS MUSICAIS
	 * 6. LOJA DE MATERIAIS DE CONSTRU��O
	 * 7. BRECH�
	 * 8. CAFETERIA
	 * 11. FLORICULTURA
	 * 12. JOALHERIA
	 * 13. LANCHONETE
	 * 14. LIVRARIA
	 * 15. MERCADINHO
	 * 16. PAPELARIA
	 * 17. COSM�TICOS
	 * 18. PET SHOP
	 * 19. RESTAURANTE
	 * 20. SAPATARIA
	 */

	//gerandor da lista aleat�ria
	public void gerarItens() {
		if(lista.size()==QUANT)
			esvaziarItens();
		while(lista.size() != QUANT)
			lista.add(itens[r.nextInt(itens.length)]);
	}

	//apresentador da lista
	public void mostrar() {
		for (Itens o : lista) {
			System.out.println(o);
		}
	}

	//acesso a lista de itens
	public Set<Itens> verLista(){
		return lista;
	}
	
	//acesso a lista de itens (uso preferencial ao front)
	public Itens[] verItens() {
		Itens[] itens = new Itens[lista.size()];
		int i=0;
		
		for(Itens o: lista) {
			itens[i] = o;
			i++;
		}
		
		return itens;
	}
	
	//limpandor da cole��o de itens
	public void esvaziarItens() {
		lista.clear();
	}
	
	//iniciando lista de compras por jogador
	public void iniciaLista() {
		gerarItens();
	}
}

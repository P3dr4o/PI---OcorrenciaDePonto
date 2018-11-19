package Model;

public class ListaDuplamenteEncadeada {

	class Celula {
		Celula ant, prox;
		Object item;
	}

	public ListaDuplamenteEncadeada() {
		this.primeiro = new Celula();
		this.ultimo = this.primeiro;
		this.primeiro.prox = null;
		this.primeiro.ant = null;
	}

	Celula primeiro, ultimo, atual;

	public void insereUltimo(Object x) {
		Celula aux = this.ultimo;
		this.ultimo = new Celula();
		this.ultimo.ant = aux;
		aux.prox = this.ultimo;
		this.ultimo.item = x;
		this.ultimo.prox = null;
	}

	public void inserePrimeiro(Object x) {
		Celula aux = this.primeiro;
		this.primeiro = new Celula();
		this.primeiro.prox = aux;
		aux.ant = this.primeiro;
		this.primeiro.prox.item = x;
	}

	public Object retiraPrimeiro() throws Exception {
		if (this.vazia()) {
			throw new Exception("Erro: Lista Vazia.");
		}
		Celula aux = this.primeiro;
		Celula q = aux.prox;
		Object item = q.item;
		aux.prox = q.prox;
		if (aux.prox == null) {
			this.ultimo = aux;
		} else {
			aux.prox.ant = aux;
		}
		return item;
	}

	public Object retiraUltimo() throws Exception {
		if (this.vazia()) {
			throw new Exception("Erro: Lista vazia.");
		} else {
			Celula aux = this.ultimo;
			Celula q = aux.ant;
			Object item = q.item;
			aux.ant = q.ant;
			if (aux.ant == null)
				this.primeiro = aux;
			else
				aux.ant.prox = aux;
			return item;
		}
	}

	public Object primeiro() throws Exception {
        if (!this.vazia()) {
            Celula aux = this.primeiro.prox;
            this.atual = aux.prox;
            return aux.item;
        } else
			throw new Exception("Erro: Lista Vazia");
    }

	public Object ultimo() throws Exception {
		if (!this.vazia()) {
			Celula aux = this.ultimo;
			this.atual = aux.ant;
			return this.ultimo.item;
		} else
			throw new Exception("Erro: Lista Vazia");
	}

	public Object proximo() {
		return this.atual.prox;
	}

	public Object anterior() {
		return this.atual.ant;
	}

	public void imprime() {
		Celula aux;
		aux = this.primeiro.prox;
		while (aux != null) {
			System.out.println(" " + aux.item.toString());
			aux = aux.prox;
		}
		System.out.println("");
	}

	public boolean vazia() {
		return (this.primeiro == this.ultimo);
	}

	public boolean isExist(Object x) {
		Celula aux = this.primeiro.prox;
		if (aux == null)
			return false;
		while (aux != null) {
			if (aux.item.equals(x))
				return true;
			else
				aux = aux.prox;
		}
		return false;
	}

	public ListaDuplamenteEncadeada mesclar(ListaDuplamenteEncadeada L_11, int p11,
			ListaDuplamenteEncadeada L_12, int p12) throws Exception {

		if (p11 < 0 || p11 > 1 || p12 > 1 || p12 < 0)
			throw new Exception("Erro: parametros incorretos");
		else {
			ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
			Celula aux11;
			Celula aux12;
			if (p11 == 0)
				aux11 = L_11.primeiro;
			else
				aux11 = L_11.ultimo;

			if (p12 == 0)
				aux12 = L_12.primeiro;
			else
				aux12 = L_12.ultimo;

			while (aux11 != null || aux12 != null) {
				if (aux11 != null) {
					lista.insereUltimo(aux11.item);
					if (p11 == 0)
						aux11 = aux11.prox;
					else
						aux11 = aux11.ant;
				}
				if (aux12 != null) {
					lista.insereUltimo(aux12.item);
					if (p12 == 0)
						aux12 = aux12.prox;
					else
						aux12 = aux12.ant;
				}
			}
			return lista;
		}

	}
}


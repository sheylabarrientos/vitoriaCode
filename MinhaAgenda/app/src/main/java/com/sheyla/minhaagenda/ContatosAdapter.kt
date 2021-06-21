package com.sheyla.minhaagenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//Classe de Adapter: vínculo entre dataset e viewholder (item) // Lista de Filmes TMDB
class ContatosAdapter(var dataSet: MutableList<Contato>, private val listener : OnItemClickListener) :
    RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>() {

    // ============= VIEWHOLDER ===============
    //Classe de Viewholder: view de atributos xml <> código:
    // referência entre os componentes e o código (ex. findViewById)
    class ContatosViewHolder(view: View) : RecyclerView.ViewHolder(view) { // qual item vou reciclar
        val nome = view.findViewById<TextView>(R.id.itemNome)
        val telefone = view.findViewById<TextView>(R.id.itemTelefone)
        val descricao = view.findViewById<TextView>(R.id.itemReferencia)
        val btnExcluir = view.findViewById<TextView>(R.id.btnExcluir)
    }

    interface OnItemClickListener {
        fun onBtnDeleteClick (position: Int)
    }

    // ============== ADAPTER ==================
    //Ciclo de vida vulgo método que cria o viewholder ## INFLA SUA APLICAÇÃO
    // parent = componente mãe que vai chamar esse meu adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatosViewHolder {
        val instanciaView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contato, parent, false) // infla essa view na parent
        return ContatosViewHolder(instanciaView)
    }

    // Vìnculo entre dataset x item (layout)
    // Substituir os itens do layout pelos itens do meu DATASET
    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        holder.nome.text = dataSet[position].nome
        holder.telefone.text = dataSet[position].telefone
        holder.descricao.text = dataSet[position].referencia
        holder.btnExcluir
    }

    // Tamanho do DATASET / Tamnho dos itens da lista
    override fun getItemCount(): Int = dataSet.size

    fun atualizarLista(listaFiltrada: MutableList<Contato>){
        //dataSet = clear()
        notifyDataSetChanged()
        // notifyItemChanged() modificar um item
    }
}
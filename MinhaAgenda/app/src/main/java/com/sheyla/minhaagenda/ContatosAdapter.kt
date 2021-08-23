package com.sheyla.minhaagenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.minhaagenda.SecondActivity.Companion.contatosList
import kotlinx.android.synthetic.main.item_contato.view.*

//Classe de Adapter: vínculo entre dataset e viewholder (item) // Lista de Filmes TMDB
class ContatosAdapter(var dataSet: List<Pessoa>) :
    RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>() {

    // ============= VIEWHOLDER ===============
    //Classe de Viewholder: view de atributos xml <> código:
    // referência entre os componentes e o código (ex. findViewById)
    class ContatosViewHolder(view: View) : RecyclerView.ViewHolder(view) { // qual item vou reciclar
        val nome = view.findViewById<TextView>(R.id.itemNome)
        val telefone = view.findViewById<TextView>(R.id.itemTelefone)
        val descricao = view.findViewById<TextView>(R.id.itemReferencia)
        val btnExcluir = view.findViewById<TextView>(R.id.btnExcluir)

        fun bindContato(pessoa: Pessoa) {
            nome.text = pessoa.nome
            telefone.text = pessoa.telefone
            descricao.text = pessoa.referencia
        }
    }

//    interface OnItemClickListener {
//        fun onBtnDeleteClick (position: Int)
//    }

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
        holder.bindContato(dataSet[position])
//        holder.nome.text = dataSet[position].nome
//        holder.telefone.text = dataSet[position].telefone
//        holder.descricao.text = dataSet[position].referencia
//        holder.btnExcluir.setOnClickListener {
////            listener?.let{
////                it.setOnDeleteListener()
////            }
        holder.itemView.btnExcluir.setOnClickListener {
            contatosList.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
        }
    }

    // Tamanho do DATASET / Tamnho dos itens da lista
    override fun getItemCount(): Int = dataSet.size

//    fun atualizarLista(listaFiltrada: MutableList<Pessoa>){
//        //dataSet = listaFiltrada
//        notifyDataSetChanged()
//        // notifyItemChanged() modificar um item
//    }
}
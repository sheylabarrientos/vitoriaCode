package com.sheyla.mymovies.ui.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R

class ProfilesAdapter(var dataSet: List<UserProfile>) :
    RecyclerView.Adapter<ProfilesAdapter.ProfilesViewHolder>() {

    // ============= VIEWHOLDER ===============
    //Classe de Viewholder: view de atributos xml <> código:
    // referência entre os componentes e o código (ex. findViewById)
    class ProfilesViewHolder(view: View) : RecyclerView.ViewHolder(view) { // qual item vou reciclar
        val itemProfile: TextView? = view.findViewById(R.id.item_name)

    }

//    interface OnItemClickListener {
//        fun onBtnDeleteClick (position: Int)
//    }

    // ============== ADAPTER ==================
    //Ciclo de vida vulgo método que cria o viewholder ## INFLA SUA APLICAÇÃO
    // parent = componente mãe que vai chamar esse meu adapter
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfilesViewHolder {
        val instanciaView = LayoutInflater.from(parent.context).inflate(R.layout.item_profile, parent, false) // infla essa view na parent
        return ProfilesViewHolder(instanciaView)
    }
    // Vìnculo entre dataset x item (layout)
    // Substituir os itens do layout pelos itens do meu DATASET
    override fun onBindViewHolder(holder: ProfilesViewHolder, position: Int) {
            holder.itemProfile?.text = dataSet[position].name
//        holder.nome.text = dataSet[position].nome
//        holder.telefone.text = dataSet[position].telefone
//        holder.descricao.text = dataSet[position].referencia
//        holder.btnExcluir.setOnClickListener {
////            listener?.let{
////                it.setOnDeleteListener()
////            }
    }

    // Tamanho do DATASET / Tamnho dos itens da lista
    override fun getItemCount(): Int = dataSet.size

//    fun atualizarLista(listaFiltrada: MutableList<Pessoa>){
//        //dataSet = listaFiltrada
//        notifyDataSetChanged()
//        // notifyItemChanged() modificar um item
//    }
}
package com.jam.periodictable.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.jam.periodictable.Db.TableElementModel
import com.jam.periodictable.R
import com.jam.periodictable.databinding.PeriodicLayoutBinding

class ElementAdapter(var mainlist: List<TableElementModel>,var adapterclick : AdapterOnClick) :
    RecyclerView.Adapter<ElementAdapter.ViewHolder>() {

    class ViewHolder(binding: PeriodicLayoutBinding, var itemClick: AdapterOnClick) :
        RecyclerView.ViewHolder(binding.root) {
        var bindings: PeriodicLayoutBinding = binding
        fun bindIdea(dataPor: TableElementModel) {
            itemView.apply {
                bindings.title.text = dataPor.Element
                bindings.subtitle.text = dataPor.AtomicMass
                bindings.number.text = dataPor.AtomicNumber
                bindings.symbol.text = dataPor.Symbol
            }
            itemView.setOnClickListener {
                itemClick.onclick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.periodic_layout, parent, false
            ), adapterclick
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mainlist[position]
        holder.bindIdea(data)

    }

    override fun getItemCount(): Int {
        return mainlist.size
    }
}

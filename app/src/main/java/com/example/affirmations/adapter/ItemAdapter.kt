package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

/**
 * Адаптер для [RecyclerView] в [MainActivity]. Отображает объект данных [Affirmation]
 */
class ItemAdapter(
    private val context: Context, private
    val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // Предоставляем ссылку на представления для каждого элемента данных
    // Сложные элементы данных могут нуждаться в более чем одном представлении для каждого элемента, и
    // вы предоставляете доступ ко всем представлениям для элемента данных в держателе представления.
    // Каждый элемент данных — это просто объект Affirmation.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
    }

    /**
     * Создание новых представлений (вызывается менеджером компоновки)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // создаем новое представление
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /**
     * Возвращает размер вашего набора данных (вызывается менеджером компоновки)
     */
    override fun getItemCount() = dataset.size

    /**
     * Заменить содержимое представления (вызывается менеджером компоновки)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }
}

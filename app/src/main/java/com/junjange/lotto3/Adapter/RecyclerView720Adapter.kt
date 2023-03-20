package com.junjange.lotto3.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junjange.lotto3.Lotto720Room.Lotto720Entity
import com.junjange.lotto3.MainViewModel
import com.junjange.lotto3.R
import kotlinx.android.synthetic.main.recycler720_item.view.*
import kotlinx.android.synthetic.main.recycler_item.view.*


class RecyclerView720Adapter internal constructor(val context: Context,var onDeleteListener : MainViewModel)
    : RecyclerView.Adapter<RecyclerView720Adapter.Lotto720ViewHolder>()
{

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<Lotto720Entity>() // Cached copy of words


    inner class Lotto720ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lotto0 = itemView.number720ball0
        val lotto1 = itemView.number720ball1
        val lotto2 = itemView.number720ball2
        val lotto3 = itemView.number720ball3
        val lotto4 = itemView.number720ball4
        val lotto5 = itemView.number720ball5
        val lotto6 = itemView.number720ball6


        val deletebutton = itemView.button720
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Lotto720ViewHolder {
        val itemView = inflater.inflate(R.layout.recycler720_item, parent, false)
        return Lotto720ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Lotto720ViewHolder, position: Int) {
        val lotto = users[position]
        holder.lotto0.text = lotto.number0
        holder.lotto1.text = lotto.number1
        holder.lotto2.text = lotto.number2
        holder.lotto3.text = lotto.number3
        holder.lotto4.text = lotto.number4
        holder.lotto5.text = lotto.number5
        holder.lotto6.text = lotto.number6


        holder.deletebutton.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v:View?) {
                onDeleteListener.deleteAll(lotto)
                return
            }
        })
    }

    internal fun setUsers(users: List<Lotto720Entity>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size

}
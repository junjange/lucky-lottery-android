package com.junjange.lotto3.Adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.junjange.lotto3.HomeRoom.Home645Entity
import com.junjange.lotto3.Lotto645Room.Lotto645Entity
import com.junjange.lotto3.MainViewModel
import com.junjange.lotto3.R
import kotlinx.android.synthetic.main.recycler_item.view.*

class RecyclerView645Adapter internal constructor(val context: Context,var onDeleteListener : MainViewModel)
    : RecyclerView.Adapter<RecyclerView645Adapter.Lotto645ViewHolder>()
{

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var users = emptyList<Lotto645Entity>() // Cached copy of words


    inner class Lotto645ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lotto1 = itemView.numberball1
        val lotto2 = itemView.numberball2
        val lotto3 = itemView.numberball3
        val lotto4 = itemView.numberball4
        val lotto5 = itemView.numberball5
        val lotto6 = itemView.numberball6

        val deletebutton = itemView.button645
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Lotto645ViewHolder {
        val itemView = inflater.inflate(R.layout.recycler_item, parent, false)
        return Lotto645ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Lotto645ViewHolder, position: Int) {
        val lotto = users[position]
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

    internal fun setUsers(users: List<Lotto645Entity>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun getItemCount() = users.size


}


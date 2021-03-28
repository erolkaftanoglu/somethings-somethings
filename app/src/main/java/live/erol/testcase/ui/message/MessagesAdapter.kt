package live.erol.testcase.ui.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import live.erol.testcase.R
import live.erol.testcase.data.entity.Message

class MessagesAdapter(private val userID: String) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val OWN_MESSAGE = -1

    private var messageList = ArrayList<Message>()

    class MessagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class OwnMessagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemViewType(position: Int): Int {
        if (messageList[position].user.id == userID) return OWN_MESSAGE
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == OWN_MESSAGE) {
            val v =
                LayoutInflater.from(parent.context).inflate(R.layout.item_own_message, parent, false)
            return OwnMessagesViewHolder(v)
        }
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        return MessagesViewHolder(v)
    }

    override fun getItemCount(): Int = messageList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messageList[position]
        val textView = holder.itemView.findViewById<TextView>(R.id.textMessage)
        textView.text = "${message.text} - ${message.user.nickname}"
    }

    fun setMessageList(list: ArrayList<Message>) {
        messageList = ArrayList(list)
        notifyDataSetChanged()
    }

    fun addMessage(message: Message, scrollToNewMessage: () -> Unit) {
        messageList.add(0, message)
        notifyItemInserted(0)
        scrollToNewMessage.invoke()
    }


}
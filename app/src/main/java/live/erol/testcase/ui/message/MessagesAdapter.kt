package live.erol.testcase.ui.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import live.erol.testcase.R
import live.erol.testcase.data.entity.Message
import java.util.*
import kotlin.collections.ArrayList

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
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_own_message, parent, false)
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
        val avatar = holder.itemView.findViewById<ImageView>(R.id.avatar)
        val nickname = holder.itemView.findViewById<TextView>(R.id.nickname)
        val date = holder.itemView.findViewById<TextView>(R.id.date)
        textView.text = "${message.text}"
        avatar.load(message.user.avatarURL) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        nickname.text = message.user.nickname
        if (message.user.id != userID) {
            date.text = "${getShortDate(message.timestamp * 1000L)}"
        } else {
            date.text = "${getShortDate(message.timestamp)}"
        }
    }

    private fun getShortDate(ts: Long?): String {
        if (ts == null) return ""
        val calendar = Calendar.getInstance(Locale.getDefault())
        calendar.timeInMillis = ts
        return android.text.format.DateFormat.format("E, dd MMM yyyy - HH:mm", calendar).toString()
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
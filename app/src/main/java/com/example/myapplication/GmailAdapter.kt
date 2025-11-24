package com.example.myapplication
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemEmailBinding

class GmailAdapter(private val emails: List<EmailModel>) : RecyclerView.Adapter<GmailAdapter.GmailViewHolder>() {

    // ViewHolder sử dụng ViewBinding
    inner class GmailViewHolder(val binding: ItemEmailBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GmailViewHolder {
        val binding = ItemEmailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GmailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GmailViewHolder, position: Int) {
        val email = emails[position]

        // Gán dữ liệu text
        holder.binding.tvSender.text = email.sender
        holder.binding.tvTitle.text = email.title
        holder.binding.tvContent.text = email.content
        holder.binding.tvTime.text = email.time

        // Xử lý Avatar: Lấy chữ cái đầu tiên của Sender
        if (email.sender.isNotEmpty()) {
            holder.binding.tvAvatar.text = email.sender[0].toString().uppercase()
        }

        // (Tuỳ chọn) Đổi màu nền Avatar ngẫu nhiên nếu muốn đẹp hơn,
        // hoặc bạn có thể set cứng màu trong XML rồi thì thôi.
    }

    override fun getItemCount(): Int {
        return emails.size
    }
}
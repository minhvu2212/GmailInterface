package com.example.gmail

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmailAdapter(private var emails: List<Email>) :
    RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

    // ViewHolder giữ các tham chiếu đến views trong mỗi item
    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarText: TextView = itemView.findViewById(R.id.avatarText)
        val senderText: TextView = itemView.findViewById(R.id.senderText)
        val subjectText: TextView = itemView.findViewById(R.id.subjectText)
        val previewText: TextView = itemView.findViewById(R.id.previewText)
        val timestampText: TextView = itemView.findViewById(R.id.timestampText)
        val starButton: ImageButton = itemView.findViewById(R.id.starButton)
    }

    // Tạo ViewHolder mới
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
        // Inflate layout cho mỗi item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_email, parent, false)
        return EmailViewHolder(view)
    }

    // Gán dữ liệu vào ViewHolder
    override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
        val email = emails[position]

        holder.apply {
            // Set nội dung cho avatar (chữ cái đầu)
            avatarText.text = email.senderInitial

            // Set màu nền cho avatar
            avatarText.background.setColorFilter(
                email.avatarColor,
                PorterDuff.Mode.SRC_IN
            )

            // Set các thông tin khác
            senderText.text = email.sender
            subjectText.text = email.subject
            previewText.text = email.preview
            timestampText.text = email.timestamp

            // Set icon cho star button dựa vào trạng thái
            starButton.setImageResource(
                if (email.isStarred) R.drawable.ic_star
                else R.drawable.ic_star_border
            )

            // Xử lý sự kiện click vào star button
            starButton.setOnClickListener {
                // Toggle trạng thái star và cập nhật icon
                val currentEmail = emails[position]
                emails = emails.toMutableList().apply {
                    set(position, currentEmail.copy(isStarred = !currentEmail.isStarred))
                }
                notifyItemChanged(position)
            }

            // Xử lý sự kiện click vào item
            itemView.setOnClickListener {
                // Có thể thêm xử lý khi click vào email
                // Ví dụ: mở chi tiết email
            }
        }
    }

    // Trả về số lượng item trong danh sách
    override fun getItemCount() = emails.size

    // Phương thức để cập nhật danh sách email
    fun updateEmails(newEmails: List<Email>) {
        emails = newEmails
        notifyDataSetChanged()
    }
}
package com.example.gmail

data class Email(
    val senderInitial: String,    // Chữ cái đầu cho avatar (E, C, T,...)
    val sender: String,           // Tên người gửi
    val subject: String,          // Tiêu đề email
    val preview: String,          // Nội dung xem trước
    val timestamp: String,        // Thời gian gửi
    val isStarred: Boolean = false, // Trạng thái đánh dấu sao
    val avatarColor: Int          // Màu cho avatar circle
)
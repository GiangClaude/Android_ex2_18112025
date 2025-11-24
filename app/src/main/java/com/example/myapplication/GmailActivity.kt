package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityGmailBinding

class GmailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGmailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Thiết lập ViewBinding
        binding = ActivityGmailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Tạo dữ liệu giả (Mock Data) giống trong ảnh đề bài
        val emailList = arrayListOf(
            EmailModel("Edurila.com", "$19 Only (First 10 spots)", "Are you looking to Learn Web Designing...", "12:34 PM"),
            EmailModel("Chris Abad", "Help make Campaign Monitor better", "Let us know your thoughts! No Images...", "11:22 AM"),
            EmailModel("Tuto.com", "8h de formation gratuite and les...", "Photoshop, SEO, Blender, CSS, WordPre...", "11:04 AM"),
            EmailModel("support", "Société Ovh : suivi de vos services", "SAS OVH - http://www.ovh.com 2 rue K...", "10:26 AM"),
            EmailModel("Matt from Ionic", "The New Ionic Creator Is Here!", "Announcing the all-new Creator, build...", "9:45 AM")
        )

        // 2. Thiết lập Adapter
        val adapter = GmailAdapter(emailList)

        // 3. Gán Adapter và LayoutManager vào RecyclerView
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
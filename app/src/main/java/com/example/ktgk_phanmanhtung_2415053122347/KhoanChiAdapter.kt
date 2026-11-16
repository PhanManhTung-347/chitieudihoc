package com.example.ktgk_phanmanhtung_2415053122347

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ktgk_phanmanhtung_2415053122347.databinding.ItemKhoanChiBinding

class KhoanChiAdapter(private val danhSachKhoanChi:List<KhoanChi>): RecyclerView.Adapter<KhoanChiAdapter.KhoanChiViewHolder>() {
    class KhoanChiViewHolder(val binding: ItemKhoanChiBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KhoanChiViewHolder {
        val binding =
            ItemKhoanChiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KhoanChiViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: KhoanChiViewHolder,
        position: Int
    ) {
        val khoanChi = danhSachKhoanChi[position]
        holder.binding.tvName.text = khoanChi.ten
        holder.binding.tvSoTien.text = "${khoanChi.soTien}"
        holder.binding.tvTrangThai.text =
            if (khoanChi.daThanhToan) "Da thanh toan" else "Chua thanh toan"
    }

    override fun getItemCount(): Int = danhSachKhoanChi.size
}

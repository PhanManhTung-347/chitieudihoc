package com.example.ktgk_phanmanhtung_2415053122347

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ktgk_phanmanhtung_2415053122347.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding_2347: ActivityMainBinding
    private var khoanChi_2347 = mutableListOf<KhoanChi>()
    private var khoanChiAdapter = KhoanChiAdapter(khoanChi_2347)
    private var idTiep = 1L
    private var tenRegex = Regex("""\p{L}[\p{L}\p{M}0-9.'-]{1,39}""")
    private var tienRegex = Regex("""[1-9][0-9]{0,7}""")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding_2347 = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar?.title = "Phan Manh Tung - 2415053122347"
        setContentView(binding_2347.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding_2347.rvKhoanChi2347.layoutManager= LinearLayoutManager(this)
        binding_2347.rvKhoanChi2347.adapter = khoanChiAdapter
        binding_2347.edtTen2347.doAfterTextChanged {
            binding_2347.tilTen2347.error = null
        }
        binding_2347.edtSoTien2347.doAfterTextChanged {
            binding_2347.tilSoTien2347.error = null
        }
        binding_2347.btnThemKhoanChi2347.setOnClickListener {
            themKhoanChi()
        }
    }
    private fun themKhoanChi(){
        val tenKhoanChi2347 = binding_2347.edtTen2347.text.toString().trim()
        var soTien2347 = binding_2347.edtSoTien2347.text.toString().trim()
        var tienHopLe = if (tienRegex.matches(soTien2347)){
            soTien2347.toLongOrNull()?:0
        }
        else
        {
            null
        }
        if (tienHopLe == null){
            binding_2347.tilSoTien2347.error ="So tien khong hop le"
        }
        val ghiChu2347 = binding_2347.edtGhiChu2347.text.toString().trim()
        if (!tenRegex.matches(tenKhoanChi2347) || tenKhoanChi2347 == null){
            binding_2347.tilTen2347.error ="Ten toi thieu phai co 2 ky tu!"
        }
        if (tenKhoanChi2347.isEmpty()|| soTien2347 == null || tienHopLe !in 1L..1000000L)
        {
            Toast.makeText(this, "Vui long kiem tra lai gia tri", Toast.LENGTH_SHORT).show()
            return
        }
        binding_2347.tilTen2347.error = null
        binding_2347.tilSoTien2347.error = null
        khoanChi_2347.add(KhoanChi(id=idTiep++, ten = tenKhoanChi2347, soTien = tienHopLe?:0, ghiChu = ghiChu2347, daThanhToan = false))
        Toast.makeText(this, "Da them khoan chi thanh cong", Toast.LENGTH_SHORT).show()
        khoanChiAdapter.notifyItemInserted(khoanChi_2347.lastIndex)
        binding_2347.edtTen2347.text?.clear()
        binding_2347.edtSoTien2347.text?.clear()
        binding_2347.edtGhiChu2347.text?.clear()
    }
}
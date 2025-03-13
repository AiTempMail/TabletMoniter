package com.example.tabletmonitor.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tabletmonitor.database.Tablet
import com.example.tabletmonitor.databinding.ActivityTabletDetailBinding
import com.example.tabletmonitor.viewmodels.TabletViewModel

class TabletDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTabletDetailBinding
    private val viewModel: TabletViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTabletDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabletId = intent.getStringExtra("tablet_id")
        tabletId?.let { id ->
            viewModel.allTablets.observe(this) { tablets ->
                tablets.find { it.id == id }?.let { tablet ->
                    populateFields(tablet)
                    setupUpdateButton(tablet)
                }
            }
        }
    }

    private fun populateFields(tablet: Tablet) {
        with(binding) {
            etName.setText(tablet.name)
            etDosage.setText(tablet.dosage)
            etStock.setText(tablet.stock.toString())
        }
    }

    private fun setupUpdateButton(originalTablet: Tablet) {
        binding.btnUpdate.setOnClickListener {
            val updatedTablet = originalTablet.copy(
                name = binding.etName.text.toString(),
                dosage = binding.etDosage.text.toString(),
                stock = binding.etStock.text.toString().toIntOrNull() ?: 0
            )
            viewModel.updateTablet(updatedTablet)
            finish()
        }
    }
}
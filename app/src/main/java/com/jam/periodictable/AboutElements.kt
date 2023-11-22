package com.jam.periodictable

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import com.jam.periodictable.Adapter.ElementAdapter
import com.jam.periodictable.Db.AppDatabase
import com.jam.periodictable.Db.TableElementsRepository
import com.jam.periodictable.Db.TableViewModel
import com.jam.periodictable.Db.TableViewModelFactory
import com.jam.periodictable.databinding.ActivityAboutElementsBinding

class AboutElements : AppCompatActivity() {

    private lateinit var binding: ActivityAboutElementsBinding
    private lateinit var tableViewModel: TableViewModel

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutElementsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = intent.getIntExtra("position", 0)

        val repository = TableElementsRepository(AppDatabase.getDatabase(this).tableElementsDao())
        tableViewModel = ViewModelProvider(this, TableViewModelFactory(repository))[TableViewModel::class.java]

        // Observe LiveData to get data
        tableViewModel.allData.observe(this) { datas ->
            // Handle the data here
            Log.e("TABLEVIEWMODEL", datas.toString())
            binding.number.text = datas[position].AtomicNumber
            binding.symbol.text = datas[position].Symbol
            binding.category.text = datas[position].Type
            binding.title.text = datas[position].Element
            binding.desc.text = datas[position].Description
            binding.overDesc.text = "Atomic Number : " + datas[position].AtomicNumber + "\n" +
                    "Atomic Symbol : " + datas[position].Symbol + "\n" +
                    "Atomic Mass : " + datas[position].AtomicMass + "\n" +
                    "Group :"  + datas[position].Groups + "\n" +
                    "Period :"  + datas[position].Period + "\n"

            binding.propertiesDesc.text = "Protons : " + datas[position].NumberofProtons + "\n" +
                    "Neutrons : " + datas[position].NumberofNeutrons + "\n" +
                    "Electrons : " + datas[position].NumberofElectrons + "\n" +
                    "Electron Negativity : " + datas[position].Electronegativity + "\n"+
                    "Melting Point : " + datas[position].MeltingPoint + "\n"+
                    "Boiling Point : " + datas[position].BoilingPoint + "\n"

            binding.historyDesc.text =  datas[position].Element + " was discovered by " + datas[position].Discoverer + " in " + datas[position].Year

            binding.usesDesc.text = Html.fromHtml("- " + datas[position].UsesAndImportance + "<br>" + "- " + datas[position].UsesAndImportance2 + "<br>" +
                    "- " + datas[position].UsesAndImportance3 + "<br><br><i>" +  datas[position].Links +"</i")
        }
    }
}
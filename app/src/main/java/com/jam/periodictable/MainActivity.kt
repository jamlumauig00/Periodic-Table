package com.jam.periodictable

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jam.periodictable.Adapter.AdapterOnClick
import com.jam.periodictable.Adapter.ElementAdapter
import com.jam.periodictable.Db.AppDatabase
import com.jam.periodictable.Db.DatabaseCopier
import com.jam.periodictable.Db.TableElementModel
import com.jam.periodictable.Db.TableElementsRepository
import com.jam.periodictable.Db.TableViewModel
import com.jam.periodictable.Db.TableViewModelFactory
import com.jam.periodictable.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterOnClick {

    private lateinit var binding: ActivityMainBinding

    private lateinit var tableViewModel: TableViewModel

    private lateinit var rview: RecyclerView
    lateinit var arrayAdapter: ElementAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        DatabaseCopier.copyDatabaseFromAssets(this)

        rview = binding.ptRview
        rview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Initialize the ViewModel
        val repository = TableElementsRepository(AppDatabase.getDatabase(this).tableElementsDao())
        tableViewModel = ViewModelProvider(this, TableViewModelFactory(repository))[TableViewModel::class.java]

        // Observe LiveData to get data
        tableViewModel.allData.observe(this) { datas ->
            // Handle the data here
            Log.e("TABLEVIEWMODEL", datas.toString())

            for (value in datas) {
                Log.e("VALUE", value.toString())
                arrayAdapter = ElementAdapter(datas, this)
                rview.adapter = arrayAdapter
                arrayAdapter.notifyDataSetChanged()
            }

        }
    }

    override fun onclick(position: Int) {
        startActivity(Intent(this, AboutElements::class.java).putExtra("position",position))
        //finish()
    }

    private var doubleBackToExitPressedOnce = false

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else if (!doubleBackToExitPressedOnce) {
            doubleBackToExitPressedOnce = true
            Toast.makeText(this, "Press Back Again to Exit!!", Toast.LENGTH_SHORT).show()
            Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
        } else {
            super.onBackPressed()
            return
        }
    }

}
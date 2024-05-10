package com.example.traveljournal2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class JournalListActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private val entries = mutableListOf("Sample Entry 1", "Sample Entry 2") // Example entries

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_journal_list)

        listView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, entries)
        listView.adapter = adapter

        val addButton = findViewById<FloatingActionButton>(R.id.addEntryButton)
        addButton.setOnClickListener {
            val intent = Intent(this, AddEntryActivity::class.java)
            startActivityForResult(intent, ADD_ENTRY_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_ENTRY_REQUEST_CODE && resultCode == RESULT_OK) {
            data?.getStringExtra("entry")?.let {
                if (it.isNotEmpty()) {
                    entries.add(it)
                    (listView.adapter as ArrayAdapter<*>).notifyDataSetChanged()
                }
            }
        }
    }

    companion object {
        const val ADD_ENTRY_REQUEST_CODE = 1
    }
}


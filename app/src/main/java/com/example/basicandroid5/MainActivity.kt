package com.example.basicandroid5

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.basicandroid5.ListAdapter.Companion.UserList

class MainActivity : AppCompatActivity() {
    lateinit var listView : RecyclerView
    lateinit var adapter: ListAdapter
    lateinit var btnAdd: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.list_item)
        adapter = ListAdapter()
        listView.layoutManager = LinearLayoutManager(this)
        listView.adapter = adapter
        btnAdd = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener() {
            AddUserDialog()
        }
    }

    fun AddUserDialog() {
        var dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.add_dialog)
        val window = dialog.window
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        var btnSave = dialog.findViewById<Button>(R.id.btnSave)
        var btnCancel = dialog.findViewById<Button>(R.id.btnCancel)
        var editName = dialog.findViewById<EditText>(R.id.name)
        var editAge = dialog.findViewById<EditText>(R.id.age)
        var radioGroup = dialog.findViewById<RadioGroup>(R.id.gender)

        btnSave.setOnClickListener() {
            try {
                var gender = radioGroup.checkedRadioButtonId
                var genderCheck = dialog.findViewById<RadioButton>(gender)
                if (editName.text.toString()!="") {
                    UserList.add(
                        UserList.size,
                        User(
                            editName.text.toString(),
                            editAge.text.toString().toInt(),
                            genderCheck.text.toString()
                        )
                    )
                    dialog.dismiss()
                }
                else Toast.makeText(this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            }
            catch (e:Exception) {
                Toast.makeText(this, "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel.setOnClickListener() {
            dialog.dismiss()
        }

        dialog.show()
    }
}
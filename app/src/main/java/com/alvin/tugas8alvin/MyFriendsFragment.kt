package com.alvin.tugas8alvin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_my_friends.*
import org.jetbrains.annotations.Nullable

class MyFriendsFragment : Fragment(){

    lateinit var listTeman: MutableList<User>

    private fun simulasiDataTeman(){
        var db = DatabaseHendler(requireContext())
        var data = db.readData()
        listTeman= ArrayList()

        for(i in 0..(data.size-1)) {
            listTeman.add(
                User(
                    data.get(i).name,
                    data.get(i).email,
                    data.get(i).id,
                    data.get(i).alamat,

                    )
            )
        }

    }
    private fun tampilTeman(){
        rv_listMyFreinds.layoutManager=LinearLayoutManager(activity)
        rv_listMyFreinds.adapter=MyFriendAdapter(requireActivity(),listTeman)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_friends, container, false)

    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

        btnSimpan.setOnClickListener {simpan()}
        btnHapus.setOnClickListener { hapus() }
        btnUpdate.setOnClickListener {  }
    }




    private fun hapus(){

        var db = DatabaseHendler(requireContext())
        var user = User(txtName.text.toString().toInt())
        db.deleteData(user)
        listTeman.clear()
        initView()
    }

    private fun simpan(){
        if(txtName.text.toString().length>0){
            var user = User(txtName.text.toString(),txtEmail.text.toString(),
                txtTelpon.text.toString().toInt(),txtAlamat.text.toString())
            var db = DatabaseHendler(requireContext())
            db.insertData(user)
            listTeman.clear()
            initView()
        }else{

            Toast.makeText(context,"Isi kan",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initView(){
        simulasiDataTeman()
        tampilTeman()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }


//     override fun onResume() {
//        super.onResume()
//        Toast.makeText(context, "Activity: onResume()", Toast.LENGTH_SHORT).show()
//    }



}
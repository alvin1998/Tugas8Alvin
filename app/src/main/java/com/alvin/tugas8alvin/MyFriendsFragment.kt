package com.alvin.tugas8alvin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_my_friends.*
import org.jetbrains.annotations.Nullable

class MyFriendsFragment : Fragment(){

    lateinit var listTeman: MutableList<MyFriend>

    private fun simulasiDataTeman(){
        listTeman= ArrayList()
        listTeman.add(
            MyFriend("Alvin","Laki-Laki",
            "alfinade@gmail.com","08122312312","Malang"))
        listTeman.add(MyFriend("Ade","Laki-Laki",
            "alfinade@gmail.com","08122312312","Malang"))
        listTeman.add(
            MyFriend("polo","Laki-Laki",
                "alfinade@gmail.com","08122312312","Malang"))
        listTeman.add(MyFriend("Ade","Laki-Laki",
            "alfinade@gmail.com","08122312312","Malang"))
        listTeman.add(
            MyFriend("marco","Laki-Laki",
                "marco@gmail.com","08122312312","Malang"))
        listTeman.add(MyFriend("al","Laki-Laki",
            "al@gmail.com","0812239139","Malang"))


    }
//    private fun tambah(){
//        listTeman= ArrayList()
//        listTeman.add(
//            MyFriend("asdasd","Laki-Laki",
//                "alfinade@gmail.com","08122312312","Malang"))
//        listTeman.add(MyFriend("Ade","Laki-Laki",
//            "alfinade@gmail.com","08122312312","Malang"))
//    }

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

//        btnSimpan.setOnClickListener {
            initView()
//        }
    }

    private fun initView(){
        simulasiDataTeman()
        tampilTeman()

    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}
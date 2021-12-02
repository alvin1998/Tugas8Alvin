package com.alvin.tugas8alvin

class User{

    var id : Int = 0
    var name : String = ""
    var email : String = ""
    var telpon : Int = 0
    var alamat : String = ""


    constructor(name:String,email:String,telpon:Int,alamat:String){
        this.name = name
        this.email = email
        this.telpon = telpon
        this.alamat = alamat
    }
    constructor(){

    }
    constructor(id:Int){
        this.id = id
    }
}
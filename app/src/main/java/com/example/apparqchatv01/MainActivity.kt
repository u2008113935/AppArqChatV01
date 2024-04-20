package com.example.apparqchatv01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apparqchatv01.databinding.ActivityMainBinding
import com.example.apparqchatv01.fragmentos.FragmentChats
import com.example.apparqchatv01.fragmentos.FragmentPerfil
import com.example.apparqchatv01.fragmentos.FragmentUsuarios

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        irOpcionesLogin()

        //Fragmento por default o defecto
        verFragmentoPerfil()

        binding.bottomNV.setOnItemSelectedListener { item->
            when (item.itemId){
                R.id.item_perfil->{ //Visualizar el fragmento perfil
                    verFragmentoPerfil()
                    true
                }
                R.id.item_usuarios->{//Visualizar el fragmento usuarios
                    verFragmentoUsuarios()
                    true
                }
                R.id.item_chats->{//Visualizar el fragmento chats
                    verFragmentoChats()
                    true
                }
                else->{
                    false
                }
            }
        }
    }

    private fun irOpcionesLogin(){
        startActivity(Intent(applicationContext, OpcionesLoginActivity::class.java))
    }
    private fun verFragmentoPerfil(){
        binding.tvTitulo.text = "Perfil"
        val fragment = FragmentPerfil()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmenttoFL.id, fragment, "Fragment Perfil")
        fragmentTransaction.commit()
    }
    private fun verFragmentoUsuarios(){
        binding.tvTitulo.text = "Usuarios"
        val fragment = FragmentUsuarios()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmenttoFL.id, fragment, "Fragment Usuarios")
        fragmentTransaction.commit()
    }
    private fun verFragmentoChats(){
        binding.tvTitulo.text = "Chats"
        val fragment = FragmentChats()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.fragmenttoFL.id, fragment, "Fragment Chats")
        fragmentTransaction.commit()

    }
}
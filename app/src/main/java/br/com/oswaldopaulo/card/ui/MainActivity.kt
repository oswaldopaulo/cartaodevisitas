package br.com.oswaldopaulo.card.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.oswaldopaulo.card.R
import br.com.oswaldopaulo.card.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
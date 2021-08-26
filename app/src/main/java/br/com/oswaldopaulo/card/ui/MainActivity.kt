package br.com.oswaldopaulo.card.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.activity.viewModels
import br.com.oswaldopaulo.card.App
import br.com.oswaldopaulo.card.databinding.ActivityMainBinding
import br.com.oswaldopaulo.card.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy {BusinessCardAdapter()}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListeners()
    }

    private fun insertListeners(){
        binding.fab.setOnClickListener {
            val intent = Intent(this@MainActivity,AddBusinessCardActivity::class.java)
            startActivity(intent)
        }

        adapter.listnerShare = {
            Image.share(this@MainActivity, it)
        }
    }

    private fun getAllBusinessCard(){
      mainViewModel.getAll().observe(this, {
            adapter.submitList(it)
      })
    }
}
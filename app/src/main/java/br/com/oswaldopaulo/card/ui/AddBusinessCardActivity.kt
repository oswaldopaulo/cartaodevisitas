package br.com.oswaldopaulo.card.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.com.oswaldopaulo.card.App
import br.com.oswaldopaulo.card.R
import br.com.oswaldopaulo.card.data.BusinessCard
import br.com.oswaldopaulo.card.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners(){
        binding.btnClose.setOnClickListener {  finish() }

        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome=binding.tilNome.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                empresa=binding.tilEmpresa.editText?.text.toString(),
                email= binding.tilEmail.editText?.text.toString(),
                cor= binding.tilCor.editText?.text.toString()

            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
package br.com.oswaldopaulo.card

import android.app.Application
import br.com.oswaldopaulo.card.data.AppDatabase
import br.com.oswaldopaulo.card.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}
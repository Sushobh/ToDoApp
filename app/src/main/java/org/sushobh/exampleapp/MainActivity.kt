package org.sushobh.exampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import org.sushobh.exampleapp.Base.BaseActivity
import org.sushobh.exampleapp.Dagger.Components.DaggerActivityBuilder
import org.sushobh.exampleapp.Dagger.Modules.ViewModelModule
import org.sushobh.exampleapp.ViewModels.MainViewModel
import javax.inject.Inject

class MainActivity : BaseActivity() {


    override fun inject() {
        DaggerActivityBuilder.builder().viewModelModule(ViewModelModule(this))
            .build().inject(this)
    }


    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val db = FirebaseFirestore.getInstance()

        val user = HashMap<String, Any>()
        user["first"] = "Ada"
        user["last"] = "Lovelace"
        user["born"] = 1815

        db.collection("users")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d("123", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("123", "Error adding document", e)
            }

    }


}
